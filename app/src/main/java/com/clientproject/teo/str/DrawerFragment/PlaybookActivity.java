package com.clientproject.teo.str.DrawerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.clientproject.teo.str.Playbook.PlaybookElimination;
import com.clientproject.teo.str.Playbook.PlaybookQualification;
import com.clientproject.teo.str.R;

/**
 * Created by Teo on 1/20/2018.
 */

public class PlaybookActivity extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.playbookactivity, null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.playbookElim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "You are inside Playbook", Toast.LENGTH_SHORT).show();

            }
        });

        //playbookElim onClick
        Button playbookElim = (Button) view.findViewById(R.id.playbookElim);

        playbookElim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playbookElimOnClick(v);
                Fragment fragment = new PlaybookElgiimination();
// Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.screen_area, fragment)
                        .commit();
            }
        });
        //playbookQual onClick'
        Button playbookQual = (Button) view.findViewById(R.id.playbookQual);

        playbookQual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playbookQualOnClick(v);
                Fragment fragment = new PlaybookQualification();
// Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.screen_area, fragment)
                        .commit();
            }
        });
    }


        //playbookElimOnClick
        public void playbookElimOnClick(View v) {
            // does something very interesting
        }


        //playbookQualOnClick
        public void playbookQualOnClick(View v) {
            // does something very interesting
        }


    }

