Example Spring B2
=================

This project is an example Building Block (B2) for Blackboard Learn using the Spring APIs that Blackboard provides for third party developers.  

### Building
To build the project, just run:

gradlew build

### Deploying
To deploy the B2 to your Learn server, run:

gradlew -Dserver=<server host and port> deployB2

where <server host and port> for a locally running server would be "localhost:80".
