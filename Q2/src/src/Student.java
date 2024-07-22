package src;

public class Student extends Client {
	private int uniRegId;
	private String uniName;
	private final double DISCOUNT = 0.5;

	public Student(int id, String name, int uniRegId, String uniName) {
		super(id, name);
		this.uniRegId = uniRegId;
		this.uniName = uniName;
	}

	public int getUniRegId() {
		return uniRegId;
	}

	public void setUniRegId(int uniRegId) {
		this.uniRegId = uniRegId;
	}

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	public double getDISCOUNT() {
		return DISCOUNT;
	}

	@Override
	public String toString() {
		return "Client Id: " + super.getId() + " Student name: " + super.getName() + " uniRegId: " + uniRegId
				+ " uniName: " + uniName + "\n";
	}

}
