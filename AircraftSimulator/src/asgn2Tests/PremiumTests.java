package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import asgn2Passengers.Business;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;
import asgn2Passengers.Premium;

public class PremiumTests {

	@Test
	public final void testUpgrade() throws PassengerException {
		Passenger newPassenger = new Premium(12, 12);
		newPassenger.upgrade();
		assertEquals(newPassenger.upgrade().getPassID().contains("J(U)P:"), true);
		assertEquals(newPassenger.isNew(), true);
		assertEquals(newPassenger.isFlown(), false);
		assertEquals(newPassenger.isQueued(), false);
		assertEquals(newPassenger.isRefused(), false);
	}

}
