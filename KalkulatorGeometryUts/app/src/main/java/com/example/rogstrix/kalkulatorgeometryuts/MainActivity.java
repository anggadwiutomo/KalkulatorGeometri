package com.example.rogstrix.kalkulatorgeometryuts;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText_1, editText_2;
    private Button btn_htng;
    private TextView textView_opt1, textView_opt2;
    private Spinner sp_plh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_plh = (Spinner) findViewById(R.id.sp_plh);
        editText_1 = (EditText) findViewById(R.id.editText_1);
        editText_2 = (EditText) findViewById(R.id.editText_2);
        btn_htng = (Button) findViewById(R.id.btn_htng);
        textView_opt1 = (TextView) findViewById(R.id.textView_opt1);
        textView_opt2 = (TextView) findViewById(R.id.textView_opt2);


        btn_htng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input1 = editText_1.getText().toString().trim();
                String input2 = editText_2.getText().toString().trim();

                double P = Double.parseDouble(input1);
                double L = Double.parseDouble(input2);
                double Luas = 0;
                double Keliling = 0;


                if (sp_plh.getSelectedItem().toString().equals("Persegi"))
                {
                    Luas = L * P ;
                    Keliling = ( 2 * P ) + ( 2 * L );
                }
                else if (sp_plh.getSelectedItem().toString().equals("Lingkaran"))
                {
                    Luas = Math.PI * ( P * P );
                    Keliling = Math.PI * ( 2 * P );

                }else {

                    Luas = ( P * L ) / 2;
                    Keliling = (P + L + ( Math.sqrt((P * P) + (L * L))));
                }
                textView_opt1.setText("Luas Bangun Datar = "+Luas);
                textView_opt2.setText("Keliling Bangun Datar = "+Keliling);
            }
        });
    }

    public void doSomething(View view) {
        NotificationManagerCompat myManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder myNoti = new NotificationCompat.Builder(this);
        myNoti.setContentTitle("Hasil Perhitungan");
        myNoti.setContentText("Luas");
        myNoti.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent i1 = new Intent(this,MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this,1,i1,0);
        myNoti.setContentIntent(pd);
        myNoti.setAutoCancel(true);

        myManager.notify(1,myNoti.build());
        finish();
    }
}
