

object ex2{
	//1. The signum of a number is 1 if the number is positive, 
	//-1 if it is negative, and 0 if it is zero. Write a function that computes this value.
	def signum(number:Int) = {if(number == 0) 0 else if(number > 0) 1 else -1}


	//2. What is the value of an empty block expression {}? What is its type?
	var b = {}  // => b: Unit = ()

	//3. Come up with one situation where the assignment x = y = 1 is valid in Scala.
	//(Hint: Pick a suitable type for x.)
	var y: Int = 0
	var x: Unit = y = 1

	//4. Write a Scala equivalent for the Java loop
	//for (int i = 10; i >= 0; i--) System.out.println(i);
	for(i <- 10 to (0,-1))
		println(i)

	//5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
	def countdown(n: Int) = { for(i <- n to (0,-1)) println(i) }

	//6. Write a for loop for computing the product of the Unicode codes of all
	//letters in a string. For example, the product of the characters in "Hello" is 825152896.
	var product: Int = 1
	for(a <- "Hello") product = product * a.toInt

	//7. Solve the preceding exercise without writing a loop. 
	//(Hint: Look at the StringOps Scaladoc.)
	"Hello".foldLeft(1)((a, b) => a * b)

	//8. Write a function product(s : String) that computes the product, 
	//as described in the preceding exercises.
	def product(string: String) = string.foldLeft(1)((a,b) => a * b)

	//9. Make the function of the preceding exercise a recursive function.
	def productRcs(s: String):BitInt = { if(s.length == 0) 1 else s.head * productRcs(s drop 1) }
	
	//10. Write a function that computes x^n, where n is an integer. Use the following
	//recursive definition: 
	//	x^n = y^2 if n is even and positive, where y = x ^ (n/2)
	//	x^n = x*x^(n-1) if n is odd and positive
	//	x^0 = 1
	//	x^n = 1 / x^(-n) is n is negative
	//Don't use a return statement.
	def npow(x: Int, n: Int):BitInt = {
		if(n > 0 && n % 2 == 0) npow(x,n/2)*npow(x,n/2)
		else if(n > 0) x * npow(x,n-1)
		else if(n == 0) 1
		else 1 / npow(x,-n)
	}
}
