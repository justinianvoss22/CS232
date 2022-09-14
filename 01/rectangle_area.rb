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
end