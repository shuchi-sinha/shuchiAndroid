package tradestore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Trade {

	private String tradeId;
	private int version;
	private String counterPartId;
	private String bookId;
	private Date maturityDate;
	private Date createdDate;
	private char expired;

	public Trade(String tId,int ver,String cpId,String bkId,Date mtyDate,Date ctdDate,char exp){
		tradeId = tId;
		version = ver;
		counterPartId = cpId;
		bookId = bkId;
		maturityDate = mtyDate;
		createdDate = ctdDate;
		expired = exp;
	}

	/*Getter and Setter */
	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterPartId() {
		return counterPartId;
	}

	public void setCounterPartId(String counterPartId) {
		this.counterPartId = counterPartId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public char getExpired() {
		return expired;
	}

	public void setExpired(char expired) {
		this.expired = expired;
	}

	@Override
	public String toString() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return "Trade{" +
				"tradeId='" + tradeId + '\'' +
				", version=" + version +
				", counterPartyId='" + counterPartId + '\'' +
				", bookId='" + bookId + '\'' +
				", maturityDate=" + simpleDateFormat.format(maturityDate) +
				", createdDate=" + simpleDateFormat.format(createdDate) +
				", expired=" + expired +
				'}';
	}
}
