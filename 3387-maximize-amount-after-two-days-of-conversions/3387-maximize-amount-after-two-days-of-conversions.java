import java.util.*;

class Solution {

    static class Exchange {
        String to;
        double rate;

        Exchange(String to, double rate) {
            this.to = to;
            this.rate = rate;
        }
    }

    public double maxAmount(
        String initialCurrency,
        List<List<String>> pairs1, double[] rates1,
        List<List<String>> pairs2, double[] rates2
    ) {
        Map<String, List<Exchange>> map1 = buildMapWithInverse(pairs1, rates1);
        Map<String, List<Exchange>> map2 = buildMapWithInverse(pairs2, rates2);

        Map<String, Double> day1 = computeMax(initialCurrency, 1.0, map1);

        double max = 1.0;

        for (Map.Entry<String, Double> entry : day1.entrySet()) {
            String currency = entry.getKey();
            double amount = entry.getValue();

            Map<String, Double> day2 = computeMax(currency, amount, map2);

            if (day2.containsKey(initialCurrency)) {
                max = Math.max(max, day2.get(initialCurrency));
            }
        }

        return max;
    }

    // 순방향 + 역방향 환전 쌍을 모두 추가
    private Map<String, List<Exchange>> buildMapWithInverse(List<List<String>> pairs, double[] rates) {
        Map<String, List<Exchange>> map = new HashMap<>();

        for (int i = 0; i < pairs.size(); i++) {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i];

            map.computeIfAbsent(from, k -> new ArrayList<>())
                .add(new Exchange(to, rate));

            map.computeIfAbsent(to, k -> new ArrayList<>())
                .add(new Exchange(from, 1.0 / rate));
        }

        return map;
    }

    // BFS 스타일로 최대 금액 계산
    private Map<String, Double> computeMax(String start, double startValue, Map<String, List<Exchange>> map) {
        Map<String, Double> maxValue = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        maxValue.put(start, startValue);
        queue.offer(start);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            double currAmount = maxValue.get(curr);

            if (!map.containsKey(curr)) continue;

            for (Exchange ex : map.get(curr)) {
                double nextAmount = currAmount * ex.rate;
                if (nextAmount > maxValue.getOrDefault(ex.to, 0.0)) {
                    maxValue.put(ex.to, nextAmount);
                    queue.offer(ex.to);
                }
            }
        }

        return maxValue;
    }
}
