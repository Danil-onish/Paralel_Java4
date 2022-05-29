package com.company;

public class Philosopher implements Runnable {
    private final int steps;
    private final Manager manager;
    private final String name;

    public Philosopher(int steps, Manager manager, String name) {
        this.steps = steps;
        this.manager = manager;
        this.name = name;
    }

    public void Start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < steps; i++) {
            try {
                manager.empty.acquire();
                manager.forks.acquire();
                manager.storage.remove(0);
                System.out.println(" - " + name + " took left fork.   Forks left: " + manager.storage.size());
                manager.access.acquire();
                manager.forks.acquire();
                manager.storage.remove(0);
                System.out.println(" - " + name + " took right fork.  Forks left: " + manager.storage.size());
                System.out.println(name + " is eating...         Forks left: " + manager.storage.size());
                manager.access.release();
                manager.empty.release();
                Thread.sleep(1000);//Eating

                manager.access.acquire();
                manager.storage.add("fork");
                manager.storage.add("fork");
                manager.forks.release(2);
                System.out.println(" + " + name + " returned forks.   Forks left: " + manager.storage.size());
                System.out.println(name + " is thinking...       Forks left: " + manager.storage.size());
                manager.access.release();

                Thread.sleep(1000);//Thinking

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}