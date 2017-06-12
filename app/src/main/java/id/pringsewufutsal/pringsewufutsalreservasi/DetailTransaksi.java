package id.pringsewufutsal.pringsewufutsalreservasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetailTransaksi extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaksi);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textView10);
        text2 = (TextView) findViewById(R.id.textView11);
        text3 = (TextView) findViewById(R.id.textView12);
        text4 = (TextView) findViewById(R.id.textView13);
        text5 = (TextView) findViewById(R.id.textView14);
        text6 = (TextView) findViewById(R.id.textView15);
        text7 = (TextView) findViewById(R.id.textView16);
        text8 = (TextView) findViewById(R.id.textView17);
        text9 = (TextView) findViewById(R.id.textView18);
        text10 = (TextView) findViewById(R.id.textView19);
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
        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }



}