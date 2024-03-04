/*1. Валидатор номера телефона/
Написать программу validatePhoneNumber. Принимать строку со значением номера телефона
(на твоё усмотрение: с консоли или на вход метода из main), на выход возвращать строку форматированный номер телефона
в формате "+7...". В номере должно быть строго 10 символов, исключая "+7" (т.е. в сумме 12 символов). Если номер начинается
с "8", "7" или не имеет префикса вообще, то приводить номер к нужному виду. Если количество символов не совпадает с нужным,
выводить в консоль ошибку "Неверный формат номера!" и завершать программу.*/
public class Main {
    public static void main(String[] args) {
        String initialNumber = "+79935602052";
        validatePhoneNumber(initialNumber);
    }

    public static void validatePhoneNumber(String number) {
        String[] N = new String[4];
        if (N.length != 4) {
            System.out.println("Неверный формат!");
        }
        if (number.startsWith("+7")) {
            number = number.replace("+7", "8");
        }
        if (number.length() != 11) {
            N[0] = "Введен некорректный номер";
            if (N[1] == null) {
                N[1] = "Сумма символов не равна 11";
            } else {
                if (N[2] == null) {
                    N[2] = "Сумма символов не равна 11";
                } else {
                    N[3] = "Сумма символов не равна 11";
                }
            }
        } else {
            N[0] = number;
            N[3] = null;
        }
        // Проверка наличия скобок и пробелов
        if (number.contains("(") || number.contains(")") || number.contains(" ")) {
            number = number.replace("(", "");
            number = number.replace(")", "");
            number = number.replace(" ", "");
            if (N[1] == null) {
                N[1] = "В номере есть пробелы и/или скобки";
            } else {
                N[2] = "В номере есть пробелы и/или скобки";
            }
        }

        System.out.println(N[0]);
        if (N[1] != null) { //Вывод сообщений об изменениях
            for (int i = 1; i < N.length; i++) {
                if (N[i] != null) {
                    System.out.print(N[i]);
                }
                if (i == N.length - 1) {
                    break;
                } else {
                    if (N[i + 1] != null) {
                        System.out.print("; ");
                    }
                }
            }
        }
    }
}