class Word {

    char[] wordChars;
    //We might want some constructor
    //A word is just going to be some string of characters
    Word(char... word){
        //The varargs gets converted to a array
        wordChars = word;
    }

    Word(int length){
        this.wordChars = new char[length];
    }

    Word(){
        this.wordChars = new char[0];
    }

    //We might want some methods to see how long the word is
    int wordLength(){
        //The length parameter of arrays gives us how large the array is
        return wordChars.length;
    }

    //Letter at a specific index
    char letterAtIndex(int index){
        //We can access the index of an array with the bracket notation
        return wordChars[index];
    }

    //Method to append a character

    //Uppercase/lower (stretch)


    //Substring(starting ending)
}