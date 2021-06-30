(*********** HW02 ***********)
(*
Student name: i.e. Christine Baca
Student ID: i.e. cab8xd
Collaborators and sources: N/A. 

For each exercise below, create an ML function that will perform the specified task. The function definitions have been given to you.
 Run each function agaist your own test cases to verify correctness. Include the test cases that you ran and the results in the comments for each exercsie.
 You may create helper functions (additional functions that are called from the main function), which may be particularly useful with the last 4 exercises.   

Please submit one file named HW02_<user_id>.ml (i.e. HW02_rp6zr.ml). 
Please make a copy of this assignment file to use as your starting point. 
I have used the label "TODO" to indicate locations in the file that you need to attend to. 
Do not change the function names. 
Please uncomment out all of your functions before submitting.
 As part of the grading process, 
 we will be adding function calls to the end of your submitted file and running it. 

This homework assignment is intended to give you practice with ML to the 
extent that we have covered in class through 9/17/19. 
Please resist using more advanced ML features that have not been covered yet. 
The intent of these exercises is to get practice with tuples, lists, and functions, 
and to use the ML that we have been introduced to so far. 
ML keywords/operators/functions that we have used as of 9/17/19:

(* *), ;, int, real, bool, true, false, string, char, #, ~,+, -, *, /, div, mod, <, >, <=, >=, =, <>, ^, andalso, orelse, not, if, then, else, floor, ceil, round, trunc, ord, ", val, ->,  list, (), [], nil,  null, @, ::, hd, tl, explode, implode, fun, fn, :	

If you think that you need to use functionality that is not listed above, please post a question to Piazza.
*)



(* 
************** Exercise 1 **************
Goal: Write a function, cube, of type int -> int that cubes a parameter
Cases that I tested:
cube 3; 
cube ~7;
val it = 27 : int
val it = ~343 : int

cube 20;
cube ~2;
val it = 8000 : int
val it = ~8 : int
Comments added by student: 
*)

fun cube(a) = a * a * a;

(*
************** Exercise 2 **************
Goal: Write function, cuber, of type real -> real that cubes a parameter
Cases that I tested:

cuber 20.0;
cuber ~2.0;
val it = ~8.0 : real
val it = ~8000.0 : real

Comments added by student: 
*)

fun cuber x:real = x * x * x;

(*
************** Exercise 3 **************
Goal: Write a function, fourth, that gets the fourth element of a generic list
Cases that I tested:

fourth [1, 2, 3, 4, 5];
fourth [#"1", #"2", #"3", #"4", #"5"];
val it = 4 : int
val it = #"4" : char

Comments added by student:
*)

fun fourth a = hd(tl(tl(tl a)));

(*
************** Exercise 4 **************
Goal: Write a function, min3, that gets the smallest int from a tuple
of 3 ints. Function type should be int * int * int * -> int
Cases that I tested:

 min3 (1, 2, 3);
 min3 (2, 1, 3);
 min3 (3, 2, 1);
 val it = 1 : int
 val it = 1 : int
 val it = 1 : int

Comments added by student:
*)

fun min3 x, y, z = if x < y andalso x < z then x else if y < x andalso y < z then y else z;

(*
************** Exercise 5 **************
Goal: Write a function to remove the second element from a tuple of size 3
Cases that I tested:
TODO - show test cases and results

red3(1, 2, 3);
red3(#"1", #"2", #"3");
val it = (1,3) : int * int
val it = (#"1",#"3") : char * char

Comments added by student:
*)

fun red3 (a,b,c) = (a, c);

(*
************** Exercise 6 **************
Goal: Get the third character of a string
Cases that I tested:
TODO - show test cases and results

thirds "cow";
thirds "Wahoowa";
val it = #"w" : char
val it = #"h" : char

Comments added by student:
*)

fun thirds s =    hd(tl(tl(explode(s))));

(*
************** Exercise 7 **************
Goal: Write a function that moves the first item in a list to the end of the list
For example, cycle1 ["first","second","third"]; would produce ["second","third","first"]
Cases that I tested:

cycle1 ["first","second","third"];
cycle1 [4,2,1];
val it = ["second","third","first"] : string list
val it = [2,3,1] : int list

Comments added by student:
*)

fun cycle1 x = tl x @ [ hd x ];

(*
************** Exercise 8 **************
Goal: Write a function that sorts a tuple of 3 reals into a list
Cases that I tested:

sort3 (4.1, 5.0,1.0);
sort3 (~100.0, 2.5,3.1);
val it = [4.1,5.0,1.0] : real list
val it = [~100.0,2.5,3.1] : real list

Comments added by student:
*)

fun sort3 (a:real, b, c) = [a] @ [b] @ [c];

(*
************** Exercise 9 **************
Goal: Delete the 3rd element in a list
Cases that I tested:

del3 [~100.0, 2.5,3.1];
del3 [#"1", #"2", #"3", #"4", #"5"];
val it = [~100.0,2.5] : real list
val it = [#"1",#"2",#"4",#"5"] : char list

Comments added by student:
*)

fun del3 x = [ hd x  ] @ [ hd (tl x) ] @ tl( tl( tl x ));

(*
************** Exercise 10 **************
Goal: Return the sum of the squares of the integers 0 through m
For example, the input value 4 would produce 30 - 0^2 + 1^2 + 2^2 + 3^2 + 4^2
Cases that I tested:

sqsum 0;
sqsum 4;
val it = 0 : int
val it = 30 : int

Comments added by student:
*)

fun sqsum n = if n = 0 then 0 else n * n + sqsum (n - 1);

(*
************** Exercise 11 **************
Goal: Cycle the items in a list n times
Move the first item to the end. Repeat…
For example, cycle([1,2,3,4,5,6,7],3); should produce [4,5,6,7,1,2,3]
Cases that I tested:

cycle([1,2,3,4,5,6,7],3);
cycle (["first","second","third","fourth"], 2);
val it = [4,5,6,7,1,2,3] : int list
val it = ["third","fourth","first","second"] : string list

Comments added by student:

Helper function (from previous exercise):
fun cycle1 x = tl x @ [ hd x ];

*)

fun cycle (x, n) = if n = 1 then cycle1(x) else cycle( cycle1(x), n - 1);



(*
************** Exercise 12 **************
Goal: Raise a real number to an int power
For example, pow(3.2,4); should produce 104.8576
Cases that I tested:

pow(3.2,4);
pow(~2.0,3);
val it = 104.8576 : real
val it = ~8.0 : real

Comments added by student:
*)


fun pow (x, i) = if i = 1 then x : real else x * (pow (x, i-1)) : real;


(*
************** Exercise 13 **************
Goal: Find the largest integer in a list 
Cases that I tested:

max [1, 2, 3];
max [1, 1000, 3, 4, 5];
val it = 3 : int
val it = 1000 : int

Comments added by student:
*)

fun max x = if x = [] then 0 else maxHelp(hd x , max(tl x ));
fun maxHelp(a,b) = if a > b then a else b;

(*
************** Exercise 14 **************
Goal: Determine if an integer is prime
Cases that I tested:

isPrime 3;
isPrime 4;
isPrime 11;
isPrime 9;
val it = true : bool
val it = false : bool
val it = true : bool
val it = false : bool

Comments added by student:
*)

fun isPrime n = if n = 2 then true else not(isDiv(n, 2));
fun isDiv (n, i) = if i <= (n - 1) then n mod i = 0 orelse isDiv(n, i + 1) else true;


(*
************** Exercise 15 **************
Goal: Conditionally select items from a list that pass a given test.

Details: Your function, select, should receive a list (i.e. [4,5,6,7,8,9])

and a Boolean function (i.e. your prime function from the exercise above). 
The items in the list should be legal to send in to the Boolean function. 
The select function should produce a list that is a subset of the initial
list. The type of your function will be: 
fn : 'a list * ('a -> bool) -> 'a list 
An example declaration: 
Calling the function this way: select([4,5,6,7,8,9],isPrime);
Should produce: val it = [5,7] : int list
Cases that I tested:

select([1,13,3,4,5,101],isPrime);
select([4,5,6,7,8,9],isPrime);
val it = [5,7] : int list
val it = [1,13,3,5,101] : int list

Comments added by student:
*)

fun select(n, f) =	if n = [] then [] else if f (hd n) then [hd n] @ select(tl n, f) else select(tl n, f);
