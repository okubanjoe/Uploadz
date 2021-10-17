import com.opencsv.CSVParser;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;



public class ParseCsvClass {


    public static List<FirstModel> parseCsvFile(InputStream is) {
        String inpath = "ExcelFiles";

        String[] CSV_HEADER = {"id", "name", "address", "zipcode"};
        Reader fileReader = null;
        CsvToBean<FirstModel> csvToBean = null;

        List<FirstModel> customers = new ArrayList<FirstModel>();

        try {
            fileReader = new InputStreamReader(is);

            ColumnPositionMappingStrategy<FirstModel> mappingStrategy = new ColumnPositionMappingStrategy<FirstModel>();

            mappingStrategy.setType(FirstModel.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            csvToBean = new CsvToBeanBuilder<FirstModel>(fileReader).withMappingStrategy(mappingStrategy).withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true).build();

            customers = csvToBean.parse();

            return customers;
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }

        return customers;
    }

}
