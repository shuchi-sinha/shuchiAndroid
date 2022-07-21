package tradestore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TradeTestCases {

	TradeCommonUtility tradeCommonUtility = new TradeCommonUtility();
	Date todayDate= Calendar.getInstance().getTime();
	SimpleDateFormat fSimpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * During transmission if the lower version is being received by the store it will reject the trade and throw an exception.
	 * @throws Exception
	 */
	@Test
	@Order(1)
	void testingOfLowerVersion() throws Exception
	{
		Date maturityDate=fSimpleDateFormat.parse("25/15/2022");

		Trade t1=new Trade("T3",7,"CP-3","B1",maturityDate, todayDate, 'N');
		tradeCommonUtility.addTradeDetails(t1);

		Trade t2=new Trade("T3",1,"CP-3","B1",maturityDate, todayDate, 'N');

		assertThrows(Exception.class,()->tradeCommonUtility.addTradeDetails(t2),"1 is less than 7");

	}

	/**
	 * This method will check whether the versions are same or not, if not the same it will override it.
	 * @throws Exception
	 */
	@Test
	@Order(2)
	void testingOfSameVersion() throws Exception{

		Date maturityDate=fSimpleDateFormat.parse("27/05/2022");
		//Same Version as before and Changing Counter-Party ID to CP-2
		Trade t3=new Trade("T1",1,"CP-1","B1",maturityDate, todayDate, 'N');
		tradeCommonUtility.addTradeDetails(t3);
		assertEquals("CP-1",tradeCommonUtility.fTradeHashMap.get("T1").getCounterPartId());
	}

	/**
	 * Store should not allow the trade which has less maturity date then today date.
	 * @throws Exception
	 */
	@Test
	@Order(3)
	void testingOfMaturityDateLessThanTodayDate() throws Exception
	{
		//Maturity date can be changed for the validation
		Date maturityDate=fSimpleDateFormat.parse("25/01/2022");
		Trade t4=new Trade("T5",1,"CP-4","B3",maturityDate, todayDate, 'N');
		tradeCommonUtility.addTradeDetails(t4);
		assertNull(tradeCommonUtility.fTradeHashMap.get("T5"));
	}


	/**
	 * Store should automatically update the expire flag if in a store the trade crosses the maturity date.
	 * @throws ParseException
	 */
	@Test
	@Order(4)
	void testingOfExpiryFlag() throws ParseException
	{
		Date maturityDate=fSimpleDateFormat.parse("25/01/2022");
		Trade t5=new Trade("T7",6,"CP-4","B1",maturityDate, todayDate, 'N');
		tradeCommonUtility.fTradeHashMap.put("T7",t5);
		tradeCommonUtility.updateExpiryFlag();
		assertEquals('Y',tradeCommonUtility.fTradeHashMap.get("T7").getExpired());
	}



}
