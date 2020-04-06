package main.java;

class Main {

    private static int getMax(int[] arr) {
        int mx = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    private static void countSort(int[] arr, int e) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
    

        // Store count of occurrences in count[]
        for(int i = 0; i < arr.length; i++) {
            count[(arr[i] / e) % 10]++;
        }

        // Change count[i] so it now contains
        //actual position of this digit in output
        for(int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        // Build output array
        for(int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / e) % 10] -1] = arr[i];
            count[(arr[i] / e) % 10]--;
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    private static void radixSort(int[] arr) {
        int maxValue = getMax(arr);
        for(int e = 1; maxValue / e > 0; e *= 10) {
            countSort(arr, e);
        }
    }

   public static void main(String[] args) {
      int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
      radixSort(arr);

      for(int value : arr) {
          System.out.println(value);
      }
   }


}