package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import asgn2Passengers.Business;
import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;

public class BusinessTests {

	@Test
	public final void testUpgrade() throws PassengerException {
		Passenger newPassenger = new Business(12, 12);
		newPassenger.upgrade();
		assertEquals(newPassenger.upgrade().getPassID().contains("F(U)J:"), true);
	}

	@Test
	public final void testBusinessIntInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testBusiness() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPassengerIntInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPassenger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCancelSeat() {
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testConfirmSeat() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFlyPassenger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBookingTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetConfirmationTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetDepartureTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetEnterQueueTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetExitQueueTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetPassID() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsConfirmed() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsFlown() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsNew() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsQueued() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsRefused() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testQueuePassenger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRefusePassenger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWasConfirmed() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWasQueued() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCopyPassengerState() {
		fail("Not yet implemented"); // TODO
	}

}
