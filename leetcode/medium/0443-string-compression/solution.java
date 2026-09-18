class Solution {
    public int compress(char[] chars) {
        int read = 0, write = 0, n = chars.length;

        while(read < n)
        {
            char curr = chars[read];
            int c = 0;

            while(read < n && chars[read] == curr)
            {
                read++;
                c++;
            }

            chars[write++] = curr;

            if(c > 1)
            {
                String countString = String.valueOf(c);
                for(char ch : countString.toCharArray())
                    chars[write++] = ch;
            }
        }

        return write;
    }
}