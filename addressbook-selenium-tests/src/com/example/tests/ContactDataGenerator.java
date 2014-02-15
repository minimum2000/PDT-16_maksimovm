package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.example.fw.ApplicationManager;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	static protected ApplicationManager app;
	
	public static void main(String[] args) throws IOException {
		if (args.length <3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remote it manually:" + file);
			return;
		}
		
		String configFile = System.getProperty("configFile", "application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File(configFile)));
        app = new ApplicationManager(properties);
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + ","
		+ contact.getAddress() + "," + contact.getHomePhone() + "," + contact.getMobilePhone()
		+ "," + contact.getWorkPhone() + "," + contact.getFirstEmail() + "," + contact.getSecondaryEmail() + "," + contact.getBirthDay() 
		+ "," + contact.getBirthMonth() + "," + contact.getBirthYear() + contact.getGroupSelect() + "," + contact.getSecondaryAddress()
		+ contact.getHomeField() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(part[0])
		  	.withLastName(part[1])
		  	.withAddress(part[2])
		  	.withHomePhone(part[3])
		  	.withMobilePhone(part[4])
		  	.withWorkPhone(part[5])
			.withFirstEmail(part[6])
		  	.withSecondaryEmail(part[7])
		  	.withBirthDay(part[8])
		  	.withBirthMonth(part[9])
		  	.withBirthYear(part[10])
		  	.withGroupSelect(part[11])
		  	.withSecondaryAddress(part[12])
		  	.withHomeField(part[13]);
			list.add(contact);
		  	line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
			.withAddress(generateRandomString())
		  	.withBirthDay(generateRandomBirthDay())
		  	.withBirthMonth(generateRandomBirthMonth())
		  	.withBirthYear(generateRandomString())
		  	.withFirstEmail(generateRandomString())
		  	.withFirstName(generateRandomString())
		  	.withGroupSelect(generateRandomGroupSelect())
		  	.withHomeField(generateRandomString())
		  	.withHomePhone(generateRandomString())
		  	.withLastName(generateRandomString())
		  	.withMobilePhone(generateRandomString())
		  	.withSecondaryAddress(generateRandomString())
		  	.withSecondaryEmail(generateRandomString())
		  	.withWorkPhone(generateRandomString());
			list.add(contact);
		}
		return list;
	}
	
	public static String generateRandomString() {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			 return "";
		  } else {
		  return "test" + rnd.nextInt();
		  }
	  }
	public static String generateRandomBirthDay() {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "-";
		  } else {
			  return Integer.toString(rnd.nextInt(31) + 1);
		  }
	  }
	  
	  public static String generateRandomBirthMonth() {
		  String[] month = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "-";
		  } else {
			  return month[rnd.nextInt(month.length)];
		  }
	  }
	  
	  public static String generateRandomGroupSelect() {
		  app.navigateTo().groupsPage();
		  List<GroupData> groups = app.getModel().getGroups();
		  int listSize = groups.size();
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "[none]";
		  } else {
			  int randomIndex = rnd.nextInt(listSize);
			  GroupData randomGroup = groups.get(randomIndex);
			  return randomGroup.getName();
		  }
	  }
}
