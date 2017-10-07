package myproj.mysoln;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class MyCallable implements Callable<Integer> {


	int val = 0;
	ReentrantLock li;
	public ReentrantLock getLi() {
		return li;
	}

	public void setLi(ReentrantLock li) {
		this.li = li;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Locked: " + li.isLocked());
	    System.out.println("Held by me: " + li.isHeldByCurrentThread());		
		
		li.lock();
		val++;
		//wl.unlock();
		
		Thread.sleep(1000);
		// return the thread name executing this callable task
		return val;
	}

	public static void main(String args[]) {
		// Get ExecutorService from Executors utility class, thread pool size is
		// 10
		ReentrantLock lock = new ReentrantLock();
		
		LockInterface li = new LockInterface();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		// create a list to hold the Future object associated with Callable
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		List<Future<Integer>> list1 = new ArrayList<Future<Integer>>();
		// Create MyCallable instance
		MyCallable callable = new MyCallable();
		MyCallable callable1 = new MyCallable();
		
		callable.setLi(lock);
		for (int i = 0; i < 5; i++) {
			// submit Callable tasks to be executed by thread pool
			Future<Integer> future = executor.submit(callable);
			Future<Integer> future1 = executor.submit(callable1);
			// add Future to the list, we can get return value using Future
			list.add(future);
			list1.add(future1);
		}
		for (Future<Integer> fut : list) {
			try {
				// print the return value of Future, notice the output delay in
				// console
				// because Future.get() waits for task to get completed
				System.out.println(new Date() + "::" + fut.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		for (Future<Integer> fut : list1) {
			try {
				// print the return value of Future, notice the output delay in
				// console
				// because Future.get() waits for task to get completed
				System.out.println(new Date() + "::" + fut.get());
				fut.
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// shut down the executor service now
		executor.shutdown();
	}

}