package src;

public class Check implements Payment {
	private double paidAmount;

	public Check(double paidAmount) {
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
		return "Check: Paid Amount: " + calcPaymentAmount();
	}
}
