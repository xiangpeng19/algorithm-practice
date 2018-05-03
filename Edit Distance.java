class Solution {
    public int minDistance(String word1, String word2) {

        int[][] opt = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < opt.length; i++) {
            // convert any word into empty string - delete
            opt[i][0] = i;
        }

        for (int j = 0; j < opt[0].length; j++) {
            // convert empty string into any word - insert
            opt[0][j] = j;
        }


        for (int i = 1; i <= opt.length - 1; i++) {
            for (int j = 1; j <= opt[i].length - 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    opt[i][j] = opt[i - 1][j - 1];
                } else {
                    int op = opt[i - 1][j - 1]; // replace ith char to jth char
                    op = Math.min(op, opt[i - 1][j]); // delete ith char to match first j chars
                    op = Math.min(op, opt[i][j - 1]); // insert the char to jth position
                    //
                    opt[i][j] = 1 + op;
                }
            }
        }
        return opt[opt.length - 1][opt[0].length - 1];
    }      

}