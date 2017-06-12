package id.pringsewufutsal.pringsewufutsalreservasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahTransaksi extends AppCompatActivity {

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);
    }
    */

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);

        dbHelper = new DataHelper(this);
        //text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.tambahEditText1);
        text3 = (EditText) findViewById(R.id.tambahEditText2);
        text4 = (EditText) findViewById(R.id.tambahEditText3);
        text5 = (EditText) findViewById(R.id.tambahEditText4);
        text6 = (EditText) findViewById(R.id.tambahEditText6);
        text7 = (EditText) findViewById(R.id.tambahEditText7);
        text8 = (EditText) findViewById(R.id.tambahEditText5);
        text9 = (EditText) findViewById(R.id.tambahEditText8);
        text10 = (EditText) findViewById(R.id.tambahEditText9);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into transaksi(tgl_transaksi, nama_pemesan, no_hp, tgl_dipesan, waktu_mulai, waktu_selesai, lapangan, total_bayar, keterangan) values('" +
                        //text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "','" +
                        text6.getText().toString() + "','" +
                        text7.getText().toString() + "','" +
                        text8.getText().toString() + "','" +
                        text9.getText().toString() + "','" +
                        text10.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
