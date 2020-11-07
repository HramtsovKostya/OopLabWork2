package labwork;
import java.io.Serializable;
import java.util.Random;

public class Matrix implements Serializable {
    private final int [][] matrix;
    private int size;
    private int pointer;

    // Конструктор по умолчанию
    public Matrix() { this(10); }

    // Конструктор с параметрами
    public Matrix(int size) {
        this.matrix = new int[size][size];
        this.size = size;
        this.pointer = 0;
    }

    // Конструктор копирования
    public Matrix(Matrix other) {
        this.matrix = new int[other.size][other.size];
        this.pointer = other.pointer;

        for (int i = 0; i < other.size; i++)
            System.arraycopy(other.matrix[i], 0, this.matrix[i], 0, other.size);
    }

    // Получить элементы матрицы
    public int[][] getMatrix() {
        return matrix;
    }

    // Получить размерность матрицы
    public int getSize() {
        return size;
    }

    // Добавление нового элемента
    public void add(int value) {
        if (pointer < size * size) {
            matrix[pointer / size][pointer % size] = value;
            pointer++;
        }
    }

    // Получение элемента по индексам
    public int elementAt(int row, int column) {
        if (row < 0 || row >= size || column < 0 || column >= size)
            throw new IndexOutOfBoundsException("Выход за границы массива!");

        return matrix[row][column];
    }

    // Заполнение матрицы случайними числами
    public void fillRandom(int bound) {
        Random random = new Random();

        for (int row = 0; row < size; row++)
            for (int column = 0; column < size; column++)
                matrix[row][column] = random.nextInt(bound);
    }

    // Поиск мин. элемента матрицы
    public int minElement() {
        int minElement = matrix[0][0];

        for (int [] array : matrix)
            for (int element : array)
                minElement = Math.min(minElement, element);

        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < size; row++) {
            for (int element : matrix[row])
                builder.append(element).append('\t');

            if (row != size - 1) builder.append('\n');
        }
        return builder.toString();
    }
}