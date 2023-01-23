package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IMovie;
import dao.IUser;
import model.Movie;
import model.User;

@RestController
public class UserController {

	@Autowired
	IUser user;
	@Autowired
	IMovie movie;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Data CRUD Repository";
	}
	@PostMapping("/login")
	public String login(@RequestBody User u) {
		 if(user.findById(u.getUsername()).get().getPassword().contains(u.getPassword())) {
			 return "true";
		 }else
			 return "false";
	}


	@PostMapping("/signup")
	public Boolean singup(@RequestBody User u) {
		try {
			user.save(u);
		return true;
	}catch(Exception e) {
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
	public String bookMyMovie(@RequestBody Movie m) {
		movie.save(m);
		return "Movie Booked";
	}
	

	@GetMapping("/allBooking")
	public Iterable<Movie> allBooking() {
		return movie.findAll();
	}

	@DeleteMapping("cancelBooking/{id}")
	public String cancelBooking(@PathVariable("id") int id) {
		movie.deleteById(id);
		return "Booking Cancelled";
	}

}
