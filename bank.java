import java.util.*;
public class bank
{
   public static void main (String[] args)
	{

/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

		// Create ArrayList of Checking Accounts
		ArrayList<CheckingAccount> Check = new ArrayList<CheckingAccount>();
		ArrayList<LoanAccount> Loan = new ArrayList<LoanAccount>();




		Loan.add(new LoanAccount("Zeus","Apollo","apollo@gmail.com",5000));
		Loan.add(new LoanAccount("Einst","Amy","amy089@yahoo.com",1000));
		Loan.add(new LoanAccount("Caesar","Julie","julie3@hotmail.com",6000));
		Loan.add(new LoanAccount("Wesley","Hayn","Hayn32@yahoo.com",1200));
		Loan.add(new LoanAccount("Tobias","Dalby","Dalby65@hotmail.com",6350));
		Loan.add(new LoanAccount("Tazmin","Brady","Brady02@gmail.com",500));
		Loan.add(new LoanAccount("Rebekk","Shaw","Shaw98@outlook.com",9841));



		Scanner in = new Scanner(System.in);
		Check.add(new CheckingAccount("Kirk" , "David" , 30000));
		Check.add (new CheckingAccount("Guten" , "Alfredo" , 64000));
		Check.add (new CheckingAccount("Hindi" , "Lena" , 13400));
		Check.add (new CheckingAccount("Warne" , "Nieve " , 46523));
		Check.add (new CheckingAccount("Villa" , "Tanis" , 12155));
		Check.add (new CheckingAccount("knight" , "Holly " , 36781));
		Check.add (new CheckingAccount("Roche " , "Sydney " , 91620));






		int Choice = 0;
		while (Choice != 8)
		{
				System.out.println("======== Bank of Eastfield ========");
			System.out.println("1 = Print Bank Info ");
			System.out.println("2 = Print Checking Accounts");
			System.out.println("3 = Deposit Money");
			System.out.println("4 = Withdraw Money");

			System.out.println("5 = Print Loan accounts");
			System.out.println("6 = Make Loan");
			System.out.println("7 = Make Loan Payment");

			System.out.println("8 = Exit");
			System.out.println("Your Choise");
			Choice = in.nextInt();
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
			if (Choice == 1)//Print Bank Info
			{
				System.out.println("======== Bank of Eastfield ========");
				System.out.println("Bank Balance $ " + Check.get(0).BankBalance);
				System.out.println("Number Of Customers " + Check.get(0).NumberCustomers);
				System.out.println();
			}
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

			if (Choice == 2)//Print Checking Accounts
			{

				System.out.println("======== Bank of Eastfield ========");
				System.out.println("Rec     LName   FName 	Balance   ");
				for (int i=0; i<Check.size(); i++)
				{
					System.out.println(  i + "\t"  + Check.get(i).LName + "\t" + Check.get(i).FName + "\t" + Check.get(i).getCheckingBalance()  );
				}
				System.out.println();
			}
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
			if (Choice == 3 ) //deposit
			{
				System.out.println("Enter Record #: " );
				int Rec = in.nextInt();
				System.out.println("Amount to Deposit : ");
				double Amount = in.nextDouble();
				Check.get(Rec).Deposit(Amount);
				System.out.println( Check.get(Rec).LName + "  " + Check.get(Rec).FName + " Now has $ "  + Check.get(Rec).getCheckingBalance());
			}
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
			if (Choice == 4) //withdraw
			{
		System.out.println(  "Enter Record #: ");
				int Rec = in.nextInt();
				System.out.println( "Amount to Withdraw : " );
				double Amount = in.nextDouble();
				Check.get(Rec).Withdraw(Amount);
				System.out.println( Check.get(Rec).LName + "  " + Check.get(Rec).FName + " Now has $ " + Check.get(Rec).getCheckingBalance());
			}

/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////


			if (Choice == 5)//Print Loan Accounts
			{

				System.out.println("======== Bank of Eastfield ========");
				System.out.println( "Rec     LName   FName    Email  Adress         Balance   ");
				for (int i=0; i<Loan.size(); i++)
				{
					System.out.println(  i + "\t" + Loan.get(i).LName + "\t" + Loan.get(i).FName + "\t" + Loan.get(i).Email + "\t" + Loan.get(i).getLoanBalance() );
				}
				System.out.println();
			}


			if (Choice == 6)//MakeLoad
			{
				System.out.println(  "Enter Record #: ");
				int Rec = in.nextInt();
				System.out.println(  "Amount of Loan : ");
				double Amount = in.nextDouble();
				Loan.get(Rec).MakeLoan(Amount);
				System.out.println( Loan.get(Rec).LName + "  " + Loan.get(Rec).FName + " Now has a loan of $ : " + Loan.get(Rec).getLoanBalance());

			}
			if (Choice == 7)//MakeLoad
			{
				System.out.println( "Enter Record #: ");
				int Rec = in.nextInt();
				System.out.println( "Loan Payment Amount : ");
				double Amount = in.nextDouble();
				Loan.get(Rec).MakePayment(Amount);
				System.out.println(  Loan.get(Rec).LName + "  " + Loan.get(Rec).FName + " Now has a loan of $ : " + Loan.get(Rec).getLoanBalance());

			}


		}
	}
}

class Customer
{
 String FName, LName;
 String Email;
 int CustomerTransactions; //Number of Transactions
 static double BankBalance;
 static int NumberCustomers;


}


class CheckingAccount extends Customer
{
	private double CheckingBalance;

	CheckingAccount(String theLName, String theFName,double OpeningDeposit)
	{
		LName = theLName; FName = theFName ; CheckingBalance = OpeningDeposit;
		BankBalance += OpeningDeposit;
		NumberCustomers++;
	}
	double getCheckingBalance()
	{
		return CheckingBalance;


	}



	void Deposit(double Amount)
	{
		CheckingBalance += Amount; BankBalance += Amount;
		CustomerTransactions++;
	}



	void Withdraw(double Amount)
	{
		CheckingBalance -= Amount ; BankBalance -=Amount;
		CustomerTransactions++;
		if (CheckingBalance < 0)
		{
			CheckingBalance -=25;
			System.out.println( FName + " " + LName + " overdrafted"  );
		}
	}
}
////////////////////////////////
////////////////////////////////
////////////////////////////////
////////////////////////////////
////////////////////////////////
////////////////////////////////

class LoanAccount extends Customer
{
	private double LoanBalance;

	LoanAccount(String theLName, String theFName, String theEmail, double OpeningLoan)
	{
		LName = theLName; FName = theFName ; Email = theEmail ;LoanBalance = OpeningLoan * 1.25;
		BankBalance -= LoanBalance;
		NumberCustomers++;

	}



	double getLoanBalance()
	{
		return LoanBalance;
	}


	void MakeLoan(double Amount)
	{
		LoanBalance += Amount*1.25; BankBalance += Amount;
			CustomerTransactions++;
	}



	void MakePayment(double Amount)
	{
		LoanBalance -= Amount; BankBalance +=Amount;
		CustomerTransactions++;
		if(LoanBalance <=0)
		{
		System.out.println("Customer X just payed off his/her load!");
		}

	}



}






