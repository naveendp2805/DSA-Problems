class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for(int student : students) {
            queue.offer(student);
        }
        
        int i = 0, c = 0;

        while(i < sandwiches.length && !queue.isEmpty()) {
            if(queue.peek() == sandwiches[i]) {
                queue.poll();
                i++;
                c = 0;
            } else {
                queue.offer(queue.poll());
                c++;

                if(c == queue.size())
                    break;
            }
        }

        return queue.size();
    }
}