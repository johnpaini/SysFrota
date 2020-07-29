package com.example.testes;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testes.model.Abastecimento;
import com.example.testes.model.DatabaseHelper;
import com.example.testes.model.Usuario;

import java.text.ParseException;
import java.util.Date;

public class CadastroAbastecimentoActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseHelper helper;
    private CadastroAbastecimentoActivity.ViewHolder mViewHolder = new CadastroAbastecimentoActivity.ViewHolder();
  // DatabaseHelper helper = new DatabaseHelper(this);


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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
//        Toast.makeText(this, "chegou aqui", Toast.LENGTH_SHORT).show();
        if (view.getId() == R.id.button_cadastrar_abastecimento) {
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
                Abastecimento abastecimento = new Abastecimento();
                abastecimento.setResponsavelAbastecimento(responsavelAbastecimento);
                abastecimento.setValorAbastecimento(valorAbastecimento);
                abastecimento.setPlacaAbastecimento(placaAbastecimento);
                abastecimento.setMesAnoAbastecimento(mesAnoAbastecimento);
                abastecimento.setLocalAbastecimento(localAbastecimento);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date data = null;
                try {
                    data = formato.parse(dataAbastecimento);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                abastecimento.setUsuarioId(1);
                abastecimento.setVeiculoId(1);




               helper.RegistrarAbastecimento(abastecimento);


            }

        }

    }

    static class ViewHolder {
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
