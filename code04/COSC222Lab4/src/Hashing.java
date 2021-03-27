import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hashing {

	// with 341116 words, a table size of 1mil keeps the load factor low
	static final int tableSize = 1000000;

	public static void main(String[] args) throws IOException {

		// TODO: Will be hashing strings using polynomial in k, for all values
		// k=1 to 45. Once you have one case working, you will probably want
		// to wrap your code in a for loop for k=1 to 45
		int[] chain_size = new int[45];
		int[] total_collisions = new int[45];
		for (int k = 1; k <= 45; k++) {

			// Leave these two lines alone for opening the input file
			FileReader f = new FileReader("englishWords.txt");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(f);

			// TODO: Create your hashtable or simulated hashtable of size tableSize
			int[] counts = new int[tableSize];

			// This loop runs through the words in the file
			while (sc.hasNext()) {
				String s = sc.nextLine();

				// TODO: remove or comment-out this next line, or modify it
				// for your own debugging purposes
				// System.out.println(s);

				// TODO: Find hashValue of s. Update your simulated hashtable
				int num = hash(s, k);
				num = num % 1000000;
				// if negative value, adding 1million to it
				// consistent with the checking
				if (num < 0) {
					num = num + 1000000;
				}
				// TODO: Don't forget to count collisions
				counts[num]++;
			}

			// TODO: Find the maximum bucket size
			// TODO: Report the total number of collisions found at this k value
			// TODO: Report the maximum bucket size found at this k value
			int max = 0;
			int tol = 0;
			for (int i = 0; i < counts.length; i++) {
				if (max < counts[i]) {
					max = counts[i];
				}

				// count collisions
				// if the value in counts[i] > 1, means there is at least 1 collisions
				if (counts[i] > 1) {
					tol = tol + (counts[i] - 1);
				}
			}
			System.out.println("k value = " + k + " resulted in " + tol + " collisions");
			System.out.println("k value = " + k + " maximum bucket size was " + max);

			chain_size[k - 1] = max;
			total_collisions[k - 1] = tol;
			// Leave this line alone to close the input file
			f.close();
		}

		// find the 3 best k-values
		// by having the best (i.e. smallest) maximum chain size.
		int[] index = new int[45];
		for (int i = 0; i < index.length; i++) {
			index[i] = i + 1;
		}

		// order by total-collisions or by max-bucket-size
		boolean flag = false;
		// true, order by max-bucket-size
		// false, order by total-collisions

		for (int i = 0; i < chain_size.length; i++) {
			for (int j = 0; j < chain_size.length - 1; j++) {
				// swap chain_size[j+1] and chain_size[i]
				// as well as index[j+1] and index[i]
				// and total_collisions[j+1] and total_collisions[i]
				if (flag) {
					if (chain_size[j] > chain_size[j + 1]) {
						int temp = chain_size[j];
						chain_size[j] = chain_size[j + 1];
						chain_size[j + 1] = temp;

						temp = index[j];
						index[j] = index[j + 1];
						index[j + 1] = temp;

						temp = total_collisions[j];
						total_collisions[j] = total_collisions[j + 1];
						total_collisions[j + 1] = temp;
					}
				} else {
					if (total_collisions[j] > total_collisions[j + 1]) {
						int temp = chain_size[j];
						chain_size[j] = chain_size[j + 1];
						chain_size[j + 1] = temp;

						temp = index[j];
						index[j] = index[j + 1];
						index[j + 1] = temp;

						temp = total_collisions[j];
						total_collisions[j] = total_collisions[j + 1];
						total_collisions[j + 1] = temp;
					}
				}
			}
		}

		//
		System.out.println();
		System.out.println("------------report 3 best k-values---------------");
		for (int i = 0; i < 3; i++) {
			System.out.println("k value = " + index[i] + " resulted in " + total_collisions[i] + " collisions");
			System.out.println("k value = " + index[i] + " maximum bucket size was " + chain_size[i]);
		}

	}

	public static int hash(String s, int k) {
		int value = 0;
		// TODO: Compute the hash function
		// -1 point if you do not use horner's method to
		// compute the polynomial
		// s[0]*k^(n-1) + s[1]*k^(n-2) + ... + s[n-1]

		// use horner's method
		for (int i = 0; i < s.length(); i++) {
			int si = (int) s.charAt(i);

			value = si + k * value;
		}

		return value;
	}
}

/***********************************************************
 * Report your best k values here (you can output all k values and then visually
 * inspect your output for your 3 best k values). Give your 3 best k-values for
 * the smallest total number of collisions, and also give your 3 best k-values
 * for the smallest value for the max-bucket-size.
 * 
 * 3 best k-values for the smallest total number of collisions
 * 
 * k value = 29 resulted in 51783 collisions k value = 29 maximum bucket size
 * was 6 k value = 31 resulted in 51789 collisions k value = 31 maximum bucket
 * size was 6 k value = 43 resulted in 51850 collisions k value = 43 maximum
 * bucket size was 5
 * 
 * 
 * 
 * 3 best k-values for the smallest value for the max-bucket-size
 * 
 * k value = 19 resulted in 52248 collisions k value = 19 maximum bucket size
 * was 5 k value = 43 resulted in 51850 collisions k value = 43 maximum bucket
 * size was 5 k value = 9 resulted in 54500 collisions k value = 9 maximum
 * bucket size was 6
 */
