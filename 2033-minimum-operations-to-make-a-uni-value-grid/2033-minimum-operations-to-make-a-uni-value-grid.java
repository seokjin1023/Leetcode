class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int base = grid[0][0] % x;
        int[] counts = new int[10001]; // 값 범위에 따라 조절
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int total = m * n;

        for (int[] row : grid) {
            for (int val : row) {
                if (val % x != base) return -1;
                counts[val]++;
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }

        // 중앙값 찾기
        int half = total / 2;
        int median = 0, acc = 0;
        for (int i = min; i <= max; i++) {
            acc += counts[i];
            if (acc > half) {
                median = i;
                break;
            }
        }

        // 연산 수 계산
        int moves = 0;
        for (int i = min; i <= max; i++) {
            if (counts[i] > 0) {
                moves += Math.abs(i - median) / x * counts[i];
            }
        }

        return moves;
    }
}


//a * k + c + b * k + c + .... (m * n개)
//sum == (a + b + ...) * x + rest * (m * n)