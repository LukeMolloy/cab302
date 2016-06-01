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
		assertEquals(newPassenger.isNew(), true);
		assertEquals(newPassenger.isFlown(), false);
		assertEquals(newPassenger.isQueued(), false);
		assertEquals(newPassenger.isRefused(), false);
	}

}
