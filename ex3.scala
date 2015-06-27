import util.Random
object ex3{
	//1. Write a code snippet that sets a to an array of n random integers 
	//between 0(inclusive) and n (exclusive).
	var randomArray = new Array[Int](20)
	for(i <- 0 until randomArray.length) randomArray(i) = Random.nextInt(20)

	//2. Write a loop that swaps adjacent elements of an array of integers. 
	//For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
	for(i <- 1 until (randomArray.length,2)) {
		var tmp = randomArray(i); 
		randomArray(i) = randomArray(i-1); 
		randomArray(i-1) = tmp 
	}

	//3. Repeat the preceding assignment, but produce a new array with the 
	//swapped values. Use for/yield.
	for( i <- 0 until randomArray.length) 
		yield if(i % 2 == 1) randomArray(i-1) 
		else if(i == randomArray.length - 1) randomArray(i) 
		else randomArray(i + 1) 

	//4. Given an array of integers, produce a new array that contains all positive values
	//of the original array, in their original order, followed by all values 
	//that are zero or negative, in their original order.
	var b = Array[Int](2,-3,4,2,-19,-2,5)
	var c = for(j <- 0 until 2; i <- 0 until b.length if((j == 0 && b(i) > 0) || (j == 1 && b(i) <= 0))) yield b(i)

	//5. How do you compute the average of an Array[Double]?
	var b = Array[Double](2.3,4.2,4.0)
	b.sum / b.length

	//6. How do you rearrange the elements of an Array[Int] so that they appear in
	//reverse sorted order? How do you do the same with an ArrayBuffer[Int]?
	b.sortWith(_ > _)
	ab.sortWith(_ > _)

	//7. Write a code snippet that produces all values from an array with duplicates
	//removed. (Hint: Look at Scaladoc.)
	a.distinct

	//8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” 
	//on page 34 using the drop method for dropping the index of the first match. 
	//Look the method up in Scaladoc.
	ab = ArrayBuffer[Int](2, 6, -1, 9, 0, -4, 6, -1, 8)
	var indexes = (for (i <- 0 until a.length if a(i) < 0) yield i)
    //> indexes  : scala.collection.immutable.IndexedSeq[Int] = Vector(2, 5, 7)
    indexes = indexes.drop(1)
	for (j <- indexes.reverse) ab.remove(j)

	//9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs 
	//that are in America. Strip off the "America/" prefix and sort the result.
	val tz = java.util.TimeZone.getAvailableIDs().filter(_.startsWith("America/")).map( (s) => s.stripPrefix("America/"))

	//10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap 
	//with the call val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    //Then call the getNativesForFlavor method with parameter 
    //DataFlavor.imageFlavor and get the return value as a Scala buffer.(Why this obscure 
    //class? It’s hard to find uses of java.util.List in the standard Java library.)
	import java.awt.datatransfer._
	import scala.collection.JavaConverters._
	import scala.collection.mutable.Buffer

	val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
	var nativesForFlavors = flavors.getNativesForFlavors(Array(DataFlavor.imageFlavor))
	val vals = collection.JavaConversions.asScalaBuffer(new java.util.LinkedList(nativesForFlavors.values))
}