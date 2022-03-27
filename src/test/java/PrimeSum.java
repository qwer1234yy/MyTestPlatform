public class PrimeSum {
    public static void main(String[] args){

    }
    public static boolean isP(int num){
        if (num < 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        for (int i = 2; i < num; i++) {

            if (num % i == 0) {
                return false;
            }

        }

        return true;
    }
    static long sm(int a){
        int sum = 0;
        for (int i = 2; i < a; i++) {

            if (isP(i)) {
                sum += i;
            }

        }



        return sum;
    }
}
