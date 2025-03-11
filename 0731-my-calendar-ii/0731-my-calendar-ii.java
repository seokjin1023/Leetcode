class MyCalendarTwo {
    List<int[]> singleList;
    List<int[]> doubleList;
    public MyCalendarTwo() {
        singleList = new ArrayList<>();
        doubleList = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        endTime--;
        for(int[] doubleBooked : doubleList) {
            int start = doubleBooked[0];
            int end = doubleBooked[1];
            if(!(endTime < start || startTime > end))
                return false;
        }
        if(singleList.isEmpty()) {
            singleList.add(new int[]{startTime, endTime});
            return true;
        }

        for(int i = 0; i < singleList.size(); i++) {
            int[] singleBooked = singleList.get(i);
            int start = singleBooked[0];
            int end = singleBooked[1];

            if(startTime < start) {
                if(endTime < start) { //가장 앞에 겹치지 않고 존재했을 경우
                    singleList.add(new int[]{startTime, endTime});
                    singleList.sort((a, b) -> a[0] - b[0]);
                    return true;
                }
                else {
                    singleList.add(new int[]{startTime, start - 1});
                    startTime = start;
                }
            }

            if(startTime >= start && startTime <= end) {
                singleList.remove(i--);
                if(endTime <= end) {
                    doubleList.add(new int[]{startTime, endTime});
                    if(startTime != start) 
                        singleList.add(new int[]{start, startTime - 1});
                    if(endTime != end)
                        singleList.add(new int[]{endTime + 1, end});
                    singleList.sort((a, b) -> a[0] - b[0]);
                    doubleList.sort((a, b) -> a[0] - b[0]);
                    return true;
                }
                else {
                    doubleList.add(new int[]{startTime, end});
                    if(startTime != start) 
                        singleList.add(new int[]{start, startTime - 1});
                    startTime = end + 1;
                }
            }
        }
        singleList.add(new int[]{startTime, endTime});
        singleList.sort((a, b) -> a[0] - b[0]);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */