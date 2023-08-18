public class Test1 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("wdwdwd");
        byte s  = (byte) 0xF;
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            sort(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sort(arr, 0, i);
        }
    }

    public static void sort(int[] arr, int index, int length) {
        int temp = arr[index];
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && arr[i + 1] > arr[i]) {
                i++;
            }
            if(temp<arr[i]){
                arr[index]=arr[i];
                index=i;
            }else {
                break;
            }
        }
        arr[index] = temp;
    }
}
