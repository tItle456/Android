package com.example.a13522.myfirsthomework;

import java.math.BigDecimal;

public class Calculator {
    private StringBuilder tempStr;// 用于临时存放输入的数值
    private BigDecimal num1;// 数字1
    private BigDecimal num2;// 数字2
    private String num3;// 数字3，用来存放进制转换后的数值
    private BigDecimal m;// 用来保存计算器中存储的数值
    private boolean point;// 判断当前数值是不是小数
    private boolean input;// 判断当前数值是否被保存
    private boolean error;// 判断当前是否出现错误，例如除数为0
    private boolean n3;// 判断当前结果是否为进制转换后的结果
    private char sign;// 记录符号
    private int digit;// digit位以上时采用科学计数法
    private int indexMax = 300;// 最高数量级
    private int indexMin = -100;// 最低数量级

    Calculator() {
        tempStr = new StringBuilder("0");
        num1 = new BigDecimal("0");
        num2 = new BigDecimal("0");
        num3 = "";
        m = new BigDecimal("0");
        point = false;
        input = false;
        error = false;
        n3 = false;
        sign = 0;
        digit = 6;
    }

    public void AC() {
        tempStr = new StringBuilder("0");
        num1 = new BigDecimal("0");
        num2 = new BigDecimal("0");
        num3 = "";
        point = false;
        input = false;
        error = false;
        n3 = false;
        sign = 0;
    }

    public void minus() {
        if (!input) {
            if (tempStr.charAt(0) == '-') {
                tempStr.delete(0, 1);
            } else {
                tempStr.insert(0, "-");
            }
        } else {
            input();
            num1 = num1.multiply(new BigDecimal("-1"));
        }
    }

    public void percent() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("0")) != 0) {
            num1 = num1.multiply(new BigDecimal("0.01"));
        }
    }

    public void mc() {
        m = new BigDecimal("0");
    }

    public void mSub() {
        if (!input) {
            input();
        }
        m = m.subtract(num1);
    }

    public void mAdd() {
        if (!input) {
            input();
        }
        m = m.add(num1);
    }

    public void mr() {
        if (!input) {
            input();
        }
        num1 = new BigDecimal(m.stripTrailingZeros().toPlainString());
    }

    public void square() {
        if (!input) {
            input();
        }
        num1 = num1.multiply(num1);
    }

    public void cube() {
        if (!input) {
            input();
        }
        num1 = num1.multiply(num1);
        num1 = num1.multiply(num1);
    }

    public void factorial() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("0")) < 0 || point || num1.compareTo(new BigDecimal("166")) > 0) {
            error = true;
        } else {
            if (num1.compareTo(new BigDecimal("0")) == 0) {
                num1 = new BigDecimal("1");
            } else {
                BigDecimal temp = new BigDecimal("1");
                for (int i = 1;; i++) {
                    temp = temp.multiply(new BigDecimal(i + ""));
                    if (num1.compareTo(new BigDecimal(i + "")) == 0) {
                        num1 = temp;
                        break;
                    }
                }
            }
        }
    }

    public void countBackwards() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("0")) == 0) {
            error = true;
        } else {
            num1 = new BigDecimal("1").divide(num1, digit, BigDecimal.ROUND_HALF_UP);
        }
    }

    public void ePower() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("-230.258509")) >= 0 && num1.compareTo(new BigDecimal("690.775527")) <= 0) {
            num1 = new BigDecimal(Math.pow(Math.E, Double.parseDouble(num1.stripTrailingZeros().toPlainString())));
        } else {
            error = true;
        }
    }

    public void tenPower() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("-100")) >= 0 && num1.compareTo(new BigDecimal("300")) <= 0) {
            num1 = new BigDecimal(Math.pow(10, Double.parseDouble(num1.stripTrailingZeros().toPlainString())));
        } else {
            error = true;
        }
    }

    public void sin() {
        if (!input) {
            input();
        }
        num1 = new BigDecimal(Math.sin(Double.parseDouble(num1.stripTrailingZeros().toPlainString())));
    }

    public void cos() {
        if (!input) {
            input();
        }
        num1 = new BigDecimal(Math.cos(Double.parseDouble(num1.stripTrailingZeros().toPlainString())));
    }

    public void tan() {
        if (!input) {
            input();
        }
        num1 = new BigDecimal(Math.tan(Double.parseDouble(num1.stripTrailingZeros().toPlainString())));
    }

    public void e() {
        if (!input) {
            input();
        }
        num1 = new BigDecimal(Math.E);
    }

    public void pi() {
        if (!input) {
            input();
        }
        num1 = new BigDecimal(Math.PI);
    }

    public void toHexString() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("0")) < 0 || num1.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0 || point) {
            error = true;
        } else {
            num3 = Integer.toHexString(Integer.valueOf(num1.stripTrailingZeros().toPlainString()));
            n3 = true;
        }
    }

    public void toOctalString() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("0")) < 0 || num1.compareTo(new BigDecimal("134217727")) > 0 || point) {
            error = true;
        } else {
            num3 = Integer.toOctalString(Integer.valueOf(num1.stripTrailingZeros().toPlainString()));
            n3 = true;
        }
    }

    public void toBinaryString() {
        if (!input) {
            input();
        }
        if (num1.compareTo(new BigDecimal("0")) < 0 || num1.compareTo(new BigDecimal("511")) > 0 || point) {
            error = true;
        } else {
            num3 = Integer.toBinaryString(Integer.valueOf(num1.stripTrailingZeros().toPlainString()));
            n3 = true;
        }
    }

    public void loge() {
        if (!input) {
            input();
        }
        if (num1.compareTo(
                new BigDecimal("0")) > 0 /*
         * && num1.compareTo(new
         * BigDecimal("690.775527")) <= 0
         */) {
            num1 = new BigDecimal(Math.log(Double.parseDouble(num1.stripTrailingZeros().toPlainString())));
        } else {
            error = true;
        }
    }

    public void log10() {
        if (!input) {
            input();
        }
        if (num1.compareTo(
                new BigDecimal("0")) > 0 /*
         * && num1.compareTo(new
         * BigDecimal("690.775527")) <= 0
         */) {
            num1 = new BigDecimal(Math.log10(Double.parseDouble(num1.stripTrailingZeros().toPlainString())));
        } else {
            error = true;
        }
    }

    public void increase(int num) {
        if (input) {
            clear0();
            clear1();
            clear3();
        }
        if (countNum(tempStr.toString(), digit - 1)) {
            if (tempStr.toString().charAt(0) == '0' && !point) {
                tempStr = new StringBuilder(num + "");
            } else if (tempStr.length() > 1 && tempStr.toString().charAt(0) == '-'
                    && tempStr.toString().charAt(1) == '0') {
                tempStr = new StringBuilder("-" + num + "");
            } else {
                tempStr.append(num);
            }
        }
    }

    public void point() {
        if (!point && countNum(tempStr.toString(), digit - 1)) {
            tempStr.append(".");
            point = true;
        }
    }

    public void divide() {
        sign = '÷';
        if (!input) {
            input();
        }
        num2 = num1;
        clear0();
        clear1();
    }

    public void multiply() {
        sign = '×';
        if (!input) {
            input();
        }
        num2 = num1;
        clear0();
        clear1();
    }

    public void subtract() {
        sign = '－';
        if (!input) {
            input();
        }
        num2 = num1;
        clear0();
        clear1();
    }

    public void add() {
        sign = '＋';
        if (!input) {
            input();
        }
        num2 = num1;
        clear0();
        clear1();
    }

    public void equal() {
        if (!input) {
            input();
        }
        switch (sign) {
            case 0:
                break;
            case '÷':
                equalDivide();
                break;
            case '×':
                equalMultiply();
                break;
            case '－':
                equalSubtract();
                break;
            case '＋':
                equalAdd();
                break;
            default:
                break;
        }
        clear2();
        sign = 0;
    }

    private void equalDivide() {
        if (num1.equals(new BigDecimal("0"))) {
            error();
        } else {
            num1 = num2.divide(num1, digit, BigDecimal.ROUND_HALF_UP);
            num2 = new BigDecimal("0");
        }
    }

    private void equalMultiply() {
        num1 = num2.multiply(num1);
        num2 = new BigDecimal("0");
    }

    private void equalSubtract() {
        num1 = num2.subtract(num1);
        num2 = new BigDecimal("0");
    }

    private void equalAdd() {
        num1 = num2.add(num1);
        num2 = new BigDecimal("0");
    }

    private boolean countNum(String str, int target) {
        char c;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                num++;
            }
        }
        return num <= target;
    }

    private void clear0() {
        tempStr = new StringBuilder("0");
        point = false;
        input = false;
        error = false;
    }

    private void clear1() {
        num1 = new BigDecimal("0");
    }

    private void clear2() {
        num2 = new BigDecimal("0");
    }

    private void clear3() {
        num3 = "";
        n3 = false;
    }

    private void input() {
        num1 = new BigDecimal(tempStr.toString());
        input = true;
        tempStr = new StringBuilder("0");
    }

    private void error() {
        error = true;
    }

    private String scientificNotation(BigDecimal num) {
        String str = num.stripTrailingZeros().toPlainString();
        StringBuilder Str = new StringBuilder();
        int i = 0;
        int count = 0;
        int index = 0;
        boolean small = false;
        boolean big = false;
        BigDecimal result;
        if (str.charAt(i) == '-') {
            Str = new StringBuilder("-");
            i++;
        }
        while (str.charAt(i) == '0') {
            i++;
            if (str.charAt(i) == '.') {
                i++;
            }
        }
        while (i < str.length() && count < digit) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (count == 1) {
                    Str.append(".");
                }
                Str.append(str.charAt(i));
                count++;
            }
            i++;
        }
        result = new BigDecimal(Str.toString());
        BigDecimal temp;
        String tempStr;
        while (true) {
            tempStr = String.valueOf(Math.pow(10, index));
            temp = result.multiply(new BigDecimal(tempStr));
            if (index > indexMax || index < indexMin) {
                return "错误";
            }
            if (num.compareTo(new BigDecimal("0")) > 0) {
                if (temp.compareTo(num) < 0) {
                    small = true;
                    index++;
                    if (big) {
                        index--;
                        break;
                    }
                } else if (temp.compareTo(num) > 0) {
                    big = true;
                    index--;
                    if (small) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                if (temp.compareTo(num) < 0) {
                    small = true;
                    index--;
                    if (big) {
                        index++;
                        break;
                    }
                } else if (temp.compareTo(num) > 0) {
                    big = true;
                    index++;
                    if (small) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Str.toString() + "e" + index;
    }

    public String toString() {
        if (error) {
            return "错误";
        }
        if (n3) {
            return num3;
        }
        if (!input) {
            return tempStr.toString();
        } else {
            String flags = num1.stripTrailingZeros().toPlainString();
            if ((num1.abs().compareTo(new BigDecimal("999999")) < 1
                    && num1.abs().compareTo(new BigDecimal("0.00001")) > -1 && countNum(flags, digit))
                    || num1.compareTo(new BigDecimal("0")) == 0) {
                return flags;
            } else {
                return scientificNotation(num1);
            }
        }
    }

    public StringBuilder getTempStr() {
        return tempStr;
    }

    public void setTempStr(StringBuilder tempStr) {
        this.tempStr = tempStr;
    }

    public BigDecimal getNum1() {
        return num1;
    }

    public void setNum1(BigDecimal num1) {
        this.num1 = num1;
    }

    public BigDecimal getNum2() {
        return num2;
    }

    public void setNum2(BigDecimal num2) {
        this.num2 = num2;
    }

    public String getNum3() {
        return num3;
    }

    public void setNum3(String num3) {
        this.num3 = num3;
    }

    public BigDecimal getM() {
        return m;
    }

    public void setM(BigDecimal m) {
        this.m = m;
    }

    public boolean isPoint() {
        return point;
    }

    public void setPoint(boolean point) {
        this.point = point;
    }

    public boolean isInput() {
        return input;
    }

    public void setInput(boolean input) {
        this.input = input;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isN3() {
        return n3;
    }

    public void setN3(boolean n3) {
        this.n3 = n3;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getIndexMax() {
        return indexMax;
    }

    public void setIndexMax(int indexMax) {
        this.indexMax = indexMax;
    }

    public int getIndexMin() {
        return indexMin;
    }

    public void setIndexMin(int indexMin) {
        this.indexMin = indexMin;
    }
}