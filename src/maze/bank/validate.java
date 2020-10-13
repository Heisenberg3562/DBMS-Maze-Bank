/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.bank;

/**
 *
 * @author Omkar
 */
public class validate {

//emailvalid
   public boolean emailValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
    }


//firstName
   public boolean firstName(String fname){
   		if (fname.matches("^[a-zA-Z]+$")) {
  			return true;
		} else {
			return false;
		}
   }

//lastName
   public boolean lastName(String lname){
   		if (lname.matches("^[a-zA-Z]+$")) {
  			return true;
		} else {
			return false;
		}
   }



//pancard
	public boolean pancard(String pan){
   		if (pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
  			return true;
		} else {
			return false;
		}
	}

}
