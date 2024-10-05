package org.example;

public class Main {
    public static void main(String[] args) {
        InMemoryBuffer inMemoryBuffer = new InMemoryBuffer(4);
        for (int i = 0; i < 5; i++) {
            Thread producer = new Thread(new Producer(inMemoryBuffer), "producer - " + i);
            producer.start();
        }
        Thread consumer = new Thread(new Consumer(inMemoryBuffer), "consumer");
        consumer.start();

    }
}