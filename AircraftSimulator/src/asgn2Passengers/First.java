/**
 * 
 */
package asgn2Passengers;

/**
 * @author hogan
 *
 */
public class First extends Passenger {

	/**
	 * First Constructor (Partially Supplied) 
	 * Passenger is created in New state, later given a Confirmed First Class reservation, 
	 * Queued, or Refused booking if waiting list is full. 
	 * 
	 * @param bookingTime <code>int</code> day of the original booking. 
	 * @param departureTime <code>int</code> day of the intended flight.  
	 * @throws PassengerException if invalid bookingTime or departureTime 
	 * @see asgnPassengers.Passenger#Passenger(int,int)
	 */
	public First(int bookingTime, int departureTime) throws PassengerException {
		super(bookingTime, departureTime);
		this.newState = true;
		this.confirmed = false;
		this.flown = false;
		this.refused = false;
		this.inQueue = false;
		this.passID = "F:" + this.passID;
	}
	
	/**
	 * Simple constructor to support {@link asgn2Passengers.Passenger#upgrade()} in other subclasses
	 */
	protected First() {
		super();
		//this.passID = "F";
	}

	@Override
	public String noSeatsMsg() {
		return "No seats available in First";
	}


	@Override
	public Passenger upgrade() {

		Passenger newPassenger = new First();
		//Passenger newPassenger = null;
		newPassenger.copyPassengerState(this);
		//this.passID = newPassenger.passID + "(U)" + this.passID;
		//this.passID = "F(U)J:";
		
		return newPassenger;
	}
}
