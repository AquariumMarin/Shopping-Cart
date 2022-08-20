//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ShoppingCart.java
// Course: CS 300 Spring 2022
//
// Author: Marin Suzuki
// Email: msuzuki9@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class contains the methods for looking up product by name or id, getting its price of a
 * given item, getting copy of items in the market, adding or removing item to a cart, counting the
 * number of occurrences of a given item within a cart, checking whether a cart contains at least
 * one occurrence of a given item, calculating the total value in dollars of the cart, removing all
 * the items in cart, and getting summary of the contents of a given cart.
 * 
 * @author Marin Suzuki
 */
public class ShoppingCart {
  private static final double TAX_RATE = 0.05; // sales tax
  // MarketItems: a perfect-size two-dimensional array that stores the list of
  // available items in a given market

  // MarketItems[i][0] refers to a String representation of the item identifiers
  // MarketItems[i][1] refers the item name. Item names are also unique
  // MarketItems[i][2] a String representation of the unit price
  // of the item in dollars
  private static String[][] marketItems =
      new String[][] {{"4390", "Apple", "$1.59"}, {"4046", "Avocado", "$0.59"},
          {"4011", "Banana", "$0.49"}, {"4500", "Beef", "$3.79"}, {"4033", "Blueberry", "$6.89"},
          {"4129", "Broccoli", "$1.79"}, {"4131", "Butter", "$4.59"}, {"4017", "Carrot", "$1.19"},
          {"3240", "Cereal", "$3.69"}, {"3560", "Cheese", "$3.49"}, {"3294", "Chicken", "$5.09"},
          {"4071", "Chocolate", "$3.19"}, {"4363", "Cookie", "$9.5"}, {"4232", "Cucumber", "$0.79"},
          {"3033", "Eggs", "$3.09"}, {"4770", "Grape", "$2.29"}, {"3553", "Ice Cream", "$5.39"},
          {"3117", "Milk", "$2.09"}, {"3437", "Mushroom", "$1.79"}, {"4663", "Onion", "$0.79"},
          {"4030", "Pepper", "$1.99"}, {"3890", "Pizza", "$11.5"}, {"4139", "Potato", "$0.69"},
          {"3044", "Spinach", "$3.09"}, {"4688", "Tomato", "$1.79"}, null, null, null, null};

  /**
   * Returns details of a specific product in the market given its name
   *
   * @param name name of the product to search
   * @return A string representation of the product to search including the identifier of the
   *         product, its name, and its price in dollars if match found.
   */
  public static String lookupProductByName(String name) {

    boolean productNameFound = false;

    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] != null && marketItems[i][1].equals(name)) {

        productNameFound = true;
        String idOfItem = marketItems[i][0];
        String nameOfItem = marketItems[i][1];
        String priceOfItem = marketItems[i][2];

        return idOfItem + " " + nameOfItem + " " + priceOfItem;
      }
    }

    if (productNameFound == false) {
      return "No match found";
    }
    return ""; // default statement added to allow this code to compile
  }
  
  @Override
  public String toString() {
    return "marin";
  }

  /**
   * Returns a string representation of the item whose id is provided as input if a match was found.
   * 
   * @param id the identifier of the product or item to search
   * @return A string representation of the product to search including the identifier of the
   *         product, its name, and its price in dollars if match found.
   */
  public static String lookupProductById(int id) {

    boolean idFound = false;
    String idInString = "" + id;

    for (int i = 0; i < 29; i++) {
      if (marketItems[i] != null && marketItems[i][0].equals(idInString)) {

        idFound = true;
        String idOfItem = marketItems[i][0];
        String nameOfItem = marketItems[i][1];
        String priceOfItem = marketItems[i][2];

        return idOfItem + " " + nameOfItem + " " + priceOfItem;
      }
    }

    if (idFound == false) {
      return "No match found";
    }
    return ""; // default statement added to allow this code to compile
  }

  /**
   * Returns the price in dollars (a double value) of a market item given its name.
   * 
   * @param name the name of the product to check its price
   * @return A double representation of a product's price. If no match was found in the market
   *         catalog, this method returns -1.0
   */
  public static double getProductPrice(String name) {
    boolean nameFound = false;

    for (int i = 0; i < 29; i++) {
      if (marketItems[i] != null && marketItems[i][1].equals(name)) {

        nameFound = true;
        String itemPriceInString = marketItems[i][2].substring(1);
        double itemPrice = Double.parseDouble(itemPriceInString);

        return itemPrice;
      }
    }

    if (nameFound == false) {
      return -1.0;
    }

    return 0.0; // default statement added to allow this code to compile
  }

  /**
   * Returns a deep copy of the marketItems array
   * 
   * @return A string array that has the exact same length and contents as the original array
   */
  public static String[][] getCopyOfMarketItems() {

    String[][] copyOfMarketItems = new String[marketItems.length][marketItems[0].length];

    for (int i = 0; i < marketItems.length; i++) {
      for (int j = 0; j < marketItems[0].length; j++) {
        copyOfMarketItems[i][j] = marketItems[i][j];
      }
    }

    return copyOfMarketItems;
  }

  /**
   * Appends an item to a given cart (appends means adding to the end). If the cart is already full
   * (meaning its size equals its length), the item will not be added to the cart.
   * 
   * @param item the name of the product to be added to the cart
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return The size of the oversize array cart after trying to add item. to the cart. This method
   *         returns the same of size without making any change to the contents of the array if it
   *         is full.
   */
  public static int addItemToCart(String item, String[] cart, int size) {

    if (size == cart.length) {
      return size;
    }

    if (size != cart.length) {
      cart[size] = item;
      return size + 1;
    }

    return 0; // default
  }

  /**
   * Returns the number of occurrences of a given item within a cart. This method must not make any
   * changes to the contents of the cart.
   * 
   * @param item the name of the item to search
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the number of occurrences of item (exact match) within the oversize array cart. Zero or
   *         more occurrences of item can be present in the cart.
   */
  public static int nbOccurrences(String item, String[] cart, int size) {

    int count = 0;
    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Checks whether a cart contains at least one occurrence of a given item. This method must not
   * make any changes to the contents of the cart.
   * 
   * @param item the name of the item to search
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return true if there is a match (exact match) of item within the provided cart, and false
   *         otherwise.
   */
  public static boolean contains(String item, String[] cart, int size) {

    boolean itemInCart = false;

    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        itemInCart = true;
      }
    }
    return itemInCart;

  }

  /**
   * This method returns the total value in dollars of the cart. All products in the market are
   * taxable (subject to TAX_RATE).
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the total value in dollars of the cart accounting taxes.
   */
  public static double checkout(String[] cart, int size) {

    double totalPrice = 0.0;

    for (int i = 0; i < size; i++) {
      totalPrice = totalPrice + getProductPrice(cart[i]);
    }
    totalPrice = (TAX_RATE + 1) * totalPrice;

    return totalPrice;
  }

  /**
   * Removes one occurrence of item from a given cart. If no match with item was found in the cart,
   * the method returns the same value of input size without making any change to the contents of
   * the array.
   * 
   * @param item the name of the item to remove
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the size of the oversize array cart after trying to remove item from the cart.
   */
  public static int removeItem(String[] cart, String item, int size) {

    int newSize = size;
    int i = 0;

    while (i < size) {
      if (cart[i].equals(item)) {
        cart[i] = cart[size - 1];
        cart[size - 1] = null;
        newSize = newSize - 1;
        break;
      }
      i = i + 1;
    }
    return newSize;
  }

  /**
   * Removes all items from a given cart. The array cart must be empty (contains only null
   * references) after this method returns.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the size of the cart after removing all its items.
   */
  public static int emptyCart(String[] cart, int size) {

    int newSize = size;

    for (int i = 0; i < size; i++) {
      cart[i] = null;
    }
    newSize = 0;

    return newSize;
  }

  /**
   * Returns a string representation of the summary of the contents of a given cart. The format of
   * the returned string contains a set of lines where each line contains the number of occurrences
   * of a given item, between parentheses, followed by one space followed by the name of a unique
   * item in the cart. (#occurrences) name1 (#occurrences) name2 etc.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return a string representation of the summary of the contents of the cart
   */
  public static String getCartSummary(String[] cart, int size) {
    int newSize = size;
    String[] cartItemSummary = new String[size];
    String[] cartOccurrencesSummary = new String[size];
    String cartSummary = "";

    for (int i = 0; i < size; i++) {
      cartItemSummary[i] = cart[i];
      cartOccurrencesSummary[i] = Integer.toString(nbOccurrences(cart[i], cart, size));
    }

    for (int k = 0; k < size; k++) {
      for (int i = 0; i < newSize - 1; i++) {
        for (int j = i + 1; j < newSize; j++) {
          if (cartItemSummary[i].equals(cartItemSummary[j])) {
            cartItemSummary[i] = cartItemSummary[newSize - 1];
            cartItemSummary[newSize - 1] = null;
            cartOccurrencesSummary[i] = cartOccurrencesSummary[newSize - 1];
            cartOccurrencesSummary[newSize - 1] = null;
            newSize = newSize - 1;
          }
        }
      }
    }

    for (int i = 0; i < newSize; i++) {
      cartSummary = cartSummary + "(" + cartOccurrencesSummary[i] + ") " + cartItemSummary[i];
      if (i != newSize - 1) {
        cartSummary = cartSummary + "\n";
      }
    }
    return cartSummary;
  }
}

