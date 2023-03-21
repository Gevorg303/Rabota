import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
    static String num;//ключ для удаления слова
    static String numsearch;//числовой ключ для поиска слова
    static String words;//для значения (из букв)
    static String words2;//для значения (из цифр)
    static public Boolean f;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("1 - открыть 1 словарь");
        System.out.println("2 - открыть 2 словарь");
        Scanner scanner = new Scanner(System.in);
        Dictionary.Read();
        Scanner in = new Scanner(System.in);
        Scanner sr = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    f=false;
                    System.out.println("1 словарь");
                    Dictionary.Vivod1();

                    System.out.println("11 - удалить слово по ключу");
                    System.out.println("12 - добавить слово (слово должно состоять из 4 букв латинского алфавита!)");
                    System.out.println("13 - поиск слова по ключу");
                    break;
                    case 11:
                        System.out.println("Введите ключ слова которое вы хотите удалить из 1 словаря");
                        num = in.next();
                        Dictionary.removal();
                        Dictionary.Vivod1();
                        break;
                    case 12:
                        System.out.println("Введите слова которое вы хотите добавить в 1 словарь");
                        words = sr.next();
                        Dictionary.checktheword();
                        Dictionary.Vivod1();
                        break;
                    case 13:
                        System.out.println("Введите ключ слова которое вы хотите найти во 1 словаре");
                        numsearch = scanner.next();
                        Dictionary.search();
                        break;
                case 2:
                    f=true;
                    System.out.println("2 словарь");
                    Dictionary.Vivod1();

                    System.out.println("21 - удалить слово по ключу");
                    System.out.println("22 - добавить слово (слово должно состоять из 4 букв латинского алфавита!)");
                    System.out.println("23 - поиск слова по ключу");
                    break;
                    case 21:
                        System.out.println("Введите ключ слова которое вы хотите удалить из 2 словаря");
                        num = in.next();
                        Dictionary.removal();
                        Dictionary.Vivod1();
                        break;
                    case 22:
                        System.out.println("Введите слова которое вы хотите добавить во 2 словарь");

                        words2 = sr.next();
                        Dictionary.checktheword();
                        Dictionary.Vivod1();
                        break;
                    case 23:
                        System.out.println("Введите ключ слова которое вы хотите найти во 2 словаре.");
                        numsearch = scanner.next();
                        Dictionary.search();
                        break;
                default:
                    System.out.println("Выберите команду из указанного списка");
            }
        }
    }
}
class Dictionary {
    static Map<String, String> map = new HashMap<>();//для 1 словоря
    static Map<String, String> map2 = new HashMap<>();//для 2 словоря
    static String line;//1 значение
    static String str;//2 значение
    static int randomNum;
    public static void Read() throws FileNotFoundException {
        String path = "C:\\Users\\Gev\\Desktop\\test.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine())//проходим по всем строкам, возврощает истину если ещё есть строка
        {
            line = scanner.nextLine();//берём эту строку
            randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);//генерируем ключи
            str = Integer.toString(randomNum);
            map.put(str, line);//1 словарь
            map2.put(line, str);//2 словарь
        }
        scanner.close();//останавливаем поток
    }

    public static void Vivod1()//вывести
    {
        if(Main.f==false)
        {System.out.println((map));}
        else {System.out.println((map2));}
    }
    public static void removal ()//удалить
    {
        if(Main.f==false)
        {map.remove(Main.num);}
        else {map2.remove(Main.num);}
    }
    public static void addnewword()//добавить
    {
        randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);//генерируем ключи
        str = Integer.toString(randomNum);
        if(Main.f==false)
        {map.put(str, Main.words);}
        else map2.put(Main.words, str);
    }
    public static void checktheword()
    {
        int z = Main.words.length();

        if (z==4 )
        {
            addnewword();
        }
        else
        {
            System.out.println("Слово не соответствует указанным требованиям");
        }
    }
    static String lidiaName;//Слово которое мы ищем
    public static void search()//поиск
    {
        if(Main.f==false)
        {lidiaName = map.get(Main.numsearch);
        System.out.println(lidiaName);}
        else
        {
            lidiaName = map2.get(Main.numsearch);
            System.out.println(lidiaName);
        }
    }
}
