# Service-one Demo Project
This is one demo project to create Spring boot demo project and run on docker container

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

# Kubernetes 
* Create kubernetes object defined under <PROJECT>/container/k8s
* Define Pod or Deployment to create one replica set fot the containers for service-one and service-two 


    kubectl create -f service-one-pod.yml

* Define node port service, this service establish and open one port to node to access service externally from the cluster


    kubectl create -f service-one-service.yml

* Define Cluster-ip service, this defines one service object with one fix IP, and it is used to access pods within one cluster.
* When defining cluster IP service we provide the Target PORT of our needed POD and gives selector the matches label or our needed pod.


    kubectl create -f service-one-clusterip.yml

* In the Deployment or POD under container definition we can pass Cluster-ip IP to be accessed inside code base to access/communicate other PODs exposed services.


      containers:
    - name: service-one
      image: dearnomi/service-one:latest
      ports:
        - containerPort: 9001
      env:
        - name: SERVICE_TWO_HOST
          value:  "10.106.168.192"
        - name: SERVICE_TWO_PORT
          value:  "9002"
