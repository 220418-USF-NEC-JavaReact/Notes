class WordDriver{

    public static void main(String args[]){
        Word noargsWord = new Word();
        System.out.println(noargsWord.wordLength());
        Word varargsWord = new Word('H', 'e', 'l', 'l', 'o');
        System.out.println(varargsWord.wordLength());
        System.out.print(varargsWord.letterAtIndex(0));
        System.out.print(varargsWord.letterAtIndex(1));
        System.out.print(varargsWord.letterAtIndex(2));
        System.out.print(varargsWord.letterAtIndex(3));
        System.out.print(varargsWord.letterAtIndex(4));

        char[] word1 = {'H', 'e', 'l', 'l', 'o'};
        char[] word2 = {'W', 'o', 'r', 'l', 'd', '!'};

        Sentence s = new Sentence(word1, word2);
        System.out.print(s.getWordAtIndex(1).length);
    }

}