# apache-kafka-project
This project has been created to explore the Apache Kafka technology. This repository is used for learning purposes. 

# Java 
This project works in the Java environment which requires a Java Development Kit (JDK). A frequently asked question is: What is JDK? 
Well, JDK is a development environment used for developing Java applications. It includes components such as Java Runtime Environment (JRE), interpreter or loader (java), a compiler (javac), archiver (jar) and a documentation generator (javadoc) and much more. This can be downloaded from the Oracle website [link](https://www.oracle.com/java/technologies/downloads/).   

This project uses JDK 17 which is compatible with the Kafka version 3.5.1. 

# ZooKeeper 
This is another prequisite software to run Apache Kafka. ZooKeeper is a piece of software that provides support for distributed applications. 
What are distributed applications? Well, these are pieces of software that run on multiple systems or computers within a network at the same time and they are usually stored at cloud services such as Amazon Web Services or Google Cloud Platform. 
These softwares uses configurations to handle synchronization and group services across multiple computers to make the whole system run as effciently as possible. Thus, to solve this ZooKeeper has been created. 

# Apache Kafka 
Kafka is an open source distributed event streaming platform which in other words meaning that Kafka is used to process data in real time. By process we mean to store produced data and consume the produced data. This is done by employing several brokers (computers) to handle the different produced data. Important concepts of Kafka are, 
- topic
- broker
- producer
- consumer 
- cluster
- partition
- segment 

# How to run 
To run the application we have to turn on the Kafka and ZooKeeper servers to handle our requests. 
The following command starts the ZooKeeper load balancer 
`<path_to_zookeper_bin_folder>/bin/zkServer.sh start`
To close ZooKeeper we have to run a similar command by swap out `start` with `stop`. 

Once we have started the ZooKeeper we can start the Kafka server with the following command
`<path_to_kafka_bin_folder/bin/kafka-server-start.sh <path>/kafka-config/server.properties`

To stop the Kafka server we can run 
`path_to_kafka/bin/kafka-server-stop.sh`
