package org.me.java.lts;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Java11Features {

	public static void main(String[] args) throws Exception {		
		//1.String methods example 
		String blankStr = "    ";	    
		String str = "  Hello, Java 11!  ";	       
        System.out.println(blankStr.isBlank()); 	//true
        System.out.println(str.strip()); 			//"Hello, Java 11!"
        System.out.println(str.strip().repeat(3)); 	//"Hello, Java 11!Hello, Java 11!Hello, Java 11!"      
        str.lines().forEach(System.out::println); 	//Prints each line
        
              
        //2.Var in Lambda example
        List<String> names = List.of("Alice", "Bob", "Charlie");   
        names.forEach((var name) -> System.out.println(name));
        List<Integer> nums = List.of(18,7,36);
        nums.forEach((var name) -> { name++; System.out.println(name);});
        
        
        //3.FileMethodsExample
        Path path = Paths.get("./example.txt");   
        Files.writeString(path, "Adding file contents to the file: example.txt! 123");  // Write to file      
        String content = Files.readString(path); // Read from file
        System.out.println(content); // "Hello, Java 11!"
         

        //4.HttpClientExample      
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.tcs.com"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        
               
        //5.NestBasedAccessExample 
        Inner inner = new Inner();
        inner.print(); // Accessing private method        
	}
	
	
	 private static class Inner {
        private void print() {
            System.out.println("Hello from Inner!");
        }
    }
}
