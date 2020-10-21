package edu.sjsu.android.gyroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private GyroscopeSensor gyroscopeSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gyroscopeSensor = new GyroscopeSensor(this);

        gyroscopeSensor.setListener(new GyroscopeSensor.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if (rz > 1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
                else if (rz < -1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        gyroscopeSensor.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gyroscopeSensor.unregister();
    }
}