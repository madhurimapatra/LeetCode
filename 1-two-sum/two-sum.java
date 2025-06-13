class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>pairIndex=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(pairIndex.containsKey(target-num)){
                return new int[]{i,pairIndex.get(target-num)};
            }
            pairIndex.put(num,i);
        }
        return new int[] {};

        

        
    }
}