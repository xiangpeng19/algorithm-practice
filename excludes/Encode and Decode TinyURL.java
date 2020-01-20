package excludes;

public class Codec {
    
    final String BASE_URL = "http://tinyurl/";
    Map<String, String> shortToLong = new HashMap<>();
    Map<String, String> longToShort = new HashMap<>();
    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int cons = 31;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return BASE_URL + longToShort.get(longUrl);
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        do {
            sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int index = (random.nextInt(100) * cons) % charSet.length();
                sb.append(charSet.charAt(index));
            }
        } while (longToShort.containsKey(sb.toString()));

        longToShort.put(longUrl, sb.toString());
        shortToLong.put(sb.toString(), longUrl);
        return BASE_URL + sb.toString();

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.replace(BASE_URL, "");
        return shortToLong.get(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));