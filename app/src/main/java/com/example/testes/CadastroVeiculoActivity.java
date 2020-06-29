package com.example.testes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testes.model.Usuario;
import com.example.testes.model.Veiculo;

public class CadastroVeiculoActivity extends AppCompatActivity implements View.OnClickListener {

    private CadastroVeiculoActivity.ViewHolder mViewHolder = new CadastroVeiculoActivity.ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_veiculo);

        this.mViewHolder.editMarca = findViewById(R.id.edit_marca);

        this.mViewHolder.editModelo = findViewById(R.id.edit_modelo);
        this.mViewHolder.editAno = findViewById(R.id.edit_ano);
        this.mViewHolder.editCor = findViewById(R.id.edit_cor);
       // this.mViewHolder.ed
        this.mViewHolder.editPlaca = findViewById(R.id.edit_placa);
        this.mViewHolder.button_inscrever = findViewById(R.id.button_inscrever);

        this.mViewHolder.button_inscrever.setOnClickListener(this);

        this.clearValues();


    }

    private void clearValues() {
        this.mViewHolder.editCor.setText("");
        this.mViewHolder.editPlaca.setText("");
        this.mViewHolder.editMarca.setText("");
        this.mViewHolder.editModelo.setText("");
        this.mViewHolder.editAno.setText("");

    }
    private static class ViewHolder {
        EditText editCor;
        EditText editPlaca;
        EditText editMarca;
        EditText editModelo;
        EditText editAno;
        //EditText editCombustivel

        Button button_inscrever;
    }
    //Registrar Veiculo
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_inscrever) {
            String cor = this.mViewHolder.editCor.getText().toString();
            String placa  = this.mViewHolder.editPlaca.getText().toString();
            String marca = this.mViewHolder.editMarca.getText().toString();
            String modelo = this.mViewHolder.editModelo.getText().toString();
            String ano = this.mViewHolder.editAno.getText().toString();
         //   String combustivel =this.mViewHolder.editC

            if ("".equals(cor) || "".equals(placa) || "".equals(marca) || "".equals(modelo) || "".equals(ano)) {
                //Mostrar mensagem de campos vazios
                Toast.makeText(this, this.getString(R.string.preencha_campos), Toast.LENGTH_LONG).show();
            } else {
                Veiculo veiculo = new Veiculo();
                veiculo.setCor(cor);
                veiculo.setAno(ano);
                //veiculo.setCombustivel(comb);
                veiculo.setMarca(marca);
                veiculo.setModelo(modelo);
                veiculo.setModelo(placa);

                Toast.makeText(this, "chegou aqui", Toast.LENGTH_LONG).show();

            }

        }
    }
}

