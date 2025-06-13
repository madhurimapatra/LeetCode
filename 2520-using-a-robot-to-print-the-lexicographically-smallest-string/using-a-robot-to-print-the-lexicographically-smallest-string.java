class Solution {
    private char smallest(int[] rightFreq) {
        for (int i = 0; i < 26; ++i) {
            if (rightFreq[i] > 0)
                return (char) ('a' + i);  //This converts the index back to the actual character.
        }
        return 'z';//'z', if all frequencies are zero

    }

    public String robotWithString(String s) {
        int n = s.length();
        int[] rightFreq = new int[26];
        for (int i = 0; i < n; ++i) {
            rightFreq[s.charAt(i) - 'a']++; //Increments the count of the character at position i in the string.
        }

        StringBuilder t = new StringBuilder(); // Stack to hold characters temporarily
        StringBuilder res = new StringBuilder();// Final result string
        int pos = 0;// Current index in input string
        while (pos < n) {
            t.append(s.charAt(pos)); //Simulates pushing the current character onto a stack.
            rightFreq[s.charAt(pos) - 'a']--; //Reduces its frequency in the rightFreq array.

            while (t.length() > 0 && t.charAt(t.length() - 1) <= smallest(rightFreq)) {//If the top of the stack is smaller or equal to the smallest character remaining in rightFreq, we can safely move it to res.
                res.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
            pos++;
        }
        return res.toString();
    }
}