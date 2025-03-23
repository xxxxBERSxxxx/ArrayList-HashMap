import java.util.Arrays;

public class HashMap {
        private static final int CAPACITY = 5; // Фиксированный размер массива
        private String[] keys = new String[CAPACITY];
        private int[] values = new int[CAPACITY];
        private int size = 0;


        public void put(String key, int value) {
            int index = getIndex(key);

            // Поиск свободного места или совпадения ключа
            while (keys[index] != null && !keys[index].equals(key)) {
                index = (index + 1) % CAPACITY; // Линейное пробирование
            }

            if (keys[index] == null) {
                size++;
            }
            keys[index] = key;
            values[index] = value;
        }

       
        public int get(String key) {
            int index = getIndex(key);

            while (keys[index] != null) {
                if (keys[index].equals(key)) {
                    return values[index];
                }
                index = (index + 1) % CAPACITY;
            }
            return -1;
        }

       
        public void remove(String key) {
            int index = getIndex(key);

            while (keys[index] != null) {
                if (keys[index].equals(key)) {
                    keys[index] = null;
                    values[index] = -1;
                    size--;
                    return;
                }
                index = (index + 1) % CAPACITY;
            }
        }

        public int[] values() {
            int[] result = new int[size];
            int count = 0;
            for (int i = 0; i < CAPACITY; i++) {
                if (keys[i] != null) {
                    result[count] = values[i];
                    count++;
                }
            }
            return result;
        }

    public String[] keySet() {
        String[] result = new String[size];
        int count = 0;
        for (int i = 0; i < CAPACITY; i++) {
            if (keys[i] != null) {
                result[count] = keys[i];
                count++;
            }
        }
        return result;
    }

        // Хэш-функция
        private int getIndex(String key) {
            return Math.abs(key.hashCode()) % CAPACITY;
        }

     
        public static void main(String[] args) {
        HashMap map = new HashMap();
            map.put("Apple", 10);
            map.put("Banana", 20);
            map.put("Orange", 30);
            map.put("Ananas", 40);
            map.put("Ежевика", 50);


            System.out.println("Apple: " + map.get("Apple"));
            map.remove("Banana");
            System.out.println("Banana: " + map.get("Banana"));
            System.out.println("После удаления: " + Arrays.toString(map.values()));
            System.out.println("Ключи: " + Arrays.toString(map.keySet()));
        }
    }
