(*********** HW03 ***********)
(*
Student name: i.e. Christine Baca
Student ID: i.e. cab8xd
Collaborators and sources: TODO - websites and people consulted

For each exercise below, create an ML function that will perform the specified
task. The function definitions have been given to you. Run each function agaist
your own test cases to verify correctness. Include the test cases that you ran
and the results in the comments for each exercsie. You may create helper
functions (additional functions that are called from the main function).

Please submit one file named HW03_<user_id>.ml (i.e. HW03_rp6zr.sml). Please
make a copy of this assignment file to use as your starting point. Do not change
the function names. Please uncomment out all of your functions before
submitting. As part of the grading process, we will be adding function calls to
the end of your submitted file and running it. If your functions are commented
out or you have changed the function names or signatures, your functions will
not receive credit. 

This homework assignment is intended to give you practice with ML to the extent
that we have covered in class through 9/24/19. Please resist using more advanced
ML features that have not been covered yet. The intent of these exercises are to
give you practice with patterns as well as additional general experience with
ML. Please use one or more patterns for each of the 6 functions. 

ML keywords/operators/functions that we have used as of 9/24/19:
(* *), ;, int, real, bool, true, false, string, char, #, ~,+, -, *, /, div, mod,
<, >, <=, >=, =, <>, ^, andalso, orelse, not, if, then, else, floor, ceil,
round, trunc, ord, ", val, ->,  list, (), [], nil,  null, @, ::, hd, tl,
explode, implode, fun, fn, :, |,_	

Specifically not needed for HW03: let

If you think that you need to use functionality that is not listed above,
please post a question to Piazza.
*)

(* This line of code will be used for testing purposes. Leave it as is. *)
exception NotImplemented of int;


(* Exercise 1 ------------------------ *)
 (* Test cases:
 * 
 * member(1,[1,2,3]);
 * val it = true : bool
 * 
 * member("c",["a","b","d","c"]);
 * val it = true : bool
 *
 * member(~9,[10,100,999,~45]);
 * val it = false : bool
 *)
(* 
  member (e,L) --
    true if and only if e is an element of list L
*)

fun member(e,L) =
  if  e = hd(L)then 
   true
  else if tl(L) = [] then
   false
  else 
   member(e,tl(L))




(* Exercise 2 ------------------------ *)
 (* Test cases:
 * 
 * less(1,[1,2,3]);
 * val it = [] : int list
 *
 * less(~9,[10,100,999,~45]);
 * val it = [~45] : int list
 *) 
(*
  less (e,L) --
    the list of all elements of L that are < e
*)
fun less (e, []) = [] 
| less (e , i::L) = 
  if i < e then 
    [i] @ less (e,L) 
else 
    [] @ less (e,L);

(* Exercise 3 ------------------------ *)
 (* Test cases:
 * 
 * repeats([0,1,2,3,1]);
 * val it = false : bool
 *
 * repeats(["a","b","c","c"]);
 * val it = true : bool
 *) 
(*
  repeats L --
    true if and only if list L contains adjacent equal elements.
*)
fun repeats (nil) = false
 |  repeats (x::nil) = false
 |  repeats (x::xs) = if x = hd(xs) then 
      true
  else repeats(xs);



(* Exercise 4 ------------------------ *)
(*
  eval (P,x) --
    the value of polynomial P at x.

  We represent a polynomial as a list of real coefficients,
  with the constant coefficient first.
  
  For example: 3x^2 + 5x + 1 would be represented as the list [1.0,5.0,3.0],
  and eval([1.0,5.0,3.0],2.0) should evaluate to 23.0. 
  
  For missing terms, 0.0 will be used. 
  i.e. x^3 - 2x is represented as the list [0.0,~2.0,0.0,1.0] 
*)
 (* Test cases:
 * 
 * eval([1.0,5.0,3.0],2.0);
 * val it = 23.0 : real
 *
 * eval([0.0,0.0,0.0],2.0);
 * val it = 0.0 : real
 *) 
(* Helper for eval(P,x)*)
fun pow (base:real, 0) = 1.0
    | pow (base:real, exp:int):real = base * pow(base, exp - 1);
fun elms ([], _, _) = 0.0
  | elms (x::xs, a, count) = (x * pow(a, count)) + elms(xs, a, count + 1);
fun eval ([], _) = 0.0 
  | eval (x::xs, a) = x + elms(xs, a, 1);


 
(* Exercise 5 ------------------------ *)
(*
  union (S1, S2) --
    the union of sets S1 and S2.

  We implement sets as unordered lists of elements, without 
  repetitions.
*)
 (* Test cases:
 * 
 * union([1,5,3],[0,2,4]);
 * val it = [1,5,3,0,2,4] : int list
 *
 * union(["a","b","c"],["d","e","f"]);
 * val it = ["a","b","c","d","e","f"] : string list 
 *)
fun union ([], S2) = S2
|   union (s1::S1, S2) = 
      if member(s1,S2) then union (S1,S2)
      else s1::union(S1,S2);

(* Exercise 6 ------------------------ *)

 (* Test cases:
 * 
 * intersection([1,5,3],[0,4,3]);
 * val it = [3] : int list
 *
 * intersection (["a","b","c"],["d","e","f"]);
 *  val it = [] : string list
 *)
(*

  intersection (S1, S2) --
    the intersection of sets S1 and S2.

  We implement sets as unordered lists of elements, without 
  repetitions.
*)
fun intersection ([], S2) = []
  | intersection(s1::S1,S2) = 
      if member(s1,S2) then s1::intersection(S1,S2)
      else intersection(S1,S2);

