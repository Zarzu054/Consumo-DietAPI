package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.PlaylistResource;

/**
 * Servlet implementation class PlaylistAddSongController
 */
public class PlaylistAddSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PlaylistAddSongController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistAddSongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String songId = request.getParameter("songId");
		String playlistId = request.getParameter("playlistId");
				
		// Add song to playlist
		PlaylistResource plr = new PlaylistResource();
		boolean success = plr.addSong(playlistId, songId);
		
		if (success) {
			request.setAttribute("message", "Song added successfully");
			log.log(Level.FINE, "Song with id=" + songId + " added to playlist with id=" + playlistId + ". Forwarding to playlist list view.");
		}
		else {
			request.setAttribute("message", "The song could not be added");
			log.log(Level.FINE, "The song with id=" + songId + " could not be added to the playlist with id=" + playlistId + ". Perhaps it is duplicated. Forwarding to playlist list view.");
		}
		
		// Forward to contact list view
		request.getRequestDispatcher("/list?playlistId=" + playlistId).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
