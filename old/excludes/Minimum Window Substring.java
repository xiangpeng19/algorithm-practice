package excludes;

public class Solution {
    /*
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */

    int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
    boolean valid(int []sourcehash, int []targethash) {
        
        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])    
                return false;
        }
        return true;
    }
    public String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        
        initTargetHash(targethash, Target);
        int j = 0, i = 0;
        for(i = 0; i < Source.length(); i++) {
            while( !valid(sourcehash, targethash) && j < Source.length()  ) {
                sourcehash[Source.charAt(j)]++;
                j++;
            }
            if(valid(sourcehash, targethash) ){
                if(ans > j - i ) {
                    ans = Math.min(ans, j - i );
                    minStr = Source.substring(i, j );
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }



    public String minWindow(String s, String t) {
        char[] cs = t.toCharArray();
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();
        for (char c : cs) {
            if (!target.containsKey(c)) {
                target.put(c, 0);
            }
            target.put(c, target.get(c) + 1);
        }

        int start = 0;
        int end = 0;
        char[] arr = s.toCharArray();
        int len = s.length();

        int count = 0;
        int min = s.length();
        String res = "";

        while (end < len) {
            if (target.containsKey(arr[end])) {
                if (!cur.containsKey(arr[end])) {
                    cur.put(arr[end], 0);
                }
                cur.put(arr[end], cur.get(arr[end]) + 1);

                if (cur.get(arr[end]) <= target.get(arr[end])) {
                    count++;
                }
            }
            // find all characters, can update the result
            while (count == cs.length) {
                if (end - start < min) {
                    min = end - start;
                    res = s.substring(start, end + 1);
                }

                // advance start pointer
                if (target.containsKey(arr[start])) {
                    cur.put(arr[start], cur.get(arr[start]) - 1);
                    if (cur.get(arr[start]) < target.get(arr[start])) {
                        count--;
                    }
                }
                start++;
            }
            end++;
        }

        return res;        
    }
}