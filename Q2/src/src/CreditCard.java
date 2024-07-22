package src;

public class CreditCard implements Payment {
	private double paidAmount;

	public CreditCard(double paidAmount) {
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
		return paidAmount + (paidAmount * 0.025);
	}
	@Override
	public String toString() {
		return "Credit Card: Paid Amount: " + calcPaymentAmount();
	}
}
