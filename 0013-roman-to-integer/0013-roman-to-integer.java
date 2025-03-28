import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.ofEntries(
            Map.entry("I", 1),
            Map.entry("IV", 4),
            Map.entry("V", 5),
            Map.entry("IX", 9),
            Map.entry("X", 10),
            Map.entry("XL", 40),
            Map.entry("L", 50),
            Map.entry("XC", 90),
            Map.entry("C", 100),
            Map.entry("CD", 400),
            Map.entry("D", 500),
            Map.entry("CM", 900),
            Map.entry("M", 1000)
        );

        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("IV|IX|XL|XC|CD|CM|[IVXLCDM]").matcher(s);

        while (matcher.find()) {
            result.add(matcher.group());
        }
        int sum = 0;
        for(String roman : result) {
            sum += map.get(roman);
        }
        return sum;
    }
}