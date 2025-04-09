class Solution {
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public int calPoints(String[] operations) {
        List<Integer> score = new ArrayList<>();
        for(String s : operations) {
            if(isInteger(s)) {
                int value = Integer.parseInt(s);
                score.add(value);
            }
            else {
                char c = s.charAt(0);
                if(c == 'C') {
                    score.remove(score.size() - 1);
                }
                else if(c == 'D') {
                    score.add(score.get(score.size() - 1) * 2);
                }
                else {
                    score.add(score.get(score.size() - 1) + score.get(score.size() - 2));
                }
            }
        }
        return score.stream().mapToInt(Integer::intValue).sum();
    }
}