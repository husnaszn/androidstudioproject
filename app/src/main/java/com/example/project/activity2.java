package com.example.project;

import android.os.Bundle;
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
        textView.setText(curWord.getQuesWord());
        Toast.makeText(activity2.this, curWord.getAnsChoi(), Toast.LENGTH_SHORT).show();


//        System.out.println(Math.random()*(max-0+1));
    }

    questionWord curWord = new questionWord();
    int max = setWordList().size();
    public void newWord(){
        curWord = setWordList().get((int) (Math.random()*(max-0+1)));
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