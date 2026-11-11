class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long individual = (long) need1 * cost1 + (long) need2 * cost2;

        long both = (long) Math.max(need1, need2) * costBoth;

        int common = Math.min(need1, need2);
        long mixed = (long) common * costBoth + (long) (need1 - common) * cost1 + (long) (need2 - common) * cost2;

        return Math.min(individual, Math.min(both, mixed));
    }
}