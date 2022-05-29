package com.company;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Manager {

    public Semaphore access;
    public Semaphore forks;
    public Semaphore empty;

    public ArrayList<String> storage = new ArrayList<>();

    public Manager(int forkss) {
        access = new Semaphore(2);
        forks = new Semaphore(forkss);
        empty = new Semaphore(1);

        for (int i = 0; i < forkss; i++) {
            storage.add("fork");
            System.out.println(" + Added fork to storage ");
        }
        System.out.println("Forks left: " + storage.size());
    }
}