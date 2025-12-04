package com.src.main.leetcode.problems;

/**
 * 408. Valid Word Abbreviation
 */
class LC408 {

    public boolean validWordAbbreviation(String word, String abbr) {

        int i = 0; // pointer for word
        int j = 0; // pointer for abbr

        // sahan --> s3n
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false; // leading zero invalid

                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(abbr.substring(start, j));
                i += num;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {

        LC408 sol = new LC408();
        System.out.println(sol.validWordAbbreviation("sahan", "s3n")); // true
        //System.out.println(sol.validWordAbbreviation("internationalization", "i12iz4n")); // true
        //System.out.println(sol.validWordAbbreviation("apple", "a2e")); // false
        //System.out.println(sol.validWordAbbreviation("substitution", "s10n")); // true
        //System.out.println(sol.validWordAbbreviation("word", "w02d")); // false
    }
}

