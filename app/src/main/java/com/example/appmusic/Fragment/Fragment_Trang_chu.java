package com.example.appmusic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appmusic.Activity.seachActivity;
import com.example.appmusic.R;

public class Fragment_Trang_chu extends Fragment {

    View view;

    EditText editText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_trang_chu,container,false);
        editText=view.findViewById(R.id.idEdtext);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getActivity(),"dã clink",Toast.LENGTH_LONG).show();
                Log.d("bbb", "onClick: edittext ");

                Intent intent=new Intent(getActivity(), seachActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
