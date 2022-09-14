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
		
		                                                                       } // class RectangleArea