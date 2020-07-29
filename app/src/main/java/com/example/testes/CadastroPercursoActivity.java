//package com.example.testes;
//
//import android.icu.text.SimpleDateFormat;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.testes.model.Abastecimento;
//import com.example.testes.model.DatabaseHelper;
//import com.example.testes.model.Percurso;
//
//import java.text.ParseException;
//import java.util.Date;
//
//public class CadastroPercursoActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private DatabaseHelper helper;
//    private CadastroPercursoActivity.ViewHolder mViewHolder = new CadastroPercursoActivity.ViewHolder();
//
//    @Override
//    public void onClick(Bundle savedInstanceState)  {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.percurso);
//
//        this.mViewHolder.edit_data = findViewById(R.id.edit_data);
//        this.mViewHolder.edit_hora_inicial = findViewById(R.id.edit_hora_inicial);
//        this.mViewHolder.edit_itinerario = findViewById(R.id.edit_itinerario);
//        this.mViewHolder.edit_km_final = findViewById(R.id.edit_km_final);
//        this.mViewHolder.edit_km_inicial = findViewById(R.id.edit_km_final);
//        this.mViewHolder.edit_veiculo = findViewById(R.id.edit_veiculo);
//
//
//        this.mViewHolder.button_cadastrar_percurso = findViewById(R.id.button_cadastrar_percurso);
//
//        this.mViewHolder.button_cadastrar_percurso.setOnClickListener(this);
//
//        this.clearValues();
//
//
//    }
//
//    private void clearValues() {
//        this.mViewHolder.edit_data.setText("");
//        this.mViewHolder.edit_hora_inicial.setText("");
//        this.mViewHolder.edit_itinerario.setText("");
//        this.mViewHolder.edit_km_final.setText("");
//        this.mViewHolder.edit_km_inicial.setText("");
//        this.mViewHolder.edit_veiculo.setText("");
//
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
//    public void onClick(View view) {
////        Toast.makeText(this, "chegou aqui", Toast.LENGTH_SHORT).show();
//        if (view.getId() == R.id.button_cadastrar_percurso) {
//            String data = this.mViewHolder.edit_data.getText().toString();
//          String veiculo = this.mViewHolder.edit_veiculo.getText().toString();
//            String kmInicial = this.mViewHolder.edit_km_inicial.getText().toString();
//            String kmFinal = this.mViewHolder.edit_km_final.getText().toString();
//            String itinerario = this.mViewHolder.edit_itinerario.getText().toString();
//            String hora_inicial = this.mViewHolder.edit_hora_inicial.getText().toString();
//
//
//
//            if ("".equals(data) || "".equals(veiculo) || "".equals(kmInicial) || "".equals(kmFinal) || "".equals(itinerario) || "".equals(itinerario)  ) {
//                //Mostrar mensagem de campos vazios
//                Toast.makeText(this, this.getString(R.string.preencha_campos), Toast.LENGTH_LONG).show();
//            } else {
//                Percurso percurso = new Percurso();
//                percurso.setHoraInicial(hora_inicial);
//                percurso.setItinerario(itinerario);
//                percurso.setKmFinal(kmFinal);
//                percurso.setKmInicial(kmInicial);
//               ;
//                percurso.setKmInicial(kmInicial);
//                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//                Date data = null;
//                try {
//                    data = formato.parse(data);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//                percurso.setUsuario(1);
//                percurso.setVeiculo(1);
//
//
//
//
//                helper.Re(percurso);
//
//
//            }
//
//        }
//
//    }
//
//    private static class ViewHolder {
//        EditText edit_itinerario;
//        EditText edit_veiculo;
//        EditText edit_data;
//        EditText edit_km_inicial;
//        EditText edit_km_final;
//        EditText edit_hora_inicial;
//        EditText calendarView2;
//
//
//        Button button_cadastrar_percurso;
//    }
//}
