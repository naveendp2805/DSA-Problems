class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length, i = 0;
        List<String> res = new ArrayList<>();

        while(i < n)
        {
            int j = i, len = 0;

            while(j < n && len + words[j].length() + (j - i) <= maxWidth)
            {
                len += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            int spaces = maxWidth - len;

            StringBuilder line = new StringBuilder();

            if(j == n || gaps == 0)
            {
                for(int k=i; k<j; k++)
                {
                    line.append(words[k]);
                    if(k != j-1)
                        line.append(" ");
                }

                while(line.length() < maxWidth)
                    line.append(" ");
            }
            else
            {
                int spaceEach = spaces / gaps;
                int extra = spaces % gaps;

                for(int k=i; k<j; k++)
                {
                    line.append(words[k]);

                    if(k != j-1)
                    {
                        int toAdd = spaceEach + (extra-- > 0 ? 1 : 0);
                        line.append(" ".repeat(toAdd));
                    }
                }
            }

            res.add(line.toString());
            i = j;
        }

        return res;
    }
}