class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int centre = arr[(arr.length - 1) / 2];

        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr, (a, b) -> {
            int diffA = Math.abs(a - centre);
            int diffB = Math.abs(b - centre);
            if (diffA == diffB)
                return Integer.compare(b, a); // 값이 큰 게 먼저
            return Integer.compare(diffB, diffA); // 거리 큰 게 먼저
        });

        return Arrays.stream(boxedArr).limit(k).mapToInt(Integer::intValue).toArray();
    }
}
