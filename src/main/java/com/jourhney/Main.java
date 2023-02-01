package com.jourhney;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(isOlympic(new int[]{}));
    }

    //1. An array is defined to be paired-N if it contains two distinct elements that sum to N for some specified value of
    // N and the indexes of those elements also sum to N. Write a function named isPairedN that returns 1 if its array parameter is a paired-N array.
    // The value of N is passed as the second parameter.
    //
    //If you are writing in Java or C#, the function signature is
    //int isPairedN(int[ ] a, int n)
    //
    //If you are writing in C or C++, the function signature is
    //int isPairedN(int a[ ], int n, int len) where len is the length of a
    //
    //There are two additional requirements.
    //
    //Once you know the array is paired-N, you should return 1. No wasted loop iterations please.
    //
    //Do not enter the loop unless you have to. You should test the length of the array and the value of n to determine whether
    // the array could possibly be a paired-N array. If the tests indicate no, return 0 before entering the loop.


    public static int isPairedN(int[] a, int n) {
        int arrayLength = a.length;

        //If length of array is less than 2, it is not a paired-N array
        if (arrayLength < 2) {
            return 0;
        }

        for (int i = 0; i < arrayLength; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (a[i] + a[j] == n && i + j == n) {
                    return 1;
                }
            }
        }
        return 0;
    }





    //2. An array a is defined to be self-referential if for i=0 to a.length-1, a[i] is the count of the number of times that
    // the value i appears in the array. As the following table indicates, {1, 2, 1, 0} is a self-referential array.
    //
    //i	a[i]	comment
    //0	1	There is one 0 in the array. (a[0] = 1)
    //1	2	There are two 1s in the array (a[1] = 2)
    //2	1	There is one 2 in the array (a[2] = 1)
    //3	0	There are no 3s in the array (a[3] = 0)
    //Here are some examples of arrays that are not self-referential:
    //
    //{2, 0, 0} is not a self-referential array. There are two 0s and no 1s. But unfortunately there is a 2 which contradicts a[2] = 0.
    //
    //{0} is not a self-referential array because there is one 0, but since a[0] = 0, there has to be no 0s.
    //
    //{1} is not a self-referential array because there is not a 0 in the array as required by a[0] = 1.
    //
    //Self-referential arrays are rare. Here are the self-referential arrays for arrays of lengths up to 10 elements:
    //
    //{1, 2, 1, 0} (see above)
    //{2, 0, 2, 0} (there are two 0s, no 1s, two 2s and no 3s
    //{2, 1, 2, 0, 0}  (there are two 0s, one 1, two 2s, no 3s and no 4s)
    //{3, 2, 1, 1, 0, 0, 0} (there are three 0s, two 1s, one 2, one 3, no 4s, 5s or 6s)
    //{4, 2, 1, 0, 1, 0, 0, 0} (there are four 0s, two 1s, one 2, no 3s, one 4, and no 5s, 6s, or 7s)
    //{5, 2, 1, 0, 0, 1, 0, 0, 0} (there are five 0s, two 1s, one 2, no 3s or 4s, one 5, and no 6s, 7s, or 8s)
    //{6, 2, 1, 0, 0, 0, 1, 0, 0, 0} (there are six 0s, two 1s, one 2, no 3s, 4s, or 5s, one 6, and no 7s, 8s, or 9s)
    //Write a function named isSelfReferential that returns 1 if its array argument is self-referential, otherwise it returns 0.
    //
    //If you are programming in Java or C#, the function signature is
    //   int isSelfReferential(int[ ] a)
    //
    //If you are programming in C or C++, the function signature is
    //   int isSelfReferential(int a[ ], int len) where len is the number of elements in the array

    //array of a -> {1, 2, 1, 0}
    //array of count -> {1, 2, 1, 0}


    public static int isSelfReferential(int[] a) {
        int arrayLength = a.length;

        //Assumption that an empty array is Self Referential
        if(arrayLength == 0){
            return 1;
        }

        int[] count = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                if (a[j] == i) {
                    count[i]++;
                }
            }
        }

        for (int i = 0; i < arrayLength; i++) {
            if (count[i] != a[i]) {
                return 0;
            }
        }
        return 1;
    }





    //3. An Olympic array is defined to be an array in which every value is greater than or equal to the sum of the values less than it.
    // The sum of the values less than the minimum value in the array is defined to be 0.
    //
    //For example, {3, 2, 1} is an Olympic array because
    //
    //1 is the minimum value and by definition the sum of the values less than it is 0. Since 1 is greater than 0, it satisfies the condition.
    //There is only one value less than 2 and 2 is greater than it, so the value 2 satisfies the condition.
    //The values 1 and 2 are less than 3 and 3 is equal to their sum, so the value 3 satisfies the condition.
    //Hence all elements of the array satisfy the conditions and the array is an Olympic array.
    //
    //{2, 2, 1, 1} is also an Olympic array because the values less than 2 sum to 2.
    //
    //{1, 1000, 100, 10000, 2} is also an Olympic array. However, {1, 99, 99, 1000, 100, 10000, 2}
    // is not an Olympic array because the sum of the numbers less than 100 (99+99+1) is greater than 100.
    // Please be sure that your function detects that this is not an Olympic array!
    //
    //{1, 2, 1, 3, 2} is not an Olympic array because 3 is not greater than or equal to 1+2+1+2.
    //
    //{1, 2, -1, 2, 2} is not an Olympic array because -1 is the minimum value but it is not greater than or equal to 0.
    //
    //Write a function named isOlympic that returns 1 if its array argument is an Olympic array, otherwise it returns 0.
    //
    //If you are writing in Java or C#, the function signature is
    //   int isOlympic (int[ ] a)
    //
    //If you are writing in C or C++, the function signature is
    //   int isOlympic(int a[ ], int len) where len is the number of elements in the array.
    //
    //Hint: use a nested loop. The outer loop will iterate through the array and the inner loop will iterate through the array again.


    public static int isOlympic(int[] a) {

        int arrayLength = a.length;
        int sumLessThanNumber = 0;

        //Assumption that an empty array is Olympic
        if (arrayLength == 0) {
            return 1;
        }

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                if (a[j] < a[i]) {
                    sumLessThanNumber += a[j];
                }
            }
            if (a[i] < sumLessThanNumber) {
                return 0;
            }
            sumLessThanNumber = 0;
        }
        return 1;
    }

}