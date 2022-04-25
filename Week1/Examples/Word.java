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
    void append(char add){
        //Our arrays are not resizeble, so we need a new array to the new word
        char[] appended = new char[wordChars.length+1];

        int index = 0;
        while(index < appended.length){
            //We need to know when we are done with original word
            if(index == wordChars.length){
                appended[index] = add;
            } else {
                appended[index] = wordChars[index];
            }
            index++;
        }

        wordChars = appended;

    }

    void append(char... add){
        //Our arrays are not resizeble, so we need a new array to the new word
        char[] appended = new char[wordChars.length + add.length];

        int index = 0;
        while(index < appended.length){
            //We need to know when we are done with original word
            if(index >= wordChars.length){
                appended[index] = add[index - wordChars.length];
            } else {
                appended[index] = wordChars[index];
            }
            index++;
        }

        wordChars = appended;

    }

    //Uppercase/lower (stretch)


    //Substring(starting ending)

    void printWord(){
        for(int i=0; i<wordChars.length; i++){
            System.out.print(wordChars[i]);
        }
    }
}