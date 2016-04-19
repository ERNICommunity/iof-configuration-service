# iof-configuration-service
Internet of Fish Configuration Service

## starting the application
- run 'java -jar configuration-0.1.0'
- make sure the file "iof_configuration.json" is in the same directory as you launch the jar file from
- the service will be available under 'localhost:8080'

## Adding new configurations
New configurations are added whenever a device requests its configuration by sending a message to the topic "iof/configuration" with its ID as message body. 
