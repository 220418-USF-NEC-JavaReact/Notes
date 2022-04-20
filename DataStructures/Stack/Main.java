class Main {
    
        public static void main(String[] args){
            Stack smallStack = new Stack();
            smallStack.push(34);
            smallStack.push(32);
            smallStack.push(44);
            smallStack.push(55);
            smallStack.peek();
            smallStack.pop();
            smallStack.pop();
            smallStack.push(333);
            smallStack.push(677);
            smallStack.push(445);
            System.out.println(smallStack.pop() + " Popped from smallStack");
            System.out.println("Top element is: " + smallStack.peek());
            System.out.println("Elements Present in Stack: ");
            smallStack.print();
            
        }
    
}
