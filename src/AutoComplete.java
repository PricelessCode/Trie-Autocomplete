public class AutoComplete {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.addWord("HELLOO");
        t.addWord("HELL");
        t.addWord("HELLXX");
        t.addWord("WHAXXSDF");
        t.addWord("WHATTASD");
        t.addWord("WASDDD");
        t.addWord("WASXXDS");

//        t.printTrie(t.getRoot());
//        t.printLetters(t.getRoot());
        t.wordsByPrefix("WAS");

    }
}
