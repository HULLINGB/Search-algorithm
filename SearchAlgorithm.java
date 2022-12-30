import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class SearchAlgorithm
{
	public static void main(String[] args) 
	{

        String[] array = {"John", "Jacob", "Joseph", "Brad", "Ariana", "Elon", "Oprah", "Philip", "Rodney", "Oliver", "Ralph"};
        int charsInARow = 0;
        ArrayList<Integer> array4 = new ArrayList<Integer>(array.length);
        System.out.println("Please enter the name you are searching for");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        char[] array1 = input.toCharArray(); 

        for(int a = 0; a < array.length; a++)
        {
        char[] array2 = array[a].toCharArray();
        
            for(int i = 0; i < array1.length; i++)
            {
                if(array1[i] == array2[i])
                {
                    charsInARow = charsInARow + 1;
                }else{
                    break;
                }
            }
			//1 or 2 charsInARow and above is suitable for a small sample size.
			//if we have millions or billions of account names, we could require
			//3, 4, or 5 charsInARow to count the account name in our list of results
			//because repeat values for charsInARow in our HashMap will automatically default
			//to the last assigned input to the hashmap, and will possibly print those values 
			//multiple times in a row.
            if(charsInARow > 0)
            {
                array4.add(charsInARow);
            }else
            {
                array4.add(0);
            }
            charsInARow = 0;
        }
		
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++)
        {
            map.put(array4.get(i), i);
        }
        Collections.sort(array4, Collections.reverseOrder()); 
        int value = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array4.get(i) > 0)
            {
                value = map.get(array4.get(i)) + 1;
                System.out.println("Account: " + array[map.get(array4.get(i))] + " matches your search  ");
                System.out.print("array[" + String.valueOf(map.get(array4.get(i))) + "]  ");
                System.out.println("Account number " + String.valueOf(value) + "  ");
			   System.out.println("has the most matching characters to your search");
            }
        }
	}
}