import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String initialNumber = "79935602052";
        validatePhoneNumber(initialNumber);
        checkTelNumber(initialNumber);
        validatePhoneNumber2(initialNumber);
    }
    // здесь я пробую работать с регулярнымы выражениями
    public static String validatePhoneNumber(String initialNumber) {
        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(initialNumber);
        if (initialNumber.startsWith("8")) {
            initialNumber = initialNumber.replaceFirst("8", "+7"); //приводим номер к заданному формату
        }
        if (initialNumber.startsWith("9")) {
            initialNumber = initialNumber.replaceFirst("9", "+79"); //приводим номер к заданному формату
        }
        if (initialNumber.startsWith("7")) {
            initialNumber = initialNumber.replaceFirst("7", "+7"); //приводим номер к заданному формату
        }
        if (matcher.matches()) {
            System.out.println("Номер телефона: " + initialNumber);
        }
        else {
            System.out.println("Неверный формат номера!");
        }
        return initialNumber;
    }

    // здесь я пробую усложнять регулярные выражения)))
    public static String checkTelNumber(String initialNumber) {
        String temp = initialNumber;
        int length = temp.replaceAll("\\D", "").length();
        if (initialNumber.contains("[a-aA-Z]")) { //номер не содержит букв
            System.out.println("Неверный формат номера!");;
        }
        if (initialNumber.startsWith("8")) {
            initialNumber = initialNumber.replace("8", "+7"); //приводим номер к заданному формату
        }
        if (initialNumber.startsWith("9")) {
            initialNumber = initialNumber.replaceFirst("9", "+79"); //приводим номер к заданному формату
        }
        if (initialNumber.startsWith("7")) {
            initialNumber = initialNumber.replaceFirst("7", "+7"); //приводим номер к заданному формату
        }
        if (length==12) {
            initialNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$"); //если номер начинается с '+', то он содержит 12 цифр
        }
        else if (length==10) {
            initialNumber.matches("^(\\d|\\(\\d{3}\\))\\d*(\\-?\\d+)?\\-?\\d*\\d$"); //если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        }

        System.out.println(initialNumber);
        return initialNumber;

    }
    // здесь я пытаюсь оптимизировать код, убрав оператор if...
    public static String validatePhoneNumber2(String initialNumber) {
        Pattern pattern = Pattern.compile("^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$");
        Matcher matcher = pattern.matcher(initialNumber);
        Matcher first = pattern.matcher("8");
        String value = first.replaceFirst(" +7 ");
        System.out.println(initialNumber);
        return initialNumber;
    }
}
