package id.pringsewufutsal.pringsewufutsalreservasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "transaksifutsal.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table transaksi(no_pemesanan integer primary key, tgl_transaksi text not null, nama_pemesan text not null, no_hp text not null, tgl_dipesan text not null, waktu_mulai text not null, waktu_selesai text not null, lapangan text not null, total_bayar text not null, keterangan text not null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO transaksi ( no_pemesanan, tgl_transaksi, nama_pemesan, no_hp, tgl_dipesan, waktu_mulai, waktu_selesai, lapangan, total_bayar, keterangan) VALUES ('1', '17-04-2017', 'Kiki', '085268656289', '20-04-2017', '19.00', '21.00', 'Lapangan 1', '150.000', 'Lunas');";
        db.execSQL(sql);

        String sql2 = "create table petugas(no_petugas integer primary key null, nama_petugas text not null, no_hp text not null, username text not null, password text not null);";
        Log.d("Data", "onCreate: " + sql2);
        db.execSQL(sql2);
        sql2 = "INSERT INTO petugas (no_petugas, nama_petugas, no_hp, username, password) VALUES ('1','Kiki Efraim', '085268656289', 'kikiefraim', 'kikiefraim');";
        db.execSQL(sql2);

        //not null auto_increment
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}
