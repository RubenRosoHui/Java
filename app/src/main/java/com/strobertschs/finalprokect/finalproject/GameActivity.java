<<<<<<< HEAD
package com.strobertschs.finalprokect.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
=======
package com.strobertschs.finalprokect.finalproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import static com.strobertschs.finalprokect.finalproject.R.drawable.cntower2;


public class GameActivity extends AppCompatActivity {


    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Resources res = getResources();
        bitmap = BitmapFactory.decodeResource(res, cntower2);
    }
}
>>>>>>> 1dd2da0cf2967e2fb65f4da3e175f720b4174264
