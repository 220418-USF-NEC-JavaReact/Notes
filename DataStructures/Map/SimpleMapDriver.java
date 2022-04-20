class SimpleMapDriver {
    public static void main (String[] args){
        SimpleMap map1 = new SimpleMap();
        map1.put("London", "England");
        map1.put("Paris", "France");
        map1.put("Berlin", "Germany");
        map1.put("Kyiv", "Ukraine");
        map1.remove("London");

        System.out.println(map1.getTheMapKey()[1]);
        System.out.println(map1.getTheMapValue()[1]);
    }
}