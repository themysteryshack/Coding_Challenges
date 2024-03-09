package coding_challenge;
import java.util.*;

public class targetSum {
	public static void main (String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter a target sum: "); //prompts the user to enter a target
			int target_sum = input.nextInt();
			System.out.print("Enter an array of values: "); //prompts the user to enter values
			int[] array = new int[10]; //default length of the array is limited to 10
			                           //can be changed to any length so the user can enter more values
			int i = 0; 
			int second_value;
			int temp_target;
			boolean found = true;
			//the following loop scans for a token and stores each value to the array
			//while storing values to the array. The loop subtracts the current value stored to the array
			//from the target_sum and stores the result in second_value
			//second_value is the potential value that may be located in the array
			//the for-loop iterates through the array and checks to see if the second_value is present
			//if the second_value is present in the array, then the current value and second value are added and stored to temp_target
			//if temp_target is equal to the target, then the subset has been found and we can exit out of the while loop
			while (input.hasNext() && found) { 
				array[i] = input.nextInt();
				second_value = target_sum - array[i];
				for (int k=0; k<=i; k++) {
					if(k != i && second_value == array[k]) { //when k!=i, since we don't want duplicates of the second_value
						temp_target = second_value + array[i];
						if (target_sum == temp_target) {
							System.out.println("Subset Exists: ");
							System.out.println("[" + second_value + ", " + array[i] + "]");
							found = false;
						}
					}
				}
				i++;
			}
		}
	}
}
//Output
//Enter a target sum:
//Enter an array of values:
//Subset Exists:
//[1, 5]
