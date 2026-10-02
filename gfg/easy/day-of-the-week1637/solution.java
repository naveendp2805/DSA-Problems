class Solution {
    public String getDayOfWeek(int[] date) {
        // code here
        int y = date[2], m = date[1], d = date[0];
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int[] t = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        
        if(m < 3)
            y--;
            
        int day = (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
        
        return days[day];
    }
};