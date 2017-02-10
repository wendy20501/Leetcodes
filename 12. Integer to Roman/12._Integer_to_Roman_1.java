public class Solution {
    public String intToRoman(int num) {
        String str = "";
        for (int i = 0; i < num / 1000; i++) {
            str += "M";
        }
        num = num % 1000;
        if (num >= 900) {
            str += "CM";
            num -= 900;
        } else if (num >= 500) {
            str += "D";
            num -= 500;
        } else if (num >= 400) {
            str += "CD";
            num -= 400;
        }
        
        for (int i = 0; i < num / 100; i++) {
            str += "C";
        }
        num = num % 100;
        
        if (num >= 90) {
            str += "XC";
            num -= 90;
        } else if (num >= 50) {
            str += "L";
            num -= 50;
        } else if (num >= 40) {
            str += "XL";
            num -= 40;
        }
        
        for (int i = 0; i < num / 10; i++) {
            str += "X";
        }
        num = num % 10;
        
        if (num >= 9) {
            str += "IX";
            num -= 9;
        } else if (num >= 5) {
            str += "V";
            num -= 5;
        } else if (num >= 4) {
            str += "IV";
            num -= 4;
        }
        
        for (int i = 0; i < num; i++) {
            str += "I";
        }
        
        return str;
    }
}