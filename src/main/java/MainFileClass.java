import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainFileClass {
    static String inpath = "ExcelFiles";

    public static void main(String[] args) {

        List<String> foundFiles = fileSearches(inpath);

        ParseCsvClass pa = new ParseCsvClass();

        for(String foundList : foundFiles){
            InputStream in = new ByteArrayInputStream(foundList.getBytes());
            pa.parseCsvFile(in);


        }

    }

    public static List<String> fileSearches(String input){
        List<String> fileFound = new ArrayList<>();
        File dir = new File(input);

        try {
            for (File file : dir.listFiles()) {
                if (file.isFile() && (file.getName().toLowerCase().endsWith("csv"))) {
                    fileFound.add(inpath + "\\" + file.getName());
                    System.out.println("Added Name: " + file.getName());
                } else if (file.isDirectory() && !file.isHidden()){
                    System.out.println("Found Directory: "+ file.getName());
                }else if (isRoot(file)){
                }
            }

        } catch (NullPointerException e) {
            e.printStackTrace();

        }
        finally {
            return fileFound;

        }

    }

    private static boolean isRoot(File file){
        File[] roots = File.listRoots();
        for (File root : roots){
            if (file.equals(root)) {
                return true;
            }
        }
        return false;
    }
}
