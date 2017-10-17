import java.util.Stack;

public class Convert {

    public String decimalToBinary(int decimal){
        StringBuilder answer = new StringBuilder();
        Stack<Integer> binary = new Stack();
        int remainder = 0;

        while(decimal >= 1){
            remainder = decimal % 2;
            decimal /= 2;
            binary.push(remainder);
        }

        while(binary.size()>0){
            answer.append(binary.pop().toString());
        }

        return answer.toString();
    }

    public String binaryToDecimal(int binary) {
        int answer = 0;
        int count = 0;


        while (binary > 0) {
            if(binary % 10 != 1 && binary % 10 != 0)
                return "not binary";
            answer += ((binary % 10) * Math.pow(2, count));
            binary /= 10;
            count++;
        }
        return Integer.toString(answer);
    }

}
