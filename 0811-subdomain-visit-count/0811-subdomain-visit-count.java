class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countDomain = new HashMap<>();
        for(String cpdomain : cpdomains) {
            String[] countPair = cpdomain.split(" ");
            int visit = Integer.parseInt(countPair[0]);
            String[] subdomain = countPair[1].split("\\.");

            StringBuilder domainBuilder = new StringBuilder();
            for (int i = subdomain.length - 1; i >= 0; i--) {
                if (domainBuilder.length() > 0) {
                    domainBuilder.insert(0, ".");
                }
                domainBuilder.insert(0, subdomain[i]);
                String domain = domainBuilder.toString();
                countDomain.put(domain, countDomain.getOrDefault(domain, 0) + visit);
            }
        }
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countDomain.entrySet()) {
            answer.add(entry.getValue() + " " + entry.getKey());
        }
        return answer;
    }
}