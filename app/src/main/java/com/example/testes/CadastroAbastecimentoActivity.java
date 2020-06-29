package com.example.testes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroAbastecimentoActivity extends AppCompatActivity implements View.OnClickListener {

    private CadastroAbastecimentoActivity.ViewHolder mViewHolder = new CadastroAbastecimentoActivity.ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_abastecimento);

        this.mViewHolder.editResponsavelAbastecimento = findViewById(R.id.edit_responsavel_abastecimento);
        this.mViewHolder.editDataAbastecimento = findViewById(R.id.edit_data_abastecimento);
        this.mViewHolder.editKmAbastecimento = findViewById(R.id.edit_km_abastecimento);
        this.mViewHolder.editLitrosAbastecimento = findViewById(R.id.edit_litros_abastecimento);
        this.mViewHolder.editMesAnoAbastecimento = findViewById(R.id.edit_mes_ano_abastecimento);
        this.mViewHolder.editPlacaAbastecimento = findViewById(R.id.edit_placa_abastecimento);
        this.mViewHolder.editLocalAbastecimento = findViewById(R.id.local_abastecimento);
        this.mViewHolder.editValorAbastecimento = findViewById(R.id.edit_valor_abastecimento);
        this.mViewHolder.editFormaPagamento = findViewById(R.id.edit_forma_pagamento);

        this.mViewHolder.button_cadastrar_abastecimento = findViewById(R.id.button_cadastrar_abastecimento);

        this.mViewHolder.button_cadastrar_abastecimento.setOnClickListener(this);

        this.clearValues();


    }

    private void clearValues() {
        this.mViewHolder.editKmAbastecimento.setText("");
        this.mViewHolder.editLitrosAbastecimento.setText("");
        this.mViewHolder.editMesAnoAbastecimento.setText("");
        this.mViewHolder.editPlacaAbastecimento.setText("");
        this.mViewHolder.editLocalAbastecimento.setText("");
        this.mViewHolder.editValorAbastecimento.setText("");
        this.mViewHolder.editResponsavelAbastecimento.setText("");
        this.mViewHolder.editFormaPagamento.setText("");

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button_inscrever) {
            String dataAbastecimento = this.mViewHolder.editDataAbastecimento.getText().toString();
            String formaPagamento = this.mViewHolder.editFormaPagamento.getText().toString();
            String kmAbastecimento = this.mViewHolder.editKmAbastecimento.getText().toString();
            String litrosAbastecimento = this.mViewHolder.editLitrosAbastecimento.getText().toString();
            String localAbastecimento = this.mViewHolder.editLocalAbastecimento.getText().toString();
            String mesAnoAbastecimento = this.mViewHolder.editMesAnoAbastecimento.getText().toString();

            String placaAbastecimento = this.mViewHolder.editPlacaAbastecimento.getText().toString();
            String responsavelAbastecimento = this.mViewHolder.editResponsavelAbastecimento.getText().toString();
            String valorAbastecimento = this.mViewHolder.editValorAbastecimento.getText().toString();


            if ("".equals(dataAbastecimento) || "".equals(formaPagamento) || "".equals(kmAbastecimento) || "".equals(litrosAbastecimento) || "".equals(localAbastecimento)
            || "".equals(mesAnoAbastecimento ) ||"".equals(placaAbastecimento ) || "".equals(responsavelAbastecimento ) ||"".equals(valorAbastecimento )  ) {
                //Mostrar mensagem de campos vazios
                Toast.makeText(this, this.getString(R.string.preencha_campos), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "chegou aqui", Toast.LENGTH_LONG).show();
                this.mViewHolder.editDataAbastecimento.setText(("Eba"));

            }

        }

    }

    private static class ViewHolder {
        EditText editDataAbastecimento;
        EditText editKmAbastecimento;
        EditText editLitrosAbastecimento;
        EditText editMesAnoAbastecimento;
        EditText editPlacaAbastecimento;
        EditText editLocalAbastecimento;
        EditText editValorAbastecimento;
        EditText editResponsavelAbastecimento;
        EditText editFormaPagamento;

        Button button_cadastrar_abastecimento;
    }
}
