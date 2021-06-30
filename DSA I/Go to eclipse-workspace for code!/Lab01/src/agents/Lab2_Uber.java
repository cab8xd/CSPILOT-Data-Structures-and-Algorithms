package agents;
/*
 * 
 * . Design some object oriented code that supports a ride sharing service such as Uber or
Lyft. Some requirements:
a) There are driver accounts and rider accounts (some folks might be both)
b) A user can enter payment info
c) A user can request rides, a driver can accept rides (or can they? Should they have
a choice? You design it.)
d) A user’s fare needs to be calculated depending on various factors.
e) A driver can deliver food from local restaurants for people if they’d like to.
f ) Include all features you can think of from using these services yourself.
g) Feel free to make other
 */

/*Pseudocode:
 * 		Classes
 * 			Riders accounts <-- Extends -- Drivers accounts
 * 				*All drivers are riders (use an extension)
 * 				Rider
 * 					Balance
					id
 * 					ID
 * 				Drivers
 * 					Hours
 * 					password(eh.)
 * 			Car
 * 				location
 * 				max # of passengers (maxPassengers)
 * 					availablepassengers
 * 				make & model
 * 				payment
 * 				plate numbers
 * 			Service
 * 				completed
 * 				price
 * 				Pickup/Drop-Off
 * 
 * 
 * 				[subclasses] INHERIT
 * 				Ride
 * 				Delivery 
 * 
 * 
 * 		Payment info
 * 		Request, accept rides
 * 		Fare calculations
 * 		Deliver food from local 
 * 		
 */

public class Lab2_Uber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

//instance variables filled in by the constructors are not included in pseudocode
public class Rider {
	//Constructor rider [ID, Balance]
	//Acessor [getID]
	//Acessor [getBalance]
	//Mutator [changeBalance newBalance]
}


public class Driver extends Rider {
	//Constructor Driver [ID, Balance, Password, Hours]
	//Accessor for all the variables
	//mutator for password, hours, and balance
}

public class Car{
	//Constructor [make, model, availablePass, payment(?), plate number]
	//Accessor: getMake, getModel, getSpace, getPayment, getPlate
	//Mutator: changePayment(new payment), changeSpace(spaceLeft)
}

public class Service{
	//Inst. Var. 		bool complete = false (along with all the other ones)
	/*Constructor:
	 * 	int spaceAvailable, double price, String pickup, String drop off 
	 *Accessor: getSpace, getPrice, getPickup, getDropOff
	 *Mutators: changeSpace, changePrice, changeDropOff, changePickup, jobFinish
	 */
}

public class 
}