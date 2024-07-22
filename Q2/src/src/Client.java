package src;

import java.io.Serializable;

public class Client implements Serializable {
	private int id;
	private String name;

	public Client() {

	}

	public Client(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Client Id: " + id + " Client Name: " + name + "\n";
	}

}
