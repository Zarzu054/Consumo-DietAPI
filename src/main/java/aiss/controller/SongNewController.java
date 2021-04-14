package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Song;
import aiss.model.resources.PlaylistResource;
import aiss.model.resources.SongResource;


/**
 * Servlet implementation class ContactNewController
 */
public class SongNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SongUpdateController.class.getName());
	
    public SongNewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String artist = request.getParameter("artist");
		String title = request.getParameter("title");
		String album = request.getParameter("album");
		String year = request.getParameter("year");
		String playlistId = request.getParameter("playlistId");
		
		// Create song
		SongResource sr = new SongResource();
		Song song = sr.addSong(new Song(title, artist, album, year));
		
		// Add song to the playlist
		PlaylistResource plr = new PlaylistResource();
		plr.addSong(playlistId, song.getId());

		// Log
		log.log(Level.FINE, "New song request. artist=" + artist + ", title= " + title + ", album= " + album + ", year= " + year +". Forwarding to playlist list view.");

		// Forward to contact list view
		request.setAttribute("message", "Song created successfully");
		request.setAttribute("playlistId", playlistId);
		request.getRequestDispatcher("/list").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
