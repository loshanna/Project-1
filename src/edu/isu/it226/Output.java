/*
 * File name: Output.java
*
* Programmer: Luke O'Shanna
* ULID: LROSHAN
*
* Date: Oct 4, 2017
*
* Class: IT 179
*/
package edu.isu.it226;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *<insert class description here>
 *
 * @author Luke
 *
 */
public class Output
{

	
	PrintWriter output = null;
	
	public boolean initialize(String filepath)
	{
		
		try
		{
			output = new PrintWriter(filepath);
			return true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Incorrect file path");
			return false;
		}	
	}
	
	public void write(String data)
	{
		output.write(data);
		
	}
	
	public void finish()
	{
		if(!(output == null))
			{
			output.close();
			}
	}
}
