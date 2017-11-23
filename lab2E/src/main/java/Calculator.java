public class Calculator {
    public double operation(double first,char sign, double last){
        switch (sign){
            case '+':
                return sum(first,last);
            case '-':
                return sub(first,last);
            case '*':
                return mult(first,last);
            case '/':
                return div(first,last);
            default:
                throw new ArithmeticException("ArithmeticException: Incorrect action sign");
        }
    }

    private double sum(double first, double last){
        return first+last;
    }

    private double sub(double first, double last){return first-last; }

    private double mult(double first, double last){
        return first*last;
    }

    private double div(double first, double last){
        return first/last;
    }
}
