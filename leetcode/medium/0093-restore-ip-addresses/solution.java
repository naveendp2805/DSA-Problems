class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> parts = new ArrayList<>();

        restore(s, 0, s.length(), res, parts);

        return res;
    }

    private static void restore(String s, int idx, int n, List<String> res, List<String> parts)
    {
        if(parts.size() == 4) 
        {
            if(idx == n)
            {
                String validIpAddress = "";
                for(int i=0; i<4; i++)
                {
                    validIpAddress += parts.get(i);
                    if(i != 3) validIpAddress += ".";
                }

                res.add(validIpAddress);
            }
            
            return;
        }

        for(int len=1; len<=3; len++)
        {
            if(idx + len > n) break;

            String part = s.substring(idx, idx+len);

            if(part.length() > 1 && part.charAt(0) == '0')
                continue;

            if(Integer.parseInt(part) > 255)
                continue;

            parts.add(part);

            restore(s, idx+len, n, res, parts);

            parts.remove(parts.size() - 1);
        }

    }
}