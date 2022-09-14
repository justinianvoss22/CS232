Script started on 2022-01-14 12:50:19-05:00 [TERM="xterm-256color" TTY="/dev/pts/1" COLUMNS="80" LINES="24"]
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat Cirlce    c rcleArea.           RectangleArea.java
/*Input: The height and width
 * Precondition: The height and width is a positive number.
 *  * Output: The area of the rectangle.
 *   *
 *    * Begun by: Dr. Adams, for CS 214, at Calvin College.
 *     * Completed by: Justin Voss
 *      * Date: 1/14/22
 *       **********************************************************/


 import java.util.Scanner;  // include class for Scanner

 public class RectangleArea {

	      /* function circleArea() computes a circle's area, given its radius.
	       *       * Parameter: r, a double
	       *             * Precondition: r is not negative.
	       *                   * Returns: the area of the circle
	       *                         */
	      public static double rectangleArea(double h, double w) {
		              return h * w;               // return an expression
			           } // RectangleArea method
	      	
	     //    main program
		   public static void main(String[] args) {
		         // prompt for height and width
		               System.out.println("\n\nTo compute the area of a rectangle,");
		                     System.out.println(" enter its height and width. ");
                             System.out.print(" Height: ");
		
		                           // Create a connection named keyboard to standard in
		                                 Scanner keyboard = new Scanner(System.in);
		                                       //Get the number from the user
		                                             double height = keyboard.nextDouble();
                                                     System.out.print("\n Width:");
                                                     double width = keyboard.nextDouble();
		                                                   // output area
		                                                         System.out.println("\nThe area is " + rectangleArea(height,width) + "\n");
		                                                               System.out.printf("The area is %f\n\n", rectangleArea(height,width));
		                                                                     System.out.printf("The area is %.15f\n\n", rectangleArea(height,width));
		                                                                       } // main method
		
		                                                                       } // class RectangleArea]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ javac       cat RectangleArea.javap lab01-results /home/cs/214/current/jav86[26Pat lab01-resultsscript.java script.ada script.clojure scrippt.ruby > lab01-results[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat lab01-results[K
[K[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat lab01-resultsscript.java script.ada script.clojure scrippt.ruby > lab01-results[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ [28Pscript script.ruby
[K[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ script script.rubycat script.java script.ada script.clojure scrippt.ruby > lab01-results[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat lab01-results[K
[K[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat lab01-resultsp lab01-results /home/cs/214/current/jav86[21Pat RectangleArea.java[Kcat RectangleArea.javap lab01-results /home/cs/214/current/jav86[26Pat lab01-resultsscript.java script.ada script.clojure scrippt.ruby > lab01-results[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ [28Pscript script.ruby
[K[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ script script.ruby[Kruby circle_area.rb[K.rbls[Kcd ..[15@mv script.clojure ..ls[Kcd ..[3Plsmv script.clojure ..cd ..[K[3Plsruby circle_area.rb[K.rbscript[K script.rubycat script.java script.ada script.clojure scrippt.ruby > lab01-results[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat lab01-results[K
[K[A]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat lab01-resultsp lab01-results /home/cs/214/current/jav86[21Pat RectangleArea.java[Kde  javac -deprecation RectangleArea.java
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ java RectangleArea


To compute the area of a rectangle,
 enter its height and width. 
 Height: 1

 Width:2

The area is 2.0

The area is 2.000000

The area is 2.000000000000000

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ java RectangleArea


To compute the area of a rectangle,
 enter its height and width. 
 Height: 2

 Width:2.5

The area is 5.0

The area is 5.000000

The area is 5.000000000000000

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ java RectangleArea


To compute the area of a rectangle,
 enter its height and width. 
 Height: 2.5

 Width:4.99999

The area is 12.499975000000001

The area is 12.499975

The area is 12.499975000000001

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ java RectangleArea


To compute the area of a rectangle,
 enter its height and width. 
 Height: 4.99999

 Width:1

The area is 4.99999

The area is 4.999990

The area is 4.999990000000000

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ exit
exit

Script done on 2022-01-14 12:52:22-05:00 [COMMAND_EXIT_CODE="0"]
