package com.example.testes;

import android.content.Intent;
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
    public void onClick(View view) {
        if (view.getId() == R.id.button_abastecimento) {
            Intent i = new Intent(this, CadastroAbastecimentoActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Abastecimento", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button_usuarios) {
            Intent i = new Intent(this, CadastroUsuariosActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show();
        }else if (view.getId() == R.id.button_itinerario) {
            Intent i = new Intent(this, CadastroItinerarioActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Itinerario", Toast.LENGTH_SHORT).show();
        }else if (view.getId() == R.id.button_veiculos) {
            Intent i = new Intent(this, CadastroVeiculoActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Veiculo", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.button_percurso) {
            Intent i = new Intent(this, CadastroVeiculoActivity.class);
            startActivity(i);
            Toast.makeText(this, "Registrar Veiculo", Toast.LENGTH_SHORT).show();
        }

    }

    public class ViewHolder {

        Button button_vistoria;
        Button button_itinerario;
        Button button_percurso;
        Button button_veiculo;
        Button button_abastecimentos;
        Button button_usuarios;

    }
}
