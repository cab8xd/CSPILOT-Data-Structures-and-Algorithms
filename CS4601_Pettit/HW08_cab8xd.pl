/* *********** HW09 ***********

Student name: i.e. Christine Baca
Student ID: i.e. cab8xd
Collaborators and sources: Emily Roland

Create a Prolog program that will solve the 64 Rooks problem (and
smaller versions) described below. Run your program against your own
specific queries. Include both the queries and the results of those
queries as comments in your file.

The "64 Rooks Problem" as discussed in class on Tuesday (11/12) is the
following:
1.) Given a chessboard (8 x 8 grid) and
2.) Given 64 rooks, each of a unique color and material combination
- There are 8 unique colors and 8 unique materials
(There are 8 groups of 8 rooks, each group of a different color)
(Within each group of 8, each is made of a different material)
3.) Place the 64 rooks on the chessboard such that no rook is able to
attack (or check) a rook of the same color or of the same material.

Rooks can only move horizontally or verically. They can attack any
other rook in the same row or column.

The 64 rooks could be described the following way:
C1M1 C1M2 C1M3 ... C1M8
C2M1 C2M2 C2M3 ... C2M8
...
C8M1 C8M2 C8M3 ... C8M8
(note: this is not a legal solution, just a way to show rook labeling)

where C stands for color and M stands for material. C1M3 signifies a
rook that is Color 1 and has Material 3. The colors are 1-8 and the
materials are 1-8. You may use a different representation than this as
long as you can clearly explain it.

Given this labeling scheme, C2M3 can not be in a row or column that
contains any C2 (C2M1, C2M2, etc.) or M3 (C1M3, C2M3, etc.) rooks.

As Prolog programs can be slow, begin by creating a program that can
solve this problem for a board of size 3 (3 x 3 grid with 9 rooks).
An example solution that it might find -
C1M1 C2M3 C3M2
C2M2 C3M1 C1M3
C3M3 C1M2 C2M1

After solving for size 3, attempt to increase the size
to 4, 5, 6, 7, and 8.

For each of these sizes, place in your comments the exact query needed
and the output from running that query. You may use different variable
names and/or labels than the ones shown above as long as you clearly
explain in your comments.

If some of these sizes can not be completed, explain why.

Refer to the examples that we have covered for solving:
- wolf, goat, cabbage
- 8-Queens
- n-Queens
- Sudoku

Feel free to use the clpfd library, which we have seen in some of our
examples: use_module(library(clpfd))

*/


% ROOKs

% Try putting in some actual things?

% Input: Size n^2 list of coordinates or (_, _, etc.).
% Return: Size n^2 list of coordinates that place each
% of the respective rooks on an n^2 list such that assuming each space
% represents a rook of a unique Cn/Mn (Color, Material) combo,
% no rook shares a row or column with another rook of similar
% attributes.

% Size 3 solution
%
% Transform [a/b, b/b, etc.] to [a/b/c1/m1, etc. ]
% Pass into legal
% Pass into noCheck

/*
rooks9(X) succeeds if X is a legal
placement of 9 rooks on a 3x3 board, listed in order
of their types coordinates.
*/

% TODO: fix output, fix ins error fill out function descr.

:- use_module(library(clpfd)).

% Cases; checking COORDINATES
/*
case1(C/_/X/Y, Cn/_/X1/Y1) :-
C == Cn,
Y =\= Y1,
X =\= X1.
case2(_/M/X/Y, _/Mn/X1/Y1) :-
M == Mn,
Y =\= Y1,
X =\= X1.
case3(_/_/X/Y, _/_/X1/Y1) :-
Y =\= Y1;
X =\= X1.
*/

% Rules; checking ATTRIBUTES
% -- Rule 1) There exists no repeating C or M in the a row of X
% -- Rule 2) There exists no repeating C or M in the a column of Y

rule1(C/M/X/_, Cn/Mn/X1/_) :-
X == X1,
C =\= Cn,
M =\= Mn.
rule2(C/M/_/Y, Cn/Mn/_/Y1) :-
Y == Y1,
C =\= Cn,
M =\= Mn.

nocheck(_, []). % empty list returns.
nocheck(C/M/X/Y, [Cn/Mn/X1/Y1 | Rest ] ) :-
rule1(C/M/X/Y, Cn/Mn/X1/Y1);
rule2(C/M/X/Y, Cn/Mn/X1/Y1),
nocheck(Cn/Mn/X1/Y1, Rest).

legal([], _). % empty lists return.
legal([C/M/X/Y|Rest], R) :- legal(Rest, R), % Recursive call to cover all of the list.
write(R),
write(Rest),
C ins 1..R, % Checks if X is a valid coordinate.
M ins 1..R, % Checks if Y is a valid coordinate.
write( C ins 1..R ),
nocheck(C/M/X/Y, Rest). % Confirm that rook C/M/X/Y does not check any rook in Rest.

rooks9([]).
rooks9(X):- % Unsure how to pass this.
write("Hello"),
write(X),

X = [_/1/1,_/1/2, _/_/1/3 % list of rooks (color/material/x position/ y position).
,_/_/2/1,_/_/2/2,_/_/2/3
,_/_/3/1,_/_/3/2,_/_/3/3],
write(X),
legal(X, 9).


/*
* rooks9(X) :-
write("Hi"),
% X = [C1/M1/_,C1/M2/_,C1/M3/_ % list of rooks (color/material/x position/ y position).
% ,C2/M1/_,C2/M2/_,C2/M3/_
% ,C3/M1/_,C3/M2/_,C3/M3/_],
X = [_/X1/Y1,_/X1/Y2,_/X1/Y3 % B list of rooks (color/material/x position/ y position).
, _/X2/Y1,_/X2/Y2,_/X2/Y3
,_/X3/Y1,_/X3/Y2,_/X3/Y3],
write("Bye"),
legal(X, 9).
*/
