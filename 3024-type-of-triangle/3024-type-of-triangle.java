class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if(a > b && a > c) 
            if(b + c <= a) return "none";
        if(b > a && b > c)
            if(a + c <= b) return "none";
        if(c > a && c > b)
            if(a + b <= c) return "none";
        
        if(a == b && b == c)
            return "equilateral";
        if(a == b || b == c || a == c)
            return "isosceles";
        return "scalene";
    }
}