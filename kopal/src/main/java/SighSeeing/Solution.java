package SighSeeing;

public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
//        int left[] = new int[n];
//        left[0] = A[0];
//        for (int i = 1; i < n; i++)
//            left[i] = Math.max(left[i-1], A[i]);
        int n=A.length;
        int right[] = new int[n];

        right[n-1] = A[n-1];
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], A[i]);

        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length-1;i++)
        {
            for(int j=i+1;j<A.length;j++)
            {
                if((A[i]+A[j]+i-j)>max){
                    max=(A[i]+A[j]+i-j);
                }
                if(right[i]==A[j])
                    break;

            }
        }
        return max;
    }
}
