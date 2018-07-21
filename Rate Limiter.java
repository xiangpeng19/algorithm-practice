class Solution {
    public boolean allow() {
        int rate = 10;
        int lastUpdateTime = -1;
        int count = 0;

        while (receive()) {
            int cur = Date.now();
            if (lastUpdateTime == -1) {
                count++;
                lastUpdateTime = cur;
            }
            
            if (cur - lastUpdateTime >= 1 min) {
                lastUpdateTime = cur;
                count = 1;
            } else if (count < rate) {
                count++;
            } else {
                reject();
            }
        }

    }

}