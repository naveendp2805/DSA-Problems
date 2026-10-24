class Solution {
    private final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(convertToDays(date1) - convertToDays(date2));
    }

    private int convertToDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int res = day;

        for (int y = 1971; y < year; y++) {
            res += isLeapYear(y) ? 366 : 365;
        }

        for(int i=0; i<month-1; i++) {
            res += days[i];
        }

        if (month > 2 && isLeapYear(year)) {
            res++;
        }

        return res;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}