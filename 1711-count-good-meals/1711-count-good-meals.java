class Solution {
    public int countPairs(int[] deliciousness) {
        int answer = 0;
        final int mod = (int)(1e9 + 7);
        int[] powerOfTwo = new int[22];
        for(int i = 0; i < 22; i++) {
            powerOfTwo[i] = (int)Math.pow(2, i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> isUsed = new HashSet<>();
        for(int delicious : deliciousness)
            map.merge(delicious, 1, Integer::sum);
        for(Integer delicious : map.keySet()) {
            long itemNum = (long)map.get(delicious);
            for(int power : powerOfTwo) {
                if(power < delicious) continue;
                int restNum = power - delicious;
                if(map.containsKey(restNum)) {
                    if(restNum == delicious)
                        answer += (int)((itemNum * (itemNum - 1) / 2) % mod);
                    else {
                        if(!isUsed.contains(restNum))
                            answer += (int)((itemNum * map.get(restNum)) % mod);
                    }
                }
            }
            isUsed.add(delicious);
        }
        return answer;
    }
}