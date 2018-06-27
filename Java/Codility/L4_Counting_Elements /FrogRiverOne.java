/*FrogRiverOne
------------


A small frog wants to get to the other side of a river. The frog is initially located on one 
bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves 
fall from a tree onto the surface of the river.

You are given a zero-indexed array A consisting of N integers representing the falling leaves. 
A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. 
The frog can cross only when leaves appear at every position across the river from 1 to X (that 
is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). 
You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do 
not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4

In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

int solution(int X, int A[], int N);
that, given a non-empty zero-indexed array A consisting of N integers and integer X, 
returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Assume that:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

A[K] represents the position where one leaf falls at time K, measured in seconds.
*/


public class FrogRiverOne {


    /*
      solution - a
    */
    // A = [1,3,1,4,2,3,5,4]  

    /*
      A[0] = 1
      A[1] = 3
      A[2] = 1
      A[3] = 4
      A[4] = 2
      A[5] = 3
      A[6] = 5
      A[7] = 4

    -----------|
     time  dis |
    -----------| 
      0   -> 1 |
      4   -> 2 |
      1   -> 3 |
      3   -> 4 | 
      6   -> 5 |  
    -----------|  
    */  
    public static int solution(int[] A, int X) {

        int tmp = 0;
        boolean[] hasLeaf = new boolean[X+1];

        for (int i = 0; i < A.length; i++) {

            if (!hasLeaf[A[i]] && A[i]<=X) {
                hasLeaf[A[i]] = true;
                tmp++;
            }

            if (tmp ==X){
                return i;
            }    
        }

        return -1;
    }



    /*
    * solution -b 
    */
    public int solution(int X, int[] A) {

        int count =X;
        int [] P = new int[X];

        for (int i=0;i<X;i++){
            P[i] = -1;
        }

        for (int i=0;i<A.length;i++) {

            if (P[A[i]-1]== -1){
                P[A[i]-1] = 1;
                count--;
                if (count == 0){
                    return i;    
                }
            }               
        }
        
        return -1;
    }


    /*
    solution - c
    */
    public int solution(int x, int[] a) {
        
        final int[] r = new int[x];
        
        int pc = x;
        int i = 0;
        
        for (; pc != 0 && i < a.length; i++) {
            if (a[i] <= x && r[a[i] - 1] == 0) {
                r[a[i] - 1] = 1;
                pc--;
            }
        }
        if (pc > 0) {
            return -1;
        }
        return i - 1;
    }


    

    public static void main(String[] args) {

        int[] A = new int[]{1,3,1,4,2,3,5,4};
        int X = 5;

        System.out.println(solution(A,X));
    }
}