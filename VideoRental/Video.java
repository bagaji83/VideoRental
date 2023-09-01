import java.util.Date;

public class Video {
	private final VideoType videoType = new VideoType();
	private final PriceCode priceCode = new PriceCode();
	private String title ;

	private Date registeredDate ;
	private boolean rented ;

	public Video(String title, int videoType, int priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
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

	public void setPriceCode(int priceCode) {
		this.priceCode.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setVideoType(int videoType) {
		this.videoType.videoType = videoType;
	}
}
