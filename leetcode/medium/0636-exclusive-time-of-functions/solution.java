class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        int prevTime = 0;

        for(String log : logs)
        {
            String[] parts = log.split(":");

            int id = Integer.parseInt(parts[0]);
            String status = parts[1];
            int time = Integer.parseInt(parts[2]);

            if(parts[1].equals("start")) 
            {
                if(!stack.isEmpty()) {
                    res[stack.peek()] += time - prevTime;
                }

                stack.push(id);
                prevTime = time;
            } 
            else 
            {
                if(!stack.isEmpty()) {
                    res[stack.peek()] += time - prevTime + 1;
                }

                stack.pop();
                prevTime = time + 1;
            }
        }

        return res;
    }
}