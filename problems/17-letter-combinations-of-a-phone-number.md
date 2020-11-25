# Letter Combinitaions of a phone number

[Return](../README.md)

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
```

Constraints:

- 0 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9'].

# Keypad

- 2 => abc
- 3 => def
- 4 => ghi
- 5 => jkl
- 6 => mno
- 7 => pqrs
- 8 => tuv
- 9 => wxyz

# Cleaner Solution:

```Java
class Solution {
    List<String> strings = new LinkedList<String>();

    Map<Character, char[]> keypad = new HashMap<Character, char[]>() {{
        put('2', new char[] {'a', 'b', 'c'});
        put('3', new char[] {'d', 'e', 'f'});
        put('4', new char[] {'g', 'h', 'i'});
        put('5', new char[] {'j', 'k', 'l'});
        put('6', new char[] {'m', 'n', 'o'});
        put('7', new char[] {'p', 'q', 'r', 's'});
        put('8', new char[] {'t', 'u', 'v'});
        put('9', new char[] {'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {
        recCombo(digits, "");
        return strings;
    }

    public void recCombo(String digits, String currStr) {
        if (digits.length() == 0) {
            // append currStr to strings
            if (currStr != "") {
                strings.add(currStr);
            }
            return;
        }

        // get numeric val of first digit
        char cDig = digits.charAt(0);
        // String cDigStr = cDig.toString();

        // get char[] for the first digit
        char[] vals = keypad.get(cDig);

        // remove first digit from digit string
        digits = digits.substring(1);


        // formulate 3-4 next values & utilize recursion
        for (char letter : vals) {
            recCombo(digits, currStr + letter);
        }

        return;
    }
}
```

# Messy Yet Functional Solution

```Java
class Solution {
    List<String> strings = new LinkedList<String>();

    public List<String> letterCombinations(String digits) {
        recCombo(digits, "");
        return strings;
    }

    public void recCombo(String digits, String curr) {
        if (digits.length() == 0) {
            // append curr to strings
            if (curr != "") {
                strings.add(curr);
            }
            return;
        }

        // get numeric val of first digit
        char cDig = digits.charAt(0);
        // remove first digit from string
        digits = digits.substring(1);


        // formulate 3-4 next values & utilize recursion
        if (cDig < '7') {
            int chr1Int = (int)cDig;
            int chr1 = (chr1Int - 50)*3 + 97;

            for (int i=0; i < 3; i++) {
                char nChar = (char)(chr1 + i);
                recCombo(digits, curr+ nChar);
            }
        } else if (cDig == '7') { // consider 4th digit
            int chr1Int = (int)cDig;
            int chr1 = (chr1Int - 50)*3 + 97;

            for (int i=0; i < 4; i++) {
                char nChar = (char)(chr1 + i);
                recCombo(digits, curr+ nChar);
            }
        } else if (cDig == '8') {
            int chr1Int = (int)cDig;
            int chr1 = (chr1Int - 50)*3 + 98;

            for (int i=0; i < 3; i++) {
                char nChar = (char)(chr1 + i);
                recCombo(digits, curr+ nChar);
            }
        } else if (cDig == '9') {
            int chr1Int = (int)cDig;
            int chr1 = (chr1Int - 50)*3 + 98;

            for (int i=0; i < 4; i++) {
                char nChar = (char)(chr1 + i);
                recCombo(digits, curr+ nChar);
            }
        }
        return;
    }
}
```
