import java.util.Arrays;


public class ArrayList {
    private static String[] list = new String[10]; // Исходный массив
    private static int size = 0; // Текущий размер

    public static void add(String element) {
        // Если массив заполнен, увеличиваем его размер
        if (size == list.length) {
            String[] newList = new String[list.length * 2];
            newList = list.clone();
            list = newList;
        }
        list[size++] = element; // Добавляем элемент
    }

    public static boolean remove(String element) {
        // Поиск элемента в массиве
        for (int i = 0; i < size; i++) {
            if ((element == null && list[i] == null) ||
                    (element != null && element.equals(list[i]))) {

                // Сдвиг элементов влево
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }

                list[--size] = null; // Очистка последней позиции
                return true; // Элемент удален
            }
        }
        return false; // Элемент не найден
    }

    public static String set(int index, String newElement) {
        String oldElement = list[index]; // Сохраняем старый элемент
        list[index] = newElement;         // Заменяем на новый
        return oldElement;                // Возвращаем старый элемент
    }

    public static void clear() {
        // Обнуляем все элементы до текущего размера
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0; // Сбрасываем размер
    }


    public static void main(String[] args) {
        add("Apple"); // Добавляем элементы
        add("Banana");
        add("Cherry");
        add("Cherry");

        System.out.println(Arrays.toString(list));
        System.out.println("Size: " + size); // Size: 2

        remove("Banana");
        System.out.println("После удаления: " + Arrays.toString(list));
        System.out.println("Текущий размер: " + size);

        String replaced = set(2, "Orange");
        System.out.println(Arrays.toString(list));
        System.out.println("Замененный элемент: " + replaced);

        clear();
        System.out.println("После очистки: " + Arrays.toString(list)); // [null, null, ...]
        System.out.println("Текущий размер: " + size);

    }
}
