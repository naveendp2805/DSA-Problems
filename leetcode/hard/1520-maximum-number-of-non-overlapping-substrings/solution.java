class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for(int i=0; i<n; i++)
        {
            int ch = s.charAt(i) - 'a';

            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for(int ch=0; ch<26; ch++)
        {
            if(last[ch] == -1) continue;

            int l = first[ch], r = last[ch];
            boolean valid = true;

            for(int i=l; i<r; i++)
            {
                int x = s.charAt(i) - 'a';

                if(first[x] < l)
                {
                    valid = false;
                    break;
                }

                r = Math.max(r, last[x]);
            }

            if(valid)
                intervals.add(new int[]{l, r});
        }

        intervals.sort((a, b) -> {
            if(a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<String> res = new ArrayList<>();

        int prev = -1;

        for(int[] interval : intervals)
        {
            int l = interval[0], r = interval[1];
            if(l > prev)
            {
                res.add(s.substring(l, r+1));
                prev = r;
            }
        }

        return res;
    }
}