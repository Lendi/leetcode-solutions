/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard:

Example 1:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

Note:

    You may use one character in the keyboard more than once.
    You may assume the input string will only contain letters of alphabet.

*/

public class Solution {
    public String[] findWords(String[] words) {

        String[] rows = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> hm = new HashMap<Character, Integer>();

        for(int i = 0; i < rows.length; i++)
        {
            for(char c: rows[i].toCharArray())
            {
                hm.put(c, i);
            }
        }

        List<String> result = new LinkedList<String>();

        for(String str : words)
        {
            if(str == " ") continue;
            int index = hm.get(str.toUpperCase().charAt(0));

            for(char ch: str.toUpperCase().toCharArray())
            {
                if(hm.get(ch) != index)
                {
                    index = -1;
                    break;
                }
            }

            if(index != -1) result.add(str);
        }

        return result.toArray(new String[0]);

    }
}
