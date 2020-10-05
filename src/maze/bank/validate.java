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
    
    //transferAccNo
	public boolean transferAccNo(String strNum) {
   		if (strNum.matches("[0-9]{10}")) {
  			return true;
		} else {
			return false;
		}
	}


//emailvalid
   public boolean emailValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
		   }

 //pinValid
   public boolean pinValid(String pin) {
      String regex = "\\d{4}";
      return pin.matches(regex);
   }

//depositAmount
   public boolean depositAmount(String da){
   	if(da == null || da.length()>10){
   		return false;
   	}
   	else if(da.matches("[0-9]+")){
   		return true;
   	}
   	else{
   		return false;
   	}
   }

//withdrawAmount
    public boolean withdrawAmount(String wa, String balance){
   	if(wa == null || wa.length()>10){
   		return false;
   	}
   	else if(wa.matches("[0-9]+")){
   		int withdraw = Integer.parseInt(wa);
   		int bal = Integer.parseInt(balance);
   		if (withdraw<bal && withdraw!=0){
   		return true;
   		}
   		return false;
   	}
   	else{
   		return false;
   	}
   }

//transferAmount

    public boolean transferAmount(String ta, String balance){
   	if(ta == null || ta.length()>10){
   		return false;
   	}
   	else if(ta.matches("[0-9]+")){
   		int transfer = Integer.parseInt(ta);
   		int bal = Integer.parseInt(balance);
   		if (transfer<bal && transfer!=0){
   		return true;
   		}
   		return false;
   	}
   	else{
   		return false;
   	}
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

//phoneNo
	public boolean phoneNo(String pno){
      String regex = "\\d{10}";
      return pno.matches(regex);		
	}

//address
	public boolean address(String addr){
   		if (addr.matches("^[a-zA-Z0-9',\"]+$")) {
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

//cpin
	public boolean cpin(String confirm, String ogpin){
		String regex = "\\d{4}";
		if(confirm.matches(regex) && confirm == ogpin){
			return true;
		}
		else{
			return false;
		}

	}
    
}
