package week03;

public class Operation {

    private int leftOperand;
    private int rightOperand;

    public Operation(String operation) {
        int indexPlus = operation.indexOf("+");
        int leftOperand = Integer.parseInt(operation.substring(0, indexPlus).trim());
        int rightOperand = Integer.parseInt(operation.substring(indexPlus + 1).trim());
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int getResult() {
        return leftOperand + rightOperand;
    }
}
