package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import dao.IAdmin;
import dao.IBooking;
import dao.IMovie;
import model.Booking;
import model.Movie;

@RestController
public class AdminController {

	@Autowired
	IAdmin admin;
	@Autowired
	IMovie movie;
	@Autowired
	IBooking booking;

	@GetMapping("/admin")
	public Iterable<Movie> getAllMovie() {
		return movie.findAll();
	}

	@PostMapping("/admin/movie")
	public String addMovie(@RequestBody Movie m) {
		movie.save(m);
		return "Movie Added";
	}

	@DeleteMapping("/admin/movie/{id}")
	public String deleteMovie(@PathVariable("id") int id) {
		movie.deleteById(id);
		return "Movie deleted";
	}

	@PutMapping("/admin/movie/{id}")
	public String updateMovie(@RequestBody Movie m ,@PathVariable("id") int id) {
		movie.findById(id).map(update -> {
			update.setMovieid(m.getMovieid());
			update.setMoviename(m.getMoviename());
			return movie.save(update);
		});
		return "Movie Updated";
	}

	@GetMapping("/admin/allBooking")
	public Iterable<Booking> getAllBooking() {
		return booking.findAll();
	}
}