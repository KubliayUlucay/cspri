package List.Polynomial;

public class TermNode {
    protected Term data;
    protected TermNode next;

    // Constructor for terms with degree
    public TermNode(Term data) {
        this.data = data;
        this.next = null;
    }

    // Constructor for terms with exponents


    public void setNext(TermNode next) {
        this.next = next;
    }

    public TermNode getNext() {
        return next;
    }

    public Term getData() {
        return data;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (data.getCoefficient() != 0) {
            result.append(data.getCoefficient());
            if (data.getExponentX() > 0) {
                result.append("x").append(data.getExponentX());
            }
            if (data.getExponentY() > 0) {
                result.append("y").append(data.getExponentY());
            }
            if (data.getExponentZ() > 0) {
                result.append("z").append(data.getExponentZ());
            }
        }
        return result.toString();
    }
}