object ex5{
	//1. Improve the Counter class in Section 5.1, "Simple Classes and Parameterless Methods" on page 51 
	//so that it doesn't turn negative at Int.MaxValue.
	class Counter {
		private var value = 0
		def increment() { if(value < Int.MaxValue) value += 1 }
		def current() = value
	}
	//2. Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.
	class BankAccount{
		private var _balance = 0
		def balance = _balance
	
		def deposit(money: Int) = _balance += money
		def withdraw(money: Int) = if(money < _balance) _balance -= money
	}
	//3. Write a class Time with read-only properties hours and minutes and a method 
	//	before(other: Time): Boolean that checks whether this time comes before the other.A Time object 
	//should be constructed as new Time(hrs, min),where hrs is in military time format(between 0 and 23)
	class Time(private var _hours: Int = 0, private var _minutes: Int = 0){
		def hours = _hours
		def minutes = _minutes
		def before(other: Time) = _hours * 60 + _minutes < other._hours * 60 _ other._minutes
	}
	//4. Reimplement the Time class from the preceding exercise so that the internal representation is 
	//the number of minutes since midnight (between 0 and 24 * 60 - 1). Do not change the public 
	//interface. That is, client code should be unaffected by your change.
	class Time(private var _hours: Int = 0, private var _minutes: Int = 0){
		private var _time = _hours * 60 + _minutes
		def hours = _time / 60
		def minutes = _time % 60
		def before(other: Time) =  _time < other._time
	}

	//5. Make a class Student with read-write JavaBeans properties name (of type String) and 
	//id (of type Long). What methods are generated? (Use javap to check.) 
	//Can you call the JavaBeans getters and setters in Scala? Should you?
	import scala.beans.BeanProperty  //in scala 2.11
	class Student(@BeanProperty var Name: String, @BeanProperty var id: Long)
	//->
	/*public class Student {
  		private java.lang.String Name;
  		private long id;
  		public java.lang.String Name();
  		public void Name_$eq(java.lang.String);
  		public void setName(java.lang.String);
  		public long id();
  		public void id_$eq(long);
  		public void setId(long);
  		public java.lang.String getName();
  		public long getId();
  		public Student(java.lang.String, long);
	}*/
	//6. In the Person class of Section 5.1, "Simple Classes and Parameterless Methods" on page 51, 
	//provide a primary constructor that turns negative ages to 0.
	class Person(var name: String = "", var age: Int = 0) {
		if(age < 0) age = 0
	}

	//7. Write a class Person with a primary constructor that accepts a string containing a first name, 
	//a space, and a last name, such as new Person("Fred Smith"). Supply read-only properties firstName 
	//and lastName. Should the primary constructor parameter be a var, a val, or a plain parameter? Why?
	class Person(name: String) {
		private val fnln = name.split(' ')
		val firstName = fnln(0)
		val lastName = fnln(1)
	}
	//name here is a plain parameter, cause it's not used in any methods.

	//8. Make a class Car with read-only properties for manufacturer, model name, and model year, and a 
	//read-write property for the license plate. Supply four constructors. All require the manufacturer 
	//and model name. Optionally, model year and license plate can also be specified in the constructor. 
	//If not, the model year is set to -1 and the license plate to the empty string. 
	//Which constructor are you choosing as the primary constructor? Why?
	class Car(val manufactuer : String, val model: String, val year: Int = -1, var license: String = "") {
		override def toString = "Car(%s, %s, %d, %s)".format(manufactuer, model, year, license)
	}
	//9.Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice). 
	//How much shorter is the Scala class?

	//10. Consider the class
	//	class Employee(val name: String, var salary: Double) { 
	//		def this() { this("John Q. Public", 0.0) }
	//	}
	//Rewrite it to use explicit fields and a default primary constructor. 
	//Which form do you prefer? Why?
	class Employee(){
		private var _name = "John Q. Public"
		var salary = 0.0
		def this(n: String, s: Double) {
			this()
			_name = n
			salary = s
		}
		def name = _name
	}
}
