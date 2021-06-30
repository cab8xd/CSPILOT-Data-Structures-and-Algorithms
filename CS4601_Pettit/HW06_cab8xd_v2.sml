(*********** HW06 ***********)
(*
Student name: i.e. Christine Baca
Student ID: i.e. cab8xd
Collaborators and sources: 

Implement a Hash Table:
The methods you will be implementing are make_empty, put, and get.

1. 'make_empty' takes in a hash function, a key comparison function, and a size
for the hashtable. The function should return a HashTable containing these two 
functions and a list array of the given size.

2. 'put' takes in a hash table, a key, and a value. It returns a hashtable
with the new ('key, 'value) tuple added if it was not already in the table. 

3. 'get' takes in a HashTable and a key. It returns a list of the value 
corresponding to that key in the HashTable. 

Important Notes:
The solution will be expected to be able to compare within its own type but not
in between types. The types that will be tested includes INTs, REALs, CHARs,
and STRINGs.

We recommend making this as simple as possible by implementing a
separate-chaining solution for the Hash Table. 


Please check and/or ask first on Piazza if you think you need to use anything
that we have not yet covered and is not in the supplement. 
ML keywords/operators/functions that we have used as of 10/15/19:

(* *), ;, int, real, bool, true, false, string, char, #, ~,+, -, *, /, div,
mod, <, >, <=, >=, =, <>, ^, andalso, orelse, not, if, then, else, floor, ceil,
round, trunc, ord, ", val, ->,  list, (), [], nil,  null, @, ::, hd, tl,
explode, implode, fun, fn, :, |,_, map, foldr, foldl	
*)

(* This line of code will be used for testing purposes. Leave it as is. *)
exception NotImplemented of int;


(* the hashtable type *)
type ('key, 'value) Hashtable = 
	('key -> int) *					(* #1 Hash *)
	('key * 'key -> bool) *			(* #2 Comp *)
	(('key * 'value) list array);	(* #3 Arr  *)



(*
hash: is the hashing function.
key_compare: is a function that compares two keys and return true if
the keys are equal, and false otherwise.
size: the dimension of the hashtable.

CONSTRUCTOR
Returns an empty Hashtable.
*)

fun make_empty(hash, key_compare, size: int) : ('key, 'value) Hashtable = 
	(hash, key_compare, Array.array(size, nil));	


(*
--------------------------------
ht - the hashtable 
k - the key
v - the value

PUT
Returns: a hastable that contains all the entries of the previous
table, plus the pair (k,v) if it does not exist already.
*)
fun put (ht : ('key, 'value) Hashtable, k, v) =
	let
		val arrayList = #3 ht; 				(* array list within hash table *)
		val list = Array.sub(arrayList, #1 ht k) 	(* list of tuples via hash index *) 

	(* 
	----------
	L: list of tuples
	(a, b): tuple
	a: key 
	b: value
	
	CONTAINS
	Returns: a boolean value indicating whether the list contains
	 the key-value pair with the key k. (Uses recursion)  
	*)

	fun contains ((a, b) :: L) = 
		#2 ht (a, k) orelse contains L			
	|	contains (_) = false;

	val updated = 						(* creates a new list based off the old and includes (k,v) *)  
		if contains list then list 			  (*  if the list does not already contains the key k *)
		else (k,v)::list;
			
		
	val _ = Array.update( 					(* updates a list in the array *)
			arrayList,
			#1 ht k, 
			updated);


	in
		(#1 ht, #2 ht, #3 ht) 				(* hash table returns here *)
	end;





(*
ht - the hashtable 
k - the key

Returns: a list of values with key k. If no values have the key, the result
should be nil
*)

fun get(ht : ('key, 'value) Hashtable, k)=
	let
		val index = (#1 ht) k;				
		val arr = #3 ht;
		val list = Array.sub (arr, index);

		fun contains((a, b) :: L) = 			(* an adjusted CONTAINS function *)
			if #2 ht (a, k) then [b]
			 else contains L 
			| contains (_) = nil; 
      in
		contains list
								(* returns a list of values with the key k if the list contains k and null otherwise *)
	end;







