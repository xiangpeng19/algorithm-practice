public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        int length = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<String>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    char[] charArr = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArr[j] = c;
                        String newStr = new String(charArr);
                        if (newStr.equals(end)) {
                            return length + 1;
                        } else {
                            if (dict.contains(newStr) && !visited.contains(newStr)) {
                                queue.offer(newStr);
                                visited.add(newStr);
                            }
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

}