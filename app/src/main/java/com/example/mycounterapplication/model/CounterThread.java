package com.example.mycounterapplication.model;

public class CounterThread extends Thread {
    long minPrime;
    public int counter;
    boolean running;
    public CounterThread(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        // compute primes larger than minPrime
        running = true;
        while (running)
        {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }
}
