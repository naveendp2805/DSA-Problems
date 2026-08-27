class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();

        int n = transactions.length;
        boolean[] invalid = new boolean[n];
        
        for(int i=0; i<n; i++)
        {
            String[] t1 = transactions[i].split(",");
            
            String name1 = t1[0];
            int time1 = Integer.parseInt(t1[1]);
            int amt1 = Integer.parseInt(t1[2]);
            String city1 = t1[3];

            if(amt1 > 1000)
                invalid[i] = true;

            for(int j=i+1; j<n; j++)
            {
                String[] t2 = transactions[j].split(",");

                String name2 = t2[0];
                int time2 = Integer.parseInt(t2[1]);
                String city2 = t2[3];

                if(name1.equals(name2) && Math.abs(time1 - time2) <= 60 && !city1.equals(city2))
                {
                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        for(int i=0; i<n; i++)
            if(invalid[i])
                res.add(transactions[i]);

        return res;
    }
}