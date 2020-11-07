import labwork.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ЗАДАЧА 1
        //=====================================================================//
        System.out.print("Введите размер квадратной матрицы: ");
        Matrix matrix = new Matrix(InputController.input(1, 10));

        matrix.fillRandom(1000);
        System.out.println("Квадратная матрица:\n" + matrix);

        System.out.println("Мин. элемент = " + matrix.minElement());
        //=====================================================================//
        
        // ЗАДАЧА 2
        //=====================================================================//
        System.out.println("\nВведите слова через запятую:");
        Words words = new Words(scanner.nextLine(), ", ");

        System.out.print("Введите номер выбранного слова: ");
        words.reverseWord(InputController.input(1, words.getCount()));

        System.out.print(words.formatString(", "));
        //=====================================================================//

        // ЗАДАЧА 3
        //=====================================================================//
        System.out.println("\nВведите слова через пробел:");

        words = new Words(scanner.nextLine(), " ");
        words.removeEachThirdWord();

        System.out.println("Предложение с удаленным каждым 3-им словом:");
        System.out.print(words.formatString(" "));
        //=====================================================================//
    }
}