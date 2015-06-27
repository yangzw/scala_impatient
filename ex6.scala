object ex6{
	//1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, 
	//and milesToKilometers.
	object Conversions{
		def inchesToSantimeters(value: Double) = value * 2.54
		def gallonsToLiters(value: Double) = value * 3.78541178
		def milesToKilometers(value: Double) = value * 1.609344
	}
	//2. The preceding problem wasn't very object-oriented. Provide a general superclass UnitConversion 
	//and define objects InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.
	class UnitConversion(val factor: Double) {
		def convert(value: Double): Double = factor * value
	}

	object InchesToSantimeters extends UnitConversion(2.54) {}
	object GallonsToLiters extends UnitConversion(3.78541178) {}
	object MilesToKilometers extends UnitConversion(1.609344) {}
	//3. Define an Origin object that extends java.awt.Point. Why is this not actually a good idea? 
	//(Have a close look at the methods of the Point class.)
	object Origin extends java.awt.Point {}
	//java.awt.Point is mutable. And object Origin limits that there's only one origin.

	//4. Define a Point class with a companion object so that you can construct Point instances as 
	//Point(3, 4), without using new.
	class Point(x: Int = 0, y: Int = 0) extends java.awt.Point(x,y) {}
	object Point{
		def apply(x: Int = 0, y: Int = 0) = new Point(x,y)
	}
	//5. Write a Scala application, using the App trait, that prints the command-line arguments in reverse 
	//order, separated by spaces. For example, scala Reverse Hello World should print World Hello.
	object Reverse extends App{
		println(args.reverse.mkString(" "))
	}
	//6. Write an enumeration describing the four playing card suits so that the toString method returns 
	//four suits .
	object Suits extends Enumeration {
		type Suits = Value
		val Spade = Value("♠")
		val Club = Value("♣")
		val Heart = Value("♥")
		val Diamond = Value("♦")
	}
	//7. Implement a function that checks whether a card suit value from the preceding exercise is red.
	object Suits extends Enumeration {
		type Suits = Value
		val Spade = Value("♠")
		val Club = Value("♣")
		val Heart = Value("♥")
		val Diamond = Value("♦")
		def isRed(card: Suits) = card == Heart || card == Diamond
	}
	//8. Write an enumeration describing the eight corners of the RGB color cube. 
	//As IDs, use the color values (for example, 0xff0000 for Red).
	object RGBCube extends Enumeration {
		val black = Value(0x000000, "Black")
		val red = Value(0xff0000, "Red")
		val green = Value(0x00ff00, "Green")
		val blue = Value(0x0000ff, "Blue")
		val yellow = Value(0xffff00, "Yellow")
		val magenta = Value(0xff00ff, "Magenta")
		val cyan = Value(0x00ffff, "Cyan")
		val white = Value(0xffffff, "White")
	}
}
