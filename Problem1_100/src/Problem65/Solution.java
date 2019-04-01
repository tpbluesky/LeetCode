package Problem65;

import java.util.regex.Pattern;

class Solution {
    private Pattern p = Pattern.compile("^[+-]?[0-9]*[.]?[0-9]+(e[+-]?[0-9]+)?$|^[+-]?[0-9]+[.]?[0-9]*(e[+-]?[0-9]+)?$");

    public boolean isNumber1(String s) {
        return p.matcher(s.trim()).matches();
    }

    public boolean isNumber(String s) {
        try {
            for (int i = 0; i < s.length(); ++i)
                if (Character.isLetter(s.charAt(i)) && s.charAt(i) != 'e') return false;
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
