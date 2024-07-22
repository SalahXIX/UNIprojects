package src;

public class Staff extends Client {
	private String jobId;
	private final double DISCOUNT = 0.75;

	public Staff(int id, String name, String jobId) {
		super(id, name);
		this.jobId = jobId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public double getDISCOUNT() {
		return DISCOUNT;
	}

	@Override
	public String toString() {
		return "Client Id: " + super.getId() + " Staff name: " + super.getName() + " job Id: " + jobId + " DISCOUNT: "
				+ DISCOUNT + "\n";
	}
}
