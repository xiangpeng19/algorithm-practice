public class Solution {


    private void OrderProductsByPriority(String[] productCode) {
        if (productCode == null || productCode.length == 0) {
            return;
        }

        int start = 0, end = productCode.length - 1;
        int i = 0;

        while (i <= end) {
            int prio = getPriority(productCode[i]);
            if (prio == 1) {
                swap(productCode, start, i);
                start++;
                i++;
            } else if (prio == 3) {
                swap(productCode, end, i);
                end--;
            } else {
                i++;
            }
        }

        System.out.println("jaja");

    }

    private void swap(String[] codes, int i, int j) {
        String t = codes[i];
        codes[i] = codes[j];
        codes[j] = t;
    }


    private int getPriority(String productCode) {
        if (productCode.startsWith("1")) {
            return 1;
        } else if (productCode.startsWith("2")) {
            return 2;
        } else {
            return 3;
        }
    }

}