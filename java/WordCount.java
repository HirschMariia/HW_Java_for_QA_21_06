import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Integer euismod consequat ante, at mattis sapien rutrum eget. " +
                "Ut nec nisi consequat, viverra diam in, tincidunt mauris. " +
                "Vestibulum posuere, sapien sed tincidunt mattis, mi nisl lobortis orci, " +
                "ac tincidunt ligula sapien nec nunc. Sed suscipit nunc in augue vehicula, " +
                "a efficitur lectus efficitur. Suspendisse ullamcorper ex ut ligula placerat, " +
                "et dignissim arcu suscipit. Duis sit amet vestibulum lacus. " +
                "Vestibulum tempor vehicula purus, vel fringilla lorem eleifend ac.";

        Map<String, Integer> wordCountMap = countWords(text);

        // Выводим результаты
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Шаблон для поиска слов (буквы и цифры, минимум один символ)
        Pattern pattern = Pattern.compile("\\w+");

        // Создаем Matcher для текста
        Matcher matcher = pattern.matcher(text);

        // Итерируемся по всем найденным словам
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Получаем найденное слово и переводим в нижний регистр
            int count = wordCountMap.getOrDefault(word, 0); // Получаем текущее количество для слова или 0, если слово еще не встречалось
            wordCountMap.put(word, count + 1); // Увеличиваем счетчик для слова
        }

        return wordCountMap;
    }
}
