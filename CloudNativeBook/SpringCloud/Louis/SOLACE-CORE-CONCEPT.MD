# Core Concepts

- [What is Messaging?](https://docs.solace.com/PubSub-Basics/Core-Concepts-Messaging.htm)                                                                
- [Message Exchange Patterns](https://docs.solace.com/PubSub-Basics/Core-Concepts-Message-Models.htm)                                                                
- [Message VPNs](https://docs.solace.com/PubSub-Basics/Message-VPNs.htm)                                                                
- [Clients](https://docs.solace.com/PubSub-Basics/Core-Concepts-Clients.htm)                                                                
- [Understanding Topics](https://docs.solace.com/PubSub-Basics/Understanding-Topics.htm)                                                                
- [Endpoints and Queues](https://docs.solace.com/PubSub-Basics/Core-Concepts-Endpoints-Queues.htm)                                                                



## What is Messaging?

### Basics

- publisher: the entity that sends or publishes the message (also called a producer

- message: what the publisher wants to say to the subscriber. Messages often  contain events, but can also carry queries, commands, and other  information.

- subscriber: the ultimate receiver of the message (also called a consumer)

  ![what's messaging](C:\Users\18813\IdeaProjects\CloudNativeGroup\CloudNativeBook\concept_pubsub_01.gif)

### Destination

In PubSub+ event brokers, a destination can be a [topic](https://docs.solace.com/PubSub-Basics/Understanding-Topics.htm) or a [queue](https://docs.solace.com/PubSub-Basics/Core-Concepts-Endpoints-Queues.htm) 

### Message Quality of Service (QoS)

Messages can be classified as `Persistent (Guaranteed)` or `Non-Persistent (Direct)` by the message producer.

Direct: (high-speed, loss toleratant)

![](C:\Users\18813\IdeaProjects\CloudNativeGroup\CloudNativeBook\direct-messaging-300x118.png)

Guaranteed: (ack)

![](C:\Users\18813\IdeaProjects\CloudNativeGroup\CloudNativeBook\guaranteed_message_pub_pattern.png)



## Message Exchange Patterns

### MEPs

- [Publish-Subscribe](https://docs.solace.com/PubSub-Basics/Core-Concepts-Message-Models.htm#Publish-)                                                                
- [Point-to-Point](https://docs.solace.com/PubSub-Basics/Core-Concepts-Message-Models.htm#Point-to)                                                                
- [Request-Reply](https://docs.solace.com/PubSub-Basics/Core-Concepts-Message-Models.htm#Request-)                                                                

### Publish-Subscribe

![](C:\Users\18813\IdeaProjects\CloudNativeGroup\CloudNativeBook\pub_sub.png)

#### Message Replay

Solace CLI commands 

```
solace> enable
solace# admin
solace(admin)# message-spool message-vpn <vpn-name>
```

### Point-to-Point

#### Non-Exclusive Consumption ( [Queue Access Types](https://docs.solace.com/PubSub-Basics/Endpoints.htm#Queue_Access_Types))

![](C:\Users\18813\IdeaProjects\CloudNativeGroup\CloudNativeBook\ptp_multi_consumers.png)

#### Endpoint Durability

Queues and topic endpoints can be either durable or temporary.

EMS: static, dynamic

### Request-Reply

![](C:\Users\18813\IdeaProjects\CloudNativeGroup\CloudNativeBook\request_reply.png)





## Message VPNs

segregation of topic space and clients

![](C:\Users\18813\IdeaProjects\CloudNativeGroup\CloudNativeBook\Msg_VPN.png)

Each event broker has a Message VPN named `default`. 

Message VPN bridges 

* like EMS Route

* published to one Message VPN to be transferred to another

## Clients





## Topics



## Endpoints and Queues





Endpoints:

Queues are significantly more flexible than topic endpoints and are the **recommended approach for most applications**. 

The use of topic endpoints should be restricted to JMS applications.