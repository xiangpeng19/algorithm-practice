public class Solution {

 /*
 给你一个log file，List<String>，每个元素代表log file一行，在每个元素里面，有substring，他们用空格分开，比如"a1ws efg7 i90s", String里面只有字母和数字，第一个substring是id，依据id后面的substring给log file排序，字母在top。
比如input是
"fhie 1df8 sfds"
"fdsf 2def sees"
"efe2 br9o fjsd"
“asd1 awer jik9"

output是：
“asd1 awer jik9"
"efe2 br9o fjsd"
"fhie 1df8 sfds"
"fdsf 2def sees"
*/
    public List<String> sortLogs(List<String> logs) {

        if (logs == null || logs.size() == 0) {
            return logs;
        }

        Collections.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] os1 = o1.split(" ");
                String[] os2 = o2.split(" ");
                return comp(os1, os2, 1, 1);
            }

            private int comp(String[] os1, String[] os2, int i1, int i2) {
                if (i1 >= os1.length || i2 >= os2.length) {
                    return 0;
                }
                int v = compare1(os1[i2], os2[i2]);
                if (v == 0) {
                    return comp(os1, os2, i1 + 1, i2 + 1);
                } else {
                    return v;
                }
            }

            public int compare1(String thisString, String anotherString) {
                char v1[] = thisString.toCharArray();
                char v2[] = anotherString.toCharArray();
                int len1 = v1.length;
                int len2 = v2.length;
                int lim = Math.min(len1, len2);


                int k = 0;
                while (k < lim) {
                    char c1 = v1[k];
                    char c2 = v2[k];
                    if (Character.isDigit(c1) && !Character.isDigit(c2)) {
                        return 1;
                    }
                    if (!Character.isDigit(c1) && Character.isDigit(c2)) {
                        return -1;
                    }
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                    k++;
                }
                return len1 - len2;
            }
        });
        return logs;
    }
 
}