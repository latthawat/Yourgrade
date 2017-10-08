package com.example.nick.yourgrade;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mnameEditText,mscoreEditText;
    private Button mfindButton,mexitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mnameEditText = (EditText) findViewById(R.id.name_edit_text);
        mscoreEditText = (EditText) findViewById(R.id.score_edit_text);
        mfindButton = (Button) findViewById(R.id.find);
        mexitButton = (Button) findViewById(R.id.exit);

        mfindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = String.valueOf(mnameEditText.getText().toString());
                String score = String.valueOf(mscoreEditText.getText().toString());
                if (mnameEditText.getText().length() == 0) {
                    mnameEditText.setError("ป้อนข้อมูล");
                } else if (mscoreEditText.getText().length() == 0) {
                    mscoreEditText.setError("ป้อนข้อมูล");
                } else if (mnameEditText.getText().length() == 0 || mscoreEditText.getText().length() == 0) {
                    mnameEditText.setError("ป้อนข้อมูล");
                    mscoreEditText.setError("ป้อนข้อมูล");
                } else if (mnameEditText.getText().length() != 0 && mscoreEditText.getText().length() != 0) {
                    Double Score = Double.valueOf(mscoreEditText.getText().toString());
                    String grade = getGrade(Score);
                    Intent intent = new Intent((MainActivity.this), Main2Activity.class);
                    intent.putExtra("name_i", name);
                    intent.putExtra("grade", grade);

                    startActivity(intent);
                }
            }
        });
        mexitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Comfirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {


                });
                dialog.show();
            }
        });
    }

        private String getGrade(Double score) {


            String score1 = "";

            if (score >= 80) {
                score1 = "A";
            } else if (score  >= 70&&score < 79) {
                score1 = "B";
            } else if (score  >= 60&&score < 69) {
                score1 = "C";
            } else if(score  >= 50&&score < 59){
                score1 = "D";
            }else{
                score1="F";

            }

            return score1;
        }
    }

