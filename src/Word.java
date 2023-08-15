import java.util.Random;

public class Word {

    private final String[] words = new String[] {"компьютер", "устье", "город", "жилище", "цветок", "книга",
            "ночлег", "глаза", "звучанье", "полчище", "день", "грусть", "ящерица", "столешница", "кустарник",
            "лесополоса", "мореплаватель", "листва", "ветер", "парковка", "берега", "газопровод", "метро", "бабушка",
            "муравей", "пламя", "труба", "корабль", "солнце", "песок", "плита", "дверь", "звезда",
            "радость", "трава", "крыша", "камень", "слово", "глубина", "радуга", "человек", "мечта",
            "земля", "дерево", "солнце", "дорога", "слово", "слеза", "зерно", "минута",
             "звонок", "мороз", "космос", "полет", "закат", "факел", "церковь",  "жизнь",
            "пламя", "живот", "любовь", "крестница", "колокольчик", "кружка", "воздух", "кухня", "полоса",
            "волна", "крест", "карандаш", "страсть", "подарок", "карандаш", "ветвь", "корень"};

    public String getWord() {
        return words[new Random().nextInt(words.length)];
    }
}
