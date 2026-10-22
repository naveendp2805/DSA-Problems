class RandomizedCollection {
    ArrayList<Integer> list;
    Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    private boolean search(int val) {
        return map.containsKey(val);
    }
    
    public boolean insert(int val) {
        boolean contain = search(val);

        if(!contain)
            map.put(val, new HashSet<>());

        list.add(val);
        map.get(val).add(list.size() - 1);

        return !contain;
    }
    
    public boolean remove(int val) {
        if(!search(val))
            return false;

        int idx = map.get(val).iterator().next();
        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);

        map.get(val).remove(idx);

        if(idx != lastIdx)
        {
            list.set(idx, lastVal);

            map.get(lastVal).remove(lastIdx);
            map.get(lastVal).add(idx);
        }

        list.remove(lastIdx);

        if(map.get(val).isEmpty())
            map.remove(val);

        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */