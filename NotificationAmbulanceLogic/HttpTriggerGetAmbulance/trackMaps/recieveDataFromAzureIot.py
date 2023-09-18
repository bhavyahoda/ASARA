import json
from azure.iot.device import IoTHubDeviceClient, Message, MethodResponse

# Define your IoT Hub connection string and device ID
CONNECTION_STRING = "HostName=suvhakathonIoThub.azure-devices.net;DeviceId=VehicleTest1;SharedAccessKey=GS7rl/w5t5NRuGuBhDIzq7zePKII5fFT2KowU+tRzfc="
DEVICE_ID = "VehicleTest1"

# Create an instance of the IoT Hub device client
client = IoTHubDeviceClient.create_from_connection_string(CONNECTION_STRING)

# Connect to IoT Hub
client.connect()

# Subscribe to messages from the device
def message_listener(message):
    # This function will be called when a message is received from the device
    try:
        # Extract and process the message payload (containing location data)
        payload = message.data.decode("utf-8")
        message_data = json.loads(payload)
        print(message_data)
        print('Hello')

        # Extract latitude, longitude, and vehicle name from the message payload
        latitude = message_data.get("latitude")
        longitude = message_data.get("longitude")
        vehicle_name = message_data.get("vehicle_name")

        if latitude is not None and longitude is not None and vehicle_name is not None:
            print(f"Received location for {vehicle_name}: Latitude {latitude}, Longitude {longitude}")

            # Update the vehicle's location on Azure Maps or perform other actions

    except Exception as e:
        print(f"Error processing message: {str(e)}")

client.on_message = message_listener
