package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageSongs {
    ArrayList<Songs> songs = new ArrayList<Songs>();
    public ArrayList<Songs> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }
    public ArrayList<Songs> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String song_name = node.get("song_name").asText();
                    String song_desc = node.get("song_desc").asText();
                    String artist_name = node.get("artist_name").asText();
                    int song_duration = node.get("song_duration").asInt();
                    Songs temp_songs = new Songs();
                    temp_songs.setId(id);
                    temp_songs.setSongName(song_name);
                    temp_songs.setSongDescription(song_desc);
                    temp_songs.setSongArtist(artist_name);
                    temp_songs.setSongDuration(song_duration);
                    songs.add(temp_songs);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return songs;
    }
}
