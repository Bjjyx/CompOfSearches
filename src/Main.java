import java.util.Scanner;

/*
Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
Используйте перебор и двоичный поиск для решения этой задачи.
Сравните время выполнения обоих решений для больших массивов (например, Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
Используйте перебор и двоичный поиск для решения этой задачи.
Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов). элементов).
 */
public class Main {

    static int[] array = new int[100000000];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length - 1; i++){

            array[i] = i;

        }

        System.out.println("Введите искомое число");
        int value = scanner.nextInt();

        long startTime = System.nanoTime();
        lineSearch(value);
        long endTime = System.nanoTime();
        System.out.println("Время линейного поиска " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime();
        binarySearch(value);
        endTime = System.nanoTime();
        System.out.println("Время бинарного поиска " + (endTime - startTime) + " наносекунд");

    }

    static void lineSearch(int value){

        for (int j : array) {

            if (j == value) {

                System.out.println("Число " + array[j] + " найдено");

            }

        }

    }

    static void binarySearch(int value){

        int startIdx = 0;
        int endIdx = array.length - 1;
        int middleIdx;

        while (startIdx <= endIdx){

            middleIdx = (startIdx + endIdx) / 2;
            if (array[middleIdx] == value){

                System.out.println("Число " + array[middleIdx] + " найдено");
                break;

            } else if (array[middleIdx] < value){

                startIdx = middleIdx + 1;

            } else if (array[middleIdx] > value) {

                endIdx = middleIdx - 1;

            }

        }

    }
}