package org.example;

public class Main {
    public static void main(String[] args) {
        InMemoryBuffer inMemoryBuffer = new InMemoryBuffer(4);
        Thread producer = new Thread(new Producer(inMemoryBuffer), "producer");
        Thread consumer = new Thread(new Consumer(inMemoryBuffer), "consumer");
        consumer.start();
        producer.start();
    }
}