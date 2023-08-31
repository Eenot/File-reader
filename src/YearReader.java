import java.util.ArrayList;
import java.util.List;

public class YearReader {
    FileReader fileReader = new FileReader();
    ArrayList<YearLine> years = new ArrayList<>();

    public YearReader(String path) {
        List<String> lines = fileReader.readFileContents(path);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] things = line.split(",");
            String monthNum = things[0];
            Double amount = Double.parseDouble(things[1]);
            Boolean isExpense = Boolean.parseBoolean(things[2]);
            YearLine yearLine = new YearLine(monthNum,amount,isExpense);
            years.add(yearLine);
        }
    }
}
