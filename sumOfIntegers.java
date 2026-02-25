// public class sumOfIntegers {
//     public static void main(String[] args) {
//         int[] numberList = { 1, 2, 3, 4, 5, 6, 7 };
//         int total = iterativeSum(numberList);
//         System.out.println(total);
//     }

//     static int recursiveSum(int[] numList, int index) {
//         // base case nya pas list nya udah kosong
//         if (index >= numList.length) {
//             return 0;
//         }
//         return numList[index] + recursiveSum(numList, index + 1);
//     }

//     static int iterativeSum(int[] numList) {
//         int total = 0;
//         for (int i = 0; i < numList.length; i++) {
//             total += numList[i];
//         }
//         return total;
//     }

// }

// yg bener harusnya recursive partial sum


public class sumOfIntegers {
    public static void main(String[] args) {
        int[] someList = {1,2,3,4,5,6,7};
        int firstToThirdSumResult = recursivePartialSum(someList, 6);
        System.out.println(firstToThirdSumResult);
     }
    public static int recursivePartialSum(int[] numberList, int index){
        if (index < 0) {
            return 0;
        }
        else if (index > numberList.length) {
            return -1;
        }
        else{
            return numberList[index] + recursivePartialSum(numberList, index-1);
        }
    }

}