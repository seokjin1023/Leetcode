class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length == 1)
            return new int[]{adjacentPairs[0][0], adjacentPairs[0][1]};
        int[] answer = new int[adjacentPairs.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair : adjacentPairs) {
            int first = pair[0], second = pair[1];
            List<Integer> list = map.computeIfAbsent(pair[0], k -> new ArrayList<>());
            list.add(second);
            list = map.computeIfAbsent(pair[1], k -> new ArrayList<>());
            list.add(first);
        }
        int start = 0;
        for(Integer num : map.keySet()) {
            if(map.get(num).size() == 1) {
                start = num;
                break;
            }
        }
        answer[0] = start;
        answer[1] = map.get(start).get(0);
        start = answer[1];
        int answerIndex = 2;
        while(answerIndex < adjacentPairs.length + 1){
            List<Integer> list = map.get(start);
            int next = list.get(0) == answer[answerIndex - 2] ? list.get(1) : list.get(0);
            answer[answerIndex++] = next;
            start = next;
        }

        return answer;
    }
}

//Pair가 앞 뒤 순서 없이 존재함.
//Map으로 각 Pair마다 저장..?
//나온 횟수가 홀수일 경우.. 마지막 값인듯?
//n unique element -> 많아봤자 최대 2개의 pair, 즉 홀수면 무조건 그 pair밖에 없음.