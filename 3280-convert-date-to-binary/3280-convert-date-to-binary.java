class Solution {
    public String convertDateToBinary(String date) {
        String[] splitdate = date.split("-");

        splitdate = Arrays.stream(splitdate)
            .map(Integer::parseInt)
            .map(i -> Integer.toString(i, 2))
            .toArray(String[]::new);

        StringBuilder sb = new StringBuilder(splitdate[0]);
        sb.append("-");
        sb.append(splitdate[1]);
        sb.append("-");
        sb.append(splitdate[2]);
        return sb.toString();
    }
}