package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        //Random rand = new Random();
        int philosophers = 5;
        int forks = philosophers;
        int steps = 3;
        int producers = philosophers;
        System.out.println("Forks: " + forks + "\nSteps: "
                + steps + "\nPhilosophers: " + philosophers);
        main.starter(forks, steps, philosophers);
    }

    private void starter(int forks, int steps, int philosophers) {

        Manager manager = new Manager(forks);
        Philosopher[] arr = new Philosopher[5];
        for (int i = 0; i < philosophers; i++) {
            arr[i] = new Philosopher(steps, manager, "Philosopher " + (i + 1));
        }
        for (int i = 0; i < philosophers; i++) {
            arr[i].Start();
        }

    }
}
