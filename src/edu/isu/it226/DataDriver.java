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

import java.util.ArrayList;
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
	Output o = new Output();
	
	
	
	
	
	//TestMethod for now
	private void generate()
	{
		System.out.println("Please enter in the name of the file you would like to add:");
		String file = input.next();
		i.getInput(file);
		
	}
	
	private void gradeCheck()
	{
		System.out.println("Please enter in course number, or enter in none");
		String course = input.next(); 
		System.out.println("Please enter in semester, or enter in none");
		String semester = input.next();
		String year = "";
		if(!semester.equals("none"))
		{
			System.out.println("Please enter in year, or enter in none");
			 year = input.next();
		}
		
		
		
		ArrayList<Student> students = i.students;
		int[] output = new int[5];
		
		if(course.equals("none") && semester.equals("none"))
		{
			return;
		}
		else if(course.equals("none"))
		{
			for (int i = 0; i < students.size(); i++)
			{
				if(students.get(i).getSemester().equals(semester) && students.get(i).getYear().equals(year))
				{
					if(students.get(i).getGrade().equals("A"))
					{
						output[0]++;
					}
					else if(students.get(i).getGrade().equals("B"))
					{
						output[1]++;
					}
					else if(students.get(i).getGrade().equals("C"))
					{
						output[2]++;
					}
					else if(students.get(i).getGrade().equals("D"))
					{
						output[3]++;
					}
					else if(students.get(i).getGrade().equals("F"))
					{
						output[4]++;
					}
				}
			}
		}
		else if(semester.equals("none"))
		{
			for (int i = 0; i < students.size(); i++)
			{
				if(students.get(i).getCourse().equals(course))
				{
					if(students.get(i).getGrade().equals("A"))
					{
						output[0]++;
					}
					else if(students.get(i).getGrade().equals("B"))
					{
						output[1]++;
					}
					else if(students.get(i).getGrade().equals("C"))
					{
						output[2]++;
					}
					else if(students.get(i).getGrade().equals("D"))
					{
						output[3]++;
					}
					else if(students.get(i).getGrade().equals("F"))
					{
						output[4]++;
					}
				}
			}
		
		
		
		}
		else
		{
			for (int i = 0; i < students.size(); i++)
			{
				if(students.get(i).getCourse().equals(course) && students.get(i).getSemester().equals(semester) && students.get(i).getYear().equals(year))
				{
					if(students.get(i).getGrade().equals("A"))
					{
						output[0]++;
					}
					else if(students.get(i).getGrade().equals("B"))
					{
						output[1]++;
					}
					else if(students.get(i).getGrade().equals("C"))
					{
						output[2]++;
					}
					else if(students.get(i).getGrade().equals("D"))
					{
						output[3]++;
					}
					else if(students.get(i).getGrade().equals("F"))
					{
						output[4]++;
					}
				}
			}
		}
		
		System.out.println("A's: " + output[0]);
		System.out.println("B's: " + output[1]);
		System.out.println("C's: " + output[2]);
		System.out.println("D's: " + output[3]);
		System.out.println("F's: " + output[4]);
	}
	
	
	
	public void write()
	{
		System.out.println("Please enter in the student ID");
		String id = input.next();
		ArrayList<Student> students = i.students;
//		System.out.println(students.size());
		for (int i = 0; i < students.size() ; i++)
		{
			System.out.println(students.get(i).toString());
			if(students.get(i).getId().equals(id))
			{
				
				o.write(students.get(i).toString());
			}
		}
//		o.write("yes");
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
			o.initialize();
			write();
		}
		else if (choice.equals("g"))
		{
			//TODO: Set up get grade function(s)
			gradeCheck();
		}
		else if (choice.equals("e"))
		{
			System.out.println("Goodbye!");
			o.finish();
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
