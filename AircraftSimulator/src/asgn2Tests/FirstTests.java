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

public class FirstTests {

	@Test (expected=PassengerException.class)
	public void checkIfDepartureTimeIsLessThen0() throws PassengerException{
		Passenger Bill = new First(12,-1);
	}
	
	@Test (expected=PassengerException.class)
	public void checkIfBookingTimeIsLessThen0() throws PassengerException{
		Passenger Bill = new First(-1,12);
	}

	@Test (expected=PassengerException.class)
	public void checkCancelSeat_IfPassnegerIsNew() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.cancelSeat(16);
	}
	
	@Test (expected=PassengerException.class)
	public void checkCancelSeat_IfPassnegerIsInQueue() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(12, 12);
		Bill.queuePassenger(13, 13);
		Bill.cancelSeat(16);
	}
	
	@Test (expected=PassengerException.class)
	public void checkCancelSeat_IfPassnegerIsRefused() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(12, 12);
		Bill.refusePassenger(12);
		Bill.cancelSeat(16);
	}
	
	@Test (expected=PassengerException.class)
	public void checkCancelSeat_IfPassnegerIsFlown() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(12, 12);
		Bill.flyPassenger(45);
		Bill.cancelSeat(16);
	}
	
	@Test (expected=PassengerException.class)
	public void checkCancelSeat_IfCancelationTimeisLessThen0() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(12, 12);
		Bill.cancelSeat(-1);
	}
	
	@Test (expected=PassengerException.class)
	public void checkCancelSeat_IfCancelationTimeisGreaterThenDepartureTime() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(12, 12);
		Bill.cancelSeat(14);
	}
	
	@Test (expected=PassengerException.class)
	public void checkConfirmSeat_IfAlreadyConfirmed() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(13, 14);
		Bill.confirmSeat(15, 16);
	}
	
	@Test (expected=PassengerException.class)
	public void checkConfirmSeat_IfRefused() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.refusePassenger(13);
		Bill.confirmSeat(13, 14);
	}
	
	@Test (expected=PassengerException.class)
	public void checkConfirmSeat_IfFlown() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.flyPassenger(12);
		Bill.confirmSeat(13, 14);
	}
	
	@Test (expected=PassengerException.class)
	public void checkConfirmSeat_IfConfirmationTimeisLessThen0() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(-1, 13);
	}
	
	@Test (expected=PassengerException.class)
	public void checkConfirmSeat_IfConfirmationTimeisGreaterThenDepartureTime() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.confirmSeat(12, 11);
	}
	
	@Test (expected=PassengerException.class)
	public void checkFlyPassenger_IfPassnegerIsNew() throws PassengerException{
		Passenger Bill = new First(12,12);
		Bill.flyPassenger(16);
	}
	
	@Test (expected=PassengerException.class)
	public void checkFlyPassenger_IfPassnegerIsQueued() throws PassengerException{
		Passenger Bill = new First(12,12);
 		Bill.queuePassenger(12, 13);
		Bill.flyPassenger(16);
	}
	
	@Test (expected=PassengerException.class)
	public void checkFlyPassenger_IfPassnegerIsRefused() throws PassengerException{
		Passenger Bill = new First(12,12);
 		//Bill.refusePassenger(14);
		Bill.flyPassenger(16);
	}
	/*@Test (expected=PassengerException.class)
	public void checkIfBookingTimeIsLessThen0() throws PassengerException{
		Passenger Bill = new First(-1,12);
	}*/
	
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

