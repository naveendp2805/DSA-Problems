class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);

        res.add(new ArrayList<>(list));

        for(int i=1; i<numRows; i++)
        {

            for(int j=i-1; j>0; j--)
                list.set(j, list.get(j) + list.get(j-1));

            list.add(1);

            res.add(new ArrayList<>(list));
        }

        return res;
    }
}