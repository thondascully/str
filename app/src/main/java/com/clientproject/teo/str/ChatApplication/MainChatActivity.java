package com.clientproject.teo.str.ChatApplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.clientproject.teo.str.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teo on 1/21/2018.
 */

public class MainChatActivity extends AppCompatActivity{


        EditText nameInput;
        ListView listView;

        Context context;
        EditText spinnerEditText;

    /*public static FirebaseDatabase dataBase = FirebaseDatabase.getInstance();
    public static DatabaseReference ref = dataBase.getReference();
*/

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.nav_header_main);
            //



            //


            nameInput = (EditText) findViewById(R.id.usernameInput);









            context = this;

        }

        public String getUsername() {
            EditText username = (EditText)findViewById(R.id.usernameInput);
            String stringUsername = username.getText().toString();

            if (stringUsername.length() == 0) {
                Toast.makeText(getApplicationContext(), "Please input a username!",
                        Toast.LENGTH_LONG).show();
            }
            return stringUsername;
        }

        public String getChatroomName() {
            String chatroomName = (String) "Chatroom";
            return chatroomName;
        }


        public void next_clicked(View v) {
            Intent intent = new Intent(this, ChatActivity.class);
            intent.putExtra("username", getUsername());
            intent.putExtra("Chat_room_name", getChatroomName());

            startActivity(intent);



        }

     /*   @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }*/

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




