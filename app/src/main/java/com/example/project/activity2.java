package com.example.project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView textView = findViewById(R.id.textView);
        newWord();
//        newAns();
        textView.setText(curWord.getQuesWord());
        Toast.makeText(activity2.this, curWord.getAnsChoi(), Toast.LENGTH_SHORT).show();

    }



    questionWord curWord = new questionWord();
    int maxwl = setWordList().size();

    int tempsa;

    int tempwl = (int) (Math.random()*(maxwl ));


    public void newWord(){
        curWord = setWordList().get(tempwl);
        String correct = curWord.getAnsChoi();
        setTempwl();
        String fone = setWordList().get(tempwl).getAnsChoi();
        setTempwl();
        String ftwo = setWordList().get(tempwl).getAnsChoi();
        setTempwl();
        String fthree = setWordList().get(tempwl).getAnsChoi();


            ArrayList<String> setAns = new ArrayList<>();
            setAns.add(fone);
            setAns.add(ftwo);
            setAns.add(fthree);
            setAns.add(correct);





//        setAns().add(fone);
//        setAns().add(ftwo);
//        setAns().add(fthree);
//        setAns().add(correct);

        Button A = findViewById(R.id.op1);
        Button B = findViewById(R.id.op2);
        Button C = findViewById(R.id.op3);
        Button D = findViewById(R.id.op4);

        int maxsa = setAns.size();
        tempsa = (int) (Math.random()*(maxsa-1));
        A.setText(setAns.get(tempsa));
        setAns.remove(tempsa);
        maxsa = setAns.size();
        tempsa = (int) (Math.random()*(maxsa));
        B.setText(setAns.get(tempsa));
        setAns.remove(tempsa);
        maxsa = setAns.size();
        tempsa = (int) (Math.random()*(maxsa));
        C.setText(setAns.get(tempsa));
        setAns.remove(tempsa);
        maxsa = setAns.size();
        tempsa = (int) (Math.random()*(maxsa));
        D.setText(setAns.get(tempsa));
        setAns.remove(tempsa);

    }



    public void newAns(){

    }


    public void setTempwl(){
        tempwl = (int) (Math.random()*(maxwl ));
    }

    public ArrayList<questionWord> setWordList(){
        ArrayList<questionWord> temp = new ArrayList<>();
        temp.add(new questionWord("قطار","train"));
        temp.add(new questionWord("سيارة","car"));
        temp.add(new questionWord("دراجة","bicycle"));
        temp.add(new questionWord("حافلة","bus"));
                return temp;
    }



}