import java.util.Arrays;


public class ArrayList {
    private static String[] list = new String[10]; 
    private static int size = 0; 

    public static void add(String element) {
      
        if (size == list.length) {
            String[] newList = new String[list.length * 2];
            newList = list.clone();
            list = newList;
        }
        list[size++] = element; 
    }

    public static boolean remove(String element) {
        
        for (int i = 0; i < size; i++) {
            if ((element == null && list[i] == null) ||
                    (element != null && element.equals(list[i]))) {

           
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }

                list[--size] = null; 
                return true; 
            }
        }
        return false; 
    }

    public static String set(int index, String newElement) {
        String oldElement = list[index]; 
        list[index] = newElement;        
        return oldElement;               
    }

    public static void clear() {
        
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0; 
    }


    public static void main(String[] args) {
        add("Apple"); 
        add("Banana");
        add("Cherry");
        add("Cherry");

        System.out.println(Arrays.toString(list));
        System.out.println("Size: " + size); 

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
