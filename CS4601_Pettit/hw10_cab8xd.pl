/* HW10
Christine Baca, cab8xd
 * Added feature: a dog.
 * 	You can pet the dog or not pet the dog. The decision does not
 *  matter other than you have the power to choose whether to
 *  pet a dog or not.  


Interactions (3)
1)
This is an adventure game. Legal moves are (l)eft, (r)ight, or (f)orward. End each move with a period.
You have no supplies whatsoever.
You are in a pleasant valley, with a trail ahead.
Next move --
f
--forward-----
You have no supplies whatsoever.
You are on a path, with ravines on both sides.
You notice a key amid the trail. Do you take the key? y/n
y
You took the key. Next move --
f
--forward-----You have a key. Drop the key at your current location with k.
You are at a fork in the path.
You find a dog. Pet the dog? y/n
y
You pet the dog. Yay!
The dog eventually meanders away.
Next move --
r
--right-----You have a key. Drop the key at your current location with k.
You are at a gate; the mountaintop is just beyond.
The gate is unlocked. You can now move forward.
Next move --
k
--key----You dropped the key.
The gate is unlocked. You can now move forward.
Next move --
f
--forward-----
You have no supplies whatsoever.
You are on the mountaintop.
There is a treasure here. Congratulations, you win! Thanks for playing.
1
true


2)
This is an adventure game. Legal moves are (l)eft, (r)ight, or (f)orward. End each move with a period.
You have no supplies whatsoever.
You are in a pleasant valley, with a trail ahead.
Next move --
f
--forward-----
You have no supplies whatsoever.
You are on a path, with ravines on both sides.
You notice a key amid the trail. Do you take the key? y/n
y
You took the key. Next move --
f
--forward-----You have a key. Drop the key at your current location with k.
You are at a fork in the path.
You find a dog. Pet the dog? y/n
n
You didn't pet the dog. Boo.
The dog eventually meanders away.
Next move --
r
--right-----You have a key. Drop the key at your current location with k.
You are at a gate; the mountaintop is just beyond.
The gate is unlocked. You can now move forward.
Next move --
f
You try to move through the gate, key still in your grasp. Bad decision. Lightning strikes the key, and you die.
Thanks for playing.

3)
This is an adventure game. Legal moves are (l)eft, (r)ight, or (f)orward. End each move with a period.
You have no supplies whatsoever.
You are in a pleasant valley, with a trail ahead.
Next move --
f
--forward-----
You have no supplies whatsoever.
You are on a path, with ravines on both sides.
You notice a key amid the trail. Do you take the key? y/n
n
You left the key. Next move --
f
--forward-----
You have no supplies whatsoever.
You are at a fork in the path.
You find a dog. Pet the dog? y/n
n
You didn't pet the dog. Boo.
The dog eventually meanders away.
Next move --
r
--right-----
You have no supplies whatsoever.
You are at a gate; the mountaintop is just beyond.
The gate seems to be locked.
Next move --
f
You can't open the gate.
You have no supplies whatsoever.
You are at a gate; the mountaintop is just beyond.
The gate seems to be locked.
*/

/*
  This is a little adventure game.  There are three
  entities: you, a treasure, and an ogre.  There are 
  six places: a valley, a path, a cliff, a fork, a maze, 
  and a mountaintop.  Your goal is to get the treasure
  without being killed first.
*/

/* Allow asserts and retracts for the predicate at */
:- dynamic at/2.

/*
  First, text descriptions of all the places in 
  the game.
*/
description(valley,
  'You are in a pleasant valley, with a trail ahead.').
description(path,
  'You are on a path, with ravines on both sides.').
description(cliff,
  'You are teetering on the edge of a cliff.').
description(fork,
  'You are at a fork in the path.').
description(gate,
  'You are at a gate; the mountaintop is just beyond.').
description(maze(_),
  'You are in a maze of twisty trails, all alike.').
description(mountaintop,
  'You are on the mountaintop.').
description(key, 
            'You have a key. \n Drop the key at your current location with k. \n').

/*
  report prints the description of your current
  location.
*/

/* Checking and reporting if the user has the key. */
hasKey :-
    at(key,you),
    description(key, X),
    write(X), nl.
hasKey :-
    nl, write("You have no supplies whatsoever."), nl.

report :-
  at(you,X),
  description(X,Y),
  hasKey,
%  gate,
  write(Y), nl.




gate :-
    at(you, gate),
    at(key, you),
    write("The gate is unlocked. You can now move forward. \n"),
    nl.
gate :-
    at(you, gate),
    at(key, used),
    write("The gate is unlocked. You can now move forward. \n"),
    nl.
gate :-  
    at(you, gate),
    write("The gate seems to be locked."),
    nl.
gate.

used.


/*
  These connect predicates establish the map.
  The meaning of connect(X,Dir,Y) is that if you
  are at X and you move in direction Dir, you
  get to Y.  Recognized directions are
  forward, right, and left.
*/
connect(valley,forward,path).
connect(path,right,cliff).
connect(path,left,cliff).
connect(path,forward,fork). 
connect(fork,left,maze(0)).
connect(fork,right,gate).
connect(maze(0),left,maze(1)).
connect(maze(0),right,maze(3)).
connect(maze(1),left,maze(0)).
connect(maze(1),right,maze(2)).
connect(maze(2),left,fork).
connect(maze(2),right,maze(0)).
connect(maze(3),left,maze(0)).
connect(maze(3),right,maze(3)).
connect(gate, forward, mountaintop).


/* shortcuts for move */
move(f) :- move(forward).
move(l) :- move(left).
move(r) :- move(right).
move(k) :- move(key).


/* Dropping the key */

move(key) :-
    write('--'),write('key'), write('----'),
    at(key, you),
    at(you,_),
    retract(at(key,you)),
    assert(at(key,used)),
    write("You dropped the key. \n"),
    nl. 
move(forward) :-
    at(you, gate),
	at(key, you),
	write("You try to move through the gate, key still in your grasp. \n Bad decision. \n \n Lightning strikes the key, and you die.\n"),
    nl,
    retract(at(you,gate)),
    assert(at(you,done)),
	!.
move(forward) :-
    at(you, gate),
	not(at(key, used)),
	write("You can't open the gate."),
    report.



/*
  move(Dir) moves you in direction Dir, then
  prints the description of your new location.
*/
move(Dir) :-
  write('--'),write(Dir),write('-----'),
  at(you,Loc),
  connect(Loc,Dir,Next),
  retract(at(you,Loc)),
  assert(at(you,Next)),
  report.



/*
  But if the argument was not a legal direction,
  print an error message and don't move.
*/
move(_) :-
  write('That is not a legal move.\n'),
  report.

/*
  Shorthand for moves, mostly used for troubleshooting.
*/
forward :- move(forward).
left :- move(left).
right :- move(right).
f :- move(forward).
l :- move(left).
r :- move(right).
k :- move(key). 

/*
  If you and the ogre are at the same place, it 
  kills you.
*/
ogre :-
  at(ogre,Loc),
  at(you,Loc),
  write('An ogre sucks your brain out through\n'),
  write('your eye sockets, and you die.\n'),
  retract(at(you,Loc)),
  assert(at(you,done)),
  !.
/*
  But if you and the ogre are not in the same place,
  nothing happens.
*/
ogre.

/*
  If you and the treasure are at the same place, you
  win.
*/
treasure :-
  at(treasure,Loc),
  at(you,Loc),
  write('There is a treasure here.\n'),
  write('Congratulations, you win!\n'),
  retract(at(you,Loc)),
  assert(at(you,done)),
  !.
/*
  But if you and the treasure are not in the same
  place, nothing happens.
*/
treasure.

/*
  If you are at the cliff, you fall off and die.
*/
cliff :-
  at(you,cliff),
  write('You fall off and die.\n'),
  retract(at(you,cliff)),
  assert(at(you,done)),
  !.
/*
  But if you are not at the cliff nothing happens.
*/
cliff.

/*
  To take the key or not. 
  If the player does not take the key, 
  the key is gone forever in that campaign. 
  */
takeKey(y) :-
  at(key,Loc),
  at(you,Loc),
  retract(at(key,Loc)),
  assert(at(key, you)),
  write('You took the key.').
takeKey(_) :-
  at(key,Loc),
  at(you,Loc),
  retract(at(key,Loc)),
  write('You left the key.').

/*
   If you are and the key are at the same place, you notice the key.
*/
key :-
  at(key,Loc),
  at(you,Loc),
  write('You notice a key amid the trail.\n\n'),
  write('Do you take the key? y/n \n'),
  read(Ans),
  call(takeKey(Ans)). 

/*
  But if you are not at the same place as the key nothing happens.
*/
key. 


/* Extra step: dog */
petDog(y):- 
    write('You pet the dog. Yay!'), nl.
petDog(_) :- write("You didn't pet the dog. Boo."), nl.

dog :- 
    at(dog, Loc),
    at(you, Loc),
    write('You find a dog. Pet the dog? y/n \n'),
    read(Ans),
    call(petDog(Ans)),
    write('The dog eventually meanders away. \n'), nl,
    retract(at(dog, Loc)).
dog.

/*
  Main loop.  Stop if player won or lost.
*/
main :- 
  at(you,done),
  write('Thanks for playing.\n'),
  !.
/*
  Main loop.  Not done, so get a move from the user
  and make it.  Then run all our special behaviors.  
  Then repeat.
*/
main :-
  write('\nNext move -- '),
  read(Move),
  call(move(Move)),
  ogre,
  treasure,
  cliff,
  gate,
  key, % key exists.
  dog,
  main.

/*
  This is the starting point for the game.  We
  assert the initial conditions, print an initial
  report, then start the main loop.
*/
    
go :-
  retractall(at(_,_)), % clean up from previous runs
  assert(at(you,valley)), % places you at the valley
  assert(at(ogre,maze(3))), % places the ogre at maze(3)
  assert(at(treasure,mountaintop)), % places the treasure at the mountaintop
  assert(at(key,path)), 
  assert(at(dog,fork)),
  write('This is an adventure game. \n'),
  write('Legal moves are (l)eft, (r)ight, or (f)orward.\n'),
  write('End each move with a period.\n\n'),
  report,
  main.
