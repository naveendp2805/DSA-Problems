class Solution {
    public String digitSum(String s, int k) {

        while(s.length() > k) 
        {
            StringBuilder next = new StringBuilder();

            for(int i=0; i<s.length(); i+=k)
            {
                String part = s.substring(i, Math.min(s.length(), i+k));
                int sum = 0;

                for(char ch : part.toCharArray()) {
                    sum += ch - '0';
                }

                next.append(sum);
            }

            s = next.toString();
        }

        return s;
    }
}