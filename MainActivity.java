package svnadvanceproject.sol.svn.com.calculator_lab2;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//import com.inducesmile.completecalculatorapp.helpers.Helper;
//import com.inducesmile.completecalculatorapp.ultility.Calculator;

public class MainActivity extends Fragment implements View.OnClickListener{

    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button plus, subtract, divide, multiply, plusMinus;
    private Button ac, percent, dot, double_zero, equal;
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private TextView outputResult;
    private Calculator mCalculator;

    public MainActivity() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        outputResult = (TextView)view.findViewById(R.id.display);
        outputResult.setText("");
        mCalculator = new Calculator();
        one = (Button)view.findViewById(R.id.btn_one);
        two = (Button)view.findViewById(R.id.btn_two);
        three = (Button)view.findViewById(R.id.btn_three);
        four = (Button)view.findViewById(R.id.btn_four);
        five = (Button)view.findViewById(R.id.btn_five);
        six = (Button)view.findViewById(R.id.btn_six);
        seven = (Button)view.findViewById(R.id.btn_seven);
        eight = (Button)view.findViewById(R.id.btn_eight);
        nine = (Button)view.findViewById(R.id.btn_nine);
        zero = (Button)view.findViewById(R.id.btn_zero);
        plus = (Button)view.findViewById(R.id.btn_plus);
        subtract = (Button)view.findViewById(R.id.btn_minus);
        divide = (Button)view.findViewById(R.id.btn_divide);
        multiply = (Button)view.findViewById(R.id.multiply);
        plusMinus = (Button)view.findViewById(R.id.btn_plus_minus);
        ac = (Button)view.findViewById(R.id.btn_ac);
        percent = (Button)view.findViewById(R.id.btn_percent);
        dot = (Button)view.findViewById(R.id.btn_dot);
        double_zero = (Button)view.findViewById(R.id.btn_double_zero);
        equal = (Button)view.findViewById(R.id.btn_equal);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        plusMinus.setOnClickListener(this);
        //divide.setText(Html.fromHtml(ThemedSpinnerAdapter.Helper.division));
        //plusMinus.setText(Html.fromHtml(Helper.plusMinus));
        ac.setOnClickListener(this);
        percent.setOnClickListener(this);
        dot.setOnClickListener(this);
        double_zero.setOnClickListener(this);
        equal.setOnClickListener(this);
        return view;
    }

    private void obtainInputValues(String input){
        switch (input){
            case "0":
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;
            case "1":
                currentDisplayedInput += "1";
                inputToBeParsed += "1";
                break;
            case "2":
                currentDisplayedInput += "2";
                inputToBeParsed += "2";
                break;
            case "3":
                currentDisplayedInput += "3";
                inputToBeParsed += "3";
                break;
            case "4":
                currentDisplayedInput += "4";
                inputToBeParsed += "4";
                break;
            case "5":
                currentDisplayedInput += "5";
                inputToBeParsed += "5";
                break;
            case "6":
                currentDisplayedInput += "6";
                inputToBeParsed += "6";
                break;
            case "7":
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                break;
            case "8":
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                break;
            case "9":
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                break;
            case ".":
                currentDisplayedInput += ".";
                inputToBeParsed += ".";
                break;
            case "+":
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                break;
            case "-":
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                break;
            case "/":
                currentDisplayedInput += "/";
                inputToBeParsed += "/";
                break;
            case "x":
                currentDisplayedInput += "*";
                inputToBeParsed += "*";
                break;
            case "%":
                currentDisplayedInput += "%";
                inputToBeParsed += "%";
                break;
            case "00":
                currentDisplayedInput += "00";
                inputToBeParsed += "00";
                break;
            case "=":
                currentDisplayedInput += "00";
                inputToBeParsed += "00";
                break;
        }
        outputResult.setText(currentDisplayedInput);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        Toast.makeText(getContext(), "Click " + data, Toast.LENGTH_LONG).show();
        if(data.equals("AC")){
            outputResult.setText("");
            currentDisplayedInput = "";
            inputToBeParsed = "";
        }
        else if(data.equals("=")){
            String enteredInput = outputResult.getText().toString();
            // call a function that will return the result of the calculate.
            String resultObject = mCalculator.getResult(currentDisplayedInput, inputToBeParsed);
            outputResult.setText(removeTrailingZero(resultObject));
        }
        else{
            obtainInputValues(data);
        }
    }
    private String removeTrailingZero(String formattingInput){
        if(!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if(newValue.equals(".0")){
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }
}
