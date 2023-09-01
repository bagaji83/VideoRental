import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public int getDaysRented() {
		int daysRented;
		long diff = ((getStatus() == 1 ? getReturnDate().getTime() : new Date().getTime()));
		diff -= getRentDate().getTime();
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		return daysRented;
	}

	public Video getVideo() {
		return video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;

		daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		switch ( video.getVideoType() ) {
			case VideoType.VHS: limit = 5 ; break ;
			case VideoType.CD: limit = 3 ; break ;
			case VideoType.DVD: limit = 2 ; break ;
		}
		return limit ;
	}

	public int calRentalPoint() {
		int eachPoint = 0 ;
		int daysRented = 0;

		daysRented = getDaysRented();

		eachPoint++;

		if ((getVideo().getPriceCode() == PriceCode.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty()) ;

		return eachPoint;
	}

	public double calRentalCharge() {
		double eachCharge = 0;
		int daysRented = 0;

		daysRented = Rental.getDaysRented();

        switch (getVideo().getPriceCode()) {
            case PriceCode.REGULAR -> {
                eachCharge += 2;
                if (daysRented > 2)
                    eachCharge += (daysRented - 2) * 1.5;
            }
            case PriceCode.NEW_RELEASE -> eachCharge = daysRented * 3;
        }
		return eachCharge;
	}
}
