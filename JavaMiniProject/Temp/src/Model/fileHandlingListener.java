package Model;

import java.util.ArrayList;

abstract class fileHandlingListener {

    int Listeners_age;
    abstract public ArrayList<Listener> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Listener> listeners);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
