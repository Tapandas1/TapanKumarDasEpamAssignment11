package epampep.assign10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));
        do
        {	System.out.println("Menu:");
        	System.out.println("1.Average of Integers");
        	System.out.println("2.Strings having length = 3 and starting with a");
        	System.out.println("3.Pallindrome Strings");
        	int x = Integer.parseInt(input.readLine().trim());
        	switch(x) {
        	case 1:  System.out.println("Enter the integers separated by space");
        			 List<Integer> listOfNumbers = Arrays.asList(input.readLine().trim().split(" ")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        			 System.out.println(averageOfList(listOfNumbers));
        			 break;
	        case 2:  System.out.println("Enter the Strings separated by space");
	        		 List<String> words = Arrays.asList(input.readLine().trim().split(" "));
	        		 Predicate<String> predicate = (s)->s.length()==3 && s.charAt(0)=='a';
	        		 List<String> result = stringsWithA(words,predicate);
	        		 System.out.println(result);
	        		 break;
	        case 3:  System.out.println("Enter input separated by Space");
			 		 List<String> wordsInput = Arrays.asList(input.readLine().trim().split(" "));		 
			 		 List<String> pallindromeStrings = pallindromeList(wordsInput,App::isPallindrome);
			         System.out.println(pallindromeStrings);
			         break;
			default:System.out.println("Wrong Input!!!!!");
	        }
	        System.out.println("Do you want to continue");
	        char c = input.readLine().trim().charAt(0);
	        if(c=='N' || c=='n')
	        	break;
        }while(true);
    }
    public static double averageOfList(List<Integer> numbers) {
    	double average = numbers.stream().mapToInt(Integer::intValue).sum()/numbers.stream().count();
    	return average;
    }
    public static List<String> stringsWithA(List<String> Strings, Predicate<String> predicate){
		List<String> result = Strings.stream().filter(predicate).collect(Collectors.toList());
		return result;
	}
    public static boolean isPallindrome(String word) {
    	for(int i=0;i<word.length()/2;i++) 
    		if(word.charAt(i)!=word.charAt(word.length()-i-1))
    			return false;
    	return true;
    }
    public static List<String> pallindromeList(List<String> Strings, Predicate<String> predicate){
		List<String> result = new ArrayList<String>();
		for(String s:Strings) {
			if(predicate.test(s))
				result.add(s);
		}
		return result;
	}
	
} 
