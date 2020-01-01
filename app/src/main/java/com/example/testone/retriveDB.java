package com.example.testone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class retriveDB extends AppCompatActivity {



    String name,e,f;

//    FirebaseDatabase db =FirebaseDatabase.getInstance();
//    DatabaseReference myRootRef= db.getReference();
//    DatabaseReference userRef = myRootRef.child("User");


    FirebaseDatabase db =FirebaseDatabase.getInstance();
    DatabaseReference rootRef = db.getReference();
    DatabaseReference userRe = rootRef.child("MEMBERS");
    DatabaseReference bopaiah = userRe.child("KG BOPAIAH");
    DatabaseReference appachu = userRe.child("APPACHU RANJAN");




    ListView listView;
    ArrayList<String> usernames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_db);



        final String myValue = getIntent().getStringExtra("namebdm");


        listView=findViewById(R.id.listView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usernames);
        listView.setAdapter(arrayAdapter);

        if (myValue.equals("bopaiah")){

            bopaiah.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String value = dataSnapshot.getValue().toString();

                    try {
                        JSONObject object= new JSONObject(value);
                        f = object.getString("Amount");
                        e = object.getString("Work");

                        name=e+"     "+"Rs "+f+"/-";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    usernames.add(name);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


        if (myValue.equals("appachu")){

            appachu.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String value = dataSnapshot.getValue().toString();

                    try {
                        JSONObject object= new JSONObject(value);
                        f = object.getString("Amount");
                        e = object.getString("Work");

                        name=e+"     "+"Rs "+f+"/-";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    usernames.add(name);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }









    }
}
