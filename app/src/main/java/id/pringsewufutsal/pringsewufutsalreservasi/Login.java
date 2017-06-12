package id.pringsewufutsal.pringsewufutsalreservasi;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText usernameEditText, passwordEditText;
    Button buttonLogin, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        buttonLogin.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);

        Button btn=(Button)findViewById(R.id.buttonSignUp);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonLogin){
            autentikasi();
        } else {

        }
    }

    private void autentikasi(){

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();


        if (username.equalsIgnoreCase("asa") && password.equalsIgnoreCase("asa")){
            Toast.makeText(Login.this, "Login sukses", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

            Log.d("Login", "Login sukses");
            finish();
        } else {
            Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_SHORT).show();
            Log.d("Login", "Login gagal");
        }

    }
}
