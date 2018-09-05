package firstProject;

import javax.swing.JOptionPane;

public class Demo {

	public static void main(String[] args) {

		 //Input and parse the max number of nodes for the data structure
		 String maxInput = JOptionPane.showInputDialog("How much do you want to store for students?");
		 int maxNum  = Integer.parseInt(maxInput); //Initial numbers of student

		 //Declare data structure object and load the initial data set
		 UOAUtilities studentBag = new UOAUtilities(maxNum);

		 //Declares student object
		StudentListing s1;

		for(int i = 0 ; i < maxNum; i++) {
			s1 = new StudentListing();
			s1.input();
			studentBag.insert(s1);
		}

		 while(true) {
		JOptionPane.showMessageDialog(null, "Menu: \n 1: Insert Student \n 2: Fetch Student \n 3: Delete Student \n 4: Update Student \n 5: Show Student \n 6: Exit \n");

		String optionInput = JOptionPane.showInputDialog("Please enter from the menu");
		int optionNumber  = Integer.parseInt(optionInput.trim());

		if (optionNumber > 6) {
			JOptionPane.showMessageDialog(null, "That is not an option number.");
			continue;
		 }
		 switch (optionNumber) {
		 case 1:
			StudentListing newStudent = new StudentListing(); 
		   	newStudent.input();
		 	studentBag.insert(newStudent);
			System.out.println("Operation Complete!");
			 break;
		 case 2: String fetchInput  = JOptionPane.showInputDialog("Who do you want to find?");
		 		studentBag.fetch(fetchInput);

		 	break;
		 case 3: String deleteInput = JOptionPane.showInputDialog("Who do you want to delete?");
		 		studentBag.delete(deleteInput);
		 	
		 	break;
		 case 4: 
			 	String updateInput = JOptionPane.showInputDialog("Who do you want to update?");
		 		 String newNameInput  = JOptionPane.showInputDialog("Update the student's name");
		 		 String newAddressInput =  JOptionPane.showInputDialog("Update the student's address");
		 		 String	newIDNUMInput =  JOptionPane.showInputDialog("Update the student's ID Number");
		 		 int newNumInput = Integer.parseInt(newIDNUMInput.trim());
		 		 String newGPA =  JOptionPane.showInputDialog("Update the student's GPA");
		 		 double newGPAInput = Double.parseDouble(newGPA.trim());
		 		 StudentListing updateStudent = new StudentListing(newNameInput, newAddressInput, newNumInput, newGPAInput);
		 		
		 		 if (studentBag.update(updateInput,updateStudent) == false){
		 			System.out.println("Operation failed because the target does not match in the records");
		 		 }
		 		 
		 	break;
		 case 5:
		 	studentBag.showAll();
		 	break;
		 default: //if case 6
			 System.exit(0);

			 break;
		 	}
		 } //end while loop

	}

}
