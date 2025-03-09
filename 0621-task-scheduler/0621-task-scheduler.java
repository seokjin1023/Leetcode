class Solution {
    public int leastInterval(char[] tasks, int n) {
        int answer = 0;
        int[] countTask = new int[26];
        Queue<int[]> runTask = new LinkedList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(char task : tasks) {
            countTask[task - 'A']++;
        }
        for(int i = 0; i < countTask.length; i++) {
            if(countTask[i] > 0)
                maxHeap.add(new int[]{i, countTask[i]});
        }
        while(!maxHeap.isEmpty() || !runTask.isEmpty()) {
            answer++;
            if(!maxHeap.isEmpty()) {
                int[] task = maxHeap.poll();
                task[1]--;

                if(task[1] > 0)
                    runTask.add(new int[]{task[0], task[1], answer + n});
            }
            if(!runTask.isEmpty() && runTask.peek()[2] <= answer) {
                maxHeap.add(runTask.poll());
            }
        }
        return answer;
    }
}