package com.example.luckyy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class stock extends Activity {
    ListView tv;
    ArrayAdapter<String> adapter;
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);
        tv = findViewById(R.id.tv);


        database = FirebaseDatabase.getInstance();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        tv.setAdapter(adapter);
        if (tv.getParent() != null) {
            ((ViewGroup) tv.getParent()).removeView(tv);
        }
        myRef = database.getReference("loto");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Log.d("ppp", "onDataChange: "+ds.getKey());
                    if(ds.getKey()==null & ds.child("a").getValue()==null|ds.child("b").getValue()==null|ds.child("c").getValue()==null|ds.child("d").getValue()==null){

                    }else{
                        adapter.add(ds.child("a").getValue().toString()+ "\n" +ds.child("b").getValue().toString()+ "\n" +ds.child("c").getValue().toString()+ "\n" +ds.child("d").getValue().toString());
                    }



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        setContentView(tv);

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

}

