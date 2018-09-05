package firstProject;

import javax.swing.JOptionPane;

public class StudentListing {
	 private String name;  // key field
	 private String address;
	 private int number; //id number
	 private double GPA;

	 public StudentListing() {

	 }

	 public StudentListing(String n, String a, int num, double GPA)  {
		  this.name = n;
	      this.address = a;
	      this.number = num;
	      this.GPA = GPA;
	  }

	   public String toString( ){
		   return("Name is " + name +  ". Address is " + address + ". Number is " + number + "\n");
	   }
	   public StudentListing deepCopy( ) {
		  StudentListing clone = new StudentListing(name, address, number, GPA);
	      return clone;
	   }
	   public int compareTo(String targetKey)  {
		   return(name.compareTo(targetKey));
	   }

	  public String getAddress() {
		  return address;
	  }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}

  	public  void input() {
		name  = JOptionPane.showInputDialog("Insert the student's name");
		address =  JOptionPane.showInputDialog("Insert the student's address");
		 String numberInput =  JOptionPane.showInputDialog("Insert the student's ID Number");
		number = Integer.parseInt(numberInput.trim());
		 String GPAInput =  JOptionPane.showInputDialog("Insert the student's GPA");
		 GPA = Double.parseDouble(GPAInput.trim());

		 

	}

	 }// end of class Listing



