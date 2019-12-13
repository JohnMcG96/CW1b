package com.example.assignmentpart2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.operation.ListenComplete;

import java.util.ArrayList;
import java.util.List;

public class MakeList extends AppCompatActivity implements View.OnClickListener {

    private ListView lstShop;
    private Button btnLogout;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;

    private DatabaseReference databaseReference;
    private ArrayList<String> list;
    private FirebaseListAdapter<String> firebaseListAdapter;
    private ArrayAdapter<String> adapter;
    private ItemData itemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_list);

        firebaseAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        itemData = new ItemData();
        lstShop = findViewById(R.id.lstShop);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.listlayout, R.id.txtCodeData, list);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Items");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnap: dataSnapshot.getChildren()){
                    itemData = itemSnap.getValue(ItemData.class);
                    list.add(itemData.toString());
                }

                lstShop.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        lstShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MakeList.this, "" + adapterView.getItemAtPosition(i).toString()
                        , Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            finish();
            startActivity(new Intent(this, MainMenu.class));
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
