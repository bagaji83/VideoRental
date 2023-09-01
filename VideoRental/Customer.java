import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);

	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		result += "Total charge: " + getTotalCharge() + "\tTotal Point:" + getTotalPoint() + "\n";


		if (getTotalPoint() >= 10) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if (getTotalPoint() >= 30) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result;
	}


	public double  getTotalCharge() {
		double totalCharge = 0;
		List<Rental> rentals = getRentals();

		for (Rental each : rentals) {
			double eachCharge = 0;
			int daysRented = 0;

			daysRented = Rental.getDaysRented(each);

			switch (each.getVideo().getPriceCode()) {
				case PriceCode.REGULAR:
					eachCharge += 2;
					if (daysRented > 2)
						eachCharge += (daysRented - 2) * 1.5;
					break;
				case PriceCode.NEW_RELEASE:
					eachCharge = daysRented * 3;
					break;
			}

			totalCharge += eachCharge;
		}
		return totalCharge;
	}

	public int getTotalPoint() {
		int totalPoint = 0;
		List<Rental> rentals = getRentals();

		for (Rental each : rentals) {
			int eachPoint = 0 ;
			int daysRented = 0;

			daysRented = Rental.getDaysRented(each);

			eachPoint++;

			if ((each.getVideo().getPriceCode() == PriceCode.NEW_RELEASE) )
				eachPoint++;

			if ( daysRented > each.getDaysRentedLimit() )
				eachPoint -= Math.min(eachPoint, each.getVideo().getLateReturnPointPenalty()) ;

			totalPoint += eachPoint ;
		}
		return totalPoint;
	}

	public void returnVideo(String videoTitle) {
		List<Rental> rentals = getRentals();
		for (Rental rental : rentals) {
			if (rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented()) {
				rental.returnVideo();
				rental.getVideo().setRented(false);
			}
		}
	}
}
