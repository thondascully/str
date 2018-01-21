package com.clientproject.teo.str.ChatApplication;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Teo on 1/21/2018.
 */

public class Message {

        public String username;
        private long sendTime;
        public String chatMessage;
        private String chatRoomName;
        private Boolean Incognito;


        public Message(String username, long sendTime, String chatMessage, String chatRoomName) {
            this.username = username;
            this.sendTime = sendTime;
            this.chatMessage = chatMessage;
            this.chatRoomName = chatRoomName;


        }


        public JSONObject messageData() {

            JSONObject obj1 = new JSONObject();

            try {
                obj1.put("Message", chatMessage);
                obj1.put("Username", username);

            } catch (JSONException JE) {
                Log.e("Json Crash!!!", "Something went wrong here");
            }

            //
            return obj1;
        }

        public String getChatRoomName() {
            return chatRoomName;
        }


    }

