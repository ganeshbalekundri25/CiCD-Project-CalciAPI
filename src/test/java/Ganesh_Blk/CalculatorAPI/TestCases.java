package Ganesh_Blk.CalculatorAPI;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Ganesh_Blk.CalculatorAPI.Calculator;

public class TestCases {

	/*
	 * Pre-requisite:
	 * Create an object of Calculator class
	 * Testcase1:
	 * 1. Test Case with Positive numbers
	 * TestCas2:
	 * 1. Test Case with 1 Positive number and 1 Negative number
	 * Testcase3:
	 * Test Case with 2 Negative numbers
	 * Testcase4:
	 * Test Case with 0 and non-zero value
	 * TestCase 5:
	 * Test Case with both zero numbers 
	 * Post-Requisite:
	 * Set Calculator class object to NULL
	 */
	/*
	 * @BeforeClass
	 * @AfterClass
	 * @Test
	 * @BeforeMethod
	 * @AfterMethod
	 * 
	 */
	
	Calculator Calc;
	int ActualResult;
	@AfterClass
	public void SetObjToNull()
	{
		System.out.println("I am in After class");
		Calc=null;
	}
	
	// ADDITIN UNIT TEST CASES
	@Test(priority=1)
	public void TestAdditionWithPositiveNumbers()
	{
		System.out.println("I am in Testcase 1");
		ActualResult=Calc.Addition(30, 50);
		Assert.assertEquals(ActualResult, 80,"Addition is not working with Positive values");
		
	}
	@BeforeMethod
	public void SetResToZero()
	{
		System.out.println("I am in before method");
		ActualResult=0;
	}
	
	@AfterMethod
	public void RunAfterEveryTestCase()
	{
		System.out.println("I am in After method");
	}
	@Test(priority=2)
	public void TestAdditionWithOnePositiveNumberOneNegativeNumber()
	{
		System.out.println(ActualResult);
		System.out.println("I am in Testcase 2");
		ActualResult=Calc.Addition(50, -10);
		Assert.assertEquals(ActualResult, 40,"Addition is not working with 1 Positive and 1 Negative Number");
		
	}
	@Test(priority=3)
	public void TestAdditionWithTwoNegativeNumbers()
	{
		System.out.println("I am in Testcase 3");
		ActualResult=Calc.Addition(-60, -70);
		Assert.assertEquals(ActualResult, -130,"Addition is not working with Negative numbers");
	}

	@Test(priority=4)
	public void TestAdditionWithZeroAndNonZeroNumbers()
	{
		System.out.println("I am in Testcase 4");
		ActualResult=Calc.Addition(30, 0);
		Assert.assertEquals(ActualResult, 30,"Addition is not working with 0 and Non 0 values");
	}
	
	@Test(priority=5)
	public void TestAdditionWithBothNumbersAsZero()
	{
		System.out.println("I am in Testcase 5");
		ActualResult=Calc.Addition(0, 0);
		Assert.assertEquals(ActualResult, 0,"Addition is not working with both numbers as 0");
	}
	
	//SUBSTRACTION UNIT TEST CASES
	@Test(priority=6)
	public void TestSubstractionWithBothNumbersAsZero()
	{
		System.out.println("I am in Testcase 6");
		ActualResult=Calc.Substraction(0, 0);
		Assert.assertEquals(ActualResult, 0,"Substraction is working with both numbers as 0");
	}
	@Test(priority=7)
	public void TestSubstractionWithOnePsitiveNumberAndOneNegativeNumber()
	{
		System.out.println("I am in Testcase 7");
		ActualResult=Calc.Substraction(10, -5);
		Assert.assertEquals(ActualResult, 15,"Substraction is working with One Positive Number And One Negative Number");
	}
	@Test(priority=8)
	public void TestSubstractionWithBothNegativeNumbers()
	{
		System.out.println("I am in Testcase 8");
		ActualResult=Calc.Substraction(-10, -5);
		Assert.assertEquals(ActualResult, -5,"Substraction is working with Both Negative Numbers");
	}
	@Test(priority=9)
	public void TestSubstractionWithBothPositiveNumbers()
	{
		System.out.println("I am in Testcase 9");
		ActualResult=Calc.Substraction(10, 5);
		Assert.assertEquals(ActualResult, 5,"Substraction is working with Both Positive Numbers");
	}
	@Test(priority=10)
	public void TestSubstractionWithOnePsitiveNumberAndZero()
	{
		System.out.println("I am in Testcase 10");
		ActualResult=Calc.Substraction(10, 0);
		Assert.assertEquals(ActualResult, 10,"Substraction is working with One Positive Number And Zero");
	}
	@Test(priority=11)
	public void TestSubstractionWithOneNegativeNumberAndZero()
	{
		System.out.println("I am in Testcase 10");
		ActualResult=Calc.Substraction(-10, 0);
		Assert.assertEquals(ActualResult, -10,"Substraction is working with One Negavtive Number And Zero");
	}
	
	// MULTIPLICATION UNIT TEST CASES
	@Test(priority=12)
	public void TestMultiplicationWithBothNumbersAsZero()
	{
		System.out.println("I am in Testcase 12");
		ActualResult=Calc.Multiplication(0, 0);
		Assert.assertEquals(ActualResult, 0,"Multiplication is working with both numbers as 0");
	}
	@Test(priority=13)
	public void TestMultiplicationWithOnePsitiveNumberAndOneNegativeNumber()
	{
		System.out.println("I am in Testcase 13");
		ActualResult=Calc.Multiplication(10, -5);
		Assert.assertEquals(ActualResult, -50,"Multiplication is working with One Positive Number And One Negative Number");
	}
	@Test(priority=14)
	public void TestMultiplicationWithBothNegativeNumbers()
	{
		System.out.println("I am in Testcase 14");
		ActualResult=Calc.Multiplication(-10, -5);
		Assert.assertEquals(ActualResult, 50,"Multiplication is working with Both Negative Numbers");
	}
	@Test(priority=15)
	public void TestMultiplicationWithBothPositiveNumbers()
	{
		System.out.println("I am in Testcase 15");
		ActualResult=Calc.Multiplication(10, 5);
		Assert.assertEquals(ActualResult, 50,"Multiplication is working with Both Positive Numbers");
	}
	@Test(priority=16)
	public void TestMultiplicationWithOnePsitiveNumberAndZero()
	{
		System.out.println("I am in Testcase 16");
		ActualResult=Calc.Multiplication(10, 0);
		Assert.assertEquals(ActualResult, 0,"Substraction is working with One Positive Number And Zero");
	}
	// DIVISION UNIT TEST CASES
	@Test(expectedExceptions = ArithmeticException.class)
	public void TestDivisionWithBothNumbersAsZero()
	{
	    System.out.println("I am in Testcase 17");
	    Calc.Division(0, 0);
	}
	@Test(priority=18)
	public void TestDivisionWithOnePsitiveNumberAndOneNegativeNumber()
	{
		System.out.println("I am in Testcase 18");
		ActualResult=Calc.Division(10, -5);
		Assert.assertEquals(ActualResult, -2,"Division is working with One Positive Number And One Negative Number");
	}
	@Test(priority=19)
	public void TestDivisionWithBothNegativeNumbers()
	{
		System.out.println("I am in Testcase 19");
		ActualResult=Calc.Division(-10, -5);
		Assert.assertEquals(ActualResult, 2,"Division is working with Both Negative Numbers");
	}
	@Test(priority=20)
	public void TestDivisionWithBothPositiveNumbers()
	{
		System.out.println("I am in Testcase 20");
		ActualResult=Calc.Division(10, 5);
		Assert.assertEquals(ActualResult, 2,"Division is working with Both Positive Numbers");
	}
	@BeforeClass
	public void CreateObject()
	{
		System.out.println("I am in Before class");
		Calc=new Calculator();
	}
}
