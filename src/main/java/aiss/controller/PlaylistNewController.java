package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Playlist;
import aiss.model.resources.PlaylistResource;

/**
 * Servlet implementation class PlaylistNewController
 */
public class PlaylistNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PlaylistNewController.class.getName());
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String name = request.getParameter("name");

		// Add playlist
		PlaylistResource plr = new PlaylistResource();
		Playlist playlist = plr.addPlaylist(new Playlist(name));

		// Log
		log.log(Level.FINE, "New playlist request. name=" + name + ". Forwarding to playlist list view.");

		// Forward to contact list view
		request.setAttribute("message", "Playlist created successfully");
		request.getRequestDispatcher("/list?playlistId=" + playlist.getId()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
