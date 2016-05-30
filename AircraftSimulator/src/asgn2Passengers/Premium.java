/**
 * 
 */
package asgn2Passengers;

/**
 * @author hogan
 *
 */
public class Premium extends Passenger {

	/**
	 * Premium Constructor (Partially Supplied)
	 * Passenger is created in New state, later given a Confirmed Premium Class reservation, 
	 * Queued, or Refused booking if waiting list is full. 
	 * 
	 * @param bookingTime <code>int</code> day of the original booking. 
	 * @param departureTime <code>int</code> day of the intended flight.  
	 * @throws PassengerException if invalid bookingTime or departureTime 
	 * @see asgnPassengers.Passenger#Passenger(int,int)
	 */
	public Premium(int bookingTime,int departureTime) throws PassengerException {
		super(bookingTime, departureTime);
		this.newState = true;
		this.confirmed = false;
		this.flown = false;
		this.refused = false;
		this.inQueue = false;
		this.passID = "P:" + this.passID;
	}
	
	/**
	 * Simple constructor to support {@link asgn2Passengers.Passenger#upgrade()} in other subclasses
	 */
	protected Premium() {
		super();
		//this.passID = "P";
	}

	@Override
	public Passenger upgrade() {
		//this.passID = "P";
		Passenger newPassenger = new Business();
		//Premium newPremium = new Premium();
		//Passenger newPassenger = null;
		newPassenger.copyPassengerState(this);
		//this.passID = newPassenger.passID + "(U)" + this.passID;
		//newPassenger.copyPassengerState(newPassenger);
		//this.passID = "P";
		return newPassenger;
	}
	
	@Override
	public String noSeatsMsg() {
		return "No seats available in Premium";
	}
}
