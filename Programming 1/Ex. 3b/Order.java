/*
* Programmierung 1 HS 2014
* Aufgabe 3-2
*
* Ruthusanth Vijayakumar (16-131-393)
* Andreas Gsponer (16-***-***)
*/

import java.text.*;

public class Order
{
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
	int counter = 0;				//variables that counts ordner.id (lines 33-35)

	/** constructor */
	public Order()
	{
		instanceCounter++;
		counter = instanceCounter;
		id = counter;
		customerName = getCustomerName();
		customerAddress = getCustomerAddress();
	}

	/** get-/set methods */
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress()
	{
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
	{
		this.customerAddress = customerAddress;
	}

	/** adds max. 5 books into the object order  */
	public void addBook(Book tmpBook )
	{
		switch (bookCounter)
		{
			case 1:
				book1 = tmpBook;
			case 2:
				book2 = tmpBook;
			case 3:
				book3 = tmpBook;
			case 4:
				book4 = tmpBook;
			case 5:
				book5 = tmpBook;
			default:
				break;
		}
		bookCounter++;
	}

	/** gets the sum of all book prices */
	public int getTotalPrice()
	{
		int sumPrice = 0;
		if (bookCounter > 1)
			sumPrice += book1.getPrice();
		if (bookCounter > 2)
			sumPrice += book2.getPrice();
		if (bookCounter > 3)
			sumPrice += book3.getPrice();
		if (bookCounter > 4)
			sumPrice += book4.getPrice();
		if (bookCounter > 5)
			sumPrice += book5.getPrice();

		return sumPrice;
	}

	/** returns a string representation of the object order */
	public String toString()
	{
		String temp = "Order id: ";
		temp += id + ", ";
		temp += "Customer: " + customerName + ", " + customerAddress + "\n";
		if(bookCounter > 1) temp += book1 + "\n";
		if(bookCounter > 2) temp += book2 + "\n";
		if(bookCounter > 3) temp += book3 + "\n";
		if(bookCounter > 4) temp += book4 + "\n";
		if(bookCounter > 5) temp += book5 + "\n";
		temp += "Total price: " + getTotalPrice() + " CHF";

		return temp;
	}
}
