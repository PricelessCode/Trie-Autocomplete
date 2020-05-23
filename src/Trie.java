import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public TrieNode getRoot() {
        return root;
    }

    public void printTrie(TrieNode tn) {
        if (tn.isEnd) {
            System.out.println(tn.wordString);
        }
        for (int i = 0; i < 26; i++) {
            if (tn.children[i] != null) {
                printTrie(tn.children[i]);
            }
        }
    }

    public void printLetters(TrieNode tn) {
        System.out.println(tn.letter);
        for (int i = 0; i < 26; i++) {
            if (tn.children[i] != null) {
                printLetters(tn.children[i]);
            }
        }
    }

    public void addWord(String word) {
        char[] charArray = word.toCharArray();
        TrieNode temp = root;
        TrieNode tn = null;

        int index = 0; // index for the word string

        // See if temp has the child with letter 'charArray[index]'(current index letter)
        tn = temp.children[charArray[index] - 'A'];

        // if the character node exists as a child (keep going)
        while (tn != null && index < charArray.length) {
            temp = tn; // temp for keep tracking of the parent
            tn = tn.children[charArray[index] - 'A'];

            if (tn != null) index++;
        }

        // Add the rest of the word if not found.
        for (; index < charArray.length; index++) {
            TrieNode node = new TrieNode(charArray[index]);
            temp.children[charArray[index] - 'A'] = node;
            temp = node;
        }

        temp.isEnd = true;
        temp.wordString = word;
    }

    public String[] wordsByPrefix(String prefix) {
        List<String> resultArray = new ArrayList<>();

        // input validation.
        if (prefix.equals("")) {
            System.out.println("Please enter any prefixes");
            return null;
        }

        // A variable for the last node. (Firstly, initialize it to root)
        TrieNode tn = root;

        // for the first few letters before the last letter, it should just traverse.
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            tn = tn.children[c - 'A'];
            // If it can't traverse to the given character anymore, return fail.
            if (tn == null) {
                System.out.println("No words found!");
                return null;
            }
        }

        // reach till the end of the prefix letter and the print the rest
        printTrie(tn);
//        return resultArray.toArray(new String[resultArray.size()]);
        return null;
    }
}
