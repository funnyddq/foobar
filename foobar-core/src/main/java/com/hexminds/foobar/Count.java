package com.hexminds.foobar;

public class Count {
    private int num;
    public void count() {
        for(int i = 1; i <= 10; i++) {  
            num += i;  
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-" + num);  
    }  
}  