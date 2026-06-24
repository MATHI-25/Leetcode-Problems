class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int area = 0;
        while(l<r){
            int curr = Math.min(height[l], height[r])*(r-l);
            area = Math.max(area,curr);
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return area;
        
    }
}