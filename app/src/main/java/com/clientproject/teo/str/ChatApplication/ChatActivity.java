package com.clientproject.teo.str.ChatApplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.clientproject.teo.str.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Teo on 1/20/2018.
 */

public class ChatActivity extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chatactivity, null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.buttonSix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "You are inside Chat", Toast.LENGTH_SHORT).show();
            }
        });
    }

        ListView listview;
        EditText chatsend;
        String username;
        String chatroomName;
        Boolean Incognito;
        Context context;
        MyListAdapter adapter;
        EditText edittext;


        public static FirebaseDatabase dataBase;
        public static DatabaseReference ref;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Log.e("onCreate","On Create worked.");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.chat_activity);
            //FirebaseApp.initializeApp(this.getApplicationContext());
            dataBase = FirebaseDatabase.getInstance();
            ref = dataBase.getReference();
            Intent intent = getIntent();
            username = intent.getStringExtra("username");
            chatroomName = intent.getStringExtra("Chat_room_name");
            Incognito = intent.getBooleanExtra("Incognito", false);
            listview = (ListView) findViewById(R.id.list_view);
            chatsend = (EditText) findViewById(R.id.chat_function);

            this.adapter = new MyListAdapter(this);

            firebaseEventListener();

            if (Incognito == true) {
                username = "???";
            }
        }



        public String getMessage() {
            return chatsend.getText().toString();

        }
        public long getTimeAndDate() {
            return System.currentTimeMillis();
        }
        public void sendButton(View v) {
            Message myMessage = new Message(username, getTimeAndDate(), getMessage(), chatroomName, Incognito);
            Log.e("sendButton", "Started sendButton");
            String message = myMessage.messageData().toString();
            Map<String, Object> jsonMap = new Gson().fromJson(message, new TypeToken<HashMap<String, Object>>() {}.getType());
            ref.child("messages").child(this.chatroomName).child(Long.toString(getTimeAndDate())).setValue(jsonMap);

            edittext = (EditText) findViewById(R.id.chat_function);

            edittext.getText().clear();
            adapter.clearMessages();

        }
//
        //


        public void firebaseEventListener() {

            ref.child("messages").child(chatroomName).addValueEventListener(new ValueEventListener() {

                public void onDataChange(DataSnapshot dataSnapshot) {
                    String key = dataSnapshot.getKey();
                    Log.e("Data Change", "Data change is running");
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        try {
                            Log.e("Try","Post Try Pre Definitions?");

                            String message = data.child("Message").getValue().toString();
                            Boolean isIncognito = Boolean.valueOf(data.child("isIncognito").getValue().toString());
                            String username = String.valueOf(data.child("Username").getValue().toString());
                            Long timestamp = Long.valueOf(data.getKey().toString());
                            Log.e("Defined", "Everything has been defined");
                            Message m = new Message(username, timestamp, message, key, isIncognito);
                            Log.e("Add.","Hasn't been added yet");
                            adapter.addMessage(m);
                            Log.e("Add.","Has been added.");

                            listview.setAdapter(adapter);


                            listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                                public boolean onItemLongClick(AdapterView<?> arg0, View view,
                                                               int index, long arg3) {
                                    // TODO Auto-generated method stub

                                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


                                    View myLayout = inflater.inflate(R.layout.main, null);
                                    EditText item = ((EditText) myLayout.findViewById(R.id.username_text_input));

                                    String stringItem = item.getText().toString();
                                    Toast.makeText(getBaseContext(), stringItem, Toast.LENGTH_LONG).show();


                                    return true;
                                }
                            });

                        } catch (DatabaseException JE) {
                            Log.e("JSONException JE Error", "Error on JSONException JE");
                        }
                        adapter.notifyDataSetChanged();
                        Log.e("notifyDataSetChanged","adapter.notifyDataSetChanged();");
                    }

                }



                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }


            return super.onOptionsItemSelected(item);
        }

    }


}
