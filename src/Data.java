
public class Data {
	
	private int ID;
	private String source;
	private String ledger;
	private String date;
	private String paiddate;
	private String validdate;
	private double debit;
	private double credit;
	private String description;
	private byte [] image;
	private double interest;
	private String subledger;
	



public Data (int id, String source , String ledger, String date,String paiddate, String validdate, double debit, double credit, String description, byte [] image, Double interest, String subledger)
{
	super();
	this.ID = id;
	this.source = source;
	this.ledger = ledger;
	this.date = date;
	this.validdate = validdate;
	this.debit = debit;
	this.credit = credit;
	this.description = description;
	this.image = image;
	this.paiddate = paiddate;
	this.interest = interest;
	this.subledger = subledger;
	
	
}
	public int getId() {
		return ID;
	}

	public void setId(int id) {
		ID = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLedger() {
		return ledger;
	}

	public void setLedger(String ledger) {
		this.ledger = ledger;
	}
	
	public String getSubledger() {
		return subledger;
	}

	public void setSubledger(String subledger) {
		this.subledger = subledger;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getPaidDate() {
		return paiddate;
	}

	public void setPaidDate(String paiddate) {
		this.paiddate = paiddate;
	}

	public String getValiddate() {
		return validdate;
	}

	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}