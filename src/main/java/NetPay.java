import java.util.*;

// this is the main class
public class NetPay {
	// // you need to uncomment the constants 
	// // and declare the values of various deduction types
	 private static final double FEDERAL_TAX_PERCENT = 10.00;
	 private static final double STATE_TAX_PERCENT = 4.50;
	 private static final double SS_PERCENT = 6.20;
	 private static final double MEDICARE_PERCENT = 1.45;
	 private static final double PAY_PER_HOUR = 7.25;
    
    public static void main(String[] args) {

    	// an example of testing your code
    	int numberOfHours = 40;
    	double netPayValue = netPay(numberOfHours);
      System.out.println();
      
    	// another example of testing your code
    	numberOfHours = 30;
    	netPayValue = netPay(numberOfHours);
      System.out.println();
      
    	// you will eventually upgrade your main method to take inputs from users
      Scanner sc = new Scanner(System.in);
      String userHours;
      while(true){ // traps user so they can keep trying again if they're input is wrong     
      System.out.println("How many hours a week did you work?");
      userHours = sc.nextLine();
      try{ // checks if integer
          numberOfHours = Integer.parseInt(userHours);
          if (numberOfHours > 0 && numberOfHours <= 168){ // checks if number is a positive and if it is <= the number of hours per week
            netPayValue = netPay(numberOfHours);
            break;
          }
          else //allows user to input a valid input
            System.out.println("Not a valid input. Please try again by entering an integer value.");
      }
      catch (NumberFormatException e) { //allows user to input a valid input
         System.out.println("Not a valid input. Please try again by entering an integer value.");
      }
      System.out.println();
      }
   }

    // you need to comment on what this method does
    public static double netPay(int numberOfHours) {
      double grossPay = PAY_PER_HOUR * numberOfHours; //calculation for grossPay
      double netPay = grossPay; //netPay must start off equal to grossPay then subtract each deduction
      double deductions[] = {FEDERAL_TAX_PERCENT, STATE_TAX_PERCENT, SS_PERCENT, MEDICARE_PERCENT}; // array for all the individual deductions
      System.out.println("Hours worked per week: \t" + numberOfHours);
      System.out.println("Gross pay: \t\t\t\t\t" + grossPay); 
      System.out.println();
      System.out.println("Deductions");
      for (int i = 0; i < deductions.length; i++){ //gets all of the calculations
         deductions[i] = deductions[i] / 100 * grossPay; // calcultaion for how much each deduction is
         deductions[i] = Math.round(deductions[i] * 100.00) / 100.00; //rounds to the nearest hundreths place
         netPay -= deductions[i]; //calculates netPay
         netPay = Math.round(netPay * 100.00) / 100.00; //rounds to the nearest hundreths place
      }
       System.out.println("Federal: \t\t\t\t\t" + deductions[0]);
       System.out.println("State: \t\t\t\t\t\t" + deductions[1]);
       System.out.println("Social Security: \t\t\t" + deductions[2]);
       System.out.println("Medicare: \t\t\t\t\t" + deductions[3]);
       System.out.println();
       System.out.println("Net Pay: \t\t\t\t\t" + netPay);
       return netPay;
    }
}
