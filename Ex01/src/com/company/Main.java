package com.company;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        ArrayList<Philosopher> philophers = new ArrayList<Philosopher>();
        Lock[] forks = new ReentrantLock[5];
        
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < 5; i++) {
            philophers.add(new Philosopher(i, forks));
        }

        for (int i = 0; i < philophers.size(); i++) {
            philophers.get(i).start();
        }
    }
}
