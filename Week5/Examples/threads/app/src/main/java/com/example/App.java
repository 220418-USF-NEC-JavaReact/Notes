/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        
        LinkedList<Integer> buffer = new LinkedList<>();

        //To create a thread created from extending the thread class
        Producer producer = new Producer(buffer);
        producer.setPriority(Thread.MAX_PRIORITY);

        //To create a thread created from implemeting the runnable interface
        Consumer cRunnable = new Consumer(buffer);
        Thread consumer = new Thread(cRunnable);

        //To start the logic in each thread
        producer.start();
        consumer.start();

        //To merge them back into the main thread
        try{
            producer.join();
            consumer.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
