public class TrieNode {
    private final int ALPHABET_SIZE = 26;
    char letter;
    TrieNode[] children;
    boolean isEnd;
    String wordString;

    public TrieNode(char letter) {
        children = new TrieNode[ALPHABET_SIZE];
        this.letter = letter;
    }
}
