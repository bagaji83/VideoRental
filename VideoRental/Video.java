import java.util.Date;

public class Video {
	private final VideoType videoType = new VideoType();
	private final PriceCode priceCode = new PriceCode();
	private String title ;

	private Date registeredDate ;
	private boolean rented ;

	public Video(String title, int videoType, int priceCode, Date registeredDate) {
		this.title = title;
		this.videoType.videoType = videoType;
		this.priceCode.priceCode = priceCode;
		this.registeredDate = registeredDate ;
	}

	public int getLateReturnPointPenalty() {
		int pentalty = 0 ;
		switch (videoType.videoType) {
			case VideoType.VHS: pentalty = 1 ; break ;
			case VideoType.CD: pentalty = 2 ; break ;
			case VideoType.DVD: pentalty = 3 ; break ;
		}
		return pentalty ;
	}
	public int getPriceCode() {
		return priceCode.priceCode;
	}

	public String getTitle() {
		return title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public int getVideoType() {
		return videoType.videoType;
	}
}
