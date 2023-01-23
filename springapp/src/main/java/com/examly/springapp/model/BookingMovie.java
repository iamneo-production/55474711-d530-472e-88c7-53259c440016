package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookingMovie {
	@Id
	private int bookingid;
	private int dateofbooking;
	private int timeofbooking;
	private int movieid;
	private String moviename;
	private int userid;
	private String username;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getDateofbooking() {
		return dateofbooking;
	}
	public void setDateofbooking(int dateofbooking) {
		this.dateofbooking = dateofbooking;
	}
	public int getTimeofbooking() {
		return timeofbooking;
	}
	public void setTimeofbooking(int timeofbooking) {
		this.timeofbooking = timeofbooking;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
