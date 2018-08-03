//write a class Factorial which has service method int getFactorial(int num) 
//which returns the factorial of a number num.
//if the number given by the user is less than  2 then throw InvalidInputException.
//find what is the highest value of int and if the factorial answer exceeds the 
//highest value  then throw FactorialException to the caller.

package exceptions;

import java.util.Scanner;

//inheriting Exception class.
class LessThanTwoException extends Exception {
	public LessThanTwoException(String message) {
		super(message);
	}
}

//// inheriting Exception class.
class ExceedHighestValueException extends Exception {
	public ExceedHighestValueException(String message) {
		super(message);
	}
}

// class for determining factorial.
class Factorial {

	int factorial(int number) throws LessThanTwoException, ExceedHighestValueException {
		int fact = 1;

		if (number < 2) {
			// Explicitly throwing an exception.

			throw new LessThanTwoException("Number cannot be less than two.");

		} else {
			for (int i = 1; i <= number; i++) {
				fact *= i;
			}
			if (fact > Integer.MAX_VALUE) {
				throw new ExceedHighestValueException("Number exceeds the limit");
			}
			return fact;
		}

	}

}

//Test class.
class TestFactorial {

	public static void main(String[] args) {
		Factorial factor = new Factorial();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number to find factorial");
		int number = scanner.nextInt();

		int result;
		try {
			result = factor.factorial(number); // risky code.
			System.out.println("Factorial= " + result); // risk dependent codes.
		} catch (LessThanTwoException less) {

			less.printStackTrace();
		} catch (ExceedHighestValueException exceed) {

			exceed.printStackTrace();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

}
