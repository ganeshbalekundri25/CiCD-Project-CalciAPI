package Ganesh_Blk.CalculatorAPI;

public class Calculator {
	
	// ADDITION FUNCTION
	public int Addition(int Num1,int Num2)
	{
		int Result;
		Result=Num1+Num2;
		return Result;
	}
	
	// SUBSTRACTION FUNCTION
	public int Substraction(int Num1, int Num2)
	{
		int Result;
		Result=Num1-Num2;
		return Result;
	}
	
	// MULTIPLICATION FUNCTION
	public int Multiplication(int Num1, int Num2)
	{
		int Result ;
		Result = Num1*Num2;
		return Result;
	}
	
	// DIVISION FUNCTION
	public int Division(int Num1, int Num2)
	{
	    if (Num2 == 0)
	    {
	        throw new ArithmeticException("Cannot divide by 0");
	    }
	    return Num1 / Num2;
	}
}
