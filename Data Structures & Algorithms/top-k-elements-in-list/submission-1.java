class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int num : count.keySet()) {
            int freqCount = count.get(num);
            if(bucket[freqCount] == null) {
                bucket[freqCount] = new ArrayList<>();
            }
            bucket[freqCount].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = nums.length; i >= 0 && index < k; i--) {
            if(bucket[i] != null) {
                for(int num : bucket[i]) {
                    result[index++] = num;
                    if(index == k) break;
                }
            }
        }

        return result;
    }
}
