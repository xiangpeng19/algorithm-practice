class TimedValue {
    int timestamp;
    int val;

    public TimedValue(int val, int timestamp) {
        this.val = val;
        this.timestamp =timestamp;
    }
}

class TimedMap {

    Map<Integer, List<TimedValue>> map;

    public TimedMap() {
        map = new HashMap<>();
    }

    public void put(int key, int value, int timestamp) {
        TimedValue tv = new TimedValue(value, timestamp);
        if (!map.containsKey(key)) {
            List<TimedValue> l = new ArrayList<>();
            map.put(key, l);
        } else {
            List<TimedValue> l = map.get(key);
            int pos = 0;
            while (l.get(pos).timestamp < timestamp) {
                pos++;
            }
            l.add(pos, tv);
        }
    }

    public Integer get(int key, int timestamp) {
        Integer res = null;
        if (map.containsKey(key)) {
            List<TimedValue> l = map.get(key);
            int pos = 0;
            while(l.get(pos).timestamp < timestamp) {
                pos++;
                res = l.get(pos.val);
            }
            return res;
        } 
        return res;
    }
    
}