package org.me.java.lts;

import java.util.SequencedCollection;
import java.util.concurrent.Executors;
import java.util.ArrayList;

public class Java21Features {
	
	
	public static void main(String[] args) {
		//1. Virtual Thread
		// Platform Thread (traditional)
        Thread platformThread = new Thread(() -> {
            System.out.println("Platform thread name: " + Thread.currentThread().getName());
            System.out.println("Is virtual: " + Thread.currentThread().isVirtual());
        });
        platformThread.start();
        try {
			platformThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        // Virtual Thread (new in Java 21)
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("Virtual thread name: " + Thread.currentThread());
            System.out.println("Is virtual: " + Thread.currentThread().isVirtual());
        });     
        try {
			virtualThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       
		
		//2. Object Pattern Matching for switch		
		System.out.println(test(42));
		
		
		//3. Sequenced Collections: Provides predictable order methods
		SequencedCollection<String> seq = new ArrayList<>(); 
		seq.add("abc");
		seq.addLast("end");
		seq.addFirst("start");
		seq.add("bbc");
		System.out.println(seq);
		
				
		//4. String Templates: Embeds variables directly in strings.
		String name = "Java"; 
		//String msg = STR."Hello \{name}"; 
		//System.out.println(msg);		
	}
	


	static String test(Object o) {
		return switch (o) { 
			case String s -> "Text"; 
			case Integer i -> "Number"; 
			default -> "Unknown"; 
		};
	}
}