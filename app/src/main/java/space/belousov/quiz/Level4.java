package space.belousov.quiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level4 extends AppCompatActivity {

    Array array = new Array(); // finding array.java

    public int count = 0; // count

    Dialog dialog; // create dialog
    Dialog dialogEnd;

    Random random = new Random();

    public int numLeft;
    public int numRight;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        // set text levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level4);
        text_levels.setTextColor(0x95000000);
        //

        // corners img_left and img_right
        final ImageView img_left = findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        final ImageView img_right = findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        //

        // finding text
        final TextView text_left = findViewById(R.id.text_left);
        text_left.setTextColor(0x95000000);
        final TextView text_right = findViewById(R.id.text_right);
        text_right.setTextColor(0x95000000);
        //

        // create dialog
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        ImageView bg = findViewById(R.id.main_bg);
        bg.setImageResource(R.drawable.ic_level4);

        ImageView previewimg = dialog.findViewById(R.id.previewImg);
        previewimg.setImageResource(R.drawable.preview_bg4);

        LinearLayout dialogfon = dialog.findViewById(R.id.dialog_fon);
        dialogfon.setBackgroundResource(R.drawable.ic_previewbackground4);

        TextView textlevel2 = dialog.findViewById(R.id.textDescription);
        textlevel2.setText(R.string.level4_text_end);


        // button close
        TextView btnClose = dialog.findViewById(R.id.btnclose);
        btnClose.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level4.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
            dialog.dismiss();
        });
        //

        dialog.show();

        // _____________________________________

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        LinearLayout dialogfonEnd = dialogEnd.findViewById(R.id.dialog_fon);
        dialogfonEnd.setBackgroundResource(R.drawable.ic_previewbackground4);

        TextView textdescriptionEnd = dialogEnd.findViewById(R.id.textDescriptionEnd);
        textdescriptionEnd.setText(R.string.level4End);

        // button close
        TextView btnClose2 = dialogEnd.findViewById(R.id.btnclose);
        btnClose2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level4.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
            dialogEnd.dismiss();
        });
        //

        // button continue
        Button btnContinue2 = dialogEnd.findViewById(R.id.btncontinue);
        btnContinue2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level4.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
            dialogEnd.dismiss();
        });
        //

        //

        // button continue
        Button btnContinue = dialog.findViewById(R.id.btncontinue);
        btnContinue.setOnClickListener(v -> {
            try {
                dialog.dismiss();
            } catch (Exception e) {

            }
        });
        //

        //

        // button back
        Button button_back = findViewById(R.id.button_back_levels);
        button_back.setBackgroundResource(R.drawable.button_black_press_white);
        button_back.setTextColor(0x95000000);
        button_back.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level4.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        });
        //

        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };

        // set animation
        final Animation a = AnimationUtils.loadAnimation(Level4.this, R.anim.alpha);
        //

        // random image

        numLeft = random.nextInt(20);
        img_left.setImageResource(array.img4[numLeft]);
        text_left.setText(array.text4[numLeft]);

        numRight = random.nextInt(20);
        while (array.strong[numLeft] == array.strong[numRight])
            numRight = random.nextInt(20);
        img_right.setImageResource(array.img4[numRight]);
        text_right.setText(array.text4[numRight]);
        //

        // process img
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_right.setEnabled(false);
                    if (array.strong[numLeft] > array.strong[numRight]) {
                        img_left.setImageResource(R.drawable.ic_img_true);
                    } else {
                        img_left.setImageResource(R.drawable.ic_img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (array.strong[numLeft] > array.strong[numRight]) {
                        if (count < 20) {
                            count++;
                        }

                        for (int i=0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i=0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                        }
                        for (int i=0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 20) {

                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level > 4) {

                        } else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 5);
                            editor.commit();
                        }

                        dialogEnd.show();
                    } else {
                        numLeft = random.nextInt(20);
                        img_left.setImageResource(array.img4[numLeft]);
                        img_left.startAnimation(a);
                        text_left.setText(array.text4[numLeft]);

                        numRight = random.nextInt(20);
                        while (array.strong[numLeft] == array.strong[numRight])
                            numRight = random.nextInt(20);
                        img_right.setImageResource(array.img4[numRight]);
                        img_left.startAnimation(a);
                        text_right.setText(array.text4[numRight]);

                        img_right.setEnabled(true);
                    }
                }

                return true;
            }
        });

        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_left.setEnabled(false);
                    if (array.strong[numLeft] < array.strong[numRight]) {
                        img_right.setImageResource(R.drawable.ic_img_true);
                    } else {
                        img_right.setImageResource(R.drawable.ic_img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (array.strong[numLeft] < array.strong[numRight]) {
                        if (count < 20) {
                            count++;
                        }

                        for (int i=0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i=0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                        }
                        for (int i=0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 20) {
                        dialogEnd.show();
                    } else {
                        numLeft = random.nextInt(20);
                        img_left.setImageResource(array.img4[numLeft]);
                        img_left.startAnimation(a);
                        text_left.setText(array.text4[numLeft]);

                        numRight = random.nextInt(20);
                        while (array.strong[numLeft] == array.strong[numRight])
                            numRight = random.nextInt(20);
                        img_right.setImageResource(array.img4[numRight]);
                        img_left.startAnimation(a);
                        text_right.setText(array.text4[numRight]);

                        img_left.setEnabled(true);
                    }
                }

                return true;
            }
        });
        //


    }

    // system back
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level4.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
    //

}