package com.dise.emmanuelabiola.rhythm;


/**
 * Created by EmmanuelAbiola on 15/10/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    // to make the thread sleep for some time (in milliseconds).
                    //sleep takes the time in milliseconds as its parameter(3000 => 3 seconds).
                    // Here we used this delay time as the time to display the splash screen activity.
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                //MainActivity is started by the code written in finally{} block.
                finally{
                    //We need to define which activity to open after displaying Splash screen.
                    // This is done using the Intent(Context, Class) constructor of the Intent class.
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    //to start the thread
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    //The splash screen activity must not be shown when the user presses the back button.
    // In order to do this, we should destroy the splash screen activity after it is shown for few seconds.
    // This is done by the use of onPause() method.
    // The onPause() method is a method of Activity class which comes into play when the user leaves the activity.
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}