class Solution {
    public void wiggleSort(int[] nums) {
        int[] res = nums.clone();
        Arrays.sort(res);
        int n= nums.length;
        int mid = (n+1)/2;
        int left = mid-1;
        int right = n-1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                nums[i] = res[left--];
            }else{
                nums[i] = res[right--];
            }
        }
        
    }
}