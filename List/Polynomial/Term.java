package List.Polynomial;

public class Term {
    int coefficient;
    int degree;
    int exponentX;
    int exponentY;
    int exponentZ;

    // Constructor for terms with degree
    public Term(int coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
        this.exponentX = 0;
        this.exponentY = 0;
        this.exponentZ = 0;
    }

    // Constructor for terms with exponents
    public Term(int coefficient, int exponentX, int exponentY, int exponentZ) {
        this.coefficient = coefficient;
        this.exponentX = exponentX;
        this.exponentY = exponentY;
        this.exponentZ = exponentZ;
        //this.degree = 0; // Assuming that terms with exponents don't have a degree
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getExponentX() {
        return exponentX;
    }

    public void setExponentX(int exponentX) {
        this.exponentX = exponentX;
    }

    public int getExponentY() {
        return exponentY;
    }

    public void setExponentY(int exponentY) {
        this.exponentY = exponentY;
    }

    public int getExponentZ() {
        return exponentZ;
    }

    public void setExponentZ(int exponentZ) {
        this.exponentZ = exponentZ;
    }
/*public void setNext(TermNode next) {
            this.next = next;
        }

        public TermNode getNext() {
            return next;
        }

        public Term getData() {
            return data;
        }*/

      /*  public String toString() {
            if (data.degree != 1 && data.degree != 0) {
                return "" + data.coefficient + "x" + data.degree;
            } else if (data.degree == 1) {
                return "" + data.coefficient + "x";
            } else {
                return "" + data.coefficient;
            }
        }*/
    }
