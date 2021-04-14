package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Playlist;
import aiss.model.Song;
import aiss.model.resources.SongResource;


/**
 * Servlet implementation class DeleteContactController
 */
public class SongUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SongUpdateController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SongUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String songId = request.getParameter("songId");
		String playlistId = request.getParameter("playlistId");
		String operation = request.getParameter("operation");
		
		// Song resource
		SongResource sr = new SongResource();

		// Load song being updated
		Song song = sr.getSong(songId);

		// Display update form with song data on it
		if (operation == null) {

			// Log
			log.log(Level.FINE, "Update request for contact with id " + songId + " (name=" + song.getTitle() + "). Forwarding to edit view.");

			// Forward to edit view
			RequestDispatcher rd = request.getRequestDispatcher("/songEditView.jsp?playlistId=" + playlistId);
			request.setAttribute("song", song);
			rd.forward(request, response);

		} else {			
			
			// Update song
			String artist = request.getParameter("artist");
			String title = request.getParameter("title");
			String album = request.getParameter("album");
			String year = request.getParameter("year");
			
			song.setArtist(artist);
			song.setTitle(title);
			song.setAlbum(album);
			song.setYear(year);
			
			sr.updateSong(song);
			
			// Log
			log.log(Level.FINE, "Update request. Artist=" + song.getArtist() + ", Title= " + song.getTitle() + ", Album= " + song.getAlbum() + ", Year= " + song.getYear() + ". Forwarding to contact list view.");

			// Forward to song list view
			request.setAttribute("message", "Song updated successfully");
			request.getRequestDispatcher("/list").forward(request, response);
				
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
