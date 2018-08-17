package com.company;

import java.util.concurrent.locks.Lock;

public class Philosopher extends Thread {
	private int tablePosition;
	private Lock[] forks;

	public Philosopher(int tablePosition, Lock[] forks) {
		this.tablePosition = tablePosition;
		this.forks = forks;
	}

	public void threadSleep(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while(true) {
			this.threadSleep(); // Thinking
			
			this.forks[tablePosition].lock();
			System.out.println("Lock " + tablePosition + ", fork" + tablePosition);
			this.forks[(tablePosition + 1) % forks.length].lock();
			System.out.println("Lock " + tablePosition + ", fork" + (tablePosition + 1) % forks.length);
			
			this.threadSleep(); // Eating
			
			this.forks[tablePosition].unlock();
			System.out.println("Unlock " + tablePosition + ", fork" + tablePosition);
			this.forks[(tablePosition + 1) % forks.length].unlock();
			System.out.println("Unlock " + tablePosition + ", fork" + (tablePosition + 1) % forks.length);
		}
	}
}
