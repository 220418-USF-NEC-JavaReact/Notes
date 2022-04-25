class Map{
    private String[] theMapKey;
    private String[] theMapValue;
    private String[] theValueKey;

    Map(){}

    //We have the map data structure 

    // A Map is an object that maps keys to values.
// A map cannot contain duplicate keys.
// Each key can map to at most one value.

// 2- Are there different ways to implement it? If so what are they?
// three general-purpose Map implementations:
// a) HashMap -- is a hash table based implementation of Map interface
// b) TreeMap -- 
// c) LinkedHashMap

// 3- What is your data structure useful for:
// Maps are useful to retrieve and update elements by keys.
// Some common scenarios can be
// A map of zip codes and address.
// A map of managers and employees

// Implementation
// 1- What version/implentation of that data structure did you go for?
// 2- What are the most basic methods needed to access/store/delete elements from your structure?
// basic methods are get(), put(), remove()
//  - How do you go about adding or deleting elements?
// to delete elements from the Map we use clear()








    public void put(String key, String value){
        String[] temp1 = new String[theMapKey.length + 1];
        String[] temp2 = new String[theMapValue.length + 1];
        for(int i = 0; i < theMapKey.length; i++){
            temp1[i] = theMapKey[i];
        }

        temp1[theMapKey.length] = key;
        for(int i = 0; i < theMapValue.length; i++){
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
        int IndexWeFound;
        for(int i = 0; i < theMapKey.length; i++){
            if(theMapKey[i].equals(key)){
                IndexWeFound = i;
            }
        }
        for (int i = 0; i < theMapKey.length; i++){
            if(IndexWeFound == i){
                
            }else if(IndexWeFound > i){
                temp1[i-1] = theMapKey[i];
            }else if(IndexWeFound < i){
                temp1[i] = theMapKey[i];
            }
            if(IndexWeFound == i){
                
            }else if(IndexWeFound > i){
                temp1[i-1] = theMapValue[i];
            }else if(IndexWeFound < i){
                temp1[i] = theMapValue[i];
            }
        }

        theMapKey = temp1;
        theMapValue = temp2;

       }
    }

    public String[] getTheMapKey(){
        return this.theMapKey;
    }

    public void setTheMapKey(){
        this.theMapKey = theMapKey;
    }

    public String[] getTheMapValue(){
        return this.theMapValue;
    }

    public void setTheMapValue(){
        this.theMapValue = theMapValue;
    }
}