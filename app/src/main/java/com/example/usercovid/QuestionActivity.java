package com.example.usercovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question;
    private TextView subQuestion;
    private Button btnYes;
    private Button btnNo;
    private int number = 0;

    public String questions [] = new String[]{
            "1. Apakah Anda mengalami salah satu dari yang berikut:",
            "2. Apakah Anda mengalami salah satu dari yang berikut:",
            "3. Apakah Anda mengalami salah satu dari yang berikut:",
            "4. Apakah anda pernah muncul gejala sekitar 14 hari setelah travelling ke luar negeri? (China, Italy, Iran, Korea Selatan, Prancis, Spanyol, Jerman, USA) atau ke kota terjangkit (Jakarta, Bali, Solo, Yogyakarta, Pontianak, Manado, Bandung dll)?",
            "5. Apakah Anda memberikan perawatan atau melakukan kontak dekat dengan seseorang dengan COVID-19 (kemungkinan atau dikonfirmasi) saat mereka sakit (batuk, demam, bersin, atau sakit tenggorokan)?"
    };

    private String subsQuestions [] = new String[] {
            "-Nyeri dada yang parah\n-Sulit untuk bangun\n-Merasa kebingungan\n-Penurunan kesadaran",
            "-Nafas yang pendek saat istirahat\n-Ketidakmampuan untuk berbaring karena kesulitan bernafas\n-Kondisi kesehatan kronis yang anda alami dirasakan lebih berat karena kesulitan bernapas",
            "-Demam\n-Batuk\n-Bersin\n-Sakit Tenggorokan\n-Sulit Bernafas",
            "",
            ""
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        question = findViewById(R.id.tv_question);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        subQuestion = findViewById(R.id.tv_sub_question);
        question.setText(questions[number]);
        subQuestion.setText(subsQuestions[number]);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnYes:
                startActivity(new Intent(QuestionActivity.this,DangerActivity.class));
                finish();
                break;
            case R.id.btnNo:
                try {
                    if(number<=question.length()){
                        number++;
                        question.setText(questions[number]);
                        subQuestion.setText(subsQuestions[number]);
                    }else{
                    }
                }catch (Exception e){
                    startActivity(new Intent(QuestionActivity.this,ResultActivity.class));
                    finish();
                }

                break;
        }
    }
}
