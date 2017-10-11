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
	private int nameCount = 0;
	private int nameIndex1 = -1;
	private int nameIndex2 = -1;
	private int idIndex = -1;
	private int gradeIndex = -1;
	private ArrayList<String> header;
	private String[] data;
	private String name;
	private String id;
	private String course;
	private String semester;
	private String year;
	private String grade;
	private ArrayList<String> assignments = new ArrayList<String>();
	private ArrayList<String> assignmentData = new ArrayList<String>();
	
	private boolean idFound = false;
	

	
	public Student(String[] data, ArrayList<String> header, String course, String semester, String year)
	{
		this.data = data;
		this.header = header;
		this.course = course;
		this.semester = semester;
		this.year = year;
		checkHeader();
		transferData();
	}
	
	
	
	public void transferData()
	{
		int count = 0;
		for (int i = 0; i < header.size(); i++)
		{
			if(!(i == nameIndex1 || i == nameIndex2 || i == idIndex || i == gradeIndex))
			{
				assignments.add(header.get(i));
				assignmentData.add(data[i]);
			}
		}
		grade = data[gradeIndex];
		id = data[idIndex];
		if(nameCount > 1)
		{
			name = data[nameIndex1] + " " + data[nameIndex2];
		}
		else 
			{
			name = data[nameIndex1];
			}
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
			else if(column.contains(" id") && !idFound)
			{
				idIndex = i;
				idFound = true;
			}
			else if(column.contains("grade"))
			{
				gradeIndex = i;
			}
		}
	}
	
	
	//TODO: Ask rishi about formatting issues
	public String toString()
	{
		
		String output = "";
		output += "Student ID,Course,Semester,Year,";
		for (int i = 0; i < assignments.size(); i++)
		{
			output += assignments.get(i)+",";
		}
		output += "\n";
		output += id + "," + course + "," + semester + "," + year + ",";
		for (int i = 0; i < assignmentData.size(); i++)
		{
			output += assignmentData.get(i)+",";
		}
		output += "\n";
		return output;
		
	}






	public int getNameCount()
	{
		return nameCount;
	}

	public int getNameIndex1()
	{
		return nameIndex1;
	}

	public int getNameIndex2()
	{
		return nameIndex2;
	}

	public int getIdIndex()
	{
		return idIndex;
	}

	public int getGradeIndex()
	{
		return gradeIndex;
	}

	public ArrayList<String> getHeader()
	{
		return header;
	}

	public String[] getData()
	{
		return data;
	}

	public String getCourse()
	{
		return course;
	}

	public String getSemester()
	{
		return semester;
	}

	public String getYear()
	{
		return year;
	}

	public String getGrade()
	{
		return grade;
	}
	
	public String getId()
	{
		return id;
	}
	
	
}
