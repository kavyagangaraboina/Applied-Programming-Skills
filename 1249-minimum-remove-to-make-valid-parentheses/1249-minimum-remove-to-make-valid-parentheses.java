class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] a = s.toCharArray();
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') c++;
            else if (a[i] == ')') {
                if (c == 0) a[i] = '*';
                else c--;
            }
        }
        for (int i = a.length - 1; i >= 0 && c > 0; i--) {
            if (a[i] == '(') {
                a[i] = '*';
                c--;
            }
        }
        StringBuilder r = new StringBuilder();
        for (char ch : a) if (ch != '*') r.append(ch);
        return r.toString();
    }
}