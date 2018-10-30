package com.example.a13522.myfirsthomework;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends BaseActivity {
    Calculator calculator;
    TextView textView;
    int digit = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        textView = findViewById(R.id.result);
        textView.setText(calculator.toString());
        Log.v("Calculator", "ok");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 横竖屏切换前调用，保存用户想要保存的数据，以下是样例
        outState.putString("tempStr", calculator.getTempStr().toString());
        outState.putString("num1", calculator.getNum1().stripTrailingZeros().toPlainString());
        outState.putString("num2", calculator.getNum2().stripTrailingZeros().toPlainString());
        outState.putString("num3", calculator.getNum3());
        outState.putString("m", calculator.getM().stripTrailingZeros().toPlainString());
        outState.putBoolean("point", calculator.isPoint());
        outState.putBoolean("input", calculator.isInput());
        outState.putBoolean("error", calculator.isError());
        outState.putBoolean("n3", calculator.isN3());
        outState.putChar("sign", calculator.getSign());
        outState.putInt("indexMax", calculator.getIndexMax());
        outState.putInt("indexMin", calculator.getIndexMin());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int ori = this.getResources().getConfiguration().orientation;
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            digit = 9;
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            digit = 6;
        }
        calculator.setDigit(digit);
        if (savedInstanceState != null) {
            String tempStr = savedInstanceState.getString("tempStr");
            calculator.setTempStr(new StringBuilder(tempStr));
            String num1 = savedInstanceState.getString("num1");
            calculator.setNum1(new BigDecimal(num1));
            String num2 = savedInstanceState.getString("num2");
            calculator.setNum2(new BigDecimal(num2));
            String num3 = savedInstanceState.getString("num3");
            calculator.setNum3(num3);
            String m = savedInstanceState.getString("m");
            calculator.setM(new BigDecimal(m));
            boolean point = savedInstanceState.getBoolean("point");
            calculator.setPoint(point);
            boolean input = savedInstanceState.getBoolean("input");
            calculator.setInput(input);
            boolean error = savedInstanceState.getBoolean("error");
            calculator.setError(error);
            boolean n3 = savedInstanceState.getBoolean("n3");
            calculator.setN3(n3);
            char sign = savedInstanceState.getChar("sign");
            calculator.setSign(sign);
            int indexMax = savedInstanceState.getInt("indexMax");
            calculator.setIndexMax(indexMax);
            int indexMin = savedInstanceState.getInt("indexMin");
            calculator.setIndexMin(indexMin);
        }
        textView.setText(calculator.toString());
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AC:
                calculator.AC();
                break;
            case R.id.minus:
                calculator.minus();
                break;
            case R.id.percent:
                calculator.percent();
                break;
            case R.id.num_7:
                calculator.increase(7);
                break;
            case R.id.num_8:
                calculator.increase(8);
                break;
            case R.id.num_9:
                calculator.increase(9);
                break;
            case R.id.num_4:
                calculator.increase(4);
                break;
            case R.id.num_5:
                calculator.increase(5);
                break;
            case R.id.num_6:
                calculator.increase(6);
                break;
            case R.id.num_1:
                calculator.increase(1);
                break;
            case R.id.num_2:
                calculator.increase(2);
                break;
            case R.id.num_3:
                calculator.increase(3);
                break;
            case R.id.num_0:
                calculator.increase(0);
                break;
            case R.id.point:
                calculator.point();
                break;
            case R.id.divide:
                calculator.divide();
                break;
            case R.id.multiply:
                calculator.multiply();
                break;
            case R.id.subtract:
                calculator.subtract();
                break;
            case R.id.add:
                calculator.add();
                break;
            case R.id.equal:
                calculator.equal();
                break;
            case R.id.mc:
                calculator.mc();
                break;
            case R.id.mAdd:
                calculator.mAdd();
                break;
            case R.id.mSub:
                calculator.mSub();
                break;
            case R.id.mr:
                calculator.mr();
                break;
            case R.id.square:
                calculator.square();
                break;
            case R.id.cube:
                calculator.cube();
                break;
            case R.id.factorial:
                calculator.factorial();
                break;
            case R.id.countBackwards:
                calculator.countBackwards();
                break;
            case R.id.ePower:
                calculator.ePower();
                break;
            case R.id.tenPower:
                calculator.tenPower();
                break;
            case R.id.sin:
                calculator.sin();
                break;
            case R.id.cos:
                calculator.cos();
                break;
            case R.id.tan:
                calculator.tan();
                break;
            case R.id.e:
                calculator.e();
                break;
            case R.id.pi:
                calculator.pi();
                break;
            case R.id.Hex:
                calculator.toHexString();
                break;
            case R.id.Octal:
                calculator.toOctalString();
                break;
            case R.id.Binary:
                calculator.toBinaryString();
                break;
            case R.id.loge:
                calculator.loge();
                break;
            case R.id.log10:
                calculator.log10();
                break;
            default:
                break;
        }
        textView.setText(calculator.toString());
    }
}