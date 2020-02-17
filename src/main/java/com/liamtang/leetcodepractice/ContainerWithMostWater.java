package com.liamtang.leetcodepractice;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int a = 0;
        int b = 0;
        int highest = 0;
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                a = height[i];
                b = height[j];
                highest = Math.min(a, b);
                System.out.println(String.format("a=%d, b=%d, length=%d, result=%d", a, b, Math.abs(i-j), Math.abs(i-j)*highest));
                result = Math.max(Math.abs(i-j)*highest, result);
            }            
        } 
        return result;
    }
    
    public static void main(String args[]) {
    	int[] height = {1,8,6,2,5,4,8,3,7};
    	ContainerWithMostWater test = new ContainerWithMostWater();
    	System.out.println(test.maxArea(height));
    }

}
