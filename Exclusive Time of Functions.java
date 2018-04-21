class Solution {
    public int[] exclusiveTime(int n, List<String> logs){
        if (logs == null || logs.size() == 0 || n < 0) {
            return new int[0];
        }

        int[] res = new int[n];

        int lastUpdateTime = 0;
        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            String[] splited = log.split(":");
            int id = Integer.valueOf(splited[0]);
            String type = splited[1];
            int time = Integer.valueOf(splited[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - lastUpdateTime;
                }
                stack.push(id);
                lastUpdateTime = time;
            } else if (type.equals("end")) {
                int lastFuncId = stack.pop();
                res[lastFuncId] += time - lastUpdateTime + 1;
                lastUpdateTime = time + 1;
            }
        }

        return res;

    }
}