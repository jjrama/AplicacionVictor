package app.victorgraciaweb.com.aplicacion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import app.victorgraciaweb.com.bean.Usuario;
import app.victorgraciaweb.com.controlador.ControladorUsuario;

public class LoginActivity extends ActionBarActivity
{
    private EditText etEmail;
    private EditText etPassword;
    private Button btValidar;
    private CheckBox chckRecordar;
    public SharedPreferences preferencias;
    private static LoginActivity loginActivity;
    public static LoginActivity getInstance(){
        return loginActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText)findViewById(R.id.edtNameLogin);
        etPassword = (EditText)findViewById(R.id.edtPassLogin);
        chckRecordar = (CheckBox) findViewById(R.id.checkbox);
        btValidar = (Button)findViewById(R.id.btnLogin);

        loginActivity = this;

        Intent myIntent = new Intent(this, ListadoCategoriasActivity.class);
        /**
         * SI tiene preferencias entra directo al login
         */
        preferencias = getSharedPreferences("ANUNCIOS_PREFERENCES", MODE_PRIVATE);
        if((preferencias.getString("email", null )!=null)|| preferencias.getString("email", "")!=""){
            List<Usuario> listaUsuarios = ControladorUsuario.accionLogin(etEmail.getText().toString(), etPassword.getText().toString());
            if(listaUsuarios != null && listaUsuarios.size() > 0){

                startActivity(myIntent);
            }
        }
        /**/
        btValidar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(!etEmail.getText().toString().equals("") && !etPassword.getText().toString().equals(""))
                {
                    List<Usuario> listaUsuarios = ControladorUsuario.accionLogin(etEmail.getText().toString(), etPassword.getText().toString());
                    if(listaUsuarios != null && listaUsuarios.size() > 0)
                    {
                        Toast.makeText(getApplicationContext(), "ACCESO CORRECTO", Toast.LENGTH_LONG).show();
                        if(chckRecordar.isChecked()){
                            preferencias = getSharedPreferences("ANUNCIOS_PREFERENCES", MODE_PRIVATE);
                            String email = listaUsuarios.get(0).getEmail();
                            String pass = listaUsuarios.get(0).getPassword();
                            SharedPreferences.Editor editor = preferencias.edit();
                            editor.putString("email", email);
                            editor.putString("password", pass);
                            editor.commit();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Debes de introducir tus datos de acceso", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
