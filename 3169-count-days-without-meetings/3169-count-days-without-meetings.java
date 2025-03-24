class Solution {
    public int countDays(int days, int[][] meetings) {
        int work = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]); 
                } else {
                    return Integer.compare(a[1], b[1]); 
                }
            }
        );
        for(int[] meeting : meetings) {
            pq.add(meeting);
        }
        int lastEndMeeting = 0;
        while(!pq.isEmpty()) {
            int[] meeting = pq.poll();
            int start = meeting[0], end = meeting[1];
            int emptyDay = start - lastEndMeeting - 1;
            if(emptyDay > 0) work += emptyDay;
            if(pq.isEmpty()) {
                emptyDay = days - Math.max(lastEndMeeting, end);
                if(emptyDay > 0) work += emptyDay;
            }
            else {
                lastEndMeeting = Math.max(lastEndMeeting, end);
            }
        }
        return work;
    }
}