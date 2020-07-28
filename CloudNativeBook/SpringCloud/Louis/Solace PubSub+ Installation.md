# Solace PubSub+ 

## Table of Content:

1. installation
2. basic concepts
3. sample usage
4. concepts



## Brief Introduction

Solace is a Middle Ware.

key word: event-driven architectures; event streaming; PubSub+ Event Broker; distributed; Appliance 



## Installation

1. git clone https://github.com/SolaceLabs/solace-single-docker-compose.git

2. cd solace-single-docker-compose/template

3. docker-compose -f PubSubStandard_singleNode.yml up -d

> another way:
>
> ```
> docker run -d -p 8080:8080 -p 55555:55555 -p:8008:8008 -p:1883:1883 -p:8000:8000 -p:5672:5672 -p:9000:9000 -p:2222:2222 --shm-size=2g --env username_admin_globalaccesslevel=admin --env username_admin_password=admin --name=solace solace/solace-pubsub-standard
> ```



## Usage

* Solace console: http://localhost:8080  (or 127.0.0.1:8080 if  401 error)
  
* login: admin/admin
  
* Solace CLI:

  * docker exec -it pubSubStandardSingleNode /usr/sw/loads/currentload/bin/cli -A

  * solace> enable

    solace# config

    solace(configure)#

## Concepts

* PubSub+ Event Broker : software, ~~~appliance~~~ , ~~cloud~~ 
* Event Mesh
  * Service Mesh 



## Sample

[Try Me!](http://127.0.0.1:8080/#/msg-vpns/ZGVmYXVsdA==/try-me/send-receive?count=20&cursor=&displayFormat=tile)  publish and subscribe to a message 

> update `PubSubStandard_singleNode.yml` to un-comment 8008 port
>
> if run by docker-compose

 



## Config 

