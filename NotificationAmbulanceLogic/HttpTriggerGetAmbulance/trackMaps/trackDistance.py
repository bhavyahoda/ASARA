import os
from azure.maps.route import MapsRouteClient
from azure.identity import DefaultAzureCredential
from azure.maps.route.models import RouteOptimizedWaypoint, LatLon, RouteLegSummary
from azure.core.credentials import AzureKeyCredential
import json
import subprocess

# Construct the Azure Maps endpoint URL
AZURE_MAPS_ENDPOINT = "https://atlas.azure.com/"

# Set the Azure Maps endpoint URL and subscription key as environment variables
os.environ["AZURE_MAPS_ENDPOINT"] = AZURE_MAPS_ENDPOINT
os.environ["AZURE_MAPS_SUBSCRIPTION_KEY"] = "ajReFGO61dJgXx8UdtyX5Br0inRqD5a8OH3A00we-AQ"

subscription_key = "ajReFGO61dJgXx8UdtyX5Br0inRqD5a8OH3A00we-AQ"

credential = AzureKeyCredential(subscription_key)

#route_client = MapsRouteClient(credential=DefaultAzureCredential())
route_client = MapsRouteClient(credential)

# Define source and destination coordinates (sample values)
route_points = [
    LatLon(13.008714932046635, 77.71410952182663),  # Starting point
    LatLon(12.999846244655144, 77.690554596418)   # Destination
]

# Calculate the route
route_directions = route_client.get_route_directions(route_points=route_points)

#print(route_directions)

distance_meters = route_directions.routes[0].summary.length_in_meters
traveltime_sec = route_directions.routes[0].summary.travel_time_in_seconds
hours = traveltime_sec // 3600  # 3600 seconds in 1 hour
minutes = (traveltime_sec % 3600) // 60  # 60 seconds in 1 minute

#print("Travel Time:", hours, "hours", minutes, "minutes")


departureTime = route_directions.routes[0].summary.departure_time
expectedArrivalTime = route_directions.routes[0].summary.arrival_time
# Convert meters to kilometers
distance_kilometers = distance_meters / 1000.0
traveltime_min = traveltime_sec / 60

print("Calculating Distance.........")
print("Calculating Distance.........")
print("Calculating Distance.........")
print("Calculating Distance.........")
print("Calculating Distance.........")
print("Calculating Distance.........")
print("Calculating Distance.........")
print("Calculating Distance.........")
print("                              ")
print("                              ")
print("Distance:", distance_kilometers, "kilometers")
print("Travel Time:",hours, "hours", minutes, "minutes")
print("Departure Time:", departureTime)
print("expectedArrivalTime:", expectedArrivalTime)
print("                              ")
print("                              ")