class Solution {
    public int countDays(int days, int[][] meetings) {
        int work = 0;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int maxEndMeeting = 0;
        for(int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if(end <= maxEndMeeting) continue;
            int emptyDay = start - maxEndMeeting - 1;
            if(emptyDay > 0) work += emptyDay;
            maxEndMeeting = Math.max(maxEndMeeting, end);
        }
        int emptyDay = days - maxEndMeeting;
        if(emptyDay > 0) work += emptyDay;
        return work;
    }
}