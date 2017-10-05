/*
 * File name: DataDriver.java
*
* Programmer: Luke O'Shanna
* ULID: LROSHAN
*
* Date: Oct 4, 2017
*
* Class: IT 179
*/
package edu.isu.it226;

import java.util.Scanner;

/**
 *<insert class description here>
 *
 * @author Luke
 *
 */
public class DataDriver
{
	Scanner input = new Scanner(System.in);
	Input i = new Input();
	
	
	
	
	//TestMethod for now
	private void generate()
	{
		i.getInput("226-fall-1996.csv");
	}
	
	
	//Generates menu
	private void menu()
	{
		System.out.println("Please enter in a command");
		System.out.println("a. Add data");
		System.out.println("s. Save data");
		System.out.println("g. Get grades");
		System.out.println("e. Exit program");
		String choice = input.next();
		if (choice.equals("a"))
		{
			//TODO: Set up add data function(s)
			generate();
		}
		else if (choice.equals("s"))
		{
			//TODO: Set up save data function(s)
		}
		else if (choice.equals("g"))
		{
			//TODO: Set up get grade function(s)
		}
		else if (choice.equals("e"))
		{
			System.out.println("Goodbye!");
			return;
		}
		else
		{
			System.out.println("Invalid input, please try again");
			menu();
			System.out.println("menu error");
			return;
		}
		menu();
	}

	public static void main(String[] args)
	{
		DataDriver driver = new DataDriver();
		driver.menu();
	}

}
