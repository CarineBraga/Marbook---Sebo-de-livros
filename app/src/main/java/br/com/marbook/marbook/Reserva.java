package br.com.marbook.marbook;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Reserva extends Activity {
    Button btcomprar,btcancelar;
    EditText t1;
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        btcomprar = (Button) findViewById(R.id.btcad);


        btcomprar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Intent abreReserva = new Intent(Reserva.this, PaginaInicial.class);
                startActivity(abreReserva);


                btcancelar = (Button) findViewById(R.id.btcancel);
                btcancelar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent fechaReserva = new Intent(Reserva.this, LoginActivity.class);
                        startActivity(fechaReserva);
                    }
                });
            }
        });
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        t1 = (EditText) findViewById(R.id.data1);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sMonthIni = C.get(Calendar.MONTH);

                showDialog(DATE_ID);
            }
        });

    }


    private void colocar_fecha () {
        t1.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni + " ");
    }


    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };


    @Override
    protected Dialog onCreateDialog (int id){
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);


        }


        return null;
    }

}





