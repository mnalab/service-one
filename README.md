# Service-one Demo Project
This is one demo project to create Services and run on docker container, by creating image, then run Image on docker container.
Also with Docker compose to run services.

This demo also demonstrate service calling from Service 1 to Service 2 in one Micro Service Platform.

Create K8s objects and deploy on Kubernetes

# Build Image 

    $ docker build -f container/Dockerfile -t service-one .

# Run container

    $ docker run -d -p 9001:9001 --name service-one service-one:latest

# Run container with env values

    $ docker run -d -p 9001:9001 --network bridge \
                        -e SERVICE_TWO_HOST='service-two' \
                        -e SERVICE_TWO_PORT='9002' \
                        --name service-one service-one:latest

# Run Container with Docker-Compose file
* To run service-one and service-two together there is one docker-compose.yml defined under <Project-Root>/container/docker-compose.yml
* To execute this use, on the terminal of given compose file folder


    $ docker-compose -up

* There are two services defined Service-one and Service-two in compose file. Both are taking external environment variables 

    
    ***Service-one Environment variables***
    SERVICE_TWO_HOST: service-two
    SERVICE_TWO_PORT: 9002

    ***Service-two Environment variables***
    SERVICE_ONE_HOST: service-one
    SERVICE_ONE_PORT: 9001

These env properties defined the port and IP of other services in one container to access that service endpoint.
