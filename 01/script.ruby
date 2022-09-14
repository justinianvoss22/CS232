Script started on 2022-01-14 13:44:05-05:00 [TERM="xterm-256color" TTY="/dev/pts/0" COLUMNS="80" LINES="24"]
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat rectangle) _area.rb
#! /usr/bin/ruby
# circle_area.rb computes the area of a rectangle given its height and width
# 
# Input: the height and width of a rectangle
# Precondition: the height and width is not negative
# Output: the area of the rectangle.
#
# Begun by: Prof. Adams, for CS 214 at Calvin College.
# Completed by: Justin Voss
# Date: 1/14/22
###############################################################

# function rectangleArea returns a rectangle's area, given its height and width
# Parameters: height and width, 2 numbers
# Precondition: height, width > 0.
# Returns: the area of a rectangle whose height and width is h and w.
PI = 3.1415927
def rectangleArea(h,w)
    h * w
end

if __FILE__ == $0
   puts "To compute the area of a rectangle,"
   puts " enter its height and width: "
   print " Height: "
   height = gets.chomp.to_f
   print " Width: "
   width = gets.chomp.to_f
   print "The rectangle's area is: "
   puts rectangleArea(height,width)
end]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ cat rectangle_area.rbexit[Kclojure -m rectangle_areaat src/rectangle_area.clj[1Plojure -m rectangle_areaexit[Kcat rectangle_area.rb[Kruby circ    rectangle_area.rb
To compute the area of a rectangle,
 enter its height and width: 
 Height: 1
 Width: 2
The rectangle's area is: 2.0
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ ruby rectangle_area.rb
To compute the area of a rectangle,
 enter its height and width: 
 Height: 2
 Width: 2.5
The rectangle's area is: 5.0
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ 2.5
2.5: command not found
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ 2.5ruby rectangle_area.rb
To compute the area of a rectangle,
 enter its height and width: 
 Height: 2.5
 Width: 4.99999
The rectangle's area is: 12.499975000000001
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ ruby rectangle_area.rb
To compute the area of a rectangle,
 enter its height and width: 
 Height: 4.99999
 Width: 1
The rectangle's area is: 4.99999
]0;jav86@gold22: ~/CS214/projects/01[01;32mjav86@gold22[00m:[01;34m~/CS214/projects/01[00m$ exit
exit

Script done on 2022-01-14 13:45:08-05:00 [COMMAND_EXIT_CODE="0"]
