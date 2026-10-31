class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String component : components)
        {
            if(component.equals("") || component.equals(".")) {
                continue;
            }

            if(component.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        StringBuilder res = new StringBuilder();

        while(!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}