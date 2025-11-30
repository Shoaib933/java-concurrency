public class PrintExtremeArray {
    static void printExtreme(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        while (s<=e) {
            if (s==e) {
                System.out.println(arr[s]);
//                System.out.println(arr[e]);
            }
            System.out.println(arr[s]);
            System.out.println(arr[e]);
            s++; e--;

        }
    }


}

static void main() {
    int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
    PrintExtremeArray.printExtreme(arr);
}
