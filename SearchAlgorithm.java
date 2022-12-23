/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {

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
                }
            }
            array4.add(charsInARow);
            charsInARow = 0;
        }
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < array.length; i++)
        {
            //int num = array4.get(i);
            map.put(array4.get(i), String.valueOf(i));
        }
        Collections.sort(array4, Collections.reverseOrder()); 

        for(int i = 0; i < array.length; i++)
        {
            //int num = array4.get(i);
            System.out.println(map.get(array4.get(i)));
        }
	}
}
