;;;; rectangle_area.clj calculates the area of a rectangle.
;;;;
;;;; Input: The height and width of a rectangle.
;;;; Output: The area of that rectangle.
;;;;
;;;; Usage: clojure -m rectangle_area
;;;;
;;;; Begun by: Prof. Adams, for CS 214 at Calvin College.
;;;; Completed by: Justin Voss
;;;; Date: 1/14/22
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns rectangle_area) ; namespace function names the program

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Function rectangleArea() computes the area of a rectangle.
;;; Receive: itsRadius, a number.
;;; Precondition: itsRadius >= 0.0.
;;; Return: the area of the corresponding rectangle.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn rectangleArea [height width]
    (* height width)  ; return height * width
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Function -main is where execution begins
;;; Input: the height and width of a rectangle.
;;; Output: the area of that rectangle.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn -main []
  (println "\nTo compute the area of a rectangle,")
  (println   " enter its height and width: ") (flush)
  (print   " Height: ") (flush)
  (let
    [ height (read)  ]
    (print   " Width: ") (flush)
    (let
      [ width (read) ]
      

      (assert (>= height 0) "-main: height must be positive")
      (assert (>= width 0) "-main: width must be positive")
      (printf "\nThe area is %f\n\n" (rectangleArea height width))

      (print "\nThe area is ")
      (print (rectangleArea height width))
      (print "\n\n")

      (printf "\nThe area is %.15f\n\n" (rectangleArea height width))
    )
  )
)  