public class WordMatch {
    private String word;

    public WordMatch(String word) {
        this.word = word;
    }

    public int scoreGuess(String guess) {
        if (guess.equals("")) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (guess.length() > word.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int reps = word.length() - guess.length() + 1;
        int ans = 0;
        for (int i = 0; i < reps; ++i) {
            String wordSub = word.substring(i, i + guess.length());
            if (wordSub.equals(guess)) {
                ans++;
            }
        }
        ans *= guess.length() * guess.length();
        return ans;
    }
    public String findBetterGuess(String s1, String s2) {
        int score1 = scoreGuess(s1), score2 = scoreGuess(s2);
        if (score1 == score2) {
            if (s1.compareTo(s2) > 0) {
                return s1;
            } else {
                return s2;
            }
        } else if (score1 < score2) {
            return s2;
        } else {
            return s1;
        }
    }
}
