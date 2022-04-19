class Sentence{

    char[][] words;

    Sentence(char[]... words){
        this.words = words;
    }

    char[] getWordAtIndex(int index){
        return words[index];
    }

}