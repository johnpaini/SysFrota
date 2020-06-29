package com.example.testes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testes.model.DatabaseHelper;
import com.example.testes.model.Usuario;

public class CadastroUsuariosActivity extends AppCompatActivity implements View.OnClickListener {


    private CadastroUsuariosActivity.ViewHolder mViewHolder = new CadastroUsuariosActivity.ViewHolder();
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_usuarios);

        this.mViewHolder.editNome = findViewById(R.id.edit_nome);
        this.mViewHolder.editCpf = findViewById(R.id.edit_cpf);
        this.mViewHolder.editSenha = findViewById(R.id.edit_senha);
        this.mViewHolder.editUnidade = findViewById(R.id.edit_unidade);
        this.mViewHolder.editDataNascimento = findViewById(R.id.edit_data_nascimento);
        this.mViewHolder.editConfirmarSenha = findViewById(R.id.edit_confirmar_senha);

        this.mViewHolder.button_inscrever = findViewById(R.id.button_inscrever);

        this.mViewHolder.button_inscrever.setOnClickListener(this);

        this.clearValues();


    }

    private void clearValues() {
        this.mViewHolder.editCpf.setText("");
        this.mViewHolder.editNome.setText("");
        this.mViewHolder.editDataNascimento.setText("");
        this.mViewHolder.editUnidade.setText("");
        this.mViewHolder.editSenha.setText("");
        this.mViewHolder.editConfirmarSenha.setText("");

    }

    private static class ViewHolder {
        EditText editConfirmarSenha;
        EditText editSenha;
        EditText editNome;
        EditText editCpf;
        EditText editUnidade;
        EditText editDataNascimento;
        Button button_inscrever;


    }
    //Registrar Usuario
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_inscrever) {
            String nome = this.mViewHolder.editNome.getText().toString();
            String cpf = this.mViewHolder.editCpf.getText().toString();
            String senha = this.mViewHolder.editSenha.getText().toString();
            String dataNascimento = this.mViewHolder.editDataNascimento.getText().toString();
            String unidade = this.mViewHolder.editUnidade.getText().toString();
            String confirmacaoSenha = this.mViewHolder.editConfirmarSenha.getText().toString();

            if ("".equals(nome) || "".equals(cpf) || "".equals(senha) || "".equals(dataNascimento) || "".equals(unidade)) {
                //Mostrar mensagem de campos vazios
                Toast.makeText(this, this.getString(R.string.preencha_campos), Toast.LENGTH_LONG).show();
            } else {
                if (!senha.equals(confirmacaoSenha))
                    Toast.makeText(this, "As Senhas Nao Conferem", Toast.LENGTH_LONG).show();
                else
                {
                    Usuario user = new Usuario();
                    user.setNome(nome);
                    user.setCpf(cpf);
                    user.setDataNascimento(dataNascimento);
                    user.setUnidade(unidade);
                    user.setSenha(senha);

                    helper.RegistrarUsuario(user);

                }


            }

        }

    }
}
