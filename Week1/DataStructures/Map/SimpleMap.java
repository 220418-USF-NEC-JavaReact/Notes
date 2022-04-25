class SimpleMap{
    private String[] theMapKey;
    private String[] theMapValue;

    SimpleMap(){
        theMapKey = new String[0];
        theMapValue = new String[0];
    }

    public void put(String key, String value){
        String[] temp1 = new String[theMapKey.length + 1];
        String[] temp2 = new String[theMapValue.length + 1];
        for (int i = 0; i < theMapKey.length; i++){
            temp1[i] = theMapKey[i];
        }
        temp1[theMapKey.length] = key;
        for (int i = 0; i < theMapValue.length; i++){
            temp2[i] = theMapValue[i];
        }
        temp2[theMapValue.length] = value;
        theMapKey = temp1;
        theMapValue = temp2;
    }

    public void remove(String key){
        if (!(theMapKey.length == 0)){
            String[] temp1 = new String[theMapKey.length - 1];
            String[] temp2 = new String[theMapValue.length - 1];
            int indexWeFound = -1;
            for(int i = 0; i < theMapKey.length; i++){
                if (theMapKey[i].equals(key)){
                    indexWeFound = i;
                }
            }
            for(int i = 0; i < theMapKey.length; i++){
                if(indexWeFound == i){
                }else if(indexWeFound > i){
                    temp1[i-1] = theMapKey[i];
                    temp2[i-1] = theMapValue[i];
                }else if(indexWeFound < i){
                    temp1[i] = theMapKey[i];
                    temp2[i] = theMapValue[i];
            
            }
            theMapKey = temp1;
            theMapValue = temp2;
        }
        }
    }
    public String[] getTheMapKey(){
        return this.theMapKey;
    }
    public void setTheMapKey(String[] theMapKey){
        this.theMapKey = theMapKey;
    }
    public String[] getTheMapValue(){
        return this.theMapKey;
    }
    public void setTheMapValue(String[] theMapValue){
        this.theMapValue = theMapValue;
    }

}