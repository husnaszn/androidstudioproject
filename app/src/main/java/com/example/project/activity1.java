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

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        newWord();

        Button backButton = findViewById(R.id.button4);

        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(activity1.this, "should be switching", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity1.this, MainActivity.class);
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
        textView.setText("what sound does the letter " + curWord.getQuesWord() + " make?");
        streakView.setText("streak: " + streak);

        String correct = setWordList().get(tempwl).getAnsChoi();
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
            int maxsa = setAns.size();
            tempsa = (int) (Math.random()*(maxsa-1));
            b.setText(setAns.get(tempsa));
            setAns.remove(tempsa);

            b.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    if (b.getText()==curWord.getAnsChoi()){
                        Toast.makeText(activity1.this, "correct!", Toast.LENGTH_SHORT).show();
                        streak++;
                        newWord();

                    }else {
                        Toast.makeText(activity1.this, "incorrect..", Toast.LENGTH_SHORT).show();
                        Toast.makeText(activity1.this, "streak of " + streak + " lost.", Toast.LENGTH_SHORT).show();
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
        temp.add(new questionWord("أ","aa"));
        temp.add(new questionWord("ب","b"));
        temp.add(new questionWord("ت","t"));
        temp.add(new questionWord("ث","tee(th)"));
        temp.add(new questionWord("ج","j"));
        temp.add(new questionWord("ح","h (heavy)"));
        temp.add(new questionWord("خ","kh"));
        temp.add(new questionWord("د","d (light)"));
        temp.add(new questionWord("ذ","(th)is"));
        temp.add(new questionWord("ر","r"));
        temp.add(new questionWord("ز","z"));
        temp.add(new questionWord("س","s (light)"));
        temp.add(new questionWord("ش","sh"));
        temp.add(new questionWord("ص","s (heavy)"));
        temp.add(new questionWord("ض","d (heavy)"));
        temp.add(new questionWord("ﻁ","t"));
        temp.add(new questionWord("ظ","th (heavy)"));
        temp.add(new questionWord("ع","a (throat)"));
        temp.add(new questionWord("غ","gh"));
        temp.add(new questionWord("ف","f"));
        temp.add(new questionWord("ق","q"));
        temp.add(new questionWord("ك","k"));
        temp.add(new questionWord("ل","l"));
        temp.add(new questionWord("م","m"));
        temp.add(new questionWord("ن","n"));
        temp.add(new questionWord("ه","h (light)"));
        temp.add(new questionWord("و","w or oo"));
        temp.add(new questionWord("ي","ee or y"));
        return temp;
    }





}