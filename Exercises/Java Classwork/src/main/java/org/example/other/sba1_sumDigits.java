package org.example.other;

public class sba1_sumDigits {
    public static void main(String[] args) {
    }

    public static int getDigitsSum3(int largeNumber) {
        int sum3 = 0;
        String largeNum = "" + largeNumber;
        for (int i = 0; i < largeNum.length(); i++) {
            int digits = Integer.parseInt("" + largeNum.charAt(i));
            sum3 += digits;
        }
        return sum3;
    }

        public static int getDigitsSum2 ( int largeNumber){      //2nd option, by Ben
            int sum2 = 0;
            for (int num = largeNumber; num != 0; num /= 10) {
                sum2 += num % 10;
            }
            return sum2;
        }

        public static int getDigitsSum(int largeNumber){
            int sum = 0;
            String strNum = "" + largeNumber;
            for (int i = 0; i < strNum.length(); i++) {
                int digits = Character.getNumericValue(strNum.charAt(i));
                sum += digits;
            }
            return sum;
        }
    }

