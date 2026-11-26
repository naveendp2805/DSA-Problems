class Solution {
    public boolean canAliceWin(int n) {
        boolean alice = true;
        int remove = 10;

        while(remove > 0) {

            if(n < remove) {
                return !alice;
            }

            n -= remove;

            if(n == 0) {
                return alice;
            }

            alice = !alice;
            remove--;
        }

        return !alice;
    }
}