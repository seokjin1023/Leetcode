class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countDomain = new HashMap<>();
        for(String cpdomain : cpdomains) {
            String[] countPair = cpdomain.split(" ");
            int visit = Integer.parseInt(countPair[0]);
            String[] subdomain = countPair[1].split("\\.");
            for(int i = 0; i < subdomain.length; i++) {
                String domain = subdomain[i];
                for(int j = i + 1; j < subdomain.length; j++) {
                    domain += "." + subdomain[j];
                }
                int counted = countDomain.getOrDefault(domain, 0);
                counted += visit;
                countDomain.put(domain, counted);
            }
        }
        List<String> answer = new ArrayList<>();
        for(String domain : countDomain.keySet()) {
            answer.add(Integer.toString(countDomain.get(domain)) + " " + domain);
        }
        return answer;
    }
}