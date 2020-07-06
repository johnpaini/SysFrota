package com.example.testes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainActivity.ViewHolder mViewHolder = new MainActivity.ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.mViewHolder.editCpf = findViewById(R.id.edit_cpf);
        this.mViewHolder.editSenha = findViewById(R.id.edit_senha);
        this.mViewHolder.button_entrar = findViewById(R.id.button_logar);
        this.mViewHolder.button_cadastrar = findViewById(R.id.button_cadastrar);

        this.mViewHolder.button_entrar.setOnClickListener(this);
        this.mViewHolder.button_cadastrar.setOnClickListener(this);


        this.clearValues();


    }

    private void clearValues() {
        this.mViewHolder.editCpf.setText("");
        this.mViewHolder.editSenha.setText("");
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_logar) {
            String cpf = this.mViewHolder.editCpf.getText().toString();
           EditText a=  this.mViewHolder.editCpf;
            String senha = this.mViewHolder.editSenha.getText().toString();
            SimpleMaskFormatter smf=  new SimpleMaskFormatter("NNN.NNN.NNN-NN");
            MaskTextWatcher mtw = new MaskTextWatcher(a ,smf);
            a.addTextChangedListener(mtw);
            Toast.makeText(this, a.toString() , Toast.LENGTH_LONG).show();

            if ("".equals(cpf) || "".equals(senha)) {
                //Mostrar mensagem de campos vazios
                Toast.makeText(this, this.getString(R.string.preencha_campos), Toast.LENGTH_LONG).show();
            } else {
                EditText c = (EditText) findViewById(R.id.edit_cpf);
                String str= c.toString();
                EditText b= (EditText) findViewById(R.id.edit_senha);
                String pass= b.toString();




               // helper.encontrarSenha();

                Toast.makeText(this, "Que bom que voltou!", Toast.LENGTH_LONG).show();


                Intent i = new Intent(MainActivity.this, CadastroAbastecimentoActivity.class);
                i.putExtra("Username", str );
                startActivity(i);

            }

        }
       else if (view.getId() == R.id.button_cadastrar) {
            Toast.makeText(this, "Cadastrar", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, CadastroUsuariosActivity.class);
            startActivity(i);
        }
    }


    // ViewHolder static uma vez
    private static class ViewHolder {
        EditText editSenha;
        EditText editCpf;
        Button button_entrar;
        Button button_cadastrar;
    }
}