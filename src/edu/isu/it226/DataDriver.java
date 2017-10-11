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
	

	private void generate()
	{
		System.out.println("Please enter in the name of the file you would like to add:");
		String file = input.next();
		i.getInput(file);
		
	}
	//TODO: Ask rishi about semester and year input
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

		for (int i = 0; i < students.size() ; i++)
		{
			if(students.get(i).getId().equals(id))
			{
				o.write(students.get(i).toString());
			}
		}

	}
	
	public void finish()
	{
		if(input != null)
		{
			input.close();
		}
		o.finish();
		i.finish();
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
			generate();
		}
		else if (choice.equals("s"))
		{
			o.initialize();
			write();
		}
		else if (choice.equals("g"))
		{
			gradeCheck();
		}
		else if (choice.equals("e"))
		{
			System.out.println("Goodbye!");
			finish();
			return;
		}
		else
		{
			System.out.println("Invalid input, please try again");
			menu();
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
