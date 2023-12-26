package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageListener extends fileHandlingListener implements Displayable {
    ArrayList<Listener> listeners = new ArrayList<Listener>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    public ArrayList<Listener> loadJsonFile(String file_path) {
        return readJsonFile("C:\\Users\\Gautam\\Desktop\\JavaMiniProject\\Temp\\src\\Model\\listeners.json");
    }

    public manageListener(){
        readJsonFile("C:\\Users\\Gautam\\Desktop\\JavaMiniProject\\Temp\\src\\Model\\listeners.json");
    }

    public ArrayList<Listener> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String name = node.get("name").asText();
                    long mobile_no = node.get("mobile_no").asLong();
                    String email = node.get("email").asText();
                    String gender = node.get("gender").asText();
                    String favourite_genre = node.get("favourite_genre").asText();
                    String favourite_artist = node.get("favourite_artist").asText();

                    Listener invest = new Listener(id, name,mobile_no,email,  gender, favourite_genre, favourite_artist);
                    listeners.add(invest);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listeners;
    }

    @Override
    public void writeJsonFile(ArrayList<Listener> listeners) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < listeners.size(); i++)
            {
                // Converting the Java object into a JSON string
                String invest_str = Obj.writeValueAsString(listeners.get(i));
                // Displaying Java object into a JSON string
                System.out.println(invest_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Mobile No");
        headers.add("Email");
        headers.add("Gender");
        headers.add("Favourite Genre");
        headers.add("Favourite Artist");


        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the investors list and then extracts the various attributes of the student such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> investor_details = new ArrayList<String>();

        investor_details.add(String.valueOf(listeners.get(line).getId()));
        investor_details.add(listeners.get(line).getName());
        investor_details.add(String.valueOf(listeners.get(line).getMobileNo()));

        investor_details.add(listeners.get(line).getEmail());
        investor_details.add(listeners.get(line).getGender());
        investor_details.add(listeners.get(line).getFavourite_genre());

        investor_details.add(listeners.get(line).getFavourite_artist());

        return investor_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> investors_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            investors_subset.add(getLine(i));
        }
        return investors_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }
    public ArrayList getTable() {
        return listeners;
    }

}

