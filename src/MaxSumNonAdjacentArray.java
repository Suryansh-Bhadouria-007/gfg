public class MaxSumNonAdjacentArray {
    public static void main(String[] args) {
        Integer arr[]={1,2,6,3,1};
        System.out.println(findMaxSum(arr,arr.length));
    }
    static int findMaxSum(Integer arr[],int n)
    {
        int incl=arr[0];
        int excl=0;
        int excl_new;
        for(int i=1;i<n;i++)
        {
            excl_new=Math.max(incl,excl);
            incl=excl+arr[i];
            excl=excl_new;
        }
        return Math.max(incl,excl);
    }
}
