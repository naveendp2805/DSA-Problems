class Solution {
    public int convertTime(String current, String correct) {
        int duration = convertToMinutes(correct) - convertToMinutes(current);
        int res = 0;
        int[] ops = {60, 15, 5, 1};

        for(int op : ops)
        {
            while(duration >= op)
            {
                duration -= op;
                res++;
            }
        }

        return res;
    }

    private int convertToMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));

        for(int i=0; i<hour; i++) {
            min += 60;
        }

        return min;
    }
}