(*
	--- Using # ---
	When using #n to access the n'th term in a tuple, it is
	necessary to define the type of the tuple in the method
	header otherwise ML can't type check. The following line
	would return an error:
		fun foo bar = #1 bar;
	while this line would not:
		fun foo (bar : (int * int)) = #1 bar;
		
	--- Standard Libraries ---
	Standard libraries can be accessed by calling the lib
	name and then the method. The Int toString(n : int) method
	can be called with the following line:
		Int.toString(10);
	Getting the n'th index in an array would be the following:
		val v = Array.sub (arr, index);
	Since ML is not an OO (Object Oriented) language, all
	common library methods are statically referenced. This
	means you have to reference the file the method is from,
	rather than taking an instance of an array and calling the
	.sub(arr: array, index : int) method on it.	
 *)


(*--------------------------------------------------------------*)

(* Types and # *)

(* 	TYPE DECLARATION: Here a type is nothing more than a convenient way of saying
	a tuple made of the following types (typedef in C). Each
	piece of the type can be accessed with the standard tuple
	indexing syntax of #n to get the n'th value.
 *)
type ('value) PolyDataStructure =
	('value list -> 'value) *
	('value * 'value list -> 'value list) *
	('value list);

(* SHOWS
type 'a PolyDataStructure =
  ('a list -> 'a) * ('a * 'a list -> 'a list) * 'a list 
*)


(* 	CONSTRUCTOR: The following method act like constructors for our type. We
	are able to give it varying parameters to create different
	properties of our type.
 *)
fun make_from_list (fun_get, fun_put, L) : ('value) PolyDataStructure =
	(fun_get, fun_put, L); 


(*	PEEK: Looks at the top value of the PolyDataStructure as defined
	by the type constructor and accessed through #1. This method
	takes a PolyDataStructure and returns the next element.
 *)
fun peek (pds : ('value) PolyDataStructure) = 
	(#1 pds) (#3 pds);


(* 	Adds a value to the list in the PolyDataStructure as defined 
	by the type constructor and accesed through #2. This method
	takes a PolyDataStructure and returns a PolyDataStructure so
	it must return a tuple containing the three values listed in
	the type constructor. 
 *)
fun put (pds : ('value) PolyDataStructure, e) : ('value) PolyDataStructure = 
	(#1 pds, #2 pds, #2 pds (e, #3 pds));


val _ = print("\n\n");
(* 	Implementing a Queue that peeks from the head and pushes to 
	the tail. Since we call the make_empty method we pass in a
	peeking and putting function. Note the type declaration of
	nil. Without specifically giving it a type, the data structure
	remains generic and you are unable to add values to it due to
	type checking errors.
 *)
val pds1 = make_from_list(fn L => hd L, fn (e, L) => L@[e], nil : int list);

(* Displaying the types of each part of the PolyDataStructure *)
val queue_get = #1 pds1;
val queue_put = #2 pds1;
val quque_list = #3 pds1;

(* Adding two values to the data sturcutre *)
val pds1 = put(pds1, 1);
val pds1 = put(pds1, 5);

(* Display the end list and what the next value is *)
val list = #3 pds1;
val next = peek(pds1);


(*--------------------------------------------------------------*)
val _ = print("\n\n");

(* Arrays *)
(* API: http://sml-family.org/Basis/array.html *)

(* The following code will create two arrays and demo some functionality *)

(* Creates an empty array and initializes it *)
val size = 10; val init_value = 0;
val empty_array = Array.array(size,init_value);

(* Creates an array from a list *)
val list = [1, 2, 3, 4, 5];
val array_from_list = Array.fromList(list);

(* Gets the i'th value in the given array *)
val i = 3;
val value_at_index_3 = Array.sub(array_from_list, i);

(* Sets the i'th value in the given array to x *)
(* Note the return of the update method is an empty value of type unit
   while array_from_list has changed value. This is because update acts like
   a void method that is pass by reference. To avoid the printing of this
   empty value to the console, you can use the val _ = syntax to silence
   the method's output.
 *)
val i = 4; val x = 100;
val changed_array = Array.update(array_from_list, i, x);
array_from_list;
val _ = Array.update(array_from_list, i-1, x div 2);
array_from_list;

	if i < length ht 
		then if #1 Array.sub(ht, i) = k
			then i
		else i < length ht
			then indexOf(ht, k, i+1)
	else
		nil;


	
	
(* help:
val i = 3;
val value_at_index_3 = Array.sub(array_from_list, i); *)



	if Array.exists (k,'value) ht
		then 	#1 Array.find(k,'value)
	else
		nil;




