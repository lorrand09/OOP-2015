package javasmmr.zoosome.models.animals;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

public class Crocodile extends Reptile implements Runnable {
	private String[] dateComp;
	private String[] timeComp;

	public Crocodile() {
		this(4, "Crocodile", 0.6, 0.6, false, true);
	}

	public Crocodile(int nrOfLegs, String name, double maintenanceCost, double dangerPerc, boolean takenCareOf,
			boolean laysEggs) {
		super(nrOfLegs, name, maintenanceCost, dangerPerc, takenCareOf, laysEggs);
	}

	// Interface method implementation.
	// It returns true if the entity interacting with our animal gets killed.
	public boolean kill() {
		double percent = Math.random();
		percent += getPredisposition() * percent;
		return (percent < this.getDangerPerc());

	}

	// Twist 1 Interfaces
	// Used to decompose the date and time.
	private void getDateComponents(String dateOutput) {
		String date = dateOutput;
		date.trim();
		String[] dateComp = date.split(" ");
		dateComp[1] = dateComp[1].substring(0, 2);
		this.dateComp = dateComp;

	}

	private void getTimeComponents(String timeOutput) {
		String time = timeOutput;
		time.trim();
		String[] timeC = time.split(":");
		String[] aux = timeC[2].split(" ");
		String[] timeComp = new String[] { timeC[0], timeC[1], aux[0], aux[1] };
		this.timeComp = timeComp;
	}

	public void run() {
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		DateFormat dateFormatter;
		String timeOutput, dateOutput;
		// Creates a new Date object that contains information about date and
		// time.
		rightNow = new Date();
		// Creates time formats depending on location.
		currentLocale = new Locale("en", "UK");
		/*
		 * DateFormat allows us to define date/time using predefined styles like
		 * DEFAULT,SHORT,MEDIUM,LONG,FULL. getTimeInstance just outputs time
		 * information.
		 */
		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
		// getDateInstance just outputs date information.
		dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
		// Converts date and time into Strings.
		timeOutput = timeFormatter.format(rightNow);
		dateOutput = dateFormatter.format(rightNow);
		this.getTimeComponents(timeOutput);
		this.getDateComponents(dateOutput);

		// We must wrap the sleep method in the error handling code to catch the
		// InterruptedException exception.
		try {
			// In this case the sleep method will stop the thread for 0.5
			// seconds.
			Thread.sleep(500);
		} catch (InterruptedException e) {

		} finally {
		}

	}

	@Override
	public double getPredisposition() {
		this.run();
		int hour = Integer.parseInt(timeComp[0]);
		String meridian = timeComp[3];
		String month = dateComp[0];
		if (((hour >= 11) && month.equalsIgnoreCase("PM")) && ((hour <= 6) && meridian.equalsIgnoreCase("AM"))) {
			return 0.30;
		} else if (month.equalsIgnoreCase("Jun")) {
			return 0.30;
		} else {
			return 0.0;
		}
	}
}