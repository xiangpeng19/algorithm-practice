package excludes;

public class Logger {

    private Map<String, Integer> records = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, int message) {

        if (!records.containsKey(message)) {
            return false;
        } else {
            int preTime = records.get(message);
            if (timestamp - preTime > 10) {
                records.put(message, timestamp);
                return true;
            } 
        }

        return false;

    }

}
