public class ArrayDequeTest {
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual
					+ ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual +
					", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		ArrayDeque<String> arrd1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, arrd1.isEmpty());

		arrd1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		passed = checkSize(1, arrd1.size()) && passed;
		passed = checkEmpty(false, arrd1.isEmpty()) && passed;

		arrd1.addLast("middle");
		passed = checkSize(2, arrd1.size()) && passed;

		arrd1.addLast("back");
		passed = checkSize(3, arrd1.size()) && passed;

		System.out.println("Printing out deque: ");
		arrd1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		ArrayDeque<Integer> arrd1 = new ArrayDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, arrd1.isEmpty());

		arrd1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, arrd1.isEmpty()) && passed;

		arrd1.removeFirst();
		// should be empty
		passed = checkEmpty(true, arrd1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 