public class ArrayDeque<T> {

    private T[] items;
    private int size, left, right;
    private final int INITIAL_CAPACITY = 8;
    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        left = right = size = 0;
    }
    public void addFirst(T item) {

        if (isFull()){
            resize((int)(capacity * 1.5));
        }

        left = (left - 1 + capacity) % capacity;
        items[left] = item;
    }

    public void addLast(T item){
        if (isFull()){
            resize((int)(capacity * 1.5));
        }

        right = (right + 1 + capacity) % capacity;
        items[right] = item;

    }
    public boolean isEmpty(){
        return size == 0;

    }
    public int size(){
        return size;
    }

    public void printDeque(){
        if (left < right){
            for (int i = left; i < right; i ++){
                if (i == right -1){
                    System.out.println(items[i]);
                    break;
                }

                System.out.print(items[i] + " ");
            }
        }else if (left > right){
            for (int i = left; i < capacity; i ++){
                System.out.println(items[i] +  " ");
            }

            for (int i = 0; i < right; i ++){
                if (i == right -1){
                    System.out.println(items[i]);
                    break;
                }
                System.out.println(items[i] + " ");
            }
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }

        T res = items[left];
        left = (left + 1) % capacity;
        if (isLowUsageRate()){
            resize((int)(capacity * 0.5));
        }

        return res;
    }

    public T removeLast(){
        if (isEmpty()) return null;
        T res = items[right];
        right = (right -1) % capacity;
        if (isLowUsageRate()){
            resize((int)(capacity * 0.5));
        }
        return res;
    }

    public T get(int index){
        return items[index];
    }

    private boolean isFull(){
        return size() == (capacity -1);
    }

    private boolean isLowUsageRate(){
        return capacity >= 16 && size() / (double) capacity < 0.25;
    }

    private void resize(int newSize){
        T[] newArr = (T[]) new Object[newSize];

        int size = size();
        if (left < right){
            for (int i = left, j = 0; i < right && j < size; i ++, j ++){
                newArr[j] = items[i];
            }
        }else if (left > right){
            int j = 0;
            for (int i = left; j < capacity - left; i ++, j ++){
                newArr[j] = items[i];
            }

            for (int i = 0; j < size; i ++, j ++){
                newArr[j] = items[i];
            }
        }
        left = 0;
        right = size;
        items = newArr;
        capacity = newSize;
    }
}
