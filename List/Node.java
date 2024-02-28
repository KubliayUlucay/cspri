package List;

public class Node {
    protected int data;
    protected Node next;
    protected int coefficient;
    protected int exponentX;
    protected int exponentY;
    protected int exponentZ;


    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public int getData(){
        return data;
    }

    public String toString(){
        return "" + data;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponentX() {
        return exponentX;
    }

    public int getExponentY() {
        return exponentY;
    }

    public int getExponentZ() {
        return exponentZ;
    }
}
