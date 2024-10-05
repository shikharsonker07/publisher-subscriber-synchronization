package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class InMemoryBuffer {
    private Queue<String> dataQueue;
    private int capacity;

    public InMemoryBuffer(int capacity) {
        dataQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void readData() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (dataQueue.isEmpty()) {
            System.out.println("Queue Empty!! " + name + " waiting for new message...");
            wait();
        }
        String msg = dataQueue.poll();
        System.out.println(name + " has consumed msg:: " + msg);
        System.out.println("Queue: " + dataQueue);
        System.out.println();
        notifyAll();
    }

    public synchronized void publishData(String message) throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (dataQueue.size() == capacity) {
            System.out.println("Queue Full!! " + name + " waiting for message to be consumed...");
            wait();
        }
        dataQueue.add(message);
        System.out.println(name + " published the message :: " + message);
        System.out.println("Queue: " + dataQueue);
        System.out.println();
        notifyAll();
    }
}
