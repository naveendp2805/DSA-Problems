class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;

        int[] res = new int[n];

        Arrays.sort(potions);

        for(int i=0; i<n; i++)
        {
            int spell = spells[i];

            int l=0, h=m-1;
            int first = m;

            while(l <= h)
            {
                int mid = l + (h - l) / 2;

                long pair = (long) potions[mid] * spell;

                if(pair >= success) {
                    first = mid;
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            res[i] = m - first;
        }

        return res;
    }
}