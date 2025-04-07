class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start == destination) return 0;
        int[] distanceSum = new int[distance.length];
        distanceSum[0] = distance[0];
        for(int i = 1; i < distance.length; i++)
            distanceSum[i] = distanceSum[i - 1] + distance[i];
        int total = distanceSum[distanceSum.length - 1];
        int toDes = destination == 0 ? 0 : distanceSum[destination - 1];
        int toStart = start == 0 ? 0 : distanceSum[start - 1];
        int startToDes = Math.abs(toDes - toStart);
        return Math.min(startToDes, total - startToDes);
    }
}