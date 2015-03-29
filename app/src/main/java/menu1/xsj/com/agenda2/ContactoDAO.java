package menu1.xsj.com.agenda2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.util.List;


public class ContactoDAO extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "agenda.db";


    private static final int DATABAS_VERSION = 1;


    private Dao<Contacto, Long> dao = null;

    public ContactoDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABAS_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource source) {
        try {
            Log.i(ContactoDAO.class.getSimpleName(), "onCreate()");
            TableUtils.createTable(source, Contacto.class);
            Contacto contacto = new Contacto();
            contacto.setNombre("Administrator");
            contacto.setEmail("admin@oceanbrasil.com");
            contacto.setTelefono("99134-3664");
            cadastrar(contacto);
        } catch (SQLException ex) {
            Log.e(ContactoDAO.class.getSimpleName(), "onCreate(): Falta  crear tablas", ex);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource source, int oldVersion, int newVersion) {

        try {
            Log.i(ContactoDAO.class.getSimpleName(), "onUpgrade()");

            TableUtils.dropTable(source,Contacto.class,true);
        } catch (SQLException ex) {
            Log.e(ContactoDAO.class.getSimpleName(), "onUpgrade(): Falla la atualizaçion", ex);
        }
    }

    public Dao<Contacto, Long> getDao(){
        if (dao == null){
            try{
                dao = getDao(Contacto.class);
            } catch (SQLException e) {
                Log.e(ContactoDAO.class.getSimpleName(), "getDao(): Falta crear DAO", e);
            }
        }
        return dao;
    }

    @Override

    public void close() {
        super.close();
        dao = null;
    }


    public void cadastrar(Contacto contacto) throws SQLException{
        getDao().create(contacto);
    }


    public void excluir(Contacto contacto) throws SQLException{
        getDao().delete(contacto);
    }


    public void alterar(Contacto contacto) throws SQLException{
        getDao().update(contacto);
    }


    public List<Contacto> listar() throws SQLException{
        return getDao().queryForAll();
    }
}
