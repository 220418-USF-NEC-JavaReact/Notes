package com.example;

import java.util.LinkedList;

public class Consumer implements Runnable{

    private LinkedList<Integer> buffer;
    private final int SIZE = 10;

    public Consumer(LinkedList<Integer> buffer){
        this.buffer = buffer;
    }

    private int consume() throws InterruptedException {
        synchronized(buffer){
            while(buffer.isEmpty()){
                System.out.println("The buffer is empty, wait for something to be produced");
                buffer.wait();
            }

            
            int ret = buffer.remove(0);
            buffer.notifyAll();
            return ret;
        }
    }


    @Override
    public void run() {
        for(int i=0; i<SIZE; i++){
            try{
                System.out.println("Consumed: " + this.consume());
                //If we wanted to slow this down, we could make the thread sleep with
                Thread.sleep(500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
}
