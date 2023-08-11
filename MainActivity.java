package com.example.texteditorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText textEditor;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditor = findViewById(R.id.textEditor);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTextToFile();
            }
        });
    }

    private void saveTextToFile() {
        String textToSave = textEditor.getText().toString();
        String filename = "saved_text.txt";

        try {
            FileOutputStream outputStream = openFileOutput(filename, MODE_PRIVATE);
            outputStream.write(textToSave.getBytes());
            outputStream.close();
            textEditor.getText().clear();
            textEditor.setHint("Text saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
