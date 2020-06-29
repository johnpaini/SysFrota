package com.example.testes.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "sysfrota.db";
    //usuario
    private static final String TABLE_USUARIO = "usuario";
    private static final String COLUMN_USUARIOIDPK = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_CPF = "cpf";
    private static final String COLUMN_SENHA = "senha";
    private static final String COLUMN_DATA_NASCIMENTO = "dataNascimento";
    private static final String COLUMN_UNIDADE = "unidade";

    // abastecimento
    private static final String TABLE_ABASTECIMENTO = "abastecimento";
    private static final String COLUMN_ABASTECIMENTOID = "id";
    private static final String COLUMN_DATAABASTECIMENTO = "dataAbastecimento";
    private static final String COLUMN_KMABASTECIMENTO = "kmAbastecimento";
    private static final String COLUMN_LITROSABASTECIMENTO = "litrosAbastecimento";
    private static final String COLUMN_MESANOABASTECIMENTO = "mesAnoAbastecimento";
    private static final String COLUMN_PLACAABASTECIMENTO = "placaAbastecimento";

    //Veiculo;
    private static final String TABLE_VEICULO = "veiculo";
    private static final String COLUMN_VEICULOID = "id";
    private static final String COLUMN_CORVEICULO = "cor";
    private static final String COLUMN_PLACAVEICULO = "placa";
    private static final String COLUMN_MARCAVEICULO = "marca";
    private static final String COLUMN_MODELOVEICULO = "modelo";
    private static final String COLUMN_ANOVEICULO = "ano";
    private static final String TAG = "";

    //Vistoria
    private static final String TABLE_VISTORIA = "vistoria";
    private static final String COLUMN_VISTORIAID = "id";
    private static final String COLUMN_DOCUMENTOSVISTORIA = "documentos";
    private static final String COLUMN_LUZESVISTORIA = "luzes";
    private static final String COLUMN_PNEUSVISTORIA = "pneus";
    private static final String COLUMN_CHAVERODAVISTORIA = "chaveRoda";
    private static final String COLUMN_ESTEPEVISTORIA = "estepe";
    private static final String COLUMN_MACACOVISTORIA = "macaco";
    private static final String COLUMN_LATARIAVISTORIA = "lataria";
    private static final String COLUMN_OBSERVACOESGERAISVISTORIA = "observacoesGerais";
    private static final String COLUMN_DATAVISTORIA = "dataVistoria";

    //Itinerario
    private static final String TABLE_ITINERARIO = "itinerario";
    private static final String COLUMN_ITINERARIOID = "id";
    private static final String COLUMN_CIDADEORIGEMITINERARIO = "cidadeOrigem";
    private static final String COLUMN_CIDADEDESTINOITINERARIO = "cidadeDestino";

    //Percurso///

    private static final String TABLE_PERCURSO = "percurso";
    private static final String COLUMN_PERCURSOID = "id";
    private static final String COLUMN_USUARIOIDFK = "usuario";
    private static final String COLUMN_ITINERARIOIDFK = "itinerario";
    private static final String COLUMN_VISTORIAIDFK = "vistoria";
    private static final String COLUMN_DATAPERCURSO = "data";
    private static final Integer COLUMN_KMINICIALPERCURSO = Integer.valueOf("kmInicial");
    private static final Integer COLUMN_KMFINALPERCURSO = Integer.valueOf("kmFinal");
    private static final Integer COLUMN_KMTOTALPERCURSO = Integer.valueOf("kmTotal");
    private static final String COLUMN_HORAINICIALPERCURSO = "horaInicial";
    private static final String COLUMN_HORAFINALPERCURSO = "horaFinal";


    SQLiteDatabase db;

    private static DatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;

    }


    private static final String TABLE_CREATE_USUARIO = "create table usuario (id integer primary key not null auto_increment, " +
            "nome text not null, cpf integer not null, senha  text not null, dataNascimento text not null, unidade text not null );";


    //Corrigir as Propriedades
    private static final String TABLE_CREATE_VEICULO = "create table veiculo (id integer primary key not null auto_increment, " +
            "cor text not null,   placa text not null, marca  text not null, modelo text not null, ano integer not null,combustivel text not null );";

    private static final String TABLE_CREATE_VISTORIA = "create table vistoria (id integer primary key not null auto_increment, " +
            "documentos boolean not null,   luzes boolean not null, pneus boolean not null, chaveRoda boolean not null " +
            "estepe  boolean not null, macaco boolean not null, lataria boolean not null,  observacoesGerais text not null, dataVistoria date not null, veiculo integer not null );";


    private static final String TABLE_CREATE_ABASTECIMENTO = "create table abastecimento (id integer primary key not null auto_increment, " +
            "nome text not null,   cpf integer not null, senha  text not null, dataNascimento, unidade text not null );";

    private static final String TABLE_CREATE_ITINERARIO = "create table itinerario (id integer primary key not null auto_increment, " +
            "nome text not null,   cpf integer not null, senha  text not null, dataNascimento, unidade text not null );";
    private static final String TABLE_CREATE_PERCURSO = "create table percurso (id integer primary key not null auto_increment, " +
            "nome text not null,   cpf integer not null, senha  text not null, dataNascimento, unidade text not null );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE_VEICULO);
        sqLiteDatabase.execSQL(TABLE_CREATE_VISTORIA);
        sqLiteDatabase.execSQL(TABLE_CREATE_ABASTECIMENTO);
        sqLiteDatabase.execSQL(TABLE_CREATE_USUARIO);
        sqLiteDatabase.execSQL(TABLE_CREATE_ITINERARIO);
        sqLiteDatabase.execSQL(TABLE_CREATE_PERCURSO);
        this.db = db;

    }

    public void RegistrarUsuario(Usuario user) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, user.getNome());
        values.put(COLUMN_CPF, user.getCpf());
        values.put(COLUMN_DATA_NASCIMENTO, user.getDataNascimento());
        values.put(COLUMN_SENHA, user.getSenha());
        values.put(COLUMN_UNIDADE, user.getUnidade());

        db.insert(TABLE_USUARIO, null, values);

    }

    //Corrigir propiedades
    public void RegistrarVeiculo(Veiculo veiculo) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //Corrigir propiedades
//        values.put(COLUMN_NOME, veiculo.getNome());
//        values.put(COLUMN_CPF, veiculo.getCpf());
//        values.put(COLUMN_DATA_NASCIMENTO, user.getDataNascimento());
//        values.put(COLUMN_SENHA, user.getSenha());
//        values.put(COLUMN_UNIDADE, user.getUnidade());

        db.insert(TABLE_VEICULO, null, values);

    }

    //Corrigir propiedades
    public void RegistrarVistoria(Vistoria vistoria) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //Corrigir propiedades
//        values.put(COLUMN_NOME, veiculo.getNome());
//        values.put(COLUMN_CPF, veiculo.getCpf());
//        values.put(COLUMN_DATA_NASCIMENTO, user.getDataNascimento());
//        values.put(COLUMN_SENHA, user.getSenha());
//        values.put(COLUMN_UNIDADE, user.getUnidade());

        db.insert(TABLE_VISTORIA, null, values);

    }

    public void RegistrarAbastecimento(Abastecimento abastecimento, String msg) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {

            //Inserir Comandos de Banco put
        } catch (Exception e) {
            Log.d(TAG, "Erro ao Registrar Abastecimento");

        }
    }

    public int updateAbastecimento(Abastecimento abastecimento) {
        SQLiteDatabase db = this.getWritableDatabase();

        // propriedades

//        return db.update(TABLE_ABASTECIMENTO, values, COLUMN_ABASTECIMENTOID +   "=
//                new String[] {String.valueOf(abastecimento.id) });

        return 1;

    }

    //Emprestimo
    public ArrayList<Abastecimento> getAllAbastecimentos() {
        ArrayList<Abastecimento> abastecimentos = new ArrayList<>();

        //SELECT * FROM ABASTECIMENTO - LEFT OUTER JOIN USUARIOS
        //ON ABASTECIMENTO.KEY_uSUARIO_ID_FK = USUARIO.KEY_USUARIO_ID

        String ABASTECIMENTO_SELECT_QUERY =
                String.format("SELECT %s, %s, %s , %s, %s from %s",
                        COLUMN_ABASTECIMENTOID,
                        COLUMN_DATAABASTECIMENTO,
                        COLUMN_KMABASTECIMENTO,
                        COLUMN_LITROSABASTECIMENTO,
                        COLUMN_MESANOABASTECIMENTO,
                        COLUMN_PLACAABASTECIMENTO);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(ABASTECIMENTO_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Abastecimento abastecimento = new Abastecimento();
                    //   abastecimento.setDataAbastecimento(cursor.getString(0));
                    abastecimento.setFormaPagamento(cursor.getString(1));
                    abastecimento.setId(cursor.getInt(2));
                    abastecimento.setKmAbastecimento(cursor.getString(3));

                    abastecimento.setLitrosAbastecimento(cursor.getString(4));
                    abastecimento.setLocalAbastecimento(cursor.getString(5));
                    abastecimento.setPlacaAbastecimento(cursor.getString(6));

                    abastecimento.setMesAnoAbastecimento(cursor.getString(7));
                    abastecimento.setResponsavelAbastecimento(cursor.getString(8));
                    // abastecimento.setUsuario(cursor.getUsuario(6));
                    abastecimento.setValorAbastecimento(cursor.getString(9));
                    // abastecimento.setVeiculo(cursor.getString(10));

                    abastecimentos.add(abastecimento);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {

        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return abastecimentos;

    }
    //List Usuarios

    // List Veiculos

    // List Vistorias

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1) {
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_USUARIO);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_VISTORIA);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_ABASTECIMENTO);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_VEICULO);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_ITINERARIO);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_PERCURSO);
            onCreate(db);


        }


    }


}
