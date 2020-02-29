package com.example.whatever;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.example.whatever.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.text.format.DateUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Voice extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_RECORD_AUDIO =0;
    private TextToSpeech myTTS;
    private SpeechRecognizer mySpeechRecognizer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Voice.this,
                        Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED) {

                    // Permission is not granted
                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Voice.this,
                            Manifest.permission.RECORD_AUDIO)) {
                        // Show an explanation to the user *asynchronously* -- don't block
                        // this thread waiting for the user's response! After the user
                        // sees the explanation, try again to request the permission.
                    } else {
                        // No explanation needed; request the permission
                        ActivityCompat.requestPermissions(Voice.this,
                                new String[]{Manifest.permission.RECORD_AUDIO},MY_PERMISSIONS_REQUEST_RECORD_AUDIO);

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    }
                } else {

                    Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
                    mySpeechRecognizer.startListening(intent);}
            }
        });
        initializeTextToSpeech();
        initializeSpeechRecognizer();



    }
    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(Voice.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setLanguage(Locale.US);
                    speak( "hello,i am fityfy,i will tell you about this application name health o. this is java based android healthcare application, It enables user to keep track of their health and wellness.fitroid has many modules such as nearby doctors,hospitals,s o s,book appointment section,body mass index calculator,step tracker,blood bank ,payment gateway, enquiry system.overall its a complete package for health wellness    .  Browse this application for more information. have a great day ahead.");
                }
            }
        });
    }

    private void initializeSpeechRecognizer() {
        if(SpeechRecognizer.isRecognitionAvailable(this)){
            mySpeechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
            mySpeechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float rmsdB) {

                }

                @Override
                public void onBufferReceived(byte[] buffer) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int error) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    List<String> results =bundle.getStringArrayList(
                            SpeechRecognizer.RESULTS_RECOGNITION
                    );
                    processResult(results.get(0));

                }

                @Override
                public void onPartialResults(Bundle partialResults) {

                }

                @Override
                public void onEvent(int eventType, Bundle params) {

                }
            });
        }
    }

    private void processResult(String command) {
        command = command.toLowerCase();
        //what is your name?
        //what is the time?
        //open the browser
        if(command.indexOf("hello")!=-1){
            speak("how can i help you?");
        }else
        if (command.indexOf("what is") != -1) {
            if(command.indexOf("your name")!=-1)
            {
                speak("My name is fityfy");
            }
            }
             else if (command.indexOf("go to") != -1) {

                if(command.indexOf("dashboard")!=-1){
             Intent intent = new Intent(Voice.this,dashboard.class);
                startActivity(intent);
            }
                else if(command.indexOf("doctor")!=-1){
                    Intent intent = new Intent(Voice.this,dp.class);
                    startActivity(intent);
                }
                else if(command.indexOf("appointment")!=-1){
                    Intent intent = new Intent(Voice.this,dp.class);
                    startActivity(intent);
                }
                else if(command.indexOf("blood")!=-1){
                    Intent intent = new Intent(Voice.this,blood.class);
                    startActivity(intent);
                }
                else if(command.indexOf("bmi")!=-1){
                    Intent intent = new Intent(Voice.this,bmi.class);
                    startActivity(intent);
                }
                else if(command.indexOf("step")!=-1){
                    Intent intent = new Intent(Voice.this,step.class);
                    startActivity(intent);
                }else if(command.indexOf("sos")!=-1) {
                    Intent intent = new Intent(Voice.this, ambulance.class);
                    startActivity(intent);
                }
                else speak("Sorry did not get what you said !");


            }
         else if (command.indexOf("how") != -1) {
            if (command.indexOf("many") != -1) {
                if (command.indexOf("hospitals") != -1) {
                    speak("There are around 50 hospitals  integrated in this application.");
                } else if (command.indexOf("beds") != -1) {
                    speak("There are around 100 to 200 beds in every hospital integrated in this application.");
                }
            }
        } else if (command.indexOf("about") != -1) {
            if (command.indexOf("method of") != -1) {
                if (command.indexOf("payment") != -1) {
                    speak("You can pay through U P I with any application installed on your device such as paytm,google pay,phone pay,amazon pay! or if you dont want to pay now you will loose a discount of 10 percent using pay now option. You can also pay later through hospital desk.");
                } else if (command.indexOf("blood") != -1) {
                    speak("in blood bank module you can donate blood yourself by filling the required form or if you need blood you can go to need blood section and search for required donor and contact him or her.");
                }
                else speak("Sorry did not get what you said !");
            }
            else speak("Sorry did not get what you said !");
        }
        else speak("Sorry did not get what you said !");

    }



    private void speak(String hello_i_am_ready) {
        if (Build.VERSION.SDK_INT >= 21) {
            myTTS.speak(hello_i_am_ready, TextToSpeech.QUEUE_FLUSH, null, null);

        } else {
            myTTS.speak(hello_i_am_ready, TextToSpeech.QUEUE_FLUSH, null);

        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        myTTS.shutdown();
    }

    public void next(View view) {
        Intent rintent=new Intent(Voice.this,dashboard.class);
        startActivity(rintent);
    }
}
