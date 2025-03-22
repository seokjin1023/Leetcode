class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int answer = 0;
        int[] vertice = new int[n];
        for(int i= 0; i < n; i++)
            vertice[i] = i;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            Set<Integer> set = map.computeIfAbsent(edge[0], k -> new HashSet<>());
            set.add(edge[1]);
            set = map.computeIfAbsent(edge[1], k -> new HashSet<>());
            set.add(edge[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int edgeNum = 0;
            int nodeNum = 0;
            if(vertice[i] != -1) {
                vertice[i] = -1;
                if(map.get(i) == null) {
                    answer++;
                    continue;
                }
                que.add(i);
                Set<Integer> node = new HashSet<>();
                while(!que.isEmpty()) {
                    Integer num = que.poll();
                    node.add(num);
                    Set<Integer> set = map.get(num);
                    if(set.isEmpty()) continue;
                    for(Integer connectedNum : new HashSet<>(set)) {
                        que.add(connectedNum);
                        Set<Integer> removeSet = map.get(num);
                        removeSet.remove(connectedNum);
                        removeSet = map.get(connectedNum);
                        removeSet.remove(num);
                        vertice[connectedNum] = -1;
                        edgeNum++;
                    }
                }
                nodeNum = node.size();
                if(edgeNum == nodeNum * (nodeNum - 1) / 2)
                    answer++;
            }
        }
        return answer;
    }
}