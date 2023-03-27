import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    /*ключ для удаления слова*/
    static String number;

    /*числовой ключ для поиска слова*/
    static String numerickey;

    /*для значения (из букв)*/
    static String wordofletters;

    /*для значения (из цифр)*/
    static String wordofnumbers;
    static public Boolean f;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("1 - открыть 1 словарь");
        System.out.println("2 - открыть 2 словарь");
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        dictionary.Read();
        Scanner in = new Scanner(System.in);
        Scanner sr = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    f = false;
                    System.out.println("1 словарь");
                    dictionary.Conclusion();

                    System.out.println("11 - удалить значение по ключу");
                    System.out.println("12 - добавить значение");
                    System.out.println("13 - поиск значения по ключу");
                    break;
                case 11:
                    System.out.println("Введите ключ слова которое вы хотите удалить из 1 словаря");
                    number = in.next();
                    dictionary.Removal();
                    dictionary.Conclusion();
                    break;
                case 12:
                    System.out.println("Введите ключ для слова которое вы хотите добавить в 1 словарь (ключ - пятизначное число)");
                    wordofnumbers = sr.next();
                    System.out.println("Введите само слово (значение - слово из 4 латинских букв)");
                    wordofletters = sr.next();
                    dictionary.ChecktheWord();
                    dictionary.Conclusion();
                    break;
                case 13:
                    System.out.println("Введите ключ слова которое вы хотите найти во 1 словаре");
                    numerickey = scanner.next();
                    dictionary.Search();
                    break;
                case 2:
                    f = true;
                    System.out.println("2 словарь");
                    dictionary.Conclusion();

                    System.out.println("21 - удалить значение по ключу");
                    System.out.println("22 - добавить значение");
                    System.out.println("23 - поиск значения по ключу");
                    break;
                case 21:
                    System.out.println("Введите ключ слова которое вы хотите удалить из 2 словаря");
                    number = in.next();
                    dictionary.Removal();
                    dictionary.Conclusion();
                    break;
                case 22:
                    System.out.println("Введите ключ слова которое вы хотите добавить во 2 словарь (Ключ - слово из 4 латинских букв)");
                    wordofletters = sr.next();
                    System.out.println("Введите само слово (значение - пятизначное число)");
                    wordofnumbers = sr.next();
                    dictionary.ChecktheWord();
                    dictionary.Conclusion();
                    break;
                case 23:
                    System.out.println("Введите ключ слова которое вы хотите найти во 2 словаре.");
                    numerickey = scanner.next();
                    dictionary.Search();
                    break;
                default:
                    System.out.println("Выберите команду из указанного списка");
            }
        }
    }
}

