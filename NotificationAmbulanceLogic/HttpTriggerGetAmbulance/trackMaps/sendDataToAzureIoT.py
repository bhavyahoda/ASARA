from azure.iot.device import IoTHubDeviceClient, Message
import time
import random

CONNECTION_STRING = "HostName=suvhakathonIoThub.azure-devices.net;DeviceId=VehicleTest1;SharedAccessKey=GS7rl/w5t5NRuGuBhDIzq7zePKII5fFT2KowU+tRzfc="
DEVICE_ID = "VehicleTest1"

def send_location_data(latitude, longitude, vehicle_name):
    client = IoTHubDeviceClient.create_from_connection_string(CONNECTION_STRING)

    while True:
        try:
            # Simulate GPS data
            current_latitude = latitude + random.uniform(-0.001, 0.001)  # Add slight variation
            current_longitude = longitude + random.uniform(-0.001, 0.001)

            # Create a message with location data
            message_body = {
                "latitude": current_latitude,
                "longitude": current_longitude,
                "vehicle_name": vehicle_name
            }
            message = Message(str(message_body))

            # Send the message to IoT Hub
            client.send_message(message)

            # Log the message sent
            print(f"Message sent for {vehicle_name}: Latitude {current_latitude}, Longitude {current_longitude}")

            time.sleep(2)  # Send data every 60 seconds

        except Exception as e:
            print(f"Error for {vehicle_name}: {str(e)}")
            time.sleep(10)  # Retry after 10 seconds

if __name__ == "__main__":
    # Input latitude, longitude, and vehicle name
    input_latitude = 13.199379  # Replace with your initial latitude
    input_longitude = 77.710136  # Replace with your initial longitude
    input_vehicle_name = "Vehicle1"  # Replace with your vehicle name

    send_location_data(input_latitude, input_longitude, input_vehicle_name)
