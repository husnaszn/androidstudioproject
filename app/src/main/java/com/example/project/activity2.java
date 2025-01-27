package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        newWord();

        Button backButton = findViewById(R.id.button4);

        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
//                Toast.makeText(activity2.this, "should be switching", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity2.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }



    questionWord curWord = new questionWord();
    int maxwl = setWordList().size();

    int tempsa;

    int tempwl = (int) (Math.random()*(maxwl ));

    int streak = 0;


    public void newWord(){


        curWord = setWordList().get(tempwl);

        TextView textView = findViewById(R.id.textView);
        TextView streakView = findViewById(R.id.streakView);
        textView.setText("what is the meaning of " + curWord.getQuesWord() + " in english?");
        streakView.setText("streak: " + streak);


        String fone = "";
        String ftwo = "";
        String fthree = "";
        String correct = "";

        ArrayList<String> Ans = new ArrayList<>();
            Ans.add(fone);
            Ans.add(ftwo);
            Ans.add(fthree);
            Ans.add(correct);

        ArrayList<String> setAns = new ArrayList<>();

        for (int i = 0; i < Ans.size(); i++) {
            for (int j = 0; j < setAns.size(); j++) {
                if (setAns.get(j)==setWordList().get(tempwl).getAnsChoi()){
                    System.out.println(Ans.get(i) + " " + setWordList().get(tempwl).getAnsChoi());
                    setTempwl();
                }
            }
            Ans.set(i, setWordList().get(tempwl).getAnsChoi());
            System.out.println(Ans.get(i) + " " + setWordList().get(tempwl).getAnsChoi());
            setTempwl();
            setAns.add(Ans.get(i));

        }






        Button A = findViewById(R.id.op1);
        Button B = findViewById(R.id.op2);
        Button C = findViewById(R.id.op3);
        Button D = findViewById(R.id.op4);

        ArrayList<Button> ansBut = new ArrayList<>();
        ansBut.add(A);
        ansBut.add(B);
        ansBut.add(C);
        ansBut.add(D);

        for (Button b: ansBut){
            System.out.println(setAns);
            int maxsa = setAns.size();
            tempsa = (int) (Math.random()*(maxsa-1));
            b.setText(setAns.get(tempsa));
            setAns.remove(tempsa);



           b.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    if (b.getText()==curWord.getAnsChoi()){
                    Toast.makeText(activity2.this, "correct!", Toast.LENGTH_SHORT).show();
                        streak++;
                        newWord();

                    }else {
                        Toast.makeText(activity2.this, "incorrect. the correct answer was: " + curWord.getAnsChoi() + ".", Toast.LENGTH_SHORT).show();
                        Toast.makeText(activity2.this, "streak of " + streak + " lost.", Toast.LENGTH_SHORT).show();
                        streak = 0;
                        newWord();

                    }

                }

            });
        }


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
        temp.add(new questionWord("دراجة نارية","motorcycle"));
        temp.add(new questionWord("جمل","camel"));
        temp.add(new questionWord("سفينة","ship"));
        temp.add(new questionWord("طائرة","airplane"));
        temp.add(new questionWord("حمار","donkey"));
        temp.add(new questionWord("تاكسي","taxi"));
                return temp;
    }



}