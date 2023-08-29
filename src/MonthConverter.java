

public class MonthConverter {

    String[] months = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь",};

    String numToMonth(Integer number) {
        return months[number-1];
    }

    String numToMonth(String number) {
        int monthNumber = Integer.parseInt(number);
        return months[monthNumber-1];

    }
}
