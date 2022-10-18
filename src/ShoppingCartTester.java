//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ShoppingCartTester.java
///////////////////////////////////////////////////////////////////////////////

/**
 * This contains testing methods for the ShoppingCart class.
 *
 * @author Marin Suzuki
 */
public class ShoppingCartTester {
  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testLookupMethods(): " + testLookupMethods());
    System.out.println("testGetProductPrice(): " + testGetProductPrice());
    System.out.println(
        "testAddItemToCartContainsNbOccurrences(): " + testAddItemToCartContainsNbOccurrences());
    System.out.println("testRemoveItem(): " + testRemoveItem());
    System.out.println("testCheckoutGetCartSummary(): " + testCheckoutGetCartSummary());
    System.out.println("runAllTests(): " + runAllTests());
  }

  /**
   * Checks whether ShoppingCart.lookupProductByName() and ShoppingCart.lookupProductById() methods
   * work as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupMethods() {
    // define test scenarios.

    // 1. The item to find is at index 0 of the marketItems array
    {
      String expectedOutput = "4390 Apple $1.59";

      if (!ShoppingCart.lookupProductByName("Apple").equals(expectedOutput)) {

        System.out.println("Problem detected: Your lookupProductByName() method "
            + "failed to return the expected output when passed Apple as input");
        return false;
      }
      if (!ShoppingCart.lookupProductById(4390).equals(expectedOutput)) {

        System.out.println("Problem detected: Your lookupProductById() method "
            + "failed to return the expected output when passed the id " + "of Apple as input");
        return false;
      }
    }

    // 2. The item to find is at the last non-null position of
    // the marketItems array
    {
      String expectedOutput = "4688 Tomato $1.79";

      if (!ShoppingCart.lookupProductByName("Tomato").equals(expectedOutput)) {

        System.out.println("Problem detected: Your lookupProductByName() method "
            + "failed to return the expected output when passed Tomato as input");
        return false;
      }
      if (!ShoppingCart.lookupProductById(4688).equals(expectedOutput)) {

        System.out.println("Problem detected: Your lookupProductById() method "
            + "failed to return the expected output when passed the id " + "of Tomato as input");
        return false;
      }
    }

    // 3. The item to find is at an arbitrary position of the
    // middle of the marketItems array
    {
      String expectedOutput = "3033 Eggs $3.09";

      if (!ShoppingCart.lookupProductByName("Eggs").equals(expectedOutput)) {

        System.out.println("Problem detected: Your lookupProductByName() method "
            + "failed to return the expected output when passed Eggs as input");
        return false;
      }
      if (!ShoppingCart.lookupProductById(3033).equals(expectedOutput)) {

        System.out.println("Problem detected: Your lookupProductById() method "
            + "failed to return the expected output when passed the id " + "of Eggs as input");
        return false;
      }
    }

    // 4. The item to find is not found in the market
    {
      String expectedOutput = "No match found";

      if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
        System.out.println("Problem detected: Your lookupProductByName() method "
            + "failed to return the expected output when passed the name of "
            + "a product not found in the market.");
        return false;
      }
      if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {

        System.out.println("Problem detected: Your lookupProductById() method "
            + "failed to return the expected output when passed the identifier"
            + "of a product not found in the market.");
        return false;
      }
      return true; // NO BUGS detected by this tester method
    }
  }

  /**
   * Checks the correctness of ShoppingCart.getProductPrice() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetProductPrice() {
    // define test scenarios

    // first test scenario: get the price of Apple
    {
      double expectedPrice = 1.59;

      // price of the product Apple in the market
      // Note that we do not use the == operator to check whether two
      // floating-point numbers (double or float) in java are equal.
      // Two variables a and b of type double are equal if the absolute
      // value of their difference is less or equal to a small threshold epsilon.
      // For instance, if Math.abs(a - b) <= 0.001, then a equals b
      if (Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
        // print feedback to report the detected bug
        System.out.println("Problem detected: Your getProductPrice() method "
            + "failed to return the expected output when passed Apple as input");
        return false;
      }
    }

    // second test scenario: get the price of a product not found in the market
    {
      double expectedPrice = -1.0;

      if (Math.abs(ShoppingCart.getProductPrice("NOT FOUND") - expectedPrice) > 0.001) {
        // print feedback to report the detected bug
        System.out.println("Problem detected: Your getProductPrice() method "
            + "failed to return the expected output when passed NOT FOUND as input");
        return false;
      }
    }

    // third test scenario: get the price of a product at the last non-null position of
    // the marketItems array
    {
      double expectedPrice = 1.79;

      if (Math.abs(ShoppingCart.getProductPrice("Tomato") - expectedPrice) > 0.001) {
        // print feedback to report the detected bug
        System.out.println("Problem detected: Your getProductPrice() method "
            + "failed to return the expected output when passed Tomato as input");
        return false;
      }
    }

    // forth test scenario: get the price of a product at an arbitrary position of the
    // middle of the marketItems array
    {
      double expectedPrice = 6.89;

      if (Math.abs(ShoppingCart.getProductPrice("Blueberry") - expectedPrice) > 0.001) {
        // print feedback to report the detected bug
        System.out.println("Problem detected: Your getProductPrice()  method "
            + "failed to return the expected output when passed Blueberry as input");
        return false;
      }
    }

    return true; // No bug detected. The ShoppingCart.getProductPrice()
                 // passed this tester.
  }

  /**
   * This tester method checks the correctness of addItemToCart, contains, and nbOccurrences methods
   * defined in the ShoppingCart class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToCartContainsNbOccurrences() {
    // define test scenarios

    // first test scenario: adding an item to the empty cart
    {
      String[] expectedCart = {"Banana", null, null, null, null, null, null, null, null, null};
      String[] cart = new String[10]; // array containing 10 null references
      int size = 0; // no item is stored in the cart //TODO
      int newSize = ShoppingCart.addItemToCart("Banana", cart, size);

      if (newSize != 1) {
        System.out.println("Problem detected: Your addItemToCart() method "
            + "failed to return the expected size when added an item to the empty cart");
        return false;
      }

      // check that the new item has been correctly added at the end of the array cart
      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) { //TODO
        System.out.println("Problem detected: Your addItemToCart() method "
            + "failed to return the expected array when added an item to the empty cart");
        return false;
      }

      if (!(ShoppingCart.contains("Banana", cart, newSize))) {
        System.out.println("Problem detected: Your conitains() method "
            + "failed to return the expected output when added an item to the empty cart");
        return false;
      }

      if (ShoppingCart.nbOccurrences("Banana", cart, newSize) != 1) {
        System.out.println("Problem detected: Your nbOccurrences() method "
            + "failed to return the expected output when added an item to the empty cart");
        return false;
      }

    }

    // second test scenario: adding an item to the full cat
    {
      String[] expectedCart = new String[] {"Milk", "Apple", "Banana", "Pizza"};
      String[] cart = new String[] {"Milk", "Apple", "Banana", "Pizza"};
      int size = 4; // full array (size == cart.length)
      int newSize = ShoppingCart.addItemToCart("Eggs", cart, size);

      if (newSize != 4) {
        System.out.println("Problem detected: Your addItemToCart() method "
            + "failed to return the expected size when added an item to the full cart");
        return false;
      }

      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) {
        System.out.println("Problem detected: Your addItemToCart() method "
            + "failed to return the expected array when added an item to the full cart");
        return false;
      }

      if ((ShoppingCart.contains("Eggs", cart, newSize))) {
        System.out.println("Problem detected: Your conitains() method "
            + "failed to return the expected output when added an item to the full cart");
        return false;
      }

      if (ShoppingCart.nbOccurrences("Eggs", cart, newSize) != 0) {
        System.out.println("Problem detected: Your nbOccurrences() method "
            + "failed to return the expected output when added an item to the full cart");
        return false;
      }

    }

    // third test scenario: adding an item to the cart successfully
    {
      String[] expectedCart = new String[] {"Milk", "Apple", "Banana", "Pizza", "Eggs", null};
      String[] cart = new String[] {"Milk", "Apple", "Banana", "Pizza", null, null};
      int size = 4; // 4 items are stored in the cart
      int newSize = ShoppingCart.addItemToCart("Eggs", cart, size);

      if (newSize != 5) {
        System.out.println("Problem detected: Your addItemToCart() method "
            + "failed to return the expected size when added an item to the cart successfully");
        return false;
      }

      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) {
        System.out.println("Problem detected: Your addItemToCart() method "
            + "failed to return the expected array when added an item to the cart successfully");
        return false;
      }

      if (!(ShoppingCart.contains("Eggs", cart, newSize))) {
        System.out.println("Problem detected: Your conitains() method "
            + "failed to return the expected output when added an item to the cart successfully");
        return false;
      }

      if (ShoppingCart.nbOccurrences("Banana", cart, newSize) != 1) {
        System.out.println("Problem detected: Your nbOccurrences() method "
            + "failed to return the expected output when added an item to the cart successfully");
        return false;
      }
    }

    return true; // No bug detected.
  }

  /**
   * This tester method checks the correctness of removeItem() method defined in the ShoppingCart
   * class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveItem() {
    // define test scenarios

    // first test scenario: Removing an item from the empty cart
    {
      int expectedSize = 0;
      String[] expectedCart = {null, null, null, null, null};

      String[] cart = new String[5]; // array containing 5 null references
      int size = 0; // no item is stored in the cart

      if (ShoppingCart.removeItem(cart, "Apple", size) != expectedSize) {
        System.out.println("Problem detected: Your removeItem() method "
            + "failed to return the expected output when removed an item from the empty cart");
        return false;
      }

      // check if the cart has the same contents as expectedCart
      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) {
        System.out.println("Problem detected: the number of occurrences of each element at "
            + "the correct is not as expected after the removeItem() method call returns");
        return false;
      }
    }

    // second test scenario: Removing an not found item from the cart
    {
      int expectedSize = 5;
      String[] expectedCart = {"Milk", "Apple", "Banana", "Pizza", "Milk", null, null};

      String[] cart = new String[] {"Milk", "Apple", "Banana", "Pizza", "Milk", null, null};
      int size = 5; // 5 items are stored in the cart

      if (ShoppingCart.removeItem(cart, "Eggs", size) != expectedSize) {
        System.out.println("Problem detected: Your removeItem() method "
            + "failed to return the expected output when removed an not found item from the cart");
        return false;
      }

      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) {
        System.out.println("Problem detected: the number of occurrences of each element at "
            + "the correct is not as expected after removing an not found item from the cart");
        return false;
      }

    }

    // third test scenario: Removing an item whose first occurrence is stored at an arbitrary
    // position within a non-empty array cart successfully
    {
      int expectedSize = 4;
      String[] expectedCart = {"Milk", "Pizza", "Banana", "Apple", null, null, null};

      String[] cart = new String[] {"Milk", "Apple", "Banana", "Apple", "Pizza", null, null};
      int size = 5; // 5 items are stored in the cart

      if (ShoppingCart.removeItem(cart, "Apple", size) != expectedSize) {
        System.out.println("Problem detected: Your removeItem() method "
            + "failed to return the expected output when removed an item whose first occurrence"
            + " is stored at an arbitrary position within a non-empty array cart successfully");
        return false;
      }

      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) {
        System.out.println("Problem detected: the number of occurrences of each element at "
            + "the correct is not as expected after removing an item whose first occurrence "
            + "is stored at an arbitrary position within a non-empty array cart successfully");
        return false;
      }

    }

    // forth test scenario: removing an item stored at index 0 of a non-empty cart successfully
    {
      int expectedSize = 4;
      String[] expectedCart = {"Pizza", "Apple", "Banana", "Apple", null, null, null};

      String[] cart = new String[] {"Milk", "Apple", "Banana", "Apple", "Pizza", null, null};
      int size = 5; // 5 items are stored in the cart

      if (ShoppingCart.removeItem(cart, "Milk", size) != expectedSize) {
        System.out.println("Problem detected: Your removeItem() method "
            + "failed to return the expected output when removed  an item stored at "
            + "index 0 of a non-empty cart successfully");
        return false;
      }

      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) {
        System.out.println("Problem detected: the number of occurrences of each element at "
            + "the correct is not as expected after removing an item stored at index"
            + " 0 of a non-empty cart successfully");
        return false;
      }

    }

    // fifth test scenario: removing an item whose first occurrence is stored at index
    // size-1 (last index position) of a non-empty cart successfully
    {
      int expectedSize = 4;
      String[] expectedCart = {"Milk", "Apple", "Banana", "Apple", null, null, null};

      String[] cart = new String[] {"Milk", "Apple", "Banana", "Apple", "Pizza", null, null};
      int size = 5; // 5 items are stored in the cart

      if (ShoppingCart.removeItem(cart, "Pizza", size) != expectedSize) {
        System.out.println("Problem detected: Your removeItem() method "
            + "failed to return the expected output when removed an item whose first "
            + "occurrence is stored at index size-1 (last index position)"
            + " of a non-empty cart successfully");
        return false;
      }

      if (!(java.util.Arrays.deepEquals(cart, expectedCart))) {
        System.out.println("Problem detected: the number of occurrences of each element at "
            + "the correct is not as expected after removing an item whose"
            + " first occurrence is stored at index size-1 (last index position)"
            + " of a non-empty cart successfully");
        return false;
      }
    }

    return true; // No bug detected.
  }

  /**
   * This tester method checks the correctness of checkout and getCartSummary() methods defined in
   * the ShoppingCart class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCheckoutGetCartSummary() {
    // define test scenarios

    // first test scenario: Getting summary of the empty cart
    {
      String expectedCartSummary = "";

      String[] cart = new String[7]; // array containing 7 null references
      int size = 0; // no item is stored in the cart

      if (!(ShoppingCart.getCartSummary(cart, size).equals(expectedCartSummary))) {
        System.out.println("Problem detected: Your testCheckoutGetCartSummary() method "
            + "failed to return the expected output when getting summary of the empty cart");
        return false;
      }
    }

    // second test scenario: Getting summary of the cart containing unique items
    {
      String expectedCartSummary =
          "(1) Milk" + "\n" + "(1) Apple" + "\n" + "(1) Banana" + "\n" + "(1) Pizza";

      String[] cart = new String[] {"Milk", "Apple", "Banana", "Pizza", null, null};
      int size = 4; // non-empty cart of size 4

      if (!(ShoppingCart.getCartSummary(cart, size).equals(expectedCartSummary))) {
        System.out.println("Problem detected: Your getCartSummary() method "
            + "failed to return the expected output when getting summary of"
            + " the cart containing unique items");
        return false;
      }

    }

    // third test scenario: Getting summary of the cart containing multiple
    // occurrences of the same items:
    {
      String expectedCartSummary = "(1) Banana" + "\n" + "(1) Onion" + "\n" + "(3) Milk" + "\n"
          + "(2) Eggs" + "\n" + "(2) Tomato";

      String[] cart = new String[] {"Tomato", "Milk", "Milk", "Eggs", "Tomato", "Onion", "Eggs",
          "Milk", "Banana", null, null};
      int size = 9; // non-empty cart of size 9

      if (!(ShoppingCart.getCartSummary(cart, size).equals(expectedCartSummary))) {
        System.out.println("Problem detected: Your getCartSummary() method "
            + "failed to return the expected output when getting summary of the cart"
            + " containing multiple occurrences of the same items");
        return false;
      }
    }
    return true; // No bug detected.
  }

  /**
   * This tester runs all the tester methods defined in this tester class. For instance, if this
   * tester class defines three tester methods named test1(), test2() and test3(), it will return
   * test1() && test2() && test3()
   * 
   * @return false if any of the tester methods fails, and true if all the tests are passed.
   */
  public static boolean runAllTests() {
    return testLookupMethods() && testGetProductPrice() && testAddItemToCartContainsNbOccurrences()
        && testRemoveItem() && testCheckoutGetCartSummary();
  }
}
