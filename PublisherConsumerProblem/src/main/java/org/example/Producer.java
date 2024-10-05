package org.example;

public class Producer implements Runnable {
    private InMemoryBuffer inMemoryBuffer;
    final String[] data = new String[]{"Sup", "Hello", "Dragon", "Thor"};

    public Producer(InMemoryBuffer inMemoryBuffer) {
        this.inMemoryBuffer = inMemoryBuffer;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                Thread.sleep(1000);
                inMemoryBuffer.publishData(data[i]);
                i = (i + 1) % data.length;
            }
        } catch (InterruptedException e) {
        }
    }
}
