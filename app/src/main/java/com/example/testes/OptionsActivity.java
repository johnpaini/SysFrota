package com.example.testes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testes.model.Itinerario;
import com.example.testes.model.Veiculo;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {
    private OptionsActivity.ViewHolder mViewHolder = new OptionsActivity.ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        this.mViewHolder.button_usuarios = findViewById(R.id.button_usuarios);

        this.mViewHolder.button_abastecimentos = findViewById(R.id.button_abastecimento);

        this.mViewHolder.button_vistoria = findViewById(R.id.button_vistoria);
        this.mViewHolder.button_veiculo = findViewById(R.id.button_veiculos);

        this.mViewHolder.button_vistoria.setOnClickListener(this);
        this.mViewHolder.button_veiculo.setOnClickListener(this);

        this.mViewHolder.button_usuarios.setOnClickListener(this);

        this.mViewHolder.button_abastecimentos.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_abastecimento) {
            Intent i = new Intent(this, CadastroAbastecimentoActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Abastecimentos", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button_usuarios) {
            Intent i = new Intent(this, CadastroUsuariosActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show();

        }else if (view.getId() == R.id.button_veiculos) {
            Intent i = new Intent(this, CadastroVeiculoActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Veiculo", Toast.LENGTH_SHORT).show();
        }

        else if (view.getId() == R.id.button_vistoria) {
            Intent i = new Intent(this, CadastroVeiculoActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Vistoria", Toast.LENGTH_SHORT).show();
        }
    }

    public class ViewHolder {

        Button button_vistoria;
        Button button_veiculo;
        Button button_abastecimentos;
        Button button_usuarios;

    }
}
