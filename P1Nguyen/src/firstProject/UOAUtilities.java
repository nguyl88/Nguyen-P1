package firstProject;

import javax.swing.JOptionPane;

public class UOAUtilities {
	private int next;
    private int size;
    private StudentListing[ ] data;

    public UOAUtilities(int size)
     {  this.next = 0;   
     	this.size = size;
     	this.data = new StudentListing[size];
    
     }//end of constructor

     public boolean insert(StudentListing newStudentListing) {
       if(next >= size) { // the structure is full
    	 JOptionPane.showMessageDialog(null, "Sorry, it's full.");
    	 System.out.println("Storage expanding.");
    	 expand(); //expand the array
         return false;
     }
  	
         data[next]= newStudentListing.deepCopy( );  // store a deep copy of the client’s StudentListing
         if(data[next] == null) {
        	JOptionPane.showMessageDialog(null, "Sorry, there's nothing in here");    
            return false;
         }
         next = next + 1; // prepare for the next insert
         JOptionPane.showMessageDialog(null, "Student added successfully.");
         System.out.println("Operation Complete!");
           return true;
           
     }// end of insert method
     
     private boolean expand() {
    	 StudentListing[] temp = data; //shallow copy
    	 data = new StudentListing[2 * size]; //currently a null
    	 if (data == null){
    		 data = temp;  	 
    		 return false;
    	 }
		System.arraycopy(temp, 0, data, 0, temp.length);
		size = size * 2;
		return true;
    	 
     }
     public StudentListing fetch(String targetKey)  {
    	 StudentListing StudentListing;
         StudentListing temp;
       // access the StudentListing using a sequential search
         int i = 0;
         while ( i < next && !(data[i].compareTo(targetKey) == 0))
         {  i++;
         }
         if(i== next){ // StudentListing not found
    	   JOptionPane.showMessageDialog(null, targetKey + " is not found.");
         return null;
         }

       //deep copy the StudentListing's information into the client's StudentListing
          StudentListing = data[i].deepCopy( );
       // move the StudentListing up one position in the array, unless it is the first StudentListing
          if(i != 0) // bubble-up accessed StudentListing
         {   temp = data[i-1];
              data[i-1] = data[i];
              data[i] = temp;
         }
	 	JOptionPane.showMessageDialog( null , targetKey + " is found. The StudentListing is" + data[i].toString());
	 	System.out.println("Operation Complete!");
         return StudentListing;
     } 

     public boolean delete(String targetKey)
     {// access the StudentListing using a sequential search
         int i = 0;
         while (i < next && !(data[i].compareTo(targetKey) == 0))
         {   i++;
         }
         if(i == next) { // StudentListing not found
        	  JOptionPane.showMessageDialog(null, "The student doesn't exist in the record.");
             return false;
         }
         //move the last StudentListing into the deleted StudentListing's position
          data[ i] = data[ next -1];
          data[next-1] = null;
          next = next - 1;
          JOptionPane.showMessageDialog(null, "The student exist and deleted.");
          System.out.println("Operation Complete!");
          return true; // StudentListing found and deleted
     }//end of the delete method

      public boolean update(String targetKey, StudentListing newStudentListing) {
    	  if(delete(targetKey) == false) {  // node not in the structure
            JOptionPane.showMessageDialog( null , targetKey + " not is found. Try again.");
    	  return false;
    	  }
          else if( insert(newStudentListing ) == false) { // insufficient memory
        	  JOptionPane.showMessageDialog( null , targetKey + " not is found. Try again.");
              return false;
          }
          else {
        	  JOptionPane.showMessageDialog( null , targetKey + "  is found. Updated.");
              return true;
              }  // node found and updated

      }

      public void showAll( ){
    	  StringBuilder sb = new StringBuilder();
    	  for(int i = 0; i < next; i++) {
    		  sb.append(data[i].toString());
      	}
	 	JOptionPane.showMessageDialog(null, sb.toString());
      }// end showAll method

      //Nott used yet
      public int getIndex(StudentListing s, StudentListing[] bag) {
    	  for (int i = 0; i< bag.length; i++)
    	    {
    	        if (bag[i] != null && bag[i].equals(s)
    	            || s == null && bag[i] == null) return i;
    	    }

    	    return -1;
      }
      
	  
}
