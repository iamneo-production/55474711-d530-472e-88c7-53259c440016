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
import dao.IMovie;
import model.Movie;

@RestController
public class AdminController {

	@Autowired
	IAdmin admin;
	@Autowired
	IMovie movie;

	@GetMapping("/admin")
	public Iterable<Movie> getAllMovie() {
		return movie.findAll();
	}

	@PostMapping("/admin/movie")
	public String addMovie(@RequestBody Movie movie) {
		return addMovie(movie);
	}

	@DeleteMapping("/admin/movie/{id}")
	public String deleteMovie(@PathVariable("id") int id) {
		movie.deleteById(id);
		return "Movie deleted";
	}

	@PutMapping("/admin/movie/{id}")
	public String updateMovie(@RequestBody Movie m) {
		movie.findById(m.getMovieid()).map(update -> {
			update.setMovieid(m.getMovieid());
			update.setMoviename(m.getMoviename());
			return movie.save(update);
		});
		return "Updated Movie";
	}

	@GetMapping("/admin/allBooking")
	public Iterable<Movie> getAllOrders() {
		return movie.findAll();
	}
}
