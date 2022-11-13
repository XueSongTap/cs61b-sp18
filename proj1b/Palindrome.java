public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int n = word.length();
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < n; i++) {
            wordDeque.addLast(word.charAt(i));
        }

        return wordDeque;
    }
    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        while (d.size() > 0) {
            if (d.removeLast() != d.removeFirst()) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        } else if (!cc.equalChars((char) d.removeFirst(), (char) d.removeLast())) {
            return false;
        } else {
            return isPalindromeHelper(d, cc);
        }
    }
}
