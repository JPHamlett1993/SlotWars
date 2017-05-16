package acme.slotwars;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.viewbadger.BadgeView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> players = new ArrayList<String>();

    private int[] getScreenSize(){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int h = displaymetrics.heightPixels;
        int w = displaymetrics.widthPixels;

        int[] size={w,h};
        return size;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button player_button = (Button) findViewById(R.id.player_button);
        final TextView textView = (TextView) findViewById(R.id.name_text);
        player_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                players.add(textView.getText().toString());
            }
        });
        final Button beginButton = (Button) findViewById(R.id.begin_button);
        beginButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginButton.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                player_button.setVisibility(View.GONE);
                GridLayout layout = (GridLayout) findViewById(R.id.container);
                if (!players.isEmpty()) {
                    layout.setRowCount(players.size());
                    for (int i = 0; i < players.size(); i++) {
                        Button playerButton = new Button(MainActivity.this);
                        playerButton.setText(players.get(i));
                        layout.addView(playerButton);
                        //layout.addView(playerButton);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "You need to add players", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
