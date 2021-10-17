import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class FirstModel {

    @CsvBindByName(column = "id")
    private String id;
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "address")
    private String address;
    @CsvBindByName(column = "zipcode")
    private String zipcode;
}
