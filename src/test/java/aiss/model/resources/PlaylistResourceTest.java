package aiss.model.resources;

import static org.junit.Assert.*;

import java.util.Collection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.Playlist;
import aiss.model.Song;

public class PlaylistResourceTest {

	static Playlist playlist, playlist2, playlist3, playlist4;
	static Song song;
	static PlaylistResource plr = new PlaylistResource();
	static SongResource sr = new SongResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		playlist = plr.addPlaylist(new Playlist("Test list 1"));
		playlist2 = plr.addPlaylist(new Playlist("Test list 2"));
		playlist3 = plr.addPlaylist(new Playlist("Test list 3"));
		
	
		song = sr.addSong(new Song("Test title","Test artist","Test album","2016"));
		if(song!=null)
			plr.addSong(playlist.getId(), song.getId());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		plr.deletePlaylist(playlist.getId());
		plr.deletePlaylist(playlist3.getId());
		plr.deletePlaylist(playlist4.getId());
		if(song!=null)
			sr.deleteSong(song.getId());
	}

	@Test
	public void testGetAll() {
		Collection<Playlist> playlists = plr.getAll(); 
		
		assertNotNull("The collection of playlists is null", playlists);
		
		// Show result
		System.out.println("Listing all playlists:");
		int i=1;
		for (Playlist pl : playlists) {
			System.out.println("Playlist " + i++ + " : " + pl.getName() + " (ID=" + pl.getId() + ")");
		}
		
	}

	@Test
	public void testGetPlaylist() {
		Playlist p = plr.getPlaylist(playlist.getId());
		
		assertEquals("The id of the playlists do not match", playlist.getId(), p.getId());
		assertEquals("The name of the playlists do not match", playlist.getName(), p.getName());
		
		// Show result
		System.out.println("Playlist id: " +  p.getId());
		System.out.println("Playlist name: " +  p.getName());

	}

	@Test
	public void testAddPlaylist() {
		String playlistName = "Add playlist test title";
		String playlistDescription = "Add playlist test description";
		
		playlist4 = plr.addPlaylist(new Playlist(playlistName,playlistDescription));
		
		assertNotNull("Error when adding the playlist", playlist4);
		assertEquals("The playlist's name has not been setted correctly", playlistName, playlist4.getName());
		assertEquals("The playlist's description has not been setted correctly", playlistDescription, playlist4.getDescription());
	}

	@Test
	public void testUpdatePlaylist() {
		String playlistName = "Updated playlist name";

		// Update playlist
		playlist.setName(playlistName);

		boolean success = plr.updatePlaylist(playlist);
		
		assertTrue("Error when updating the playlist", success);
		
		Playlist pl  = plr.getPlaylist(playlist.getId());
		assertEquals("The playlist's name has not been updated correctly", playlistName, pl.getName());

	}

	@Test
	public void testDeletePlaylist() {
		boolean success = plr.deletePlaylist(playlist2.getId());
		assertTrue("Error when deleting the playlist", success);
		
		Playlist pl = plr.getPlaylist(playlist2.getId());
		assertNull("The playlist has not been deleted correctly", pl);
	}

	@Test
	public void testAddSong() {
		if(song!=null) {
			boolean success = plr.addSong(playlist3.getId(), song.getId());
			assertTrue("Error when adding the song", success);
		}
	}

	@Test
	public void testRemoveSong() {
		//TODO
	}

}
