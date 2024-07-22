package src;

public class Cash implements Payment {
	private double paidAmount;

	public Cash(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Override
	public double calcPaymentAmount() {
		return paidAmount;
	}

	@Override
	public String toString() {
		return "Cash: Paid Amount: " + calcPaymentAmount();
	}

}
