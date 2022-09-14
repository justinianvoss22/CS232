Script started on 2022-01-14 13:07:20-05:00 [TERM="xterm-256color" TTY="/dev/pts/1" COLUMNS="80" LINES="24"]
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat rectangle_area.adv b
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
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat rectangle_area.adbexit[Kjava RectangleArea[19@c -deprecation RectangleArea.java[15Pcat RectangleArea.javap lab01-results /home/cs/214/current/jav86[21Pat RectangleArea.java[15@javac -deprecation RectangleArea.java[19P RectangleAreaexit[Kcat rectangle_area.adb[Kgnatmake circle      rectangle_area.adb     a
x86_64-linux-gnu-gcc-7 -c rectangle_area.adb
x86_64-linux-gnu-gnatbind-7 -x rectangle_area.ali
x86_64-linux-gnu-gnatlink-7 rectangle_area.ali
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ ./rectangle_) area

To compute the area of a rectangle,
enter its height and width: 
Height: 1
Width: 2

The rectangle's area is  2.00000E+00

The rectangle's area is 2.000000000000000

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ ./rectangle_area

To compute the area of a rectangle,
enter its height and width: 
Height: 2
Width: 2.5

The rectangle's area is  5.00000E+00

The rectangle's area is 5.000000000000000

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ ./rectangle_area

To compute the area of a rectangle,
enter its height and width: 
Height: 2.5
Width: 4.99999

The rectangle's area is  1.25000E+01

The rectangle's area is 12.499975204467773

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ ./rectangle_area

To compute the area of a rectangle,
enter its height and width: 
Height: 4.99999
Width: 1

The rectangle's area is  4.99999E+00

The rectangle's area is 4.999989986419678

]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ scrip     exit
exit

Script done on 2022-01-14 13:09:00-05:00 [COMMAND_EXIT_CODE="0"]
