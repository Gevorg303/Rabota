import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    /*ключ для удаления слова*/
    static String key;

    /*числовой ключ для поиска слова*/
    static String keyWords;

    /*для значения (из букв)*/
    static String wordLetters;

    /*для значения (из цифр)*/
    static String wordNumbers;
    static public Boolean f;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("1 - открыть 1 словарь");
        System.out.println("2 - открыть 2 словарь");

        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        dictionary.Read();
        Scanner in = new Scanner(System.in);
        Scanner sr = new Scanner(System.in);
        try {
            while (true) {
                int choice = scanner.nextInt();
                switch (choice) {

                    case 1:
                        f = false;
                        System.out.println("Вы открыли 1 словарь, выберите команду из указаного списка");
                        dictionary.Conclusion();
                        menu1();
                        break;
                        case 11:
                            System.out.println("Введите ключ слова которое вы хотите удалить из 1 словаря");
                            key = in.next();
                            dictionary.Removal();
                            dictionary.Conclusion();
                            menu1();
                            break;
                        case 12:
                            System.out.println("Введите ключ для слова которое вы хотите добавить в 1 словарь (ключ - пятизначное число)");
                            wordNumbers = sr.next();
                            System.out.println("Введите само слово (значение - слово из 4 латинских букв)");
                            wordLetters = sr.next();
                            dictionary.ChecktheWord();
                            dictionary.Conclusion();
                            menu1();
                            break;
                        case 13:
                            System.out.println("Введите ключ слова которое вы хотите найти во 1 словаре");
                            keyWords = scanner.next();
                            dictionary.Search();
                            menu1();
                            break;
                    case 2:
                        f = true;
                        System.out.println("Вы открыли 2 словарь, выберите команду из указаного списка");
                        dictionary.Conclusion();
                        menu2();
                        break;
                        case 21:
                            System.out.println("Введите ключ слова которое вы хотите удалить из 2 словаря");
                            key = in.next();
                            dictionary.Removal();
                            dictionary.Conclusion();
                            menu2();
                            break;
                        case 22:
                            System.out.println("Введите ключ слова которое вы хотите добавить во 2 словарь (Ключ - слово из 4 латинских букв)");
                            wordLetters = sr.next();
                            System.out.println("Введите само слово (значение - пятизначное число)");
                            wordNumbers = sr.next();
                            dictionary.ChecktheWord();
                            dictionary.Conclusion();
                            menu2();
                            break;
                        case 23:
                            System.out.println("Введите ключ слова которое вы хотите найти во 2 словаре.");
                            keyWords = scanner.next();
                            dictionary.Search();
                            menu2();
                            break;
                    default:
                        System.out.println("Выбрана неверная команда. Будьте внимательней!");
                        System.out.println("1 - открыть 1 словарь");
                        System.out.println("2 - открыть 2 словарь");
                }
            }
        } catch (Exception e) {
            System.out.println("Введено некоретное значение");
        }
    }
    public static void menu1(){
        System.out.println("11 - удалить значение по ключу");
        System.out.println("12 - добавить значение");
        System.out.println("13 - поиск значения по ключу");
    }
    public static void menu2(){
        System.out.println("21 - удалить значение по ключу");
        System.out.println("22 - добавить значение");
        System.out.println("23 - поиск значения по ключу");
    }
}

