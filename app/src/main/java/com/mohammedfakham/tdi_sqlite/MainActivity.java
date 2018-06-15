package com.mohammedfakham.tdi_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_nom, editText_prenom, editText_age;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_nom = findViewById(R.id.txt_nom);
        editText_prenom = findViewById(R.id.txt_prenom);
        editText_age = findViewById(R.id.txt_age);

        userAdapter = new UserAdapter(this);
    }

    public void clickAjouter(View v) {

        User user = new User();
        user.setNom(editText_nom.getText().toString());
        user.setPrenom(editText_prenom.getText().toString());
        user.setAge(Integer.parseInt(editText_age.getText().toString()));

        userAdapter.ajouterUser(user);

        Toast.makeText(MainActivity.this, "User Ajouté!", Toast.LENGTH_SHORT).show();
    }

    public void clickAfficher(View v) {

        StringBuilder sb = new StringBuilder();

        for (User u : userAdapter.listeUsers()) {

            sb.append(u).append("\n");

        }

        Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();

    }
}
