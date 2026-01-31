package com.yatish.thread;

class MyTask implements Runnable {
    public void run() {
        System.out.println("Thread running");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        
//        Runnable runnable=new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Run 1");
//			}
//		};
//		
//		Runnable runnable2=new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Run 2");
//			}
//		};
//		
//		Runnable runnable3=new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Run 3");
//			}
//		};
//        
//		Thread t1 = new Thread(runnable);
//		Thread t2 = new Thread(runnable2);
//		Thread t3 = new Thread(runnable3);
//
//		t1.start();
//		t2.start();
//		t3.start();

    	Demo d=new Demo();
    }
}


class Demo {
	Demo(){
	        for (int i = 1; i < 10; i++) {
	            int threadNo = i;

	            Runnable runnable = new Runnable() {
	                @Override
	                public void run() {
	                    System.out.println("Run " + threadNo +
	                            " | Thread name: " + Thread.currentThread().getName());
	                }
	            };

	            Thread t = new Thread(runnable);
	            t.start(); 
	        }
	    
	}
}
