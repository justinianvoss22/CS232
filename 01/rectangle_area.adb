-- rectangle_area.adb computes the area of a rectangle
--
-- Input: The height and width of a rectangle
-- Precondition: The height and width of a rectangle are positive.
-- Output: The area of the recctangle.
--
-- Begun by: Prof. Adams, CS 214 at Calvin College.
-- Completed by: Justin Voss
-- Date: 1/14/22
----------------------------------------------------

with Ada.Text_IO, Ada.Float_Text_IO;
use  Ada.Text_IO, Ada.Float_Text_IO;

procedure rectangle_area is

   height, width, area : float; 

   -- function rectangleArea computes a rectangle's area, given its height and width
   -- Parameter: h,w, floats
   -- Precondition: h,w >= 0.0
   -- Return: the area of the rectangle whose height and width is h and w
   ----------------------------------------------------
   function rectangleArea(h: in float; w: in float) return float is -- has the parameter for numbers h and w for the function rectangleArea
   begin -- starts the code segment
      return h * w; -- returns the value of the area, which is height * width
   end rectangleArea; -- ends the code segment

begin  -- begins the block of code                         
   New_Line; -- puts a blank line
   Put_Line("To compute the area of a rectangle,"); -- prints a line of text
   Put_Line("enter its height and width: "); -- prints a line of text
   Put("Height: ");
   Get(height); -- asks the user for an input
   Put("Width: ");
   Get(width); -- asks the user for an input


   area := rectangleArea(height,width); -- assigns the variable "area" as the function call of rectangleArea, using the user input

   New_Line; -- blank line
   Put("The rectangle's area is "); -- displays a line of text
   Put(area); -- displays the calculated area
   New_Line; New_Line; -- puts two blank lines

   Put("The rectangle's area is "); -- displays a line of text
   Put(area, 1, 15, 0); -- prints the area, with more parameters, making the decimal place go to 15 digits
   New_Line; New_Line; -- puts two blank lines
end rectangle_area; -- ends the block of code

-- Put line puts every thing in that text segment on one line, and then makes a new line after.
-- Put just displays the text, but then the next thing goes right next to that, instead of a new line.
-- You can adjust the precision by changing the paramaters after the variable. In this case, it was 15 digits after the decimal point.
