class Solution {
    public String maskPII(String s) {
        
        if(s.contains("@")) {
            s = s.toLowerCase();

            int at = s.indexOf("@");

            String name = s.substring(0, at);
            String domain = s.substring(at);

            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + domain;
        }

        StringBuilder digits = new StringBuilder();

        for(char digit : s.toCharArray()) {
            if(Character.isDigit(digit)) {
                digits.append(digit);
            }
        }

        int countryCode = digits.length() - 10;
        String lastFour = digits.substring(digits.length() - 4);
        String res = "";

        if (countryCode == 0) {
            res = "***-***-" + lastFour;
        } 
        else {
            res = "+" + "*".repeat(countryCode)
                    + "-***-***-" + lastFour;
        }

        return res;
    }
}