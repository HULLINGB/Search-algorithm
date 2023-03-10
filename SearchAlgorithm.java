import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;


public class Main
{
	
	public static void main(String[] args) 
	{
        String[] array = {"johnjacobs", "jacobjohn", "johnjoco", "robertdowneyjr", "josephrodrigo","elonmusk", "oprahwinfrey", "philipvegas", "rodneyhullinger", "oliverwhicom", "ralphnaider", "michaelphelps",
		"selenagomez", "amandacerny", "chrisevans", "chrishemsworth", "arianagrande", "bradleycooper", "bradhullinger", "anadearmas", "oliviarodrigo", "billgates", "jimcarrey", "davechappel", "lebronjames", "willsmith", "sethmacfarlane",
		"dualipa", "alexisren", "emmawatson", "donaldjtrump", "joebiden", "edwardnorton", "billgates", "markzuckerberg", "beyonce", "kevinhart", "jimcarrey", "jenniferlopez",
            "justinbieber", "icecube", "bradpitt", "therock", "galgagot", "chrisbrown", "robertdowneryjr", "leonardodicaprio", "tomcruise", "charliechaplin", "morganfreeman", "tomhanks",
			"hughjackman", "ryanreynolds", "blakelively", "mattdamon", "sylvesterstallone", "camerondiaz", "georgeclooney", "stevenspielberg", "harrisonford", "robertdeniro", "alpacino", "russelcrowe", "liamneeson", "katewinslet",
			"markwahlberg", "natalieportman", "piercebrosman", "seanconnery", "orlandobloom", "katieperry", "dwaynejohnson", "jackiechan", "jetli", "adamsandler", "davidspade", "scarlettjohansson", "annehathaway", "jessicaalba",
			"willferrell", "juliaroberts", "jenifferaniston", "nicolascage", "danielcraig", "keanureeves", "ianmckellen", "halleberry", "brucewillis",
			"samuelljackson", "benstiller", "tommyleejones", "denzelwashington", "stevecarell", "meganfox", "vindiesel", "timallen", "robinwilliams", "owenwilson", "zachgalifianakis", "christianbale", "sandrabullock", "brucelee", "drewbarrymore", "jacknicholson", "billmurray", "jasonstatham", "katebeckinsale"
        };
        int charsInARow = 0;
        ArrayList<Integer> array3 = new ArrayList<Integer>(array.length);
        System.out.println("Please enter the name you are searching for");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        char[] array1 = input.toCharArray();
		int num = 25;
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
			//Puttin this little checker will ensure that all the values
			//that dont have any matching characters get a higher charsInARow
			//for no reason. This is will make sure only accounts that had matching
			//characters will be part of the mechanism that creates different values
			//for the HashMap value reference so we dont have duplicate in our output
			
			if(charsInARow > 0)
			{
			  while(x < array3.size())
				{
					if(array3.get(x).equals(charsInARow))
					{
						charsInARow++;
					}
					x++;
				}
				x = 0;
			}
			if(array1.length > 1)
			{
			    if(charsInARow > 1)
			    {
			    array3.add(charsInARow);
			    }else{
			    array3.add(0);
			    }   
			}
			if(array1.length < 2)
			{
			    array3.add(charsInARow);
			}
            charsInARow = 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++)
        {
            map.put(array3.get(i), i);
        }
        Collections.sort(array3, Collections.reverseOrder()); 
		if(array3.get(0) == 0)
        {
            System.out.println("No accounts match your search");
            System.out.println("Please enter a more specific search");
        }
        int value = 0;
        for(int i = 0; i < num; i++)
        {
            if(array3.get(i) > 0)
            {
                System.out.println("Account: " + array[map.get(array3.get(i))] + " matches your search  ");
                System.out.print("array[" + String.valueOf(map.get(array3.get(i))) + "]  ");
				value = map.get(array3.get(i)) + 1;
                System.out.println("Account number " + String.valueOf(value) + "  ");
			   System.out.println("has the most matching characters to your search");
            }
        }
	}
}