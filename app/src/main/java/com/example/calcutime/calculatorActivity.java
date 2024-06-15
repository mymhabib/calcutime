package com.example.calcutime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;
import soup.neumorphism.NeumorphImageButton;

public class calculatorActivity extends AppCompatActivity {
    private EditText display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        NeumorphImageButton hapusBTN = findViewById(R.id.hapusBTN);

        hapusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusBTN(view);
            }
        });

        hapusBTN.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clearBTN(view);
                return true; // return true to indicate the long click event was handled
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos+1);

    }

    public void nolBTN(View view){

        updateText("0");

    }
    public void satuBTN(View view){
        updateText("1");
    }
    public void duaBTN(View view){
        updateText("2");
    }
    public void tigaBTN(View view){
        updateText("3");
    }
    public void empatBTN(View view){
        updateText("4");
    }
    public void limaBTN(View view){
        updateText("5");
    }
    public void enamBTN(View view){
        updateText("6");
    }
    public void tujuhBTN(View view){
        updateText("7");
    }
    public void delapanBTN(View view){
        updateText("8");
    }
    public void sembilanBTN(View view){
        updateText("9");
    }
    public void kaliBTN(View view){
        int cursorPos = display.getSelectionStart();
        if (display.getText().length() == 0){
            updateText("0×");
            display.setSelection(cursorPos + 2);
        }
        int textLen = display.getText().length();
        if ((display.getText().toString().substring(textLen - 1, textLen).equals("+")) || (display.getText().toString().substring(textLen - 1, textLen).equals("-")) || (display.getText().toString().substring(textLen - 1, textLen).equals("^")) || (display.getText().toString().substring(textLen - 1, textLen).equals("÷"))){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "×");
            display.setText(selection);
            display.setSelection(cursorPos);
        }else if (!display.getText().toString().substring(display.getText().length() - 1, display.getText().length()).equals("×")) {
            updateText("×");
        }
    }
    public void bagiBTN(View view){
        int cursorPos = display.getSelectionStart();
        if (display.getText().length() == 0){
            updateText("0÷");
            display.setSelection(cursorPos + 2);
        }
        int textLen = display.getText().length();
        if ((display.getText().toString().substring(textLen - 1, textLen).equals("+")) || (display.getText().toString().substring(textLen - 1, textLen).equals("-")) || (display.getText().toString().substring(textLen - 1, textLen).equals("^")) || (display.getText().toString().substring(textLen - 1, textLen).equals("×"))){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "÷");
            display.setText(selection);
            display.setSelection(cursorPos);
        }else if (!display.getText().toString().substring(textLen - 1, textLen).equals("÷")) {
            updateText("÷");
        }
    }
    public void tambahBTN(View view){
        int cursorPos = display.getSelectionStart();
        if (display.getText().length() == 0){
            updateText("0+");
            display.setSelection(cursorPos + 2);
        }
        int textLen = display.getText().length();
        if ((display.getText().toString().substring(textLen - 1, textLen).equals("÷")) || (display.getText().toString().substring(textLen - 1, textLen).equals("-")) || (display.getText().toString().substring(textLen - 1, textLen).equals("^")) || (display.getText().toString().substring(textLen - 1, textLen).equals("×"))){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "+");
            display.setText(selection);
            display.setSelection(cursorPos);
        }else if (!display.getText().toString().substring(textLen - 1, textLen).equals("+")) {
            updateText("+");
        }

    }
    public void kurangBTN(View view){
        int cursorPos = display.getSelectionStart();
        if (display.getText().length() == 0){
            updateText("0-");
            display.setSelection(cursorPos + 2);
        }
        int textLen = display.getText().length();
        if ((display.getText().toString().substring(textLen - 1, textLen).equals("÷")) || (display.getText().toString().substring(textLen - 1, textLen).equals("+")) || (display.getText().toString().substring(textLen - 1, textLen).equals("^")) || (display.getText().toString().substring(textLen - 1, textLen).equals("×"))){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "-");
            display.setText(selection);
            display.setSelection(cursorPos);
        }else if (!display.getText().toString().substring(textLen - 1, textLen).equals("-")) {
            updateText("-");
        }

    }
    public void pangkatBTN(View view){
        int cursorPos = display.getSelectionStart();
        if (display.getText().length() == 0){
            updateText("0^");
            display.setSelection(cursorPos + 2);
        }
        int textLen = display.getText().length();
        if ((display.getText().toString().substring(textLen - 1, textLen).equals("÷")) || (display.getText().toString().substring(textLen - 1, textLen).equals("+")) || (display.getText().toString().substring(textLen - 1, textLen).equals("-")) || (display.getText().toString().substring(textLen - 1, textLen).equals("×"))){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "^");
            display.setText(selection);
            display.setSelection(cursorPos);
        }else
        if (!display.getText().toString().substring(textLen - 1, textLen).equals("^")) {
            updateText("^");
        }
    }
    public void negatifBTN(View view){

        if (display.getText().length() == 0){
            updateText("0");
        }
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if ((display.getText().toString().substring(textLen - 1, textLen).equals("÷")) || (display.getText().toString().substring(textLen - 1, textLen).equals("+")) || (display.getText().toString().substring(textLen - 1, textLen).equals("^")) || (display.getText().toString().substring(textLen - 1, textLen).equals("×")) || (display.getText().toString().substring(textLen - 1, textLen).equals("-")) || (display.getText().toString().substring(textLen - 1, textLen).equals("(")) || (display.getText().toString().substring(textLen - 1, textLen).equals(")"))){


//
        } else {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "(-"+ display.getText().toString().substring(display.getText().length() - 1, display.getText().length()) + ")");
            display.setText(selection);
            display.setSelection(cursorPos+3);
        }

    }

    public void kurungBukaBTN(View view){
//        int cursorPos = display.getSelectionStart();
//        int openPar = 0;
//        int closePar = 0;
//        int textLen = display.getText().length();
//
//        for (int i = 0; i < cursorPos; i++){
//            if (display.getText().toString().substring(i, i+1).equals("(")){
//                openPar += 1;
//            }
//            if (display.getText().toString().substring(i, i+1).equals(")")){
//                closePar += 1;
//            }
//        }
//        if ((openPar == closePar) || display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
//            updateText("(");
//        }
//        else if ((closePar < openPar) && !display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
//            updateText(")");
//
//        }
//        display.setSelection(cursorPos + 1);
        updateText("(");

    }
    public void kurungTutupBTN(View view){

        updateText(")");

    }

    public void pointBTN(View view){
        int cursorPos = display.getSelectionStart();
        if (display.getText().length() == 0){
            updateText("0.");
            display.setSelection(cursorPos + 2);
        }
        int textLen = display.getText().length();
        int checkPoint = 0;
        if (!((display.getText().toString().substring(textLen - 1, textLen).equals("÷")) || (display.getText().toString().substring(textLen - 1, textLen).equals("+")) || (display.getText().toString().substring(textLen - 1, textLen).equals("^")) || (display.getText().toString().substring(textLen - 1, textLen).equals("×")) || (display.getText().toString().substring(textLen - 1, textLen).equals("-")) || (display.getText().toString().substring(textLen - 1, textLen).equals("(")) || (display.getText().toString().substring(textLen - 1, textLen).equals(")")) || (display.getText().toString().substring(textLen - 1, textLen).equals(".")))) {
//            for (int i = 0; i < cursorPos; i++) {
//                if (display.getText().toString().substring(i, i + 1).equals(".")) {
//                    checkPoint = 1;
//                }
//            }
            if (!(checkPoint == 1)) {
                updateText(".");
            }
        }

    }
    public void equalBTN(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        int textLen = result.length();
        if ((result.substring(textLen - 2, textLen).equals(".0"))){
            StringBuffer noZeroDecimal= new StringBuffer(result);
            noZeroDecimal.deleteCharAt(noZeroDecimal.length()-1);
            noZeroDecimal.deleteCharAt(noZeroDecimal.length()-1);
            display.setText(noZeroDecimal);
            display.setSelection(noZeroDecimal.length());
        } else {
            display.setText(result);
            display.setSelection(result.length());
        }
    }
    public void clearBTN(View view){
        display.setText("");
    }

    public void hapusBTN(View view){

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos !=0 && textLen!=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

}
