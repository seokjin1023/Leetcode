//다익스트라로 n-1까지의 최단 거리를 구하는 것과 비슷하게 가는 경로의 수를 더해준다.
class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            map.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> que = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        que.offer(new long[]{0, 0}); // node, distance

        int MOD = 1_000_000_007;

        while (!que.isEmpty()) {
            long[] current = que.poll();
            int nodeNum = (int)current[0];
            long distance = (long)current[1];

            if (distance > dist[(int)nodeNum]) continue;

            for (int[] intersection : map.getOrDefault(nodeNum, new ArrayList<>())) {
                int newNodeNum = intersection[0];
                long newDistance = (long)distance + intersection[1];

                if (newDistance < dist[newNodeNum]) {
                    dist[newNodeNum] = newDistance;
                    ways[newNodeNum] = ways[nodeNum];
                    que.offer(new long[]{newNodeNum, newDistance});
                } else if (newDistance == dist[newNodeNum]) {
                    ways[newNodeNum] = (ways[newNodeNum] + ways[nodeNum]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}


