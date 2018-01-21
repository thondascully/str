package com.example.teo.myapplication;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.clientproject.teo.str.ChatApplication.Message;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Teo on 11/20/2017.
 */




public class MyListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Message> myArrayList;



    public MyListAdapter(Context context) {
        super();
        this.context = context;
        myArrayList = new ArrayList<Message>();
    }
    @Override
    public int getCount(){
        return myArrayList.size();
    }


    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    public void addMessage(Message newMessage) {
        myArrayList.add(newMessage);
        Log.e("Add Message","Got passed myArrayList.add(newMessage);");

    }

    public void clearMessages() {
        myArrayList.clear();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = myArrayList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View myLayout = inflater.inflate(R.layout.cell_layout, null);
        TextView messageTextView = (TextView) myLayout.findViewById(R.id.txtMessage);
        messageTextView.setText(message.chatMessage.toString());

        TextView usernameTextView = (TextView) myLayout.findViewById(R.id.txtInfo);
        usernameTextView.setText(message.username.toString());
        convertView = myLayout;

        return convertView;
    }

}


