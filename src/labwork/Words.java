package labwork;
import java.io.Serializable;
import java.util.ArrayList;

public class Words implements Serializable {
    private String [] words;
    private int count;

    // Конструктор с параметрами
    public Words(String stringOfWords, String splitter) {
        StringBuilder builder = new StringBuilder(stringOfWords);

        for (String deleted : new String [] { "  ", " ,", ",," })
            deleteChar(builder, deleted);

        words = builder.toString().split(splitter);
        count = words.length;
    }
    
    // Конструктор копирования
    public Words(Words other) {
        this.words = new String [other.count];
        this.count = other.count;

        System.arraycopy(other.words, 0, this.words, 0, other.count);
    }

    // Получить длину массива
    public int getCount() {
        return count;
    }

    // Получить массив слов
    public String [] getWords() {
        return words;
    }

    // Удаление 1-го символа в указанной подстроке
    private void deleteChar(StringBuilder builder, String deleted) {
        int index = builder.indexOf(deleted);

        while (index != -1) {
            builder.deleteCharAt(index);
            index = builder.indexOf(deleted);
        }
    }

    // Форматирование строки
    public String formatString(String splitter) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < getCount() - 1; index++)
            builder.append(words[index]).append(splitter);
        builder.append(words[getCount() - 1]).append('\n');

        return builder.toString();
    }

    // Переворачивание слова
    public void reverseWord(int number) {
        StringBuilder builder = new StringBuilder(words[number - 1]);
        words[number - 1] = builder.reverse().toString();
    }
    
    // Удаление каждого 3-го слова из предложения
    public void removeEachThirdWord() {
        ArrayList<String> list = new ArrayList<>();

        for (int index = 0; index < getCount(); index++)
            if ((index + 1) % 3 != 0) list.add(words[index]);

        words = list.toArray(new String[0]);
        count = words.length;
    }
}