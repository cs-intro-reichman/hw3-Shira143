
import javax.lang.model.util.ElementScanner14;

// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x1>=0)
		{
			if (x2>=0)
			{
			for (int i = 0; i < x2; i++) 
			{
				x1++;
			}
			}	
			else
			{
				for (int j = 0; j > x2; j--) 
				{
					x1--;
				}
			}
		}
		else
		{
			if (x2>=0)
			{
				for (int m = 0; m < x2; m++) 
				{
					x1++;
				}
			}
			else
			{
				for (int l = 0; l > x2; l--) 
					{
						x1--;
					}
			}
			}
		
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2>=0)
		{
			{
				for (int i = 0; i < x2; i++)
				 {
					x1--;
				}
			}
		}
		else
		{
			for (int j = 0; j >x2; j--) 
			{
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int a = x1;
		if (((x1==0) || (x2==0)) || ((x1==0)&&(x2==0)))
		return 0;
		if (x1>0)
		{
			if (x2>0)
			{
					for (int i = 1; i < x2; i++) 
					{
						x1 += plus(0, a);
					}
					return x1;
			}
			else if (x2<0)
			{
					for (int m = -1; m > x2; m--) 
					{
						x1 += plus(0, x1);
					}
					return minus(0, a);
				}
			}
		
			if (x1<0)
			{
				if (x2>0)
				{
					for (int i = 1; i < x2; i++)
					 {
						x1 += minus(0, a);
					}
					return x1;
				}
				else if (x2<0)
				{
					for (int k =-1;k > x2;k--) 
					{
						x1 += plus(0, a);
					}
					return minus(0, x1);
				}
			}
			return x1;
	}
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n)
	 {
		int sum = x;
		if (n == 0)
		return 1;
		else if (x==0)
		return 0;
		if (x>0)
		{
			for (int i = 0; i < (n-1); i++)
		 {
			sum = times(sum,x);
		}
		return sum;
		}
		if (x<0)
		{
			if (mod(n,2) == 0)
			{
				x = minus(0, x);
			for (int i = 0; i < (n-1); i++)
			 {
				sum = times(sum,x);
			}
			return sum;
			}
			else if (mod(n,2) != 0)
			{
				for (int l = 0; l < (n-1); l++) 
				{
					sum = times(sum, x);
				}
				return sum;
			}
		}
		return sum;
	}
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		
		int count  = 0;
		int sum = x1;
		if (x1 == 0)
		return 0;
		if (x1 == x2)
		return 1;
		if ((x1>0) && (x2>0))
		{
			if (x1<x2)
			{
				return 0;
			}
			if (x1>x2)
			{
				while (sum >= x2)
				{
					sum -= x2;
					count++;
				}
				return count;
			}
			
		}
		return x1;	
	}
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int sum = 0;
		if (x1 == x2)
		return 0;
		else if (x1<x2)
		return x1;
		else 
		{
			int fullDiv  = div(x1, x2);
			int sumFull = times(fullDiv,x2 );
			int left = minus(x1, sumFull);
			return left;
		}
	}	
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x<0)
		return 0;
		else if ((x == 1) || (x==0))
		return x;
		else
		{
			for (int i = 0; i < x; i++) 
		{
				if (pow(i, 2) == x)
				{
					return i;
				}
		}
		}
		return x; 
	}	  	  
}