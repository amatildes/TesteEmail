package com.adriano.testeemail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Perfil extends AppCompatActivity {
    private TextView txtEmail, txtID;
    private Button btnLogOut;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        inicializarComponentes();
        eventoClick();
    }

    private void eventoClick() {
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conexao.logOut();
                finish();
            }
        });
    }

    private void inicializarComponentes() {
        txtEmail = findViewById(R.id.txtEmail);
        txtID = findViewById(R.id.txtID);
        btnLogOut = findViewById(R.id.btnLogOut);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();

        verificarUser();
    }

    private void verificarUser() {
        if (user == null){
            finish();
        }else {
            txtID.setText("ID :" + user.getUid());
            txtEmail.setText("Email :" + user.getEmail());
        }
    }
}
