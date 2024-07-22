package src;

public class WireTransfer implements Payment {
	private double paidAmount;

	public WireTransfer(double paidAmount) {
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
		return paidAmount + 100;
	}

	@Override
	public String toString() {
		return "Wire Transfer: Paid Amount: " + calcPaymentAmount();
	}
}
