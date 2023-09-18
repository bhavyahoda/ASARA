import logging
import requests
import azure.functions as func
import json


# Simulated database for available ambulances
ambulance_db = {
    "Ambulance-1201": {"location": {"latitude": 12.972041382662443, "longitude": 77.70724306665103}, "priority": 1, "status": "available"},
    "Ambulance-2203": {"location": {"latitude": 13.022889458491134, "longitude": 77.7037240091704}, "priority": 2, "status": "available"},
    "Ambulance-3203": {"location": {"latitude": 13.02046437579861, "longitude": 77.70964632622717}, "priority": 1, "status": "available"},
    "Ambulance-4204": {"location": {"latitude": 13.013648930016391, "longitude": 77.72153387592849}, "priority": 1, "status": "NA"},
    "Ambulance-5205": {"location": {"latitude": 13.008714932046635, "longitude": 77.71410952182663}, "priority": 1, "status": "available"},
    # Add more ambulances to the database as needed
}

def main(req: func.HttpRequest) -> func.HttpResponse:
    # Parse case data from the HTTP request
    case_data = req.get_json()

    # Logic to assign the case to an available ambulance based on location and priority
    ambulance_id = assign_ambulance(case_data)
    cust_name = case_data.get("name")

    logic_app_url = "https://prod-81.eastus.logic.azure.com:443/workflows/aa57286223254ddca32ebeae44ce3acd/triggers/manual/paths/invoke?api-version=2016-10-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=Inwh7_dxjlW_kCe9nOW6fw13cC0Q61JvpIK3iJVjD_w"

    subject = f"ASARA Case ID:#3123 - Urgent Assistance Required for a ASARA Rescued Animal"
    body = f"<html> \
<head></head> \
<body>\
    <p>Dear Emergency Department Team at Friends For Animals,</p>\
    <p>We are reaching out to request immediate assistance for an animal rescue operation currently in progress by one of our dedicated ASARA volunteers. Your prompt response is crucial to saving this animal's life.</p>\
    <p><strong>Rescue Details:</strong></p>\
    <ul>\
        <li>Animal Type: Dog</li>\
        <li>ASARA Volunteer Name: {cust_name}</li>\
        <li>Contact Number: +91 7432212143</li>\
        <li>Location: 12.999846244655144, 77.690554596418 (Near PPS FORD)</li>\
        <li>Condition: The dog is paralyzed and in urgent need of medical attention.</li>\
    </ul>\
    <p>Your expertise and resources are vital in ensuring the well-being of this animal. We kindly request your immediate intervention and dispatch of an ambulance to the specified location.</p>\
    <p>Your prompt action and support are greatly appreciated.</p>\
    <p>Thank you for your commitment to the welfare of animals.</p>\
    <p><em>Best Regards,</em></p>\
    <p><strong>ASARA Team</strong></p>\
</body>\
</html>\
"
    # JSON data to be sent to the Logic App
    payload = {
        "subject": subject,
        "body":  body,
        "to": "subanerjee@microsoft.com",
        "bcc": "subanerjee@microsoft.com"
    }

    # Convert the payload dictionary to JSON
    json_payload = json.dumps(payload)

    # Set the content type header to indicate JSON data
    headers = {'Content-Type': 'application/json'}

    # Make an HTTP POST request to trigger the Logic App with JSON data
    response = requests.post(logic_app_url, data=json_payload, headers=headers)
    if ambulance_id:
        return func.HttpResponse(f'Thanks {cust_name} for prompt action! Case ID:#3123. Please be patient! {ambulance_id} dispatched for the rescue.')
    else:
        return func.HttpResponse(f'Thanks {cust_name} for prompt action! Unfortunately no available ambulances. Please try again later.', status_code=503)

def assign_ambulance(case_data):
    # Extract case location and priority from the case data
    case_location = case_data.get("location")
    case_priority = case_data.get("priority")

    nearest_ambulance_id = None
    min_distance = float('inf')  # Initialize with positive infinity

    # Iterate through the ambulance database to find the nearest available ambulance
    for ambulance_id, ambulance_info in ambulance_db.items():
        if ambulance_info["status"] == "available" and ambulance_info["priority"] >= case_priority:
            # Calculate distance between case location and ambulance location
            distance = calculate_distance(
                case_location["latitude"], case_location["longitude"],
                ambulance_info["location"]["latitude"], ambulance_info["location"]["longitude"]
            )

            if distance < min_distance:
                min_distance = distance
                nearest_ambulance_id = ambulance_id

    # Check if a nearest available ambulance was found
    if nearest_ambulance_id:
        return nearest_ambulance_id

    # No available ambulances meeting the criteria
    return None


def calculate_distance(lat1, lon1, lat2, lon2):

    from math import radians, sin, cos, sqrt, atan2

    # Radius of the Earth in kilometers
    R = 6371.0

    # Convert latitude and longitude from degrees to radians
    lat1, lon1, lat2, lon2 = map(radians, [lat1, lon1, lat2, lon2])

    # Haversine formula
    dlon = lon2 - lon1
    dlat = lat2 - lat1
    a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
    c = 2 * atan2(sqrt(a), sqrt(1 - a))
    distance = R * c

    return distance