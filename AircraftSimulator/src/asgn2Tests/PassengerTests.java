package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;

public class PassengerTests {

	@Test
	public final void testPassengerIntInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPassenger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCancelSeat() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.confirmSeat(12, 13);;
		Bill.cancelSeat(13);
		assertEquals (Bill.isNew(), true);
	}

	@Test
	public final void testConfirmSeat() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.confirmSeat(12, 13);
		assertEquals (Bill.isConfirmed(), true);
	}

	@Test
	public final void testFlyPassenger() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.confirmSeat(12, 13);
		Bill.flyPassenger(12);
		assertEquals (Bill.isFlown(), true);
	}


	@Test
	public final void testIsConfirmed() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.confirmSeat(12, 13);
		assertEquals(Bill.isConfirmed(), true);
	}

	@Test
	public final void testIsFlown() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.confirmSeat(12, 13);
		Bill.flyPassenger(12);
		assertEquals(Bill.isFlown(), true);
	}

	@Test
	public final void testIsNew() throws PassengerException {
		Passenger Bill = new First(12, 12);
		assertEquals(Bill.isNew(), true);
	}

	@Test
	public final void testIsQueued() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.queuePassenger(12, 13);
		assertEquals(Bill.isQueued(), true);
	}

	@Test
	public final void testIsRefused() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.refusePassenger(12);
		assertEquals(Bill.isRefused(), true);
	}

	@Test
	public final void testNoSeatsMsg() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testQueuePassenger() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.queuePassenger(12, 13);
		assertEquals(Bill.isQueued(), true);
	}

	@Test
	public final void testRefusePassenger() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.queuePassenger(12, 13);
		Bill.refusePassenger(12);
		assertEquals(Bill.isRefused(), true);
	}


	@Test
	public final void testWasConfirmed() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.confirmSeat(12, 13);
		assertEquals(Bill.wasConfirmed(), true);
	}

	@Test
	public final void testWasQueued() throws PassengerException {
		Passenger Bill = new First(12, 12);
		Bill.queuePassenger(10, 11);
		assertEquals(Bill.wasQueued(), true);
	}

	@Test
	public final void testCopyPassengerState() throws PassengerException {
		Passenger Bill = new First(10, 11);
		Passenger BillTest = new First(7, 8);
		
		
	}

}
