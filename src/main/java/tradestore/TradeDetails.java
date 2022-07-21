package tradestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Java Program for the Trade Details, where trades are added and the results are verified using the TradeTestCases.java
 *
 * @author Neeraj Kashyap
 * @version 1.0
 * @since 26/01/2022
 */

public class TradeDetails {

	public static void main(String[] args) throws Exception {

		TradeCommonUtility tradeCommonUtility = new TradeCommonUtility();
		Date todayDate= Calendar.getInstance().getTime();
		SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");

		/*Add the Trade details of T1*/
		Date maturityDate=sd.parse("20/05/2020");
		Trade t1 = new Trade("T1",1,"CP-1","B1",maturityDate,todayDate,'N');
		tradeCommonUtility.addTradeDetails(t1);

		/*Add the Trade details of T2*/
		maturityDate=sd.parse("20/05/2021");
		Trade t2 = new Trade("T2",2,"CP-2","B1",maturityDate,todayDate,'N');
		tradeCommonUtility.addTradeDetails(t2);

		/*Add the Trade details of T2*/
		maturityDate=sd.parse("20/05/2021");
		Trade t3 = new Trade("T2",1,"CP-1","B1",maturityDate,sd.parse("14/03/2015"),'N');
		tradeCommonUtility.addTradeDetails(t3);

		/*Add the Trade details of T3*/
		maturityDate=sd.parse("20/05/2014");
		Trade t4 = new Trade("T3",3,"CP-3","B2",maturityDate,todayDate,'Y');
		tradeCommonUtility.addTradeDetails(t4);

		System.out.println("========================================================================");
		System.out.println("Trade list: ");
		tradeCommonUtility.printAllTheTradeDetails();
		System.out.println("========================================================================");

	}
}
