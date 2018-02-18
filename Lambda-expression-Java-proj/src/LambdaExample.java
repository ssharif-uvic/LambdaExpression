
interface MyInterface {
	public int multiply(int a, int b);
}

class MyClass {

	public void execute(MyInterface myInterface) {
		System.out.println(myInterface.multiply(4, 5));
	}

}

public class LambdaExample {
	public static void main(String[] args) {
		
		int v = 9;
		
		MyClass myClass = new MyClass();

		
		//reassigning value to v gives error as follows:
		//Local variable v defined in an enclosing scope must be final or effectively final
		//v = 999;
		
		//Old way of creating an anonymous class based on the interface
		myClass.execute(new MyInterface() {
			@Override
			public int multiply(int a, int b) {
				return a * b * v;

			}
		});
		
		
		//New way of doing the same thing as above but based on Lambda expressions
		//Prerequisites: Must have an interface that has only ONE method in it
		//We can define the method of the interface to make an anonymous class 
		//that is based on that interface with the one method
		myClass.execute((a,b) -> a * b * 100 * v);
		myClass.execute((a,b) -> { return a * b * 100 * v; });
	}
}
