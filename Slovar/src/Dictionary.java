import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary implements InterfaceDict{

        /*для 1 словоря где ключ это цифры*/
        Map<String, String> map_number = new HashMap<>();

        /*для 2 словоря где ключ это буквы*/
        Map<String, String> map_word = new HashMap<>();
        String line;
        String strArray[];

        /*Слово которое мы ищем*/
        String WordSearch;

        public void Read() throws FileNotFoundException {
            String path = "test.txt";
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            /*проходим по всем строкам, возврощает истину если ещё есть строка*/
            while (scanner.hasNextLine())
            {
                line = scanner.nextLine();//берём эту строку
                strArray = line.split(" ");
                map_number.put(strArray[0], strArray[1]);//1 словарь
                map_word.put(strArray[1], strArray[0]);//2 словарь
            }
            scanner.close();//останавливаем поток
        }
        /*вывести*/
        public void Conclusion()
        {
            if (Main.f == false) {
                System.out.println((map_number));
            } else {
                System.out.println((map_word));
            }
        }
        /*удалить*/
        public void Removal()
        {
            if (Main.f == false) {
                map_number.remove(Main.key);
            } else {
                map_word.remove(Main.key);
            }
        }
        /*добавить*/
        public void AddNewWord()
        {
            if (Main.f == false) {
                map_number.put(Main.wordNumbers, Main.wordLetters);
            } else map_word.put(Main.wordLetters, Main.wordNumbers);
        }
        /*Проверка*/
        public void ChecktheWord() {
            Boolean f1 = Main.wordNumbers.matches("\\d{5}");
            Boolean f2 = Main.wordLetters.matches("[a-zA-Z]{4}");
            if (f1 && f2) {
                AddNewWord();
            } else {
                System.out.println("Слово не соответствует указанным требованиям");
            }
        }
        /*поиск*/
        public void Search()
        {
            if (Main.f == false) {
                WordSearch = map_number.get(Main.keyWords);
                System.out.println(WordSearch);
            } else {
                WordSearch = map_word.get(Main.keyWords);
                System.out.println(WordSearch);
            }
        }
}
