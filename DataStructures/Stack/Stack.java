class Stack {

    static final int max = 1000;
    public int top;
    public int arr[] = new int[max];

    public boolean isEmpty(){
        return (top<0);
    }
    public Stack(){
        top = -1;
    }


    public boolean push(int x){
        if (top >= (max - 1)){
            System.out.println("Stack Overflowww");
            return false;
        }
        else{
            arr[++top] = x;
            System.out.println(x + " Pushed into the Stack");
            return true;
        }
    }

    public int pop(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = arr[top--];
            return x;
        }
    
    }

    public int peek(){
        if (top<0){
            System.out.println("Stack Underflow/Empty");
            return 0;
        } else {
            int x = arr[top];
            return x;
        }
    }

    public void print() {
        for (int i = top; i>-1;i--){
            System.out.print(" " + arr[i]);
        }
    }
}
