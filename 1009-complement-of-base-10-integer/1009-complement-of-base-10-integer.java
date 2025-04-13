class Solution {
    public int bitwiseComplement(int n) {
        String binN = Integer.toString(n, 2);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < binN.length(); i++) {
            if(binN.charAt(i) == '0')
                sb.append('1');
            else
                sb.append('0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}