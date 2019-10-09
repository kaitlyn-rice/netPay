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
      while(true){      
      System.out.println("How many hours a week did you work?");
      userHours = sc.nextLine();
      try{
          numberOfHours = Integer.parseInt(userHours);
          if (numberOfHours > 0){
            netPayValue = netPay(numberOfHours);
            break;
          }
          else
            System.out.println("Not a valid input. Please try again by entering an integer value.");
      }
      catch (NumberFormatException e) {
         System.out.println("Not a valid input. Please try again by entering an integer value.");
      }
      System.out.println();
      }
   }

    // you need to comment on what this method does
    public static double netPay(int numberOfHours) {
      double grossPay;
      double deductions;
      double netPay= 0;     
      System.out.println("Hours worked per week: \t" + numberOfHours);
      grossPay = PAY_PER_HOUR * numberOfHours;
      System.out.println("Gross pay: \t\t\t\t\t" + grossPay); 
      System.out.println();
      System.out.println("Deductions");
      deductions = FEDERAL_TAX_PERCENT / 100 * grossPay;
      deductions = Math.round(deductions*100.00)/100.00;
      System.out.println("Federal: \t\t\t\t\t" + deductions);
      netPay = grossPay - deductions;
      deductions = STATE_TAX_PERCENT / 100 * grossPay;
      deductions = Math.round(deductions*100.00)/100.00;
      System.out.println("State: \t\t\t\t\t\t" + deductions);
      netPay = netPay - deductions;
      deductions = SS_PERCENT / 100 * grossPay;
      deductions = Math.round(deductions*100.00)/100.00;
      System.out.println("Social Security: \t\t\t" + deductions);
      netPay = netPay - deductions;
      deductions = MEDICARE_PERCENT / 100 * grossPay;
      deductions = Math.round(deductions*100.00)/100.00;
      System.out.println("Medicare: \t\t\t\t\t" + deductions);
      netPay = netPay - deductions;
      netPay = Math.round(netPay*100.00)/100.00;
      System.out.println();
      System.out.println("Net Pay: \t\t\t\t\t" + netPay);
      return netPay;
    }
}
