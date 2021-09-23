# spring-boot-activemq-messaging-demo
 ActiveMQ Message Broker connection with JMS Template + WebMVC.

### Structure:

A HTTP request can be send to following endpoints:

- api/message/car/{name}/{brand}
- api/message/film/{name}/{releaseYear}

After receiving a request via WebMVC it gets forwarded to the ActiveMQ topic.
There is an listener active which checks if a new message is comming to the topic and will response to a response topic after reciving messages.

The property spring.jms.pub-sub-domain is set to true because topics are used instead of queues. 