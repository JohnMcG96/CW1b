package com.example.assignmentpart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.wonderkiln.camerakit.CameraView;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private Button btnLogout, btnOpenAdd, btnOpenRemove, btnOpenList, btnOpenPantry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }



        btnOpenAdd = findViewById(R.id.btnOpenAdd);
        btnOpenRemove = findViewById(R.id.btnOpenRemove);
        btnOpenList = findViewById(R.id.btnOpenList);
        btnOpenPantry = findViewById(R.id.btnOpenPantry);
        btnLogout = findViewById(R.id.btnLogout);

        btnOpenAdd.setOnClickListener(this);
        btnOpenRemove.setOnClickListener(this);
        btnOpenList.setOnClickListener(this);
        btnOpenPantry.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnOpenAdd){
            finish();
            startActivity(new Intent(this, AddItem.class));
        }
        if(view == btnOpenRemove){
            finish();
            startActivity(new Intent(this, RemoveItem.class));
        }
        if(view == btnOpenList){
            finish();
            startActivity(new Intent(this, MakeList.class));
        }
        if(view == btnOpenPantry){
            finish();
            startActivity(new Intent(this, ViewPantry.class));
        }
        if(view == btnLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
