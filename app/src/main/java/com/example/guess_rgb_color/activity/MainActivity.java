package com.example.guess_rgb_color.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.guess_rgb_color.R;
import com.example.guess_rgb_color.fragment.GameFragment;
import com.example.guess_rgb_color.navigation.NavigationManager;

import butterknife.ButterKnife;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0, getString(R.string.exit_from_application))
                .setOnMenuItemClickListener(e -> {
                    System.exit(0);
                    return true;
                });
        menu.add(0,0,1, getString(R.string.share))
                .setOnMenuItemClickListener(e -> {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Download this cool game!";
                    String shareSub = "Hello";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, this.getString(R.string.share_using)));
                    return true;
                });
        return true;
    }

    @Override
    public void onBackPressed() {
        NavigationManager manager = new NavigationManager(getSupportFragmentManager());
        manager.navigateBack(this);
    }
}
