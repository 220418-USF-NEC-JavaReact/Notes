package com.example;

import java.util.LinkedList;

public class Producer extends Thread{
    
    //The shared buffer between the producer and consumer
    private final LinkedList<Integer> buffer;
    //The max amount of items to store in our buffer
    private final int SIZE = 10;

    public Producer(LinkedList<Integer> buffer){
        this.buffer = buffer;
    }

    //Create a private method, which handles the producing logic
    private void produce(int i) throws InterruptedException {
        //For the producer and the consumer, we are sharing a buffer, so we should use synchronized
        synchronized(buffer){
            while(buffer.size() == SIZE){
                System.out.println("The buffer is full, waiting");
                buffer.wait();
            }

            buffer.add(i);
            //Notify all the threads also sharing the buffer
            //This will essentially send a message to all threads talking with the buffer
            //And tell them "hey I got updated"
            buffer.notifyAll();
        }
    }

    //To actually provide logic to the thread, we must override the run method
    @Override
    public void run(){
        for(int i=0; i<SIZE; i++){
            System.out.println("Producing: " + (i+1));
            try{
                this.produce(i+1);
                Thread.sleep(500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
