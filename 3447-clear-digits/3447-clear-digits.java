//  brute force approch 
// 0123456 <--- index
// abc45gf

//

// after deleting one by one
// 012345
// abc5gf

// now deleting the left side character at index 2

// after deleting the both char & digit the string shifts like this

// 01234
// ab5gf

// now you can ses you have to decrease the value of index to catch the another
// digit ,otherwise it will missed out,so i-- is neccesasary

// stack based approch

class Solution {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
