package src;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class Shipment implements Serializable {
	private String ShipmentCode;
	private LocalDate registrationDate;
	private double weight;
	private double shippingCost;
	private Client shipper;
	private Destination destination;
	private ShippingWays shippingWay;
	private Payment[] paymentWay;
	private double amountPaid;
	private PaymentWay paymentways;

	public Shipment(String shipmentCode, LocalDate registrationDate, double weight, double shippingCost, Client shipper,
			Destination destination, ShippingWays shippingWay, Payment[] paymentWay) {
		super();
		this.ShipmentCode = shipmentCode;
		this.registrationDate = registrationDate;
		this.weight = weight;
		this.shippingCost = shippingCost;
		this.shipper = shipper;
		this.destination = destination;
		this.shippingWay = shippingWay;
		this.paymentWay = paymentWay;
	}

	public String getShipmentCode() {
		return ShipmentCode;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public Client getShipper() {
		return shipper;
	}

	public void setShipper(Client shipper) {
		this.shipper = shipper;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public ShippingWays getShippingWay() {
		return shippingWay;
	}

	public void setShippingWay(ShippingWays shippingWay) {
		this.shippingWay = shippingWay;
	}

	public Payment[] getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(Payment[] paymentWay) {
		this.paymentWay = paymentWay;
	}

	public PaymentWay getPaymentways() {
		return paymentways;
	}

	public void setPaymentways(PaymentWay paymentways) {
		this.paymentways = paymentways;
	}

	public void setShipmentCode(String shipmentCode) {
		ShipmentCode = shipmentCode;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public void addPayment(Payment payment) {
		if (paymentWay == null) {
			paymentWay = new Payment[1];
			paymentWay[0] = payment;
		} else {
			Payment[] newArray = new Payment[paymentWay.length + 1];
			System.arraycopy(paymentWay, 0, newArray, 0, paymentWay.length);
			newArray[newArray.length - 1] = payment;
			paymentWay = newArray;
		}
	}

	@Override
	public String toString() {
		return "Shipment Code: " + ShipmentCode + "\n" + destination + "\nShipper: " + shipper + "\nRegistration Date: "
				+ registrationDate + ", Weight: " + weight + "\nShipping Cost: " + shippingCost + ", Amount Paid: "
				+ amountPaid + ", Shipping method: " + shippingWay + "\nPayments: " + Arrays.toString(paymentWay)
				+ ", Payment ways: " + paymentways + ", Amount Left: " + (shippingCost - amountPaid);
	}

}
