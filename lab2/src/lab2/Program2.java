package lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Program2 {
		//private static SimpleCalculator calc = new SimpleCalculator();
	private static BetterCalculator calc = new BetterCalculator();
	private static ArrayList<String> operations = new ArrayList<String>();

		public static void main (String [] args)
		{
			// setup operations
			operations.add("+");
			operations.add("-");
			operations.add("*");
			operations.add("/");
			operations.add("^");
			
			//print Welcome message
			System.out.println("Welcome to my calculator program");
			System.out.println("Enter your values separated by your operations");
			System.out.println("For example: 12 + 3 - 4");
			System.out.println("Don't forget to put in spaces between the values and the operations");
			System.out.println("The calculator works left to right and does not");
			System.out.println("recognise brackets.");
			System.out.println("When you wish to stop the program type \"quit\"");
			System.out.print(">> ");
			
			// loop until the user wishes to quit
			/*while (parseInput())
			{
				System.out.print(">> ");
			}*/
			parseInput();
			
				
		}
		
		private static boolean parseInput() {
			String[] tokens = getInput();
			String operation = "+";
			
			// if no tokens then return
			if (tokens.length == 0)
				return true;
			
			for (String currentToken : tokens)
			{
				// if the input begins with 'quit' then exit
				if(currentToken.equals("quit"))
					return false;
				
				else if (operations.contains(currentToken))
				{
					operation = currentToken;
				}
				// else it should be a number convert to double and apply the operation
				else 
				{
					double number = Double.parseDouble(currentToken);
					if (operation.equals("+"))
						System.out.println(calc.add(number));
					else if (operation.equals("-"))
						System.out.println(calc.subtract(number));
					else if (operation.equals("*"))
						System.out.println(calc.times(number));
					else if (operation.equals("/"))
						System.out.println(calc.divides(number));
					else if (operation.equals("^"))
						System.out.println(calc.power(number));
					
				}
			}
			return true;
		}

		private static String[] getInput()
		{
			Scanner scan =  new Scanner (System.in);
			String line = scan.nextLine();
			scan.close();
			return line.split(" ");
		}
}

class BetterCalculator extends SimpleCalculator{
	public double times (double number)
	{
		total *= number;
		return total;
	}
	public double divides (double number)
	{
		total /= number;
		return total;
	}
	public double power (double number)
	{
		total = Math.pow(total, number);
		return total;
	}
}

