package Model;

import java.util.ArrayList;

abstract class fileHandlingSongs {
    abstract public ArrayList<Songs> readJsonFile(String file_path);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);
}