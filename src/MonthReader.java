import java.util.ArrayList;
import java.util.List;

public class MonthReader {
    FileReader fileReader = new FileReader();
    ArrayList<MonthLine> month = new ArrayList<>();
    public MonthReader(String path) {
        List<String> lines = fileReader.readFileContents(path);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] things = line.split(",");
            String itemName = things[0];
            Boolean isExpense = Boolean.parseBoolean(things[1]);
            Integer quantity = Integer.parseInt(things[2]);
            Double sumOne = Double.parseDouble(things[3]);
            MonthLine monthLine = new MonthLine(itemName,isExpense,quantity,sumOne);
            month.add(monthLine);
        }
    }
}
