object ex4{
	//1. Set up a map of prices for a number of gizmos that you covet.
	//Then produce a second map with the same keys and the prices at a 10 percent discount.
	val gizmos = Map("iphone" -> 5000, "nike free 5.0" -> 720, "mac" -> 9000)
	val gizmos2 = for((name,price) <- gizmos) yield (name, price * 0.9)

	//2. Write a program that reads words from a file. Use a mutable map to count how often 
	//each word appears. To read the words, simply use a java.util.Scanner:
	//val in = new java.util.Scanner(java.io.File("myfile.txt")) 
	//while (in.hasNext()) process in.next() Or look at Chapter 9 for a Scalaesque way.
	//At the end, print out all words and their counts.

	import java.util.Scanner
	val in = new java.util.Scanner(new java.io.File("myfile.txt"))
	val wordCount = new scala.collection.mutable.HashMap[String, Int]
	while(in.hasNext()) {
		val word = in.next()
		val count = wordCount.getOrElse(word, 0)
		wordCount(word) = count + 1
	}

	//3. Repeat the preceding exercise with an immutable map.
	val in = new java.util.Scanner(new java.io.File("myfile.txt"))
	val wordCount = Map[String, Int]()
	while(in.hasNext()) {
		val word = in.next()
		val count = wordCount.getOrElse(word, 0)
		wordCount += (word -> (count + 1))
	}

	//4. Repeat the preceding exercise with a sorted map, 
	//so that the words are printed in sorted order.
	val in = new java.util.Scanner(new java.io.File("myfile.txt"))
	var wordCount = scala.collection.immutable.SortedMap[String, Int]()
	while(in.hasNext()) {
		val word = in.next()
		val count = wordCount.getOrElse(word, 0)
		wordCount += (word -> (count + 1))
	}

	//5. Repeat the preceding exercise with a java.util.TreeMap that 
	//you adapt to the Scala API.
	import scala.collection.JavaConversions.mapAsScalaMap
	val scores: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
	val in = new java.util.Scanner(new java.io.File("myfile.txt"))
	while(in.hasNext()) {
		val word = in.next()
		val count = wordCount.getOrElse(word, 0)
		wordCount += (word -> (count + 1))
	}

	//6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, 
	//and similarly for the other weekdays. 
	//Demonstrate that the elements are visited in insertion order.
	val weekdays = scala.collection.mutable.LinkedHashMap(
		"Monday" -> java.util.Calendar.Monday,
		"Tuesday" -> java.util.Calendar.TUESDAY,
		"Wednesday" -> java.util.Calendar.WEDNESDAY,
		"Thursday" -> java.util.Calendar.THURSDAY,
		"Friday" -> java.util.Calendar.FRIDAY,
		"Saturday" -> java.util.Calendar.SATURDAY,
		"Sunday" -> java.util.Calendar.SUNDAY)

	//7. Print a table of all Java properties, like this:
	//java.runtime.name 	| Java(TM) SE Runtime Environment
	//sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
	//java.vm.version 		| 17.0-b16
	//java.vm.vendor 		| Sun Microsystems Inc.
	//java.vendor.url 		| http://java.sun.com/
	//path.separator 		| :
	//java.vm.name 			| Java HotSpot(TM) Server VM
	//You need to find the length of the longest key before you can print the table.
	import scala.collection.JavaConversions.propertiesAsScalaMap
	val javaProps: scala.collection.Map[String, String] = System.getProperties()
	var maxKeyLength = 0
	javaProps.keys.foreach(k => maxKeyLength = maxKeyLength max k.length)
	for((k, v) <- javaProps) println(k.padTo(maxKeyLength, ' ') + " | " + v)

	//8. Write a function minmax(values: Array[Int]) that returns 
	//a pair containing the smallest and largest values in the array.
	def minmax(values: Array[Int]) = {(values.min,values.max)}

	//9. Write a function lteqgt(values: Array[Int], v: Int) that returns 
	//a triple containing the counts of values less than v, equal to v, and greater than v.
	def lteqgt(values: Array[Int], v: Int) = {
		var l = 0
		var e = 0
		var g = 0
		for(n <- values) if(n > v) g += 1 else if(n == v) e += 1 else l += 1
		(l, e, g)
	}

	//10. What happens when you zip together two strings, such as "Hello".zip("World")? 
	//Come up with a plausible use case.
	"Hello".zip("World")  
	// => res6: scala.collection.immutable.IndexedSeq[(Char, Char)] = Vector((H,W), (e,o), (l,r), (l,l), (o,d))
	//use for a map to encrypt
}
