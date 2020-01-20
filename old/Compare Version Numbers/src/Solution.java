/**
 * Created by lxp19_000 on 2015-02-26.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");

        int longest = s1.length > s2.length? s1.length: s2.length;

        for (int i = 0; i < longest; i++) {
            int ver1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int ver2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            if (ver1 > ver2) return 1;
            if (ver1 < ver2) return -1;
        }
        return 0;
    }



    public static void main(String[] args) {
        String v1 = "1";
        String v2 = "1.1";
        System.out.println(new Solution().compareVersion(v1, v2));
    }
}
