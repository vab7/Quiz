package space.belousov.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        // button BACK
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(r -> {
            try {
                Intent intent = new Intent(GameLevels.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        });
        //

        // button transition to level1
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(v -> {
            try {
                if (level >= 1) {
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);
                    finish();
                }
            } catch (Exception e) {

            }
        });
        //

        // button transition to level2
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(v -> {
            try {
                if (level >= 2) {
                    Intent intent = new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);
                    finish();
                }
            } catch (Exception e) {

            }
        });
        //

        // button transition to level3
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(v -> {
            try {
                if (level >= 3) {
                    Intent intent = new Intent(GameLevels.this, Level3.class);
                    startActivity(intent);
                    finish();
                }
            } catch (Exception e) {

            }
        });
        //

        // button transition to level4
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(v -> {
            try {
                if (level >= 4) {
                    Intent intent = new Intent(GameLevels.this, Level4.class);
                    startActivity(intent);
                    finish();
                }
            } catch (Exception e) {

            }
        });
        //

        final int[] x = {
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
        };

        for (int i=1; i < level; i++) {
            TextView tv = findViewById(x[i]);
            tv.setText("" + (i + 1));
        }

    }

    // System button BACK

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

    //

}