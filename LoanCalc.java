// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) 
	{	
		double pay = 0;
		double money = loan;
		for (int i = 0 ; i < (n) ; i++) 
		{
			pay = (money - payment)*(1+rate);
			money = pay;
		}
		return pay;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double g = loan/n;
		iterationCounter = 0;
		while (endBalance(loan, rate, n, g)>=epsilon)
		{
			g += epsilon;
			iterationCounter++;
		}
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double lo = 0;
		double hi = loan;
		double g = (hi + lo)/2; 
		double finalG = endBalance(loan, rate, n, g); // מה ישאר לי בסוף
		double finaleL = endBalance(loan, rate, n, lo); // מה היתרה
		iterationCounter = 0;
		while ((hi - lo) >= epsilon) // כל עוד הטווח לא שווה לאפסילון אתה מקטין את הטווח כל פעם
		{
			if ((finalG * finaleL)>0) // אם שניהם בעלי אותו סימן
			{
				lo = g;
				finaleL = finalG; // בגלל שאל הופך לגי אז ככה עם הפיינל אל
			}
			else
			{
				hi = g;
			}
			 iterationCounter++;
			 g = (lo + hi) / 2; // מאפס את גי
			 finalG = endBalance(loan, rate, n, g);
		}

		return g;
    }
}