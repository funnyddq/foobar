package com.hexminds.foobar;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {  
        JoinThread t1 = new JoinThread("t1");  
        JoinThread t2 = new JoinThread("t2");  
        t1.start();  
        t2.start();  
        t1.join();  
        t2.join();  
        System.out.println("主线程开始执行！");  
    }  
}  
class JoinThread extends Thread {  
    public JoinThread(String name) {  
        super(name);  
    }  
    public void run() {  
        for(int i = 1; i <= 10; i++)  
            System.out.println(getName() + getId() + "执行了" + i + "次");  
    }  
}  