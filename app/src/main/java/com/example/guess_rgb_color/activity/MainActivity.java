package com.example.guess_rgb_color.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guess_rgb_color.fragment.GameFragment;
import com.example.guess_rgb_color.fragment.InfoFragment;
import com.example.guess_rgb_color.tools.Color;
import com.example.guess_rgb_color.tools.Generator;
import com.example.guess_rgb_color.R;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.fragment_container, GameFragment.getInstance());
        transaction.commit();
    }
}
