package src;

import java.io.Serializable;
import java.time.LocalDate;

public class ShipmentStatus implements Serializable{
	private LocalDate shippingDate;
	private LocalDate receivingDate;
	private Shipment shipement;
	
	public ShipmentStatus(LocalDate shippingDate, LocalDate receivingDate, Shipment shipement) {
		super();
		this.shippingDate = shippingDate;
		this.receivingDate = receivingDate;
		this.shipement = shipement;
	}

	public LocalDate getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(LocalDate shippingDate) {
		this.shippingDate = shippingDate;
	}

	public LocalDate getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(LocalDate receivingDate) {
		this.receivingDate = receivingDate;
	}

	public Shipment getShipement() {
		return shipement;
	}

	public void setShipement(Shipment shipement) {
		this.shipement = shipement;
	}

	@Override
	public String toString() {
		return "shippingDate=" + shippingDate + ", receivingDate=" + receivingDate + ", shipement="
				+ shipement + "]";
	}
	
	
	
	

}
