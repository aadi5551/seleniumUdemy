package seleniumSection15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamTest1 {

	
	//Count the number of names starting with Alphabet A in List.
	//Traditional way to do it.
	//@Test
	public void regular() {
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Aditya");
		names.add("Himanshu");
		names.add("Suraj");
		
		int count=0;
		
		for(int i=0; i<names.size(); i++) {
			
			String actual =names.get(i);
			
			if(actual.startsWith("A")) {
				
				count++;
			}
		}
		
		System.out.println("This is count: "+count);
	}
	
	
	//Same above thing but using Java Streams
	//@Test
	public void streamFilter() {
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Aditya");
		names.add("Himanshu");
		names.add("Suraj");
		//there is no life for intermediate operation if there is no terminal operation.
		//Terminal operation will execute only if intermediate 	operation (filter) returns true.
		//We can create Stream.
		//How to use filter in Stream API.
		long c= names.stream().filter(scan->scan.startsWith("A")).count();
		System.out.println(c);
		
		//Works same as above but in optimized form.
		long cNew= Stream.of("Abhijeet","Don","Aditya","Himanshu","Suraj").filter(scan->scan.startsWith("A")).count();
		System.out.println(cNew);
		

		long d=  Stream.of("Abhijeet","Don","Aditya","Himanshu","Suraj").filter(scan->
				
				{
					scan.startsWith("A");
					return false;
		
				}).count();
		System.out.println("It is for 'd' "+ d);
		
		//print all the name of ArrayList using Java Stream without using any loop.
		//It shows all results.
		names.stream().filter(scan->scan.length()>4).forEach(var->System.out.println(var));
		//only shows first result from the filtered ArrayList.
		names.stream().filter(scan->scan.length()>4).limit(1).forEach(var->System.out.println(var));
	}
	
	//@Test
	public void streamMap(){
		
		//print names which have last letter as "a" with Uppercase
	 Stream.of("Azbhijeet","Don","Aditya","Himanshu","Suraja").filter(scan->scan.endsWith("a")).map(scan->scan.toUpperCase())
	 .forEach(scan->System.out.println(scan));
		
	 //print names which have first letter as "a" with uppercase and sorted.
	 //Use Arrays.asList(arg0); for converting Simple Arrays to ArraysList.
	 
	 List<String> arrName= Arrays.asList("Abhijeet","Don","Aditya","Himanshu","ASuraja");
	 arrName.stream().filter(scan->scan.startsWith("A")).sorted().map(scan->scan.toUpperCase())
	 .forEach(scan->System.out.println(scan));
		
	 
	 //Merging List A and List B to a single List.
	 ArrayList<String> names= new ArrayList<String>();
		names.add("man");
		names.add("qwerty");
		names.add("Women");
		names.add("child");
		names.add("Adam");
		
		//Merging 2 different Lists
		Stream<String> newStream =Stream.concat(names.stream(), arrName.stream());
		//newStream.sorted().forEach(scan->System.out.println(scan));
		
		boolean flag= newStream.anyMatch(scan->scan.equalsIgnoreCase("Adadsfm"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	
	@Test
	public void streamCollect() {
		
		//List
		//New list

		List<String> ls=  Stream.of("Azbhijeet","Don","Aditya","Himanshu","Suraja").filter(scan->scan.endsWith("a")).map(scan->scan.toUpperCase())
		 .collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		
		// Assignement task
		List<Integer> values= Arrays.asList(1,4,5,2,4,1,6,7,3,6,8,3,4,3,2,0,5);
		//print the unique number from this array
		//sort the array
		
		//Print unique values from array list.
		values.stream().distinct().sorted().forEach(scan->System.out.println(scan));
		//sort it in sorted order- 3rd index - 
		List<Integer> intList= values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("This is last println: "+intList.get(2));
		
	}
	
	
	
	
	
}
