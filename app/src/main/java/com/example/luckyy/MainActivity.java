package com.example.luckyy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3;
    public TextView[] tv = new TextView[6];
    public int[] a = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6};
    public TextView[] tv2 = new TextView[6];
    public int[] b = {R.id.tva, R.id.tvb, R.id.tvc, R.id.tvd, R.id.tve, R.id.tvf};
    public TextView[] tv3 = new TextView[7];
    public int[] c = {R.id.tva1, R.id.tvb2, R.id.tvc3, R.id.tvd4, R.id.tve5, R.id.tvf6, R.id.tvg7};
    public TextView[] tv4 = new TextView[7];
    public int[] d = {R.id.tva11, R.id.tvb22, R.id.tvc33, R.id.tvd44, R.id.tve55, R.id.tvf66, R.id.tvg77};
    int t=0;
    Intent intent;
    FirebaseDatabase database;
    DatabaseReference myRefa,myRefb,myRefc,myRefd;
    DatabaseReference myReft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        intent= new Intent(MainActivity.this,stock.class);
        initView();
        database = FirebaseDatabase.getInstance();
        myReft = database.getReference("t");
        myReft.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                t=Integer.parseInt(dataSnapshot.getValue().toString());
                Log.d("aaa", "onDataChange: "+dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                thread th = new thread();
                th.run();
                for (int p = 0; p < tv.length; p++) {
                    tv[p].setText(" " + th.lottery[p]);
                }
                for (int p = 0; p < tv2.length; p++) {
                    tv2[p].setText(" " + th.lottery2[p]);
                }
                for (int p = 0; p < tv3.length; p++) {
                    tv3[p].setText(" " + th.lottery3[p]);
                }
                for (int p = 0; p < tv4.length; p++) {
                    tv4[p].setText(" " + th.lottery4[p]);
                }

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    t++;
                    myReft.setValue(""+t);

                    myRefa = database.getReference("loto").child(""+t).child("a");
                    myRefb = database.getReference("loto").child(""+t).child("b");
                    myRefc = database.getReference("loto").child(""+t).child("c");
                    myRefd = database.getReference("loto").child(""+t).child("d");


                    myRefa.setValue(Arrays.toString(thread.lottery));
                    myRefb.setValue(Arrays.toString(thread.lottery2));
                    myRefc.setValue(Arrays.toString(thread.lottery3));
                    myRefd.setValue(Arrays.toString(thread.lottery4));





            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        for (int s = 0; s < tv.length; s++) {
            tv[s] = findViewById(a[s]);

            tv[s].setTextSize(15);
        }
        for (int s = 0; s < tv2.length; s++) {
            tv2[s] = findViewById(b[s]);

            tv2[s].setTextSize(15);
        }
        for (int s = 0; s < tv3.length; s++) {
            tv3[s] = findViewById(c[s]);

            tv3[s].setTextSize(15);
        }
        for (int s = 0; s < tv4.length; s++) {
            tv4[s] = findViewById(d[s]);

            tv4[s].setTextSize(15);
        }

    }
}
