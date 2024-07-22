package src;

import java.io.Serializable;

public class Destination implements Serializable {
	private String destCode;
	private String destName;
	private double airCost1stKilo;
	private double airCostEachAddHalf;
	private double groundShippingDiscount;
	private double seaShippingDiscount;

	public Destination(String destCode, String destName, double airCost1stKilo, double airCostEachAddHalf,
			double groundShippingDiscount, double seaShippingDiscount) {
		super();
		this.destCode = destCode;
		this.destName = destName;
		this.airCost1stKilo = airCost1stKilo;
		this.airCostEachAddHalf = airCostEachAddHalf;
		this.groundShippingDiscount = groundShippingDiscount;
		this.seaShippingDiscount = seaShippingDiscount;
	}

	public String getDestCode() {
		return destCode;
	}

	public void setDestCode(String destCode) {
		this.destCode = destCode;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	public double getAirCost1stKilo() {
		return airCost1stKilo;
	}

	public void setAirCost1stKilo(double airCost1stKilo) {
		this.airCost1stKilo = airCost1stKilo;
	}

	public double getAirCostEachAddHalf() {
		return airCostEachAddHalf;
	}

	public void setAirCostEachAddHalf(double airCostEachAddHalf) {
		this.airCostEachAddHalf = airCostEachAddHalf;
	}

	public double getGroundShippingDiscount() {
		return groundShippingDiscount;
	}

	public void setGroundShippingDiscount(double groundShippingDiscount) {
		this.groundShippingDiscount = groundShippingDiscount;
	}

	public double getSeaShippingDiscount() {
		return seaShippingDiscount;
	}

	public void setSeaShippingDiscount(double seaShippingDiscount) {
		this.seaShippingDiscount = seaShippingDiscount;
	}

	@Override
	public String toString() {
		return "Destination Name: " + destName + ", Destination Code: " + destCode + ", 1st Kilo air cost: "
				+ airCost1stKilo + ", Each half Kilo air cost: " + airCostEachAddHalf + "\nGround shipping discount: "
				+ groundShippingDiscount * 100 + "%" + ", Sea shipping discount: " + seaShippingDiscount * 100 + "%";
	}
}
