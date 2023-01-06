import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;


public class SearchAlgorithm
{
	public static void main(String[] args) 
	{
        String[] array = {"johnjacobs", "jacobjohn", "johnjoco", "robertdowneyjr", "josephrodrigo", "bradhullinger", "arianagrande", "elonmusk", "oprahwinfrey", "philipvegas", "rodneyhullinger", "oliverwhicom", "ralphnaider", "michaelphelps",
		"selenagomez", "amandacerny", "chrisevans", "chrishemsworth", "bradpitt", "bradleycooper", "anadearmas", "oliviarodrigo", "billgates", "jimcarrey", "davechappel", "lebronjames", "willsmith", "sethmacfarlane",
		"dualipa", "alexisren", "emmawatson", "donaldjtrump", "joebiden", "edwardnorton", "billgates", "markzuckerberg", "beyonce", "kevinhart", "jimcarrey", "jenniferlopez",
            "justinbieber", "icecube", "therock", "galgagot", "chrisbrown", "robertdowneryjr", "leonardodicaprio", "tomcruise", "charliechaplin", "morganfreeman", "tomhanks",
			"hughjackman", "ryanreynolds", "blakelively", "mattdamon", "sylvesterstallone", "camerondiaz", "georgeclooney", "stevenspielberg", "harrisonford", "robertdeniro", "alpacino", "russelcrowe", "liamneeson", "katewinslet",
			"markwahlberg", "natalieportman", "piercebrosman", "seanconnery", "orlandobloom", "katieperry", "dwaynejohnson", "jackiechan", "jetli", "adamsandler", "davidspade", "scarlettjohansson", "annehathaway", "jessicaalba",
			"willferrell", "juliarobert", "juliaroberts", "jenifferaniston", "nicolascage", "danielcraig", "keanureeves", "ianmckellen", "halleberry", "brucewillis",
			"samuelljackson", "benstiller", "tommyleejones", "denzelwashington", "stevecarell", "meganfox", "vindiesel", "timallen", "robinwilliams", "owenwilson", "zachgalifianakis", "chistianbale", "sandrabullock", "brucelee", "drewbarrymore", "jacknicholson", "billmurray", "jasonstatham", "katebeckinsale"
        };
        int charsInARow = 0;
        ArrayList<Integer> array4 = new ArrayList<Integer>(array.length);
        System.out.println("Please enter the name you are searching for");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        char[] array1 = input.toCharArray();
		int num = 10;
		int x = 0;
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
			if(charsInARow == array2.length)
			{
				charsInARow = charsInARow + 2;
			}
			while(x < array4.size())
            {
                if(array4.get(x).equals(charsInARow))
                {
                    charsInARow++;
                }
                x++;
            }
            x = 0;
            //1 or 2 charsInARow and above is suitable for a small sample size.
			//if we have millions or billions of account names, we could require
			//3, 4, or 5 charsInARow to count the account name in our list of results
			//because repeat values for charsInARow in our HashMap will automatically default
			//to the last assigned input to the hashmap, and will possibly print those values 
			//multiple times in a row.
            if(charsInARow > 2)
            {
                array4.add(charsInARow);
            }else{
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
		if(array4.get(0) == 0)
        {
            System.out.println("No accounts match your search");
            System.out.println("Please enter a more specific search");
        }
        int value = 0;
        int l = 0;
        for(int i = 0; i < num; i++)
        {
            if(array4.get(i) > 0)
            {
                System.out.println("Account: " + array[map.get(array4.get(i))] + " matches your search  ");
                System.out.print("array[" + String.valueOf(map.get(array4.get(i))) + "]  ");
				value = map.get(array4.get(i)) + 1;
                System.out.println("Account number " + String.valueOf(value) + "  ");
			   System.out.println("has the most matching characters to your search");
            }
        }
	}
}