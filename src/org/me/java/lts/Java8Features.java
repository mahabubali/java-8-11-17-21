package org.me.java.lts;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Java8Features {
	public static void main(String[] args) {
		//1. Lambda Expression
		List<String> names = Arrays.asList("Alice", "Bob", "John"); 
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			System.out.println("Hi "+it.next());
		}
		names.forEach(name -> System.out.println("Hi " + name));
		
		
		//2. Streams
		List<String> fruits = Arrays.asList("Apple", "Banana", "Grapes", "Avacado"); 
				List<String> filtered = fruits.stream()					
				.filter(s -> s.startsWith("A"))
				.map(s -> s.toUpperCase())
				.limit(1)
				.collect(Collectors.toList()); 
				System.out.println(filtered);
				
		
		//3. Functional Interface
		Greeting eng = (name) -> System.out.println("Hello " + name);
		eng.say("John");
		Greeting fr = (name) -> System.out.println("Bonjour " + name); 
		fr.say("Mark");
		//The four pillars of FunctionalInteface
		Function<String, Integer> len = str -> str.length();
		System.out.println(len.apply("hello"));
		Consumer<String> printUpper = str -> System.out.println(str.toUpperCase());
		printUpper.accept("hello");
		Predicate<Integer> isEven = num -> num%2 == 0;
		System.out.println(isEven.test(12));
		Supplier<String> greet = () -> "Hello from Supplier!";
		System.out.println(greet.get());
		
		
		//4. default Methods in Interface.
		eng.sayHello();			//default method
		eng.say("Tyler");     	//single abstract method
		Greeting.getMessage();	//static method
		
		
		//5. Optional Class
		String name = "Java";
		Optional<String> name1 = Optional.ofNullable(null); 
		System.out.println(name1.orElse("Empty"));
		
		User userWithEmail = new User("Alice", "alice@example.com");
		User userWithoutEmail = new User("Bob", null);
		System.out.println("Email: "+userWithEmail.getEmail().orElse("Email not provided"));   
		System.out.println("Email: "+userWithoutEmail.getEmail().orElse("Email not provided")); 
		
	}
}


@FunctionalInterface
interface Greeting {
	void say(String name);
	
	default void sayHello() {
		System.out.println("Hello there!");
	}
	
	static void getMessage() {
		System.out.println("Hello from static method!");
	}
}



class User {
	private String name;
	private String email;
	public User(String name, String email) {
	    this.name = name;
	    this.email = email;
	}
	
	public Optional<String> getEmail() {
	    return Optional.ofNullable(email);
	}
}
