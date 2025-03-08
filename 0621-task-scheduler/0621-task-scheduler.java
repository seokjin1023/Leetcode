class Solution {
    private int checkTaskNum(int[] task) {
        int answer = 0;
        for(int i = 0; i < task.length; i++) {
            answer += task[i];
        }
        return answer;
    }
    public int leastInterval(char[] tasks, int n) {
        if(n == 1)
            return tasks.length;
        int answer = 0;
        int[] countTask = new int[26];
        int[] runningTask = new int[26];
        for(char task : tasks) {
            countTask[task - 'A']++;
        }
        int taskNum = 0;
        while(checkTaskNum(countTask) > 0) {
            for(int i = 0; i < countTask.length; i++) {
                if(countTask[i] > 0) {
                    countTask[i]--;
                    tasks[taskNum++] = (char)(i + 'A');
                }
            }
        }
        taskNum = 0;
        while(taskNum < tasks.length) {
            int putIndex = tasks[taskNum] - 'A';
            if(runningTask[putIndex] == 0) {
                runningTask[putIndex] = n;
                for(int i = 0; i < runningTask.length; i++) {
                    if(runningTask[i] > 0 && i != putIndex) {
                        runningTask[i]--;
                    }
                }
                taskNum++;
            }
            else {
                for(int i = 0; i < runningTask.length; i++) {
                    if(runningTask[i] > 0) {
                        runningTask[i]--;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}