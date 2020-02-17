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
        if (command.indexOf("Heyy") != -1) {
            speak("Namaste ,i think you are from a country with rich heritage and culture that is india");
        }else
        if (command.indexOf("what is your name") != -1) {
            speak("My name is usher.");
        }else
        if (command.indexOf("time") != -1) {
            Date now = new Date();
            String time = DateUtils.formatDateTime(this, now.getTime(), DateUtils.FORMAT_SHOW_TIME);
            speak("The time now is " + time);

        } else if (command.indexOf("open") != -1) {
            if (command.indexOf("browser") != -1) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.co.in/?hl=hi"));
                startActivity(intent);
            } else if (command.indexOf("instagram") != -1) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/"));
                startActivity(intent);
            }
        } else if (command.indexOf("how") != -1) {
            if (command.indexOf("many") != -1) {
                if (command.indexOf("hospitals") != -1) {
                    speak("There are around 100 hospitals near delhi and ghaziabad which are integrated in this application.");
                } else if (command.indexOf("beds") != -1) {
                    speak("There are around 600 to 800 beds in every hospitals near delhi and ghaziabad which are integrated in this application.");
                }
            }
        } else if (command.indexOf("about") != -1) {
            if (command.indexOf("method") != -1) {
                if (command.indexOf("payment") != -1) {
                    speak("You can pay through U P I with any application installed on your device such as paytm,google pay,phone pay,amazon pay! or if you dont want to pay now you will loose a discount of 20 percent using pay later option. You can also pay later through hospital desk.");
                } else if (command.indexOf("blood") != -1) {
                    speak("in blood bank module you can donate blood yourself by filling the required form or if you need blood you can go to need blood section and search for required donor and contact him or her.");
                }
            }
        }else if(command.indexOf("who")!=-1){
            if(command.indexOf("developed")!=-1){
                speak("This application has been developed by team hexdroide and i have been developed and designed by the most talented person that is AAman Kaansal");
            }
        }
        else
        {
            speak("Sorry did not get what you said");
        }
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
                    speak("Hello I am Usher,I will tell you about this application named Appoint X.This is an java based application which helps you book appointments with the doctors O P D of the hospital near you.This application has many modules such as hospitals search near you,book appointments,types of facilities in hospitals,blood bank modules,payment gateway and query and feedback section where you can message your query.It is an allrounder application where you can do everthing under one roof.If you want to enter this application click the start button.");
                }
            }
        });
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
