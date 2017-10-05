/*
 * File name: Input.java
*
* Programmer: Luke O'Shanna
* ULID: LROSHAN
*
* Date: Oct 4, 2017
*
* Class: IT 179
*/
package edu.isu.it226;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *<insert class description here>
 *
 * @author Luke
 *
 */
public class Input
{

	Scanner scan = null;
	ArrayList<String> header;
	ArrayList<Student> students = new ArrayList<Student>();
	String[] temp;
	int studentCount = 0;
	int studentCountCurrent = 0;
	String course;
	String semester;
	String year;
	
	public void getInput(String file)
	{
		try
		{
			scan = new Scanner(new File(file));
			
			
		}
		catch (Exception e)
		{
			System.out.println("Incorrect file path");
			return;
		}
		
		String[] courseInfo = file.split("-");
		course = courseInfo[0];
		semester = courseInfo[1];
		year = courseInfo[2];
		
		header =  new ArrayList<String>(Arrays.asList(scan.nextLine().split(",")));

		makeStudents();
	}
	
	public void makeStudents()
	{	
		while(scan.hasNextLine())
		{
			temp = scan.nextLine().split(",");
			students.add(new Student(temp, header, course, semester, year));
			studentCount++;
		}
		
		System.out.println("Students added: " + (studentCount - studentCountCurrent));
		System.out.println("Students already in database: " + studentCountCurrent);
		studentCountCurrent = studentCount;
	}
	

		
	
}
	
	


