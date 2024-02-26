package coding_challenge;
import java.util.*;
public class Luhn {
	public static void main (String[] args) throws Exception {
		try (Scanner input = new Scanner(System.in)) { //creating a Scanner object
			System.out.print("Number: "); //prompts the user to enter a text
			String number = input.next(); //scans and stores the input to string variable text
			int len = number.length(); //stores the length of the string to a variable called len
			//initializes sum to -1 so our sum won't be checked by the isCardValid method yet
			//sum stores the sum of the credit card numbers according to the Luhn algorithm
			//we would like the sum to be checked after we iterate through the string
			int sum = -1; 
			int a = 0, b = 0;
			//used javaTpoint to find getNumericValue method which is a built-in method
			//that converts the character of a string to a numeric value
			//the following if statement checks whether or not the length is greater than 1
			//if not, INVALID is printed
			if (len > 1) {
				a = Character.getNumericValue(number.charAt(0));
				b = Character.getNumericValue(number.charAt(1));
			}
			//the following if statement calls isCardValid to see if the card is a valid
			//AMERICAN EXPRESS, MASTERCARD, or VISA card
			//if isCardValid returns true then isNumberValid is called to see if the card
			//number is valid
			if (isCardValid(a, b, sum, len)) {
				isNumberValid(number);
			}
		}
	}
	
	//The following method passes 4 integers:
	//o a: the first index of the string
	//o b: the second index of the string
	//o sum: the sum of all the digits multiplied by 2 and all the digits that weren't
	//       multiplied by 2
	//o len: the length of the string
	//The method checks to see if the card is under Visa, MasterCard, or American Express
	//and if it's not under either of these corporations, then it prints INVALID
	//The method checks if the sum is divisible by 10 and if it is divisible by 10, it calls
	//the isSumValid method while passing an integer
	public static boolean isCardValid(int a, int b, int sum, int len) {
		int card = 0;
		//if statement to see if the card is a VISA
		if (a == 4 && (len == 13 | len == 16)) {
			if ((sum%10) == 0) {
				card = 1;
				isSumValid(card);
			}
			return true;
		}
		//if statement to see if the card is a MASTERCARD
		else if (a == 5 && len == 16) {
			if (b == 1 | b == 2 | b == 3 | b == 4 | b == 5) {
				if ((sum%10) == 0) {
					card = 2;
					isSumValid(card);
				}
				return true;
			}
		}
		//if statement to see if the card is an AMERICAN EXPRESS
		else if (a == 3 && len == 15) {
			if (b == 4 | b == 7) {
				if ((sum%10) == 0) {
					card = 3;
					isSumValid(card);
				}
				return true;
			}
		}
			System.out.println("INVALID");
			return false;
	}
	
	//The following method uses a for-loop to iterate through the string and 
	//converts each character of the string to a value and stores it in a variable called val
	//It adds up all the values placed in the odd position and stores it in a variable called odd
	//and multiplies all the values placed in the even position by 2 and then adds them all up and 
	//stores it in a variable called even
	//After, all the odd positioned values and even positioned values are added, then odd and even are
	//added and its value is stored in sum
	//Then, we call the isCardValid method to check if the sum is valid
	public static void isNumberValid(String number) {
		int a = Character.getNumericValue(number.charAt(0));
		int b = Character.getNumericValue(number.charAt(1));
		int even = 0;
		int odd = 0;
		int sum = -1;
		int len = number.length();
		for (int i = 0; i<number.length(); i++) {
			int val = Character.getNumericValue(number.charAt(i));
			//if the index is at an even position
			if (i%2 == 0) {
				val = val*2;
				//if the value is greater than 9, we need to split up the two digits in the ones place and tens place,
				//then add them up. For example, 12 becomes 1+2, 19 becomes 1+9, 17 become 1+7, and so on...
				if (val > 9) {
					even += 1 + (val-10);
				}
				else {
					even += val;
				}
			}
			//if the index is at an odd position
			else {
				odd += val;
			}
		}
		sum = odd + even;
		isCardValid(a, b, sum, len);
	}
	
	//The following method prints out the corporation's name if their sum is valid
	//If there sum is not valid, then it prints out INVALID
	//the variable card is reinitialized by the isCardValid method
	public static void isSumValid(int card) {
		if (card == 1) {
			System.out.println("VISA");
		}
		else if (card == 2) {
			System.out.println("MASTERCARD");
		}
		else if (card == 3) {
			System.out.println("AMERICAN EXPRESS");
		}
		else {
			System.out.println("INVALID");
		}
	}
	
}

//Number: 
//VISA
