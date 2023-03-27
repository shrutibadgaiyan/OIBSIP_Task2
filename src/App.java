import java.util.*;
// ATM MACHINE PROJECT IN JAVA

// 1.VALIDATE Will Be Able To Use The Machine Services
// After Validation of THE USER THROUGH ATM NUMBER AND PIN

// 2. USER Will  ABLE TO PERFORM BELOW OPERATIONS
     // 1.View Transaction History
     // 2. WITHDRAW AMOUNT
     // 3. DEPOSIT AMOUNT
     // 4. Transfer Amount
     // 5. EXIT


 class atm{
	 
	 private static double balance;
		private double depositAmount;
		private double withdrawAmount;
		
	static ArrayList<Double> arrli1=new ArrayList<>();
	static	ArrayList<String> arrli2=new ArrayList<>();
		
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
	void viewBalance() {
		System.out.println("Available Balance is : "+getBalance());
	}
}
class Transfer extends atm{
	void transferAmount(double transferAmount,int atmpin) {
			if(transferAmount%500==0){
		if(getBalance()>=transferAmount) {
			arrli1.add(transferAmount);
			arrli2.add(" Amount Transfered to Acount Id: "+atmpin);
			System.out.println("The Amount "+transferAmount+" Has been Transfered to the ATM ACCOUNT ID: "+atmpin);
			setBalance(getBalance()-transferAmount);
			viewBalance();	
			
		}else {
			System.out.println("Insufficient Balance !!");
		}
			}else {
				System.out.println("Enter Amount in terms of 500 Rupees Note only ! ");
			}
		
	}
}
 class Trans extends atm {
  void viewTransaction() {
	  if(arrli1.size()>0) {
		  System.out.println("Transaction History: ");
		   for(int i=0;i<arrli1.size();i++) {
			System.out.println(arrli1.get(i)+arrli2.get(i));   
		    
	  }}else {
		System.out.println("You Have No Transaction History!");  
	  }
 }
	 }
 
 
 class Withdraw extends atm{
	 
	 void withdrawl(double withdrawAmount) {
		
		if(withdrawAmount%500==0){
		if(withdrawAmount<=getBalance()) {
		
			
			arrli1.add(withdrawAmount);
			arrli2.add(" Amount Withdrawn");
			
			System.out.println("Collect the Cast : "+withdrawAmount);
			setBalance(getBalance()-withdrawAmount);
		       viewBalance();	
		}
		else{
			System.out.println("Insufficient Balance !!");
		}
	 }else {
		 System.out.println("Please Enter Amount in terms of 500 Rupees Note only");
	 }
		
	 }
	 
 }
 class depo extends atm {
	void  depositAmount(double depositAmount) {
		if(depositAmount%500==0&& depositAmount>=0) {
			
		
		arrli1.add(depositAmount);
		arrli2.add(" Amount Deposited");
		System.out.println(depositAmount+" Deposited Successfully !!");
	setBalance(getBalance()+depositAmount);
	viewBalance();
		}else {
			System.out.println("Please enter Amount in terms of 500 Rupees only ");
		}
	}
 }
 


public class App {
    public static void main(String[] args) throws Exception {
    
            //consider there are 10 users
		//Array of ATM users id
		//int Uatmid[]= new int[10];
		int Uatmid[]= {111,222,333,444,555,666,777,888,999};
		int atmnumber=1234;
		int atmpin=123;
		
	//Array of ATM users pin
    //int uatmpin[]=new int[10];
		int Uatmpin[]= {11,22,33,44,55,66,77,88,99};
		atm ob=new atm();
		Trans ob1=new Trans();
		Withdraw ob2=new Withdraw();
		depo ob3=new depo();
		Transfer ob4=new Transfer();
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to ATM Machine !!!");
			System.out.println("ENTER YOUR ATM NUMBER: ");
			int atmno=sc.nextInt();
			System.out.println("Enter YOUR ATM PIN : ");
			int atmpi=sc.nextInt();
			int check=0;
			// traversing the whole user array of ATM ID and PIN
			for(int i=0;i<9;i++) {
				if((Uatmid[i]==atmno)&&(Uatmpin[i]==atmpi)) {
					check=1;
					break;}
				}
		
			if(check==1) {
				System.out.print("Validation Done");
				while(true) {
				
			
					System.out.println();
					System.out.println("1.VIEW TRANSACTION HISTORY ");
					System.out.println("2.WITHDRAW AMOUNT");
					System.out.println("3.DEPOSIT AMOUNT");
					System.out.println("4.TRANSFER AMOUNT FROM THE ACCOUNT");
					System.out.println("5.Quit");
					System.out.println("Enter Choice : ");
					int ch=sc.nextInt();
					switch(ch) {
					case 1:
						ob1.viewTransaction();
						//ob.viewBalance();
						break;
					case 2:
						System.out.println("Enter Amount to be Withdraw : ");
						double withdrawAmount=sc.nextDouble();
						ob2.withdrawl(withdrawAmount);
						break;
					case 3:
						System.out.println("Enter amount to be Deposit: ");
						double depositAmount=sc.nextDouble();//5000
						ob3.depositAmount(depositAmount);
						break;
					case 4:
						System.out.println("Enter Amount to be Transfered : ");
						double transferAmount=sc.nextDouble();
						System.out.println("Enter ATM ID of the Account the Amount to be Transfer: ");
						int atmId=sc.nextInt();
						ob4.transferAmount(transferAmount,atmId);
						
						break;
					case 5:
						System.out.println("Collect your ATM Card");
						System.out.println("Thank You for using our ATM Machine! COME AGAIN SOON..");
						System.exit(0);
				default:
					System.out.println("Please Enter a Valid Option: ");
		
					
					}
		
				}
			}else {
				System.out.println(" Incorrect ATM Number or Pin ");
				System.exit(0); 
			}
			
		}

    }
}
