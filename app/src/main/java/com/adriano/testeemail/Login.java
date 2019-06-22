package com.adriano.testeemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText editEmail,editSenha;
    private Button btnLogar,btnNovo;
    private TextView txtResetSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //inicializar Componentes da tela
        inicializarComponentes();
        //Eventos dos Botoes
        eventosClicks();
    }
    //Chama a tela de cadastro (btnNovo)
    private void eventosClicks() {
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Cadastro.class);
                startActivity(i);
            }
        }); //fim do metodo
    }

    private void inicializarComponentes() {

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.ediSenha);
        btnLogar = findViewById(R.id.btnLogar);
        btnNovo = findViewById(R.id.btnNovo);
        txtResetSenha = findViewById(R.id.txtResetSenha);
    }
}
