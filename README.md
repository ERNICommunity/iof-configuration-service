# iof-configuration-service

:warning: **REPOSITORY NOT ACTIVE SINCE 2016 Dependabot alerts in git security settings disabled**

Internet of Fish Configuration Service

## starting the application
- run 'java -jar configuration-0.1.0'
- make sure the file "iof_configuration.json" is in the same directory from which you launch the jar file
- the service will be available under 'localhost:8080'

## Adding new configurations
New configurations are added whenever a device requests its configuration by sending a message to the topic "iof/configuration" with its ID as message body. 
