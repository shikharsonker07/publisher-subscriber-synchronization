package org.example;

public class Consumer implements Runnable {
    private InMemoryBuffer inMemoryBuffer;

    public Consumer(InMemoryBuffer inMemoryBuffer) {
        this.inMemoryBuffer = inMemoryBuffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                inMemoryBuffer.readData();
            }
        } catch (InterruptedException e) {
        }

    }
}
