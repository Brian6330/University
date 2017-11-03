/*
* Programmming 1 HS 2017
* Exercise 3b
*
* Brian S. 16-xxx-yyy;
* Julius O. 16-xxx-yyy;
*/

import java.text.*;

public class Order {
	
	//some instance variables
	private int id;
	private String customerName;
	private String customerAddress;

	//objects for the books created with book-constructor; to store book informations
	public Book book1 = new Book();
	public Book book2 = new Book();
	public Book book3 = new Book();
	public Book book4 = new Book();
	public Book book5 = new Book();

	int bookCounter = 1;

	static int instanceCounter = 0;	//************
	int counter = 0;				//variables that counts order.id (lines 33-35)

	/** constructor */
	public order() {
		instanceCounter++;
		counter = instanceCounter;
		id = counter;
		this.customerName = getCustomerName();
		this.customerAddress = getCustomerAddress();
	}

	/** get-/set methods */
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/** adds max. 5 books into the object order  */
	public void addBook(Book inputBook ) {
		switch (bookCounter){
			case 1:
				book1 = inputBook;
			case 2:
				book2 = inputBook;
			case 3:
				book3 = inputBook;
			case 4:
				book4 = inputBook;
			case 5:
				book5 = inputBook;
			default:
				break;
		}
		bookCounter++;
	}

	/** gets the sum of all book prices */
	public int getTotalPrice() {
		int totalPrice = 0;
		if (bookCounter > 1)
			totalPrice += book1.getPrice();
		if (bookCounter > 2)
			totalPrice += book2.getPrice();
		if (bookCounter > 3)
			totalPrice += book3.getPrice();
		if (bookCounter > 4)
			totalPrice += book4.getPrice();
		if (bookCounter > 5)
			totalPrice += book5.getPrice();

		return totalPrice;
	}

	/** returns a string representation of the object order */
	public String toString() {
		String request = "Order id: ";
		request += id + ", ";
		request += "Customer: " + customerName + ", " + customerAddress + "\n";
		if(bookCounter > 1) request += book1 + "\n";
		if(bookCounter > 2) request += book2 + "\n";
		if(bookCounter > 3) request += book3 + "\n";
		if(bookCounter > 4) request += book4 + "\n";
		if(bookCounter > 5) request += book5 + "\n";
		request += "Total price: " + getTotalPrice() + " CHF";

		return request;
	}
}
	
