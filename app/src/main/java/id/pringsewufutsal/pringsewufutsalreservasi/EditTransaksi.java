package id.pringsewufutsal.pringsewufutsalreservasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditTransaksi extends AppCompatActivity {

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_transaksi);
    }
    */

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    TextView text1;
    EditText text2, text3, text4, text5, text6, text7, text8, text9, text10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_transaksi);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.editTextView3);
        text2 = (EditText) findViewById(R.id.editEditText1);
        text3 = (EditText) findViewById(R.id.editEditText2);
        text4 = (EditText) findViewById(R.id.editEditText3);
        text5 = (EditText) findViewById(R.id.editEditText4);
        text6 = (EditText) findViewById(R.id.editEditText6);
        text7 = (EditText) findViewById(R.id.editEditText7);
        text8 = (EditText) findViewById(R.id.editEditText5);
        text9 = (EditText) findViewById(R.id.editEditText8);
        text10 = (EditText) findViewById(R.id.editEditText9);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM transaksi WHERE no_pemesanan = '" +
                getIntent().getStringExtra("no_pemesanan") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
            text8.setText(cursor.getString(7).toString());
            text9.setText(cursor.getString(8).toString());
            text10.setText(cursor.getString(9).toString());
        }
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update transaksi set tgl_transaksi='"+
                        text2.getText().toString() +"', nama_pemesan='" +
                        text3.getText().toString()+"', no_hp='"+
                        text4.getText().toString() +"', tgl_dipesan='" +
                        text5.getText().toString()+"', waktu_mulai='"+
                        text6.getText().toString() +"', waktu_selesai='" +
                        text7.getText().toString() +"', lapangan='" +
                        text8.getText().toString()+"', total_bayar='"+
                        text9.getText().toString() +"', keterangan='" +
                        text10.getText().toString() + "' where no_pemesanan='" +
                        text1.getText().toString()+"'");
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
