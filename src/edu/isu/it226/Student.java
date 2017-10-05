/*
 * File name: Student.java
*
* Programmer: Luke O'Shanna
* ULID: LROSHAN
*
* Date: Oct 3, 2017
*
* Class: IT 179
*/
package edu.isu.it226;

import java.util.ArrayList;

/**
 *<insert class description here>
 *
 * @author Luke
 *
 */
public class Student
{
	int nameCount = 0;
	int nameIndex1 = -1;
	int nameIndex2 = -1;
	int idIndex = -1;
	ArrayList<String> header;
	String[] data;
	String course;
	String semester;
	String year;
	
	

	
	public Student(String[] data, ArrayList<String> header, String course, String semester, String year)
	{
		this.data = data;
		this.header = header;
		this.course = course;
		this.semester = semester;
		this.year = year;
		checkHeader();
	}
	
	
	
	
	
	
	public void checkHeader()
	{
		 
		
		for(int i=0; i < header.size(); i++)
		{
			String column = header.get(i).toString().toLowerCase();
			
			if(column.contains("name"))
			{
				nameCount++;
				if(nameIndex1 == -1)
				{
					nameIndex1 = i;
				}
				else
				{
					nameIndex2 = i;
				}
			}
			else if(column.contains("id"))
			{
				idIndex = i;
			}
		}
	}
	
	public String toString()
	{
		return null;
		
	}
	
}
