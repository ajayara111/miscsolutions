package my.experiment.code;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LockInterface {
	ReentrantReadWriteLock l = new ReentrantReadWriteLock();
	ReadLock rl = l.readLock();
	WriteLock wl = l.writeLock();
	Semaphore sp = new Semaphore(1);
	public void setWriteLock(){
		try{
		sp.acquire();
		//wl.lock();
		}
		catch (Exception e){
			System.out.println("Exception " + e.getMessage());
			
		}
	}
	
	public void unsetWriteLock(){
		sp.release();
	}
}
