import java.util.ArrayList;
import java.util.List;

public class ValidCreditCard {

    public static boolean creditCardValidator(Long creditCardNumber){

        int numDigits = 0;
        List<Integer> reversedCreditCardDigitArray = new ArrayList<Integer>();

        for(Long i = creditCardNumber; i > 0L; i = i/10){
            reversedCreditCardDigitArray.add((int)(i%10));
            numDigits++;
        }

        if(numDigits < 14 || numDigits > 19){
            return false;
        }

        int checkDigit = (int) (creditCardNumber % 10);
        //remove check digit from reversed array
        reversedCreditCardDigitArray.remove(0);

        for(int j = 0; j < reversedCreditCardDigitArray.size(); j++){
            if(j%2 == 0){
                int newDigit = reversedCreditCardDigitArray.get(j) * 2;
                if(newDigit < 10) {
                    reversedCreditCardDigitArray.set(j, newDigit);
                }
                else{
                    int firstDigit = newDigit % 10;
                    int secondDigit = (newDigit / 10) % 10;
                    newDigit = firstDigit + secondDigit;
                    reversedCreditCardDigitArray.set(j,newDigit);
                }
            }
        }

        int sum = 0;
        for (Integer integer : reversedCreditCardDigitArray) {
            sum += integer;
        }

        return 10 - sum % 10 == checkDigit;
    }

    public static void main(String[] args){
        System.out.println("helo");
    }
}
