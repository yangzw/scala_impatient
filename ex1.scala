import math._
import BigInt.probablePrime
import util.Random

object ex1 {
	//1. In the Scala REPL, type 3. followed by the Tab key. What methods can be applied?

	//=> show you many methods

	//2. In the Scala REPL, compute the square root of 3, 
	//and then square that value. By how much does the result differ from 3? 
	//(Hint: The res variables are your friend.)
	println((3 - pow(sqrt(3),2)))       //=>4.440892098500626E-16

	//3. Are the res variables val or var?
	//=>val
	//4. Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL.
	//What does this operation do? Where can you find it in Scaladoc?
	"crazy" * 3    //> res0: String = crazycrazycrazy    in StringOps

	//5. What does 10 max 2 mean? In which class is the max method defined?
	10 max 2      //=> res3: Int = 10     defined in RichInt class

	//6. Using BigInt, compute 2^1024.
	BigInt(2) pow 1024    
	//=> res4: scala.math.BigInt = 17976931348623159077293051907890247336179
	//7697894230657273430081157732675805500963132708477322407536021120113879
	//8713933576587897688144166224928474306394741243777678934248654852763022
	//1960124609411945308295208500576883815068234246288147391311054082723716
	//3350510684586298239947245938479716304835356329624224137216

	//7. What do you need to import so that you can get a random prime as 
	//probablePrime(100, Random), without any qualifiers before probablePrime and Random?
	probablePrime(100, Random)
	//need to mport BigInt.probablePrime and import util.Random
	//res6: scala.math.BigInt = 1118847557383135932776762910961

	//8. One way to create random file or directory names is to produce a random BigInt 
	//and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul". 
	//Poke around Scaladoc to find a way of doing this in Scala.
	probablePrime(100, Random).toString(36)
	//res7: String = 3elh9zeflt1zyjqwwdon

	//9. How do you get the first character of a string in Scala? The last character?
	val s = "Sample"
	s.head                //res8: Char = S
	s(0)
	s.last                //res9: Char = e
	s(s.length - 1)


	//10. What do the take, drop, takeRight, and dropRight string functions do? 
	//What advantage or disadvantage do they have over using substring?
	s.take(3)     //take: select first n elements
	s.drop(3)     //drop: Selects all elements except first n ones.
	s.takeRight(3)   //takeRight: Selects last n elements.
	s.dropRight(3)   //dropRight: Selects all elements except first n ones.
}
