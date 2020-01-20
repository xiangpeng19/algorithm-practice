package excludes;

class Solution {
    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) {
            return "";
        }

        String[] blocks = address.split("[.]");

        return String.join("[.]", blocks);
    }
}