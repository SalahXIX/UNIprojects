package src;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class TestApp implements Serializable {

	static ArrayList <Client> Clients = new ArrayList <Client>();
	static ArrayList <Destination> destinations = new ArrayList <Destination>();
	static ArrayList <Shipment> shipments = new ArrayList <Shipment>();
	static ArrayList<ShipmentStatus> shipmentsStatus = new ArrayList<ShipmentStatus>();
	private static int id = 1001;
	private static int destinationCode = 1001;
	private static int shipmentcode = 1001;


	public static void main(String[] args) {
		MainMenu();
	}

	public static void MainMenu() {
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Choose one of the next options: \n\n" + ""
					+ "1.  Add Client\n2.  Add Destination\n"
					+ "3.  Create new shipment\n"
					+ "4.  Update an existing shipment\n"
					+ "5.  Sending/Receiving shipment\n"
					+ "6.  Report1- List the existing clients \n"
					+ "7.  Report2- List the destination details \n"
					+ "8.  Report3- List the shipment details \n"
					+ "9.  Report4- List the queued shipments \n"
					+ "10. Report5- List the client shipments \n"
					+ "11. Report6- List the income\n"
					+ "12. Report7- List the shipments not yet collected \n"
					+ "13. save and exit");
			choice = input.nextInt();
		}
		while (choice < 1 || choice > 14);
		if(choice==1) { 
			chooseType();
		}else if (choice==2) {
			AddDestination();
		}else if (choice==3) {
			createNewShipment();
		}else if (choice==4) {
			updateExistingShipment();
		}else if (choice==5) {
			SendingOrReceivingShipment();
		}else if(choice ==6) {
			report1();
		}else if(choice ==7) {
			report2();
		}else if(choice ==8) {
			report3();
		}else if(choice ==9) {
			report4();
		}else if(choice ==10) {
			report5();
		}else if(choice ==11) {
			report6();
		}else if(choice ==12) {
			report7();
		}else if(choice ==13) {
			saveandexit();
		} else if(choice == 14) {
			report8();
		}
	}
	public static double round(double number) {
		double rounded = Math.ceil(number * 2) / 2;
		return rounded;
	}

	public static void chooseType() { 
		Scanner input1 = new Scanner(System.in);
		int choice1;
		do {
			System.out.print(
					"Choose one of the next options: \n\n"
							+ "1. Add Client\n"
							+ "2. Add Student\n"
							+ "3. Add Company\n"
							+ "4. Add Staff\n");
			choice1 = input1.nextInt();
		}
		while(choice1<1 || choice1>4);
		if(choice1==1) {
			AddClient();
		} else if (choice1 == 2) {
			AddStudent();
		} else if (choice1 == 3) {
			AddCompany();
		} else if (choice1 == 4) {
			AddStaff();
		}

	}

	public static void AddClient(){
		ObjectInputStream in;
		try {
			in =new ObjectInputStream(new FileInputStream("ClientsData.dat"));
			Clients = (ArrayList<Client>)in.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int size = Clients.size();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		Client c = new Client((size+id),name);
		Clients.add(c);
		MainMenu();
	}

	public static void AddStudent() {

		ObjectInputStream in;
		try {
			in =new ObjectInputStream(new FileInputStream("ClientsData.dat"));
			Clients = (ArrayList<Client>)in.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int size = Clients.size();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		System.out.println("Enter your University name: ");
		String UniName = input.nextLine();
		System.out.println("Enter your University Regitration ID: ");
		int uniRegId =input.nextInt();
		Student s=new Student((id+size),name,uniRegId,UniName);
		Clients.add(s);
		MainMenu();

	}
	public static void AddCompany() {
		ObjectInputStream in;
		try {
			in =new ObjectInputStream(new FileInputStream("ClientsData.dat"));
			Clients = (ArrayList<Client>)in.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int size = Clients.size();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = input.next();
		System.out.println("Enter your Location: ");
		String location = input.next();
		System.out.println("Enter your PoBox:  ");
		int PoBox =input.nextInt();
		Company s=new Company((size+id),name,location,PoBox);
		Clients.add(s);
		MainMenu();

	}
	public static void AddStaff() {
		ObjectInputStream in;
		try {
			in =new ObjectInputStream(new FileInputStream("ClientsData.dat"));
			Clients = (ArrayList<Client>)in.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int size = Clients.size();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = input.next();
		System.out.println("Enter your Job ID: ");
		String JobId = input.next();
		Staff s=new Staff((size+id),name,JobId);
		Clients.add(s);
		MainMenu();

	}
	public static void AddDestination() {	
		ObjectInputStream in;
		try {
			in =new ObjectInputStream(new FileInputStream("DestData.dat"));
			destinations = (ArrayList<Destination>)in.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int size = destinations.size();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Destination name: ");
		String destname = input.next();
		System.out.println("Enter your Air Cost for First Kilogram: ");
		double acfk = input.nextInt();
		System.out.println("Enter your Air cost for Each Added Half: ");
		double acfh = input.nextInt();
		System.out.println("Enter your Ground Shipping Discount: ");
		double gsd = input.nextInt();
		System.out.println("Enter your Sea Shipping Discount:  ");
		double ssd = input.nextInt();
		//String destCode, String destName, double airCost1stKilo, double airCostEachAddHalf,
		//double groundShippingDiscount, double seaShippingDiscount
		Destination d = new Destination("Dest"+String.valueOf(size+destinationCode),destname, acfk, acfh, gsd, ssd);
		destinations.add(d);
		MainMenu();
	}
	public static void createNewShipment() {
		ObjectInputStream inF;
		try {
			inF =new ObjectInputStream(new FileInputStream("DestData.dat"));
			shipments = (ArrayList<Shipment>)inF.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int size = shipments.size();
		Shipment shipment;
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the weight of the shipment: ");
		double weight = in.nextDouble();
		double NewWeight = 0;
		if (weight <= 1)
			NewWeight = 1;
		else if (weight > 1)
			NewWeight = roundnearsthalf(weight);

		System.out.println("Please choose the shipper: ");
		for (int i = 1; i < Clients.size() + 1; i++) {
			System.out.println(i + ": " + Clients.get(i - 1).getName()); 
		}
		int finalChoice = 0;
		while (true) {
			int input = in.nextInt();
			if (input > 0 && input < Clients.size() + 1) {
				finalChoice = input;
				break;
			}
		}
		Client shipper = Clients.get(finalChoice - 1);

		System.out.println("Please choose the destination: ");
		for (int i = 1; i < destinations.size() + 1; i++) {
			System.out.println(i + ": " + destinations.get(i - 1).getDestName());
		}
		while (true) {
			int input = in.nextInt();
			if (input > 0 && input < destinations.size() + 1) {
				finalChoice = input;
				break;
			}
		}

		Destination destination = destinations.get(finalChoice - 1);

		double shippingCost;
		if (NewWeight > 1)
			shippingCost = destination.getAirCost1stKilo() + (NewWeight - 1) * 2 * destination.getAirCostEachAddHalf();
		else
			shippingCost = destination.getAirCost1stKilo();

		ShippingWays shippingWay = ShippingWays.AirFreight;
		String finalAnswer;

		System.out.println("Current shipping way: Air Freight. Would you like to change the shipping way? (yes/no)");
		while (true) {
			String input = in.next();
			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
				finalAnswer = input;
				break;
			
			}
		}

		if (finalAnswer.equalsIgnoreCase("yes")) {
			System.out.println("What shipping way would you like? \n1- Ground Shipping\n2- Sea Freight");
			while (true) {
				int input = in.nextInt();
				if (input > 0 && input < 3) {
					finalChoice = input;
					break;
				}
			}

			if (finalChoice == 1) {
				shippingWay = ShippingWays.GroundShipping;
				shippingCost = shippingCost - (shippingCost * destination.getGroundShippingDiscount());
			} else {
				shippingWay = ShippingWays.SeaFreight;
				shippingCost = shippingCost - (shippingCost * destination.getSeaShippingDiscount());
			}

		}

		System.out.println("What payment plan would you like to follow? \n"
				+ "1- Postponed till later \n"
				+ "2- Paid in partial \n3- Paid in total");

		while (true) {
			int input = in.nextInt();
			if (1 > input || input > 3)
				System.out.println("Invalid input. Please enter a valid number: ");
			else if (input > 0 && input < 4) {
				finalChoice = input;
				break;
			}
		}
		PaymentWay PaymentWay = null;
		if (finalChoice == 1)
			PaymentWay = PaymentWay.Postponed;
		else if (finalChoice == 2)
			PaymentWay = PaymentWay.Partial;
		else if (finalChoice == 3)
			PaymentWay = PaymentWay.PaidTotal;

		shipment = new Shipment("Ship" + (size+shipmentcode), LocalDate.now(), weight, shippingCost, shipper, destination,
				shippingWay, null);
		shipment.setPaymentways(PaymentWay);

		if (PaymentWay == PaymentWay.PaidTotal) { 
			System.out.printf(
					"Amount due: %.2f \n"
					+ "What payment way would you like to use? \n"
					+ "1- Credit Card Payment \n"
					+ "2- Wire Transfer Payment \n"
					+ "3- Check Payment \n4- Cash Payment\n",
					shippingCost);

			while (true) {
				int input = in.nextInt();
					if (input > 0 && input < 5) {
					finalChoice = input;
					break;
				}
			}
			Payment payment;
			if (finalChoice == 1) {
				payment = new CreditCard(shippingCost);
				shipment.addPayment(payment);
			} else if (finalChoice == 2) {
				payment = new WireTransfer(shippingCost);
				shipment.addPayment(payment);
			} else if (finalChoice == 3) {
				payment = new Check(shippingCost);
				shipment.addPayment(payment);
			} else if (finalChoice == 4) {
				payment = new Cash(shippingCost);
				shipment.addPayment(payment);
			}
			shipment.setAmountPaid(shippingCost);
		}
		if (PaymentWay == PaymentWay.Partial) {
			double amountLeft = shipment.getShippingCost() - shipment.getAmountPaid();
			System.out.printf("How much would you like to pay? Amount left: %.2f\n", amountLeft);
			double partialPaymentAmount;
			while (true) {
				double input = in.nextDouble();
				if (input > 0 && input <= amountLeft) {
					partialPaymentAmount = input;
					break;
				}
			}
			System.out.printf("Amount due: %.2f \n"
					+ "What payment way would you like to use? \n"
					+ "1- Credit Card Payment \n"
					+ "2- Wire Transfer Payment \n"
					+ "3- Check Payment \n"
					+ "4- Cash Payment\n",
					partialPaymentAmount);

			while (true) {
				int input = in.nextInt();
				if (input > 0 && input < 5) {
					finalChoice = input;
					break;
				}
			}
			Payment payment;
			if (finalChoice == 1) {
				payment = new CreditCard(partialPaymentAmount);
				shipment.addPayment(payment);
			} else if (finalChoice == 2) {
				payment = new WireTransfer(partialPaymentAmount);
				shipment.addPayment(payment);
			} else if (finalChoice == 3) {
				payment = new Check(partialPaymentAmount);
				shipment.addPayment(payment);
			} else if (finalChoice == 4) {
				payment = new Cash(partialPaymentAmount);
				shipment.addPayment(payment);
			}

			shipment.setAmountPaid(shipment.getAmountPaid() + partialPaymentAmount);
		}

		shipments.add(shipment);

		if (shipment.getAmountPaid() == shipment.getShippingCost()) {
			ShipmentStatus shipmentStatus = new ShipmentStatus(null, null,shipment);
			shipmentsStatus.add(shipmentStatus);
		}
		MainMenu();
	}
	public static void updateExistingShipment() {
		System.out.println("Existing Shipments: ");
		for (Shipment s : shipments) {
			System.out.printf("%s - Shipper: %s, Destination: %s\n", s.getShipmentCode(), s.getShipper().getName(),
					s.getDestination().getDestName());
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the shipment code: ");

		Shipment shipment = null;
		String choice = null;
		boolean found = false;
		while (true) {
			choice = in.next();
			for (Shipment s : shipments) {
				if (s.getShipmentCode().equalsIgnoreCase(choice)) {
					found = true;
					shipment = s;
				}
			}
			double amountLeft = shipment.getShippingCost() - shipment.getAmountPaid(); 
			if (amountLeft == 0)
				System.out.println("Shipment has been paid fully.\n");
			else {
				if (amountLeft == shipment.getShippingCost()) {
					System.out.printf("Current shipping way: %s. Current shipping cost: %.2f \n"
							+ "Would you like to change the shipping way? (yes/no)\n",
							shipment.getShippingWay().toString(), shipment.getShippingCost());
					while (true) {
						String input = in.next(); 
						if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
							choice = input;
							break;
						}
					}

					if (choice.equalsIgnoreCase("yes")) {
						System.out.println("What shipping way would you like? \n"
								+ "1- Air Freight\n"
								+ "2- Ground Shipping\n"
								+ "3- Sea Freight");
						int intChoice = 0;
						while (true) {
							int input = in.nextInt();
							if (input > 0 && input < 4) {
								intChoice = input;
								break;
							}
						}
						double originalAmount = 0;
						if (shipment.getShippingWay() == ShippingWays.GroundShipping)
							originalAmount = shipment.getShippingCost()
							/ (1 - shipment.getDestination().getGroundShippingDiscount()); 																								// 1000
						else if (shipment.getShippingWay() == ShippingWays.SeaFreight)
							originalAmount = shipment.getShippingCost()
							/ (1 - shipment.getDestination().getSeaShippingDiscount());
						else if (shipment.getShippingWay() == ShippingWays.AirFreight)
							originalAmount = shipment.getShippingCost();

						if (intChoice == 1) { 
							shipment.setShippingWay(ShippingWays.AirFreight);
							shipment.setShippingCost(originalAmount);
						} else if (intChoice == 2) {
							shipment.setShippingWay(ShippingWays.GroundShipping);
							shipment.setShippingCost(
									originalAmount- (originalAmount * shipment.getDestination().getGroundShippingDiscount()));
						} else if (intChoice == 3) {
							shipment.setShippingWay(ShippingWays.SeaFreight);
							shipment.setShippingCost(
									originalAmount - (originalAmount * shipment.getDestination().getSeaShippingDiscount()));
						}

						System.out.printf("New shipping cost: %.2f\n",shipment.getShippingCost());
					}
				} 
				amountLeft = shipment.getShippingCost() - shipment.getAmountPaid();
				System.out.printf("Amount Left: %.2f. Would you like to make a payment? (yes/no)\n", amountLeft);

				while (true) { 
					String input = in.next();
					if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
						choice = input;
						break;
					}
				}
				if (choice.equalsIgnoreCase("yes")) {
					System.out.println("How much would you like to pay?");
					double paymentAmount;
					while (true) { 
						double input = in.nextDouble();
						if (input > 0 && input <= amountLeft) {
							paymentAmount = input;
							break;
						}
					}
					System.out.printf(
							"Amount left: %.2f \n"
									+ "What payment way would you like to use? \n"
									+ "1- Credit Card Payment \n"
									+ "2- Wire Transfer Payment \n"
									+ "3- Check Payment \n"
									+ "4- Cash Payment\n",paymentAmount);
					int intChoice = 0;
					while (true) {
						int input = in.nextInt();
						if (input > 0 && input < 5) {
							intChoice = input;
							break;
						}
					}
					if (intChoice == 1) {
						shipment.addPayment(new CreditCard(paymentAmount));
					} else if (intChoice == 2) {
						shipment.addPayment(new WireTransfer(paymentAmount));
					} else if (intChoice == 3) {
						shipment.addPayment(new Check(paymentAmount));
					} else if (intChoice == 4) {
						shipment.addPayment(new Cash(paymentAmount));
					}
					shipment.setAmountPaid(shipment.getAmountPaid() + paymentAmount);
					System.out.println("Payment successful.\n");
					shipment.setPaymentways(PaymentWay.Partial); 
					if (shipment.getAmountPaid() == shipment.getShippingCost()) { 
						shipmentsStatus.add(new ShipmentStatus(null, null,shipment));
					}
				}
			}
			MainMenu();
		}
	}

	private static double roundnearsthalf(double weight) {
		return Math.ceil(weight* 2) / 2.0f;
	}
	
	public static void SendingOrReceivingShipment() {
		ObjectInputStream inF;
		try {
			inF =new ObjectInputStream(new FileInputStream("DestData.dat"));
			shipments = (ArrayList<Shipment>)inF.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Shipments Available are: ");
		for (Shipment a : shipments) {
			System.out.println(a.getShipmentCode() + "\t" + a.getDestination().getDestName() + "\t" + a.getShipper());
		}
		Scanner cin = new Scanner(System.in);
		System.out.println("Enter the shipment code: ");
		String scode = cin.next();
		for (Shipment sh: shipments) {
				if(sh.getShipmentCode().equalsIgnoreCase(scode)) {
				if ((sh.getPaymentways() == PaymentWay.Partial) || (sh.getPaymentways() == PaymentWay.Postponed)) {
					System.out.println("The amount is not paid in full");
				}
				else {
					for (ShipmentStatus s: shipmentsStatus) {
						if(s.getShipement().getShipmentCode().equalsIgnoreCase(scode)) {
							System.out.println("Do you want to send or receieve the shipment? (send/receive)");
							String answer = cin.next();
							if (answer.equalsIgnoreCase("send")) {
							if (s.getShipement().getRegistrationDate().isBefore(LocalDate.now())|| 
									s.getShipement().getRegistrationDate().isEqual(LocalDate.now())){
								s.setShippingDate(LocalDate.now());
								System.out.println("do you want to receive the shipment? (yes/no)");
								String response = cin.next();
								if (response.equalsIgnoreCase("yes")) {
									if (s.getShipement().getRegistrationDate().isBefore(LocalDate.now()) ||
											s.getShipement().getRegistrationDate().isEqual(LocalDate.now())) {
										System.out.println("after how many days do you want to receive the shipment: ");
									int days = cin.nextInt();
									    s.setReceivingDate(s.getShipement().getRegistrationDate().plusDays(days));
									}
								}
								else {
									System.out.println("shipment has been sent");
								}
							} 
							}
							else if(answer.equalsIgnoreCase("receive")) {
							if (s.getShipement().getRegistrationDate().isBefore(LocalDate.now()) ||
									s.getShipement().getRegistrationDate().isEqual(LocalDate.now())) {
								System.out.println("after how many days do you want to receive the shipment: ");
								int days = cin.nextInt();
							    s.setReceivingDate(s.getShipement().getRegistrationDate().plusDays(days));
							 
							   }
							}
							else {
								System.out.println("Invalid choice");
								MainMenu();
							}
						}
					}
				}
			}
		}
		MainMenu();
		
	}

	public static void report1() {
		int client_counter=0;
		int student_counter=0;
		int company_counter=0;
		int staff_counter=0;
		for (Client c : Clients) {
			if(! (c instanceof Student)&& ! (c instanceof Company)&& ! (c instanceof Staff) ) {
				client_counter++;
			}
		}
		System.out.println(client_counter+" Client(s)");
		
		for (Client c1 :Clients) { 
			if(! (c1 instanceof Student)&& ! (c1 instanceof Company)&& ! (c1 instanceof Staff)) {
				System.out.println("Client ID: "+c1.getId()+"\tClient Name: "+c1.getName()+"\n");
			}
		}
		for (Client c2 : Clients) {
			if(c2 instanceof Student) {
				student_counter++;
			}
		}
		System.out.println(student_counter+" Student(s)");
		
		for (Client c3 : Clients) {
			if (c3 instanceof Student) { 
				System.out.println("Student ID: "+c3.getId()+"\tStudent Name: "+c3.getName()+"\n");
			}
		}
		for (Client c4 : Clients) {
			if(c4 instanceof Company) {
				company_counter++;
			}
		}
		System.out.println(company_counter+" Company(s)");
		
		for (Client c5 : Clients) {
			if (c5 instanceof Company) { 
				System.out.println("Company ID: "+c5.getId()+"\tCompany Name: "+c5.getName()+"\n");
			}
		}
		for (Client c6 : Clients) {
			if(c6 instanceof Staff) {
				staff_counter++;
			}
		}
		System.out.println(staff_counter+" Staff(s)");
		
		for (Client c7 : Clients) {
			if (c7 instanceof Staff) { 
				System.out.println("Staff ID: "+c7.getId()+"\tStaff Name"+c7.getName()+"\n");
			}
		}
		MainMenu();
	}
	
	public static void report2() { 
		Scanner cia = new Scanner(System.in);
		if (destinations.size() == 0) {
			System.out.println("There are no destinations.\n");
			return;
		}
		System.out.println("All Destinations:\n");
		for (Destination d : destinations) {
			System.out.printf("%s - %s\n", d.getDestCode(), d.getDestName());
		}
		System.out.println("Enter The destination Code: \n");
		String code_dest = cia.next();
		for (Destination d : destinations) { 
			if (d.getDestCode().equalsIgnoreCase(code_dest)) { 
				System.out.println(d.toString());
			}
		}
		MainMenu();
	}
	
	public static void report3() { 
		Scanner sh_de = new Scanner(System.in);
		System.out.println("All Shipments:\n");
		for (Shipment s : shipments) {
			System.out.printf("%s - %s\n", s.getShipmentCode(),s.getShipper().getName());
		}
		System.out.println("Enter the shipment Code: ");
		String code_ship = sh_de.next();
		for ( ShipmentStatus ss : shipmentsStatus) { 
			if(ss.getShipement().getShipmentCode().equalsIgnoreCase(code_ship)) { 
				System.out.println(ss.getShipement().toString());
				System.out.println("Shipping Date: "+ss.getShippingDate());
				System.out.println("Receiving Date: "+ss.getReceivingDate());

			}
		}
		MainMenu();
	}
	
	public static void clientarraytofile(ArrayList<Client> c) {
		FileOutputStream f;
		ObjectOutputStream obj = null;
		try {
			f=new FileOutputStream("ClientsData.dat");
			obj = new ObjectOutputStream(f);
			obj.writeObject(c);
			obj.close();
			f.close();
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	public static void Destarraytofile(ArrayList<Destination> d) {
		FileOutputStream f;
		ObjectOutputStream obj = null;
		try {
			f=new FileOutputStream("DestData.dat");
			obj = new ObjectOutputStream(f);
			obj.writeObject(d);
			obj.close();
			f.close();
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	public static void shiptarraytofile(ArrayList<Shipment> s) {
		FileOutputStream f;
		ObjectOutputStream obj = null;
		try {
			f=new FileOutputStream("ShipData.dat");
			obj = new ObjectOutputStream(f);
			obj.writeObject(s);
			obj.close();
			f.close();
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	public static void statusarraytofile(ArrayList<ShipmentStatus> s) {
		FileOutputStream f;
		ObjectOutputStream obj = null;
		try {
			f=new FileOutputStream("StatusData.dat");
			obj = new ObjectOutputStream(f);
			obj.writeObject(s);
			obj.close();
			f.close();
		}catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void saveandexit() {
		clientarraytofile(Clients);
		Destarraytofile(destinations);
		shiptarraytofile(shipments);
		statusarraytofile(shipmentsStatus);
		System.out.println("Data saved.\nRefresh the page.");	

	}
	public static void report4() {
		int queued = 0;
		for(ShipmentStatus sh : shipmentsStatus ) {
			if (sh.getShipement().getPaymentways() == PaymentWay.PaidTotal) {
				if(sh.getShippingDate()==null) {
					queued++;
					System.out.println("Queued Shipment "+queued+": \n"+"Shipment Code: "+sh.getShipement().getShipmentCode()
							+ "\nRegistration Date:  "+sh.getShipement().getRegistrationDate()
							+"\n"+sh.getShipement().getShipper()
							+"\nShipping Way: "+sh.getShipement().getShippingWay() +"\n");
				}
			}

		}
		MainMenu();

	}
	
	public static void report5() { 
		System.out.print("Here are The Existing Clients: \n");
		for(Client c : Clients) {
			System.out.println(c.toString());
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Client ID: ");
		int id=input.nextInt();
		int count=0;
		for(ShipmentStatus s : shipmentsStatus) {
			if (s.getShipement().getShipper().getId() == id) { 
				count++;
				System.out.println("Here are the Client's Shipments: \n"
						+ "Shipment "+count+": \n" + 
						"Shipment Code: "+s.getShipement().getShipmentCode() +"\n"
						+"Registration Date: "+s.getShipement().getRegistrationDate()+"\n"+
						"Shipment Weight: "+s.getShipement().getWeight()+"\n"+
						"Shipment Cost: "+s.getShipement().getShippingCost()+"\n"+
						"Destination name: "+s.getShipement().getDestination().getDestName()+"\n" +
						"Sending Date: "+s.getShippingDate()+"\n"+
						"Recieving Date: "+s.getReceivingDate());
			}
			
		}
		MainMenu();
	}
	public static void report6() { 
		int income=0;
		for(Shipment s : shipments) {
			income+=s.getShippingCost();
		}
		System.out.println("The company overall income is QAR "+income);
		MainMenu();
	}
	public static void report7() { 
		System.out.println("Here are The Shipments that are sent but not collected yet: ");
		for(ShipmentStatus s : shipmentsStatus) { 
			if(s.getShippingDate() != null && s.getReceivingDate() == null) {
				System.out.println("Shipment Code: "+s.getShipement().getShipmentCode()+
						"\n"+s.getShipement().getShipper());
			}
		}
		MainMenu();
	}
	
	
	public static void report8() {
		ObjectInputStream inF;
		try {
			inF =new ObjectInputStream(new FileInputStream("DestData.dat"));
			Clients = (ArrayList<Client>)inF.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		double fees = 0;
		Scanner cin = new Scanner(System.in);
		System.out.println("Client name: ");
		String name = cin.next();
		for (Client c: Clients) {
			if (c.getName().equalsIgnoreCase(name)) {
				for (Shipment s : shipments) {
					if (s.getShipper().getName().equalsIgnoreCase(name)) {
						System.out.println("do you want to pay via wire transfer? (yes/no");
						String choice = cin.next();
						if (choice.equalsIgnoreCase("yes")) {
						System.out.println("how much additional do you want to pay: ");
						double amount = cin.nextDouble();
						s.addPayment(new WireTransfer(amount));
						fees += amount;
						} else {
							System.out.println("only accepting wire transfer for additional payments");
							MainMenu();
						}
					}
					ObjectOutputStream out;
					try {
						out =new ObjectOutputStream(new FileOutputStream("report8.txt"));
						out.writeChars("client: "+ s.getShipper().getName());
						out.writeChars("Additional fees amount: " + fees +"QAR");
					}catch(IOException e) {
						System.out.println(e);
					}
						
						
				}
			}
		}
		
		MainMenu();
	}
	
	
	
}