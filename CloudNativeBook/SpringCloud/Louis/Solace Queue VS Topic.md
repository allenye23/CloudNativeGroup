###### Solace Queue VS Topic



![](./queues-vs-topic-endpoints_pic-1.png)

queue endpoint is a **superset** of the topic endpoint



### **Which endpoint should you use?**

* Queues are used more often 
  * support for more subscriptions, more consumers, and the ability to read  without removal which is very handy for troubleshooting and special  processing

* topic endpoints were originally created to support durable subscriptions in JMS



# Adding Subscriptions to Endpoints

![](./routing_messages.jpg)