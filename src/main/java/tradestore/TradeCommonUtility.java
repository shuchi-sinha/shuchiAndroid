package tradestore;

import java.util.Date;
import java.util.HashMap;


public class TradeCommonUtility {

	HashMap<String,Trade> fTradeHashMap = new HashMap<String,Trade>();


	/**
	 * The following method prints all the trade details.
	 */
	public void printAllTheTradeDetails(){
		for (String tId:fTradeHashMap.keySet()){
			System.out.println(fTradeHashMap.get(tId).toString());
		}
	}

	/**
	 * The following function checks the maturity date
	 * @param maturityDate: Maturity Date
	 * @param CurrentDate: current date
	 * @return: returns the boolean value.
	 */
	public boolean checkMaturityDate(Date maturityDate, Date CurrentDate){
		if(CurrentDate.compareTo(maturityDate)>0){
			return false;
		}else{
			return true;
		}

	}

	/**
	 * The following function checks the version of the trade.
	 * @param trade : Trade
	 * @param version : version number.
	 * @throws Exception: Exception message
	 */
	public void checkVersion(Trade trade, int version) throws Exception
	{
		if(trade.getVersion()< version)
		{
			throw new Exception(trade.getVersion()+" version is less than "+ version+" version");
		}

	}

	/**
	 * The following function adds the trade details
	 * @param trade: Trade
	 * @throws Exception: Exception message.
	 */
	public void addTradeDetails(Trade trade) throws Exception{

		if(fTradeHashMap.containsKey(trade.getTradeId())){

			checkVersion(trade,fTradeHashMap.get(trade.getTradeId()).getVersion());

			if(checkMaturityDate(trade.getMaturityDate(),fTradeHashMap.get(trade.getTradeId()).getMaturityDate())){
				fTradeHashMap.replace(trade.getTradeId(),trade);
				System.out.println(trade.getTradeId()+" is added to the trade store");
			}else{
				System.out.println(trade.getTradeId()+" is not added to the trade store as maturity date is less than the current date");
			}
		}else{
			if(checkMaturityDate(trade.getMaturityDate(),trade.getCreatedDate())){
				fTradeHashMap.put(trade.getTradeId(),trade);
				System.out.println(trade.getTradeId()+" is added to the trade store");
			}else {
				System.out.println(trade.getTradeId()+" is not added to the trade store as maturity date is less than the current date");
			}
		}
	}

	/**
	 * This method will update the expiry flag to Y, if the trade crosses the maturity date.
	 */
	public void updateExpiryFlag(){
		Date newCurrentDate = new Date();
		for (String replaceExpired : fTradeHashMap.keySet()){
			if (newCurrentDate.compareTo(fTradeHashMap.get(replaceExpired).getMaturityDate())>0){
				Trade newTrade = fTradeHashMap.get(replaceExpired);
				newTrade.setExpired('Y');
				fTradeHashMap.replace(replaceExpired,newTrade);
				System.out.println("The "+newTrade.getTradeId()+" is replaced");
			}
		}
	}

}
