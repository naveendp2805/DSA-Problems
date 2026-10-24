class Solution {
    private final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrivedDate = convertToDays(arriveAlice);
        int aliceLeavedDate = convertToDays(leaveAlice);

        int bobArrivedDate = convertToDays(arriveBob);
        int bobLeavedDate = convertToDays(leaveBob);

        return Math.max(0, Math.min(aliceLeavedDate, bobLeavedDate) - Math.max(aliceArrivedDate, bobArrivedDate) + 1);
    }

    private int convertToDays(String date)
    {
        int month = Integer.parseInt(date.substring(0, 2));
        int res = Integer.parseInt(date.substring(3, 5));

        for(int i=0; i<month-1; i++) {
            res += days[i];
        }

        return res;
    }
}