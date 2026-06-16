package Rahitech_DevOpsBatch.CalculatorAPI;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {

	/*
	 * Pre-requisite:
	 * Create an object of Calculator class
	 * Testcase1:
	 * 1. Test Addition with Positive numbers
	 * TestCas2:
	 * 1. Test Addition with 1 Positive number and 1 Negative number
	 * Testcase3:
	 * Test Additon with 2 Negative numbers
	 * Testcase4:
	 * Test Adddition with 0 and non-zero value
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
	@BeforeClass
	public void CreateObject()
	{
		System.out.println("I am in Before class");
		Calc=new Calculator();
	}
}
