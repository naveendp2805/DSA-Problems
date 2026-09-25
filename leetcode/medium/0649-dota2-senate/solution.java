class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = senate.length();

        for(int i=0; i<n; i++)
        {
            if(senate.charAt(i) == 'R') q1.offer(i);
            else q2.offer(i);
        }

        while(!q1.isEmpty() && !q2.isEmpty())
        {
            int r = q1.poll(), d = q2.poll();

            if(r < d) q1.offer(r + n);
            else q2.offer(d + n);
        }

        return q2.isEmpty() ? "Radiant" : "Dire";
    }
}