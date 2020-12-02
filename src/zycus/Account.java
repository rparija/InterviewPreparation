package zycus;
import java.util.*;
abstract class Account {
    Person accHolder; 
    Integer accNum; 
    Integer balance; 
    String accountType;
    
    //declare a static hashmap variable with name "accounts" with key as Integer and value which can store both objects of type SavingsAccount and CurrentAccount 
    static HashMap<Integer,Account> accounts= new HashMap<Integer,Account>();
    public abstract void setAccountDetails(Person accHolder, Integer accNum, Integer balance);
    public abstract void setBalance(Integer balance);
    public abstract Integer getBalance(); public abstract String debit(Integer amount);
    public abstract String credit(Integer amount); 
    
    public static String createSavingsAccount(Person accHolder, Integer accNum, Integer balance){ 
        //write code to create a savings account object every time this method is called and add the account number as key and object as value to a HashMap of type <Integer,Account> 
        //use setAccountDetails method in SavingsAccount class to set the values
        //if the balance while creating an account is >=1000 then return "Savings Account SuccessFully Created!" or return "Validation Failed!" 
        //if validation fails then set all the fields and SavingsAccount object to null 
    Account savingsAccount= new SavingsAccount(accHolder,  accNum,  balance);
    if(balance>=1000)
    {
        accounts.put(accNum,savingsAccount);
        return "Savings Account SuccessFully Created!";
    }
    else
    {
        savingsAccount=null;
        accounts.put(accNum,savingsAccount);
        return "Validation Failed!";
    }
    } 
        
    public static String createCurrentAccount(Person accHolder, Integer accNum, Integer balance){ 
        //write code to create a current account object every time this method is called and add the account number as key and object as value to the Accounts.account variable 
        //use setAccountDetails method in CurrentAccount class to set the values 
        //if the balance while creating an account is >=10000 then return "Current Account SuccessFully Created!" or return "Validation Failed!"
        //if validation fails then set all the fields and SavingsAccount object to null 
    	 Account currentAccount= new CurrentAccount(accHolder,  accNum,  balance);
    	    if(balance>=10000)
    	    {
    	        accounts.put(accNum,currentAccount);
    	        return "Current Account SuccessFully Created!";
    	    }
    	    else
    	    {
    	    	currentAccount=null;
    	        accounts.put(accNum,currentAccount);
    	        return "Validation Failed!";
    	    }
    } 
} 

class SavingsAccount extends Account { 
   
	 	Person accHolder; 
	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((accNum == null) ? 0 : accNum.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SavingsAccount other = (SavingsAccount) obj;
			if (accNum == null) {
				if (other.accNum != null)
					return false;
			} else if (!accNum.equals(other.accNum))
				return false;
			return true;
		}
		Integer accNum; 
	    Integer balance; 
	    String accountType;
	    
    public SavingsAccount(Person accHolder, Integer accNum, Integer balance) {
    	this.accHolder=accHolder;
        this.accNum=accNum;
        this.balance=balance;
        this.accountType="Savings";
        }
	public void setAccountDetails(Person accHolder, Integer accNum, Integer balance){
        //write code here to set the accHolder(account holder),accNum(account number),balance and accountType fields 
       this.accHolder=accHolder;
       this.accNum=accNum;
       this.balance=balance;
       this.accountType="Savings";
    } 
    @Override
    public String toString()
    {
        return String.format("Name :"+accHolder.getName()+" Age : "+accHolder.getAge()+" City : "+accHolder.getCity()+""
        		+ "  Account Number : "+accNum +" Balance : "+balance +" Account Type : Savings");
    }
    //write a toString() method to to generate account details when the hashmap's "accounts.get(accNum)" method is used to print all the user details in the below format 
    //"Name : Arjun Age : 21 City : Bangalore Account Number : 12345 Balance : 1000 Account Type : Savings" (without quotes) 
    //write setter and getter methods to set and get balance with return type Integer 
    
    public String debit(Integer amount){ 
        //write code here to handle debiting(withdrawal) from an account 
        //if the withdrawal amount makes the balance lesser than zero then return "Cannot deduct more than available balance!" 
        //if the withdrawal amount makes the balance lesser than minimum balance(1000) and greater than zero then return ex: "500 Rs. has been successfully debited and the balance is 500 Rs. and minimum balance is not present in account: 1234"
        //else return ex: "2000 Rs. has been successfully debited and the balance is 1500 Rs. in account: 1234"
    	Account savAccount=Account.accounts.get(this.accNum);
    	if(savAccount.getBalance()-amount<0)
    	{
    		return "Cannot deduct more than available balance!";
    	}
    	else if(savAccount.getBalance()-amount<1000 && this.balance-amount>0)
    	{
    		int newbal=savAccount.getBalance()-amount;
    		savAccount.setBalance(newbal);
    		Account.accounts.put(this.accNum, savAccount);
    		return amount+" Rs. has been successfully debited and the balance is "+(newbal) +"Rs. and minimum balance is not present in account: "+this.accNum;
    	}
    	else
    	{
    		int newbal=savAccount.getBalance()-amount;
    		savAccount.setBalance(newbal);
    		Account.accounts.put(this.accNum, savAccount);
    		return amount+" Rs. has been successfully debited and the balance is "+(newbal) +"Rs.  in account: "+this.accNum;
    	}
    } 
    
    public String credit(Integer amount){ 
        //write code here to handle crediting(deposit) to an account
        //update the balance in the hashmap variable Account.accounts 
        //return ex: "1000 Rs. has been successfully credited and the balance is 2000 Rs. in account: 1234"
    		Account savAccount=Account.accounts.get(this.accNum);
    	
    	
    		int newbal=savAccount.getBalance()+amount;
    		savAccount.setBalance(newbal);
    		Account.accounts.put(this.accNum, savAccount);
    		return amount+" Rs. has been successfully credited and the balance is "+(newbal) +"Rs.  in account: "+this.accNum;
    	
    	
    }
	@Override
	public void setBalance(Integer balance) {
		this.balance=balance;
		
	}
	@Override
	public Integer getBalance() {
		return this.balance;
	} 
} 

class CurrentAccount extends Account{ 
	Person accHolder; 
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNum == null) ? 0 : accNum.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavingsAccount other = (SavingsAccount) obj;
		if (accNum == null) {
			if (other.accNum != null)
				return false;
		} else if (!accNum.equals(other.accNum))
			return false;
		return true;
	}
	Integer accNum; 
    Integer balance; 
    String accountType;
	public CurrentAccount(Person accHolder, Integer accNum, Integer balance) {
    	 this.accHolder=accHolder;
         this.accNum=accNum;
         this.balance=balance;
         this.accountType="Savings";
	}

	public CurrentAccount() {
   	
	}
	public void setAccountDetails(Person accHolder, Integer accNum, Integer balance){ 
        //write code here to set the accHolder(account holder),accNum(account number),balance and accountType fields 
		   this.accHolder=accHolder;
	       this.accNum=accNum;
	       this.balance=balance;
	       this.accountType="Savings";
    } 
	 @Override
    public String toString()
    {
        return String.format("Name :"+accHolder.getName()+" Age : "+accHolder.getAge()+" City : "+accHolder.getCity()+""
        		+ "  Account Number : "+accNum +" Balance : "+balance +" Account Type : Savings");
    }
    //write a toString() method to to generate account details when the hashmap's "accounts.get(accNum)" method is used to print all the user details in the below format 
    //"Name : Arjun Age : 21 City : Bangalore Account Number : 12345 Balance : 1000 Account Type : Current" (without quotes) 
    //write setter and getter methods to set and get balance with return type Integer 

    public String debit(Integer amount){ //write code here to handle debiting(withdrawal) from an account 
        //update the balance in the hashmap variable Account.accounts
        //if the withdrawal amount makes the balance lesser than minimum balance(10000) then return ex: "500 Rs. has been successfully debited and the balance is 9500 Rs. and amount is overdrawn in account: 1234" 
        //else return ex: "2000 Rs. has been successfully debited and the balance is 13000 Rs. in account: 1234" 
    	Account savAccount=Account.accounts.get(this.accNum);
    	
    	 if(savAccount.getBalance()-amount<10000)
    	{
    		int newbal=savAccount.getBalance()-amount;
    		savAccount.setBalance(newbal);
    		Account.accounts.put(this.accNum, savAccount);
    		return amount+" Rs. has been successfully debited and the balance is "+(newbal) +"Rs. and amount is overdrawn in account: "+this.accNum;
    	}
    	else
    	{
    		int newbal=savAccount.getBalance()-amount;
    		savAccount.setBalance(newbal);
    		Account.accounts.put(this.accNum, savAccount);
    		return amount+" Rs. has been successfully debited and the balance is "+(newbal) +"Rs.  in account: "+this.accNum;
    	}
    } 
    
    public String credit(Integer amount){
        //write code here to handle crediting(deposit) to an account 
        //update the balance in the hashmap variable Account.accounts 
        //then return ex: "1000 Rs. has been successfully credited and the balance is 11000 Rs. in account: 1234"
    	
    	Account savAccount=Account.accounts.get(this.accNum);
    	
    	
		int newbal=savAccount.getBalance()+amount;
		savAccount.setBalance(newbal);
		Account.accounts.put(this.accNum, savAccount);
		return amount+" Rs. has been successfully credited and the balance is "+(newbal) +"Rs.  in account: "+this.accNum;
	

    }

	@Override
	public void setBalance(Integer balance) {
		this.balance=balance;
		
	}

	@Override
	public Integer getBalance() {
		
		return this.balance;
	} 
                
	 
} 
            
class Person{ 
    //declare three variables for name,city and age of a person and also a parameterized constructor 
    String name;
    String city;
    int age;

    public Person (String name,String city,int age)
    {
        this.name=name;
        this.city=city;
        this.age=age;
    }
     public Person ()
    {
        
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
     
 } 
 
 
class Source {
    public static void main(String[] args){
        //Implement main() function to check your code...
        //don't remove the main() function, you will get error in RUN CODE.
    }
}