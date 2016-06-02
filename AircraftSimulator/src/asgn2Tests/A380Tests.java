/**
 * 
 */
package asgn2Tests;

import asgn2Aircraft.A380;
import asgn2Aircraft.Aircraft;
import asgn2Aircraft.AircraftException;
import asgn2Aircraft.Bookings;
import asgn2Passengers.Business;
import asgn2Passengers.Economy;
import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;
import asgn2Passengers.Premium;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Justin
 *
 */
public class A380Tests {

	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testA380DepartureTimeLessThan0() throws AircraftException {
		Aircraft airTest = new A380("Test", -1);	
	}

	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testA380FlightCodeNull() throws AircraftException {
		Aircraft airTest = new A380(null, 1);	
	}
	

	
	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testA380DepartureLessThan0() throws AircraftException {
		Aircraft test = new A380("Code", -1, 2, 3, 4, 5);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testA380FirstLessThan0() throws AircraftException {
		Aircraft test = new A380("Code", 1, -1, 3, 4, 5);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testA380BusinessLessThan0() throws AircraftException {
		Aircraft test = new A380("Code", 1, 2, -1, 4, 5);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testA380PremiumLessThan0() throws AircraftException {
		Aircraft test = new A380("Code", 1, 2, 3, -1, 5);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testA380EconomyLessThan0() throws AircraftException {
		Aircraft test = new A380("Code", 1, 2, 3, 4, -1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#Aircraft(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testAircraftFlightCodeNull() throws AircraftException {
		Aircraft test = new A380(null, 0);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#Aircraft(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testAircraftDepartureLessThan0() throws AircraftException {
		Aircraft test = new A380("Code", -1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testCancelBooking() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.cancelBooking(Bill, 12);
		assertEquals(plane.flightEmpty(), true);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test(expected=PassengerException.class)
	public final void testCancelBooking_PASSENGER_NOT_CONFIRMED() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		plane.cancelBooking(Bill, 12);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test(expected=PassengerException.class)
	public final void testCancelBooking_CANCELLATION_TIME_LESS_THAN_0() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1);
		Passenger Bill = new First(12, 2);
		Bill.confirmSeat(-1, 13);
		plane.confirmBooking(Bill, 12);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test(expected=AircraftException.class)
	public final void testCancelBooking_PASSENGER_NOT_ON_PLANE() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1);
		Passenger Bill = new First(12, 2);
		Bill.confirmSeat(12, 13);
		plane.cancelBooking(Bill, 12);

	}


	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test
	public final void testConfirmBooking() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		assertEquals(plane.flightEmpty(), false);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test(expected=PassengerException.class)
	public final void testConfirmBooking_CONF_TIME_LESS_THAN_0() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(-1, 17);
		plane.confirmBooking(Bill, 12);
		//plane.confirmBooking(Bill, 12);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test(expected=PassengerException.class)
	public final void testConfirmBooking_DEP_TIME_LESS_THAN_0() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(14, -1);
		plane.confirmBooking(Bill, 12);
		//plane.confirmBooking(Bill, 12);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test(expected=PassengerException.class)
	public final void testConfirmBooking_PASS_ISCONFIRMED() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(14, 15);
		Bill.confirmSeat(12, 13);
		plane.confirmBooking(Bill, 12);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test(expected=PassengerException.class)
	public final void testConfirmBooking_PASS_ISREFUSED() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(14, 15);
		Bill.refusePassenger(12);
		plane.confirmBooking(Bill, 12);
	}
	
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test(expected=AircraftException.class)
	public final void testConfirmBooking_NO_SEATS_AVAILABLE() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		
		Passenger Bill = new First(14, 15);
		plane.confirmBooking(Bill, 14);
		Passenger Bill1 = new First(14, 15);
		plane.confirmBooking(Bill1, 14);
		Passenger Bill2 = new First(14, 15);
		plane.confirmBooking(Bill2, 14);
		Passenger Bill3 = new First(14, 15);
		plane.confirmBooking(Bill3, 14);
		Passenger Bill4 = new First(14, 15);
		plane.confirmBooking(Bill4, 14);
		Passenger Bill5 = new First(14, 15);
		plane.confirmBooking(Bill5, 14);
		Passenger Bill6 = new First(14, 15);
		plane.confirmBooking(Bill6, 14);
		Passenger Bill7 = new First(14, 15);
		plane.confirmBooking(Bill7, 14);
		Passenger Bill8 = new First(14, 15);
		plane.confirmBooking(Bill8, 14);
		Passenger Bill9 = new First(14, 15);
		plane.confirmBooking(Bill9, 14);
		Passenger Bill10 = new First(14, 15);
		plane.confirmBooking(Bill10, 14);
		Passenger Bill11 = new First(14, 15);
		plane.confirmBooking(Bill11, 14);
		Passenger Bill12 = new First(14, 15);
		plane.confirmBooking(Bill12, 14);
		Passenger Bill13 = new First(14, 15);
		plane.confirmBooking(Bill13, 14);
		
		Passenger Bill14 = new First(14, 15);
		plane.confirmBooking(Bill14, 14);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test
	public final void test2ConfirmBookingS() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		Passenger Bob = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		assertEquals(plane.flightEmpty(), false);
	}


	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightEmpty()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testFlightEmpty() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		assertEquals(plane.flightEmpty(), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightFull()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testFlightFull() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		for (int i = 0; i<14; i++){
			Passenger test = new First(12, 12);
			plane.confirmBooking(test, 12);
		}
		for (int i = 0; i<64; i++){
			Passenger test = new Business(12, 12);
			plane.confirmBooking(test, 12);
		}
		
		for (int i = 0; i<35; i++){
			Passenger test = new Premium(12, 12);
			plane.confirmBooking(test, 12);
		}
		
		for (int i = 0; i<371; i++){
			Passenger test = new Economy(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.flightFull(), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flyPassengers(int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testFlyPassengers() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.flyPassengers(12);
		assertEquals(Bill.isFlown(), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testGetBookings() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 12);
		Bookings a = plane.getBookings();
		Passenger Bill = new First(12, 12);
		Bill.confirmSeat(12, 13);
		a.getTotal();
		assertEquals(a.getTotal(), 0);	
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getPassengers()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testGetPassengersWhen1() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		assertEquals(plane.getPassengers().size(), 1);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getPassengers()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testGetPassengersWhenMultiple() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		Passenger Bob = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		assertEquals(plane.getPassengers().size(), 2);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#hasPassenger(asgn2Passengers.Passenger)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test
	public final void testHasPassenger() throws PassengerException, AircraftException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		assertEquals(plane.hasPassenger(Bill), true);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#hasPassenger(asgn2Passengers.Passenger)}.
	 * @throws PassengerException 
	 * @throws AircraftException 
	 */
	@Test
	public final void testHasPassengerWhenMultiplePassengers() throws PassengerException, AircraftException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		Passenger Bob = new First(12, 12);
		Passenger Jill = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.confirmBooking(Jill, 12);
		assertEquals(plane.hasPassenger(Bob), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#initialState()}.
	 */
	@Test
	public final void testInitialState() {
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsAvailableEconomy() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Economy(12, 12);
		for (int i = 0; i<370; i++){
			Passenger test = new Economy(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsNotAvailableEconomy() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Economy(12, 12);
		for (int i = 0; i<371; i++){
			Passenger test = new Economy(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), false);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsAvailablePremium() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Premium(12, 12);
		for (int i = 0; i<34; i++){
			Passenger test = new Premium(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsNotAvailablePremium() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Premium(12, 12);
		for (int i = 0; i<35; i++){
			Passenger test = new Premium(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), false);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsAvailableBusiness() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Business(12, 12);
		for (int i = 0; i<63; i++){
			Passenger test = new Business(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsNotAvailableBusiness() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Business(12, 12);
		for (int i = 0; i<64; i++){
			Passenger test = new Business(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), false);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsAvailableFirst() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		for (int i = 0; i<13; i++){
			Passenger test = new First(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testSeatsNotAvailableFirst() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		for (int i = 0; i<14; i++){
			Passenger test = new First(12, 12);
			plane.confirmBooking(test, 12);
		}

		assertEquals(plane.seatsAvailable(Bill), false);
	}


	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testEconomyUpgradeBookings() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Economy(12, 12);
		Passenger Bob = new Economy(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.upgradeBookings();
		assertEquals(plane.getNumPremium(), 2);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testBookingsEmptiesEconomy() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Economy(12, 12);
		Passenger Bob = new Economy(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.upgradeBookings();
		assertEquals(plane.getNumEconomy(), 0);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testPremiumUpgradeBookings() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Premium(12, 12);
		Passenger Bob = new Premium(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.upgradeBookings();
		assertEquals(plane.getNumBusiness(), 2);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testBookingsEmptiesPremium() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Premium(12, 12);
		Passenger Bob = new Premium(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.upgradeBookings();
		assertEquals(plane.getNumPremium(), 0);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testBusinessUpgradeBookings() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Business(12, 12);
		Passenger Bob = new Business(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.upgradeBookings();
		assertEquals(plane.getNumFirst(), 2);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testBookingsEmptiesBusiness() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new Business(12, 12);
		Passenger Bob = new Business(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.upgradeBookings();
		assertEquals(plane.getNumBusiness(), 0);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public final void testFirstUpgradeBookings() throws AircraftException, PassengerException {
		Aircraft plane = new A380("Code", 1230);
		Passenger Bill = new First(12, 12);
		Passenger Bob = new First(12, 12);
		plane.confirmBooking(Bill, 12);
		plane.confirmBooking(Bob, 12);
		plane.upgradeBookings();
		assertEquals(plane.getNumFirst(), 2);
	}
}
