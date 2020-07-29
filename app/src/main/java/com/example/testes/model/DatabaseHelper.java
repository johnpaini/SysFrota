package com.example.testes.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.testes.R;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_NAME = "sysfrota.db";


    //    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_DESCRIPTION+" TEXT,"+
    //    COLUMN_DATE+" DATE,"+COLUMN_DONE+" BOOLEAN)";
    //    SQLiteDatabase db;


    private static final String TABLE_USUARIO = "usuario";
    private static final String TABLE_ABASTECIMENTO = "abastecimento";
    private static final String TABLE_VEICULO = "veiculo";
    private static final String TABLE_VISTORIA = "vistoria";
    private static final String TABLE_ITINERARIO = "itinerario";
    private static final String TABLE_PERCURSO = "percurso";

    //usuario

    private static final String COLUMN_USUARIOIDPK = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_CPF = "cpf";
    private static final String COLUMN_SENHA = "senha";
    private static final String COLUMN_DATA_NASCIMENTO = "dataNascimento";
    private static final String COLUMN_UNIDADE = "unidade";

    // abastecimento

    private static final String COLUMN_ABASTECIMENTOID = "id";
    private static final String COLUMN_DATAABASTECIMENTO = "dataAbastecimento";
    private static final String COLUMN_KMABASTECIMENTO = "kmAbastecimento";
    private static final String COLUMN_LITROSABASTECIMENTO = "litrosAbastecimento";
    private static final String COLUMN_MESANOABASTECIMENTO = "mesAnoAbastecimento";
    private static final String COLUMN_PLACAABASTECIMENTO = "placaAbastecimento";
    private static final String COLUMN_USUARIOID_FK = "usuarioId";
    private static final String COLUMN_VEICULOID_FK = "veiculoId";

    //Veiculo;

    private static final String COLUMN_VEICULOID = "id";
    private static final String COLUMN_CORVEICULO = "cor";
    private static final String COLUMN_PLACAVEICULO = "placa";
    private static final String COLUMN_MARCAVEICULO = "marca";
    private static final String COLUMN_MODELOVEICULO = "modelo";
    private static final String COLUMN_ANOVEICULO = "ano";

    //Vistoria

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
    private static final String COLUMN_VISTORIAUSUARIOID_FK = "usuarioId";
    private static final String COLUMN_VISTORIAVEICULOID_FK = "veiculoId";
    //Itinerario

    private static final String COLUMN_ITINERARIOID = "id";
    private static final String COLUMN_CIDADEORIGEMITINERARIO = "cidadeOrigem";
    private static final String COLUMN_CIDADEDESTINOITINERARIO = "cidadeDestino";

    //Percurso///


    private static final String COLUMN_PERCURSOID = "id";
    private static final String COLUMN_PERCURSOUSUARIOID_FK = "usuarioId";
    private static final String COLUMN_PERCURSOVEICULOID_FK = "veiculoId";
    private static final String COLUMN_ITINERARIOID_FK = "itinerarioId";
    private static final String COLUMN_VISTORIAID_FK = "vistoriaId";
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

        String TABLE_CREATE_USUARIO = "CREATE TABLE " + TABLE_USUARIO +
                "(" +
                COLUMN_USUARIOIDPK + " INTEGER PRIMARY KEY," +
                COLUMN_NOME + " TEXT" +
                COLUMN_CPF + " TEXT," +
                COLUMN_SENHA + " TEXT," +
                COLUMN_DATA_NASCIMENTO + " TEXT," +
                COLUMN_UNIDADE + " TEXT," + ")";

        String TABLE_CREATE_VEICULO = "CREATE TABLE " + TABLE_VEICULO +
                "(" +
                COLUMN_VEICULOID + " INTEGER PRIMARY KEY," +
                COLUMN_CORVEICULO + " TEXT" +
                COLUMN_PLACAVEICULO + " TEXT," +
                COLUMN_MARCAVEICULO + " TEXT," +
                COLUMN_MODELOVEICULO + " TEXT," +
                COLUMN_ANOVEICULO + " TEXT," + ")";


        String TABLE_CREATE_ABASTECIMENTO = "CREATE TABLE " + TABLE_ABASTECIMENTO +
                "(" +
                COLUMN_ABASTECIMENTOID + " INTEGER PRIMARY KEY," +
                COLUMN_DATAABASTECIMENTO + " TEXT" +
                COLUMN_KMABASTECIMENTO + " TEXT," +
                COLUMN_LITROSABASTECIMENTO + " TEXT," +
                COLUMN_MESANOABASTECIMENTO + " TEXT," +
                COLUMN_PLACAABASTECIMENTO + " TEXT," +
                COLUMN_USUARIOID_FK + "INTEGER REFERENCES " + TABLE_USUARIO + "," + // Define a foreign key
                COLUMN_VEICULOID_FK + "INTEGER REFERENCES " + TABLE_VEICULO + "," + ")";

        String TABLE_CREATE_VISTORIA = "CREATE TABLE " + TABLE_VISTORIA +
                "(" +
                COLUMN_VISTORIAID + " INTEGER PRIMARY KEY," +
                COLUMN_DOCUMENTOSVISTORIA + " TEXT" +
                COLUMN_LUZESVISTORIA + " TEXT," +
                COLUMN_PNEUSVISTORIA + " TEXT," +
                COLUMN_CHAVERODAVISTORIA + " TEXT," +
                COLUMN_ESTEPEVISTORIA + " TEXT," +
                COLUMN_MACACOVISTORIA + " TEXT," +
                COLUMN_LATARIAVISTORIA + " TEXT," +
                COLUMN_OBSERVACOESGERAISVISTORIA + " TEXT," +
                COLUMN_DATAVISTORIA + " TEXT," +
                COLUMN_ANOVEICULO + " TEXT," +
                COLUMN_VISTORIAUSUARIOID_FK + "INTEGER REFERENCES " + TABLE_USUARIO + "," + // Define a foreign key
                COLUMN_VISTORIAVEICULOID_FK + "INTEGER REFERENCES " + TABLE_VEICULO + "," + ")";

        String TABLE_CREATE_ITINERARIO = "CREATE TABLE " + TABLE_VISTORIA +
                "(" +
                COLUMN_ITINERARIOID + " INTEGER PRIMARY KEY," +
                COLUMN_CIDADEORIGEMITINERARIO + " TEXT" +
                COLUMN_CIDADEDESTINOITINERARIO + " TEXT," + ")";


        String TABLE_CREATE_PERCURSO = "CREATE TABLE " + TABLE_PERCURSO +
                "(" +
                COLUMN_PERCURSOID + " INTEGER PRIMARY KEY," +
                COLUMN_DATAPERCURSO + " TEXT" +
                COLUMN_KMINICIALPERCURSO + " TEXT," +
                COLUMN_KMFINALPERCURSO + " TEXT," +
                COLUMN_KMTOTALPERCURSO + " TEXT," +
                COLUMN_HORAINICIALPERCURSO + " TEXT," +
                COLUMN_HORAFINALPERCURSO + " TEXT," +
                COLUMN_PERCURSOUSUARIOID_FK + "INTEGER REFERENCES " + TABLE_USUARIO + "," + // Define a foreign key
                COLUMN_PERCURSOVEICULOID_FK + "INTEGER REFERENCES " + TABLE_VEICULO + "," +
                COLUMN_ITINERARIOID_FK + "INTEGER REFERENCES " + TABLE_ITINERARIO + "," +
                COLUMN_VISTORIAID_FK + "INTEGER REFERENCES " + TABLE_VISTORIA + "," + ")";

        sqLiteDatabase.execSQL(TABLE_CREATE_USUARIO);
        sqLiteDatabase.execSQL(TABLE_CREATE_VISTORIA);
        sqLiteDatabase.execSQL(TABLE_CREATE_VEICULO);
        sqLiteDatabase.execSQL(TABLE_CREATE_ABASTECIMENTO);
        sqLiteDatabase.execSQL(TABLE_CREATE_ITINERARIO);
        sqLiteDatabase.execSQL(TABLE_CREATE_PERCURSO);
        this.db = db;

    }

    public void RegistrarUsuario(Usuario user) {
        db = this.getWritableDatabase();
        db.beginTransaction();
        try{

            ContentValues values = new ContentValues();
            values.put(COLUMN_NOME, user.getNome());
            values.put(COLUMN_CPF, user.getCpf());
            values.put(COLUMN_DATA_NASCIMENTO, user.getDataNascimento());
            values.put(COLUMN_SENHA, user.getSenha());
            values.put(COLUMN_UNIDADE, user.getUnidade());
            db.insert(TABLE_USUARIO, null, values);
            db.setTransactionSuccessful();


        }catch (Exception e){

            Log.d( "ALERTA", "Erro ao Registrar Usuario");

        }finally {
            db.endTransaction();
            Log.d( "ALERTA", "Usuario Cadastrado com Sucesso!");
        }



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

    public void RegistrarAbastecimento(Abastecimento abastecimento) {

        Log.d( "ALERTA", "Erro ao Registrar Abastecimento");
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(COLUMN_DATAABASTECIMENTO, (String.valueOf(abastecimento.getDataAbastecimento())));
            values.put(COLUMN_KMABASTECIMENTO, abastecimento.getKmAbastecimento());
            values.put(COLUMN_LITROSABASTECIMENTO, abastecimento.getLitrosAbastecimento());
            values.put(COLUMN_MESANOABASTECIMENTO, abastecimento.getMesAnoAbastecimento());
            values.put(COLUMN_PLACAABASTECIMENTO, abastecimento.getPlacaAbastecimento());
            values.put(COLUMN_USUARIOID_FK, abastecimento.getUsuarioId());
            values.put(COLUMN_VEICULOID_FK, abastecimento.getVeiculoId());


            db.insert(TABLE_ABASTECIMENTO, null, values);
            db.setTransactionSuccessful();
            //Inserir Comandos de Banco put
        } catch (Exception e) {
            Log.d( "ALERTA", "Erro ao Registrar Abastecimento");

        }
    }
    public void RegistrarPercurso(Percurso percurso) {

        Log.d( "ALERTA", "Erro ao Registrar Percurso");
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {

       ContentValues values = new ContentValues();
//            values.put(COLUMN_DATAPERCURSO, (String.valueOf(percurso.getData())));
//            values.put(COLLUMN_HORA_FINAL, percurso.getHoraFinal());
//            values.put(COLUMN_LITROSABASTECIMENTO, percurso.getLitrosAbastecimento());
//            values.put(COLUMN_MESANOABASTECIMENTO, percurso.getMesAnoAbastecimento());
//            values.put(COLUMN_PLACAABASTECIMENTO, percurso.getPlacaAbastecimento());
//            values.put(COLUMN_USUARIOID_FK, percurso.getUsuarioId());
//            values.put(COLUMN_VEICULOID_FK, percurso.getVeiculoId());


            db.insert(TABLE_PERCURSO, null, values);
            db.setTransactionSuccessful();
            //Inserir Comandos de Banco put
        } catch (Exception e) {
            Log.d( "ALERTA", "Erro ao Registrar Percurso");

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
