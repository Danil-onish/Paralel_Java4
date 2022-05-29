package com.company;

public class Producer implements Runnable {
    private final int forks;
    private final Manager manager;
    private final String name;

    public Producer(int forks, Manager manager, String name) {
        this.forks = forks;
        this.manager = manager;
        this.name = name;

        new Thread(this).start();
    }

    @Override
    public void run() {

        try {
            manager.access.acquire();
            for (int i = 0; i < forks; i++) {
                //manager.forks.release();
                //manager.empty.release();
                manager.storage.add("fork");
                System.out.println(" + Added fork to storage ");
                //manager.Items++;

                //manager.empty.release();
            }
            manager.access.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}