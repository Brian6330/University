// Done By: Julius Oeftiger 16-127-532; Brian Schweigler 16-102-071
/* ************************************************************************* *\
*                Programmierung 1 HS 2017 - Serie 2-2                         *
\* ************************************************************************* */

import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Book {

  private int id;
  private String title;
  private String author;
  private Date dateOfPublication;
	private int price;

  public static final String DATE_FORMAT = "dd.MM.yyyy";


  public Book(int id, String title, String author, Date dateOfPublication, int price) {          //constructor
    this.id = id;
    this.title = title;
    this.author = author;
    this.dateOfPublication = dateOfPublication;
		this.price = price;
  }

  /** Returns the age of the book in days since publication */
  public int age() {

    Date dateNow = new Date();
    long bookAge = ( dateNow.getTime() - dateOfPublication.getTime() ) / (24*60*60*1000);   // Calculate age of Book with method datenow

    return (int) bookAge; //return the age of the book in days
  }

  /** Returns a String representation of the book */
  public String toString() {

    return id +", "+ title +", "+ author +", "+ dateToString(dateOfPublication) +", "+ age() +" days old";        //return book details as string
  }

  /** Reads all book data from user input */
  public void input() {

    Scanner scn1 = new Scanner( System.in );  // seperate scanner because of weird bug when combining scn.nextInt(); with scn.nextLine();
    System.out.print( "Please enter id: " );
    this.id = scn1.nextInt();

    Scanner scn = new Scanner( System.in );
    System.out.print( "\nPlease enter title: " );
    this.title = scn.nextLine();


    System.out.print( "\nPlease enter author: " );
    this.author = scn.nextLine();

    System.out.print( "\nPlease enter the date of publication (dd.MM.YYYY): " );
    this.dateOfPublication = stringToDate( scn.nextLine() );
    scn1.close();
    scn.close();
  }

  // get-set
  public int getID() {
    return id;
  }
  public void setID(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getDateOfPublication() {
    return dateOfPublication;
  }
  public void setDateOfPublication(Date dateOfPublication) {
    this.dateOfPublication = dateOfPublication;
  }
	public int setPrice() {
		this.price = price;
	}
	public void setPrice(int price) {
		if (price < 0)
			price = 0;
		this.price = 0
	}

  //--- helper methods -- DO NOT CHANGE ------------------------------------
  /** Converts the Date object d into a String object */
  public static String dateToString( Date d ) {

    SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
    return fmt.format( d );
  }

  /** Converts the String object s into a Date object */
  public static Date stringToDate( String s ) {

    Date r = null;
    try {
      SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
      r = fmt.parse( s );
    } catch ( ParseException e ) {
      System.err.println( e );
      System.exit(1);
    }
    return r;
  }
}
