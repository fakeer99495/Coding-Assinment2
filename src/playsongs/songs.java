package playsongs;

import java.util.*;

public class songs {

	
		static class Song {
		    private String name;

		    public Song(String name) {
		        this.name = name;
		    }

		    public String getName() {
		        return name;
		    }
		}

		static class RecentlyPlayedStore {
		    private int capacity;
		    private Map<String, Deque<Song>> store;

		    public RecentlyPlayedStore(int capacity) {
		        this.capacity = capacity;
		        this.store = new HashMap<>();
		    }

		    public void addRecentlyPlayed(String user, Song song) {
		        if (!store.containsKey(user)) {
		            store.put(user, new LinkedList<>());
		        }

		        Deque<Song> userSongs = store.get(user);

		        if (userSongs.size() >= capacity) {
		            userSongs.removeLast();
		        }

		        userSongs.addFirst(song);
		    }

		    public List<String> getRecentlyPlayed(String user) {
		        if (!store.containsKey(user)) {
		            return Collections.emptyList();
		        }

		        Deque<Song> userSongs = store.get(user);
		        List<String> recentlyPlayed = new ArrayList<>();

		        for (Song song : userSongs) {
		            recentlyPlayed.add(song.getName());
		        }

		        return recentlyPlayed;
		    }
		}

		
		    public static void main(String[] args) {
		        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
		        Song s1 = new Song("S1");
		        Song s2 = new Song("S2");
		        Song s3 = new Song("S3");
		        Song s4 = new Song("S4");

		        store.addRecentlyPlayed("User", s1);
		        store.addRecentlyPlayed("User", s2);
		        store.addRecentlyPlayed("User", s3);

		        List<String> userSongs = store.getRecentlyPlayed("User");
		        System.out.println("User's Recently Played Songs: " + userSongs);

		        store.addRecentlyPlayed("User", s4);
		        userSongs = store.getRecentlyPlayed("User");
		        System.out.println("User's Recently Played Songs: " + userSongs);

		        store.addRecentlyPlayed("User", s2);
		        userSongs = store.getRecentlyPlayed("User");
		        System.out.println("User's Recently Played Songs: " + userSongs);

		        store.addRecentlyPlayed("User", s1);
		        userSongs = store.getRecentlyPlayed("User");
		        System.out.println("User's Recently Played Songs: " + userSongs);
		    }
		
	

	




	}


