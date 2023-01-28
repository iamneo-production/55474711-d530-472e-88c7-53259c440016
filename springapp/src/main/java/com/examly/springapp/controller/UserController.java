package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IBooking;
import dao.ILogin;
import dao.IMovie;
import dao.IUser;
import model.Booking;
import model.Login;
import model.Movie;
import model.User;

@RestController
public class UserController {
	@Autowired
	IUser user;
	@Autowired
	IMovie movie;
	@Autowired
	IBooking booking;
	@Autowired
	ILogin login;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Movie Application";
	}

	@PostMapping("/login")
	public String login(@RequestBody Login l) {
		if (login.findById(l.getUsername()).get().getPassword().contains(l.getPassword())) {
			return "true";
		} else
			return "false";
	}

	@PostMapping("/signup")
	public Boolean singup(@RequestBody User u) {
		try {
			user.save(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/allMovie")
	public Iterable<Movie> allMovie() {
		return movie.findAll();
	}

	@GetMapping("/movie/{id}")
	public String searchMovie(@PathVariable("id") int id) {
		return movie.findById(id).get().getMoviename();
	}

	@PostMapping("/book")
	public String bookMyMovie(@RequestBody Booking m) {
	   booking.save(m);
		return "Movie Booked";
	}

	@GetMapping("/allBooking")
	public List<Booking> viewBookingDetails() {
		return booking.findAll();
	}

	@DeleteMapping("cancelBooking/{id}")
	public String cancelBooking(@PathVariable("id") int id) {
		booking.deleteById(id);
		return "Booking Cancelled";
	}
}