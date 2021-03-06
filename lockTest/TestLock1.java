package cn.zzl.lockTest;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock1 {
	private ArrayList<Integer> arrayList = new ArrayList<>();
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		final TestLock1 test = new TestLock1();
		
		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			}; 
		}.start();
		
		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			}; 
		}.start();
	}
	
	public void insert(Thread thread) {
		lock.lock();//获取锁
		try {
			//
			System.out.println(thread.getName()+"得到了锁");
			for(int i=0;i<5;i++) {
				arrayList.add(i);
			}
		}catch(Exception e) {
			//
		}finally {
			System.out.println(thread.getName()+"释放了锁");
			lock.unlock();//释放锁
		}
	}
}
