package com.example.calculatorprojectv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class ActualStoryMode extends AppCompatActivity {

    TextView lOne, lTwo, lThree, lFour;
    Button nBtn;
    MediaPlayer backgroundMusicOne;
    public static KeepCount count = new KeepCount(0);;

    public static final String SHARED_PREFS = "sharedPrefs";
    static final String STORE_COUNT = "classCount";

    String[] introductionLabels = {"It is the year 2435",
    "And just like any other day, you go to a secure underground facility to conduct your research and experimentation with AI",
    "You and your team were so close to achieving full autonomous humanoid bots, capable of emotion and thought",
    "However, that's when it all went wrong"};

    String[] introScreenPartOne = {"Suddenly, the humanoid robots started to get a mind of their own!",
            "They started to violently undo their restraints, and mangaged to boogie with da hoodie loose",
    "As you and the other scientists started to make their escape, all of you realized something very important... All of you forgot your keycards..",
    "BUT THAT DIDN'T MATTER, as you and your mates started to bolt to the door"};

    String[] introScreenPartTwo = {"As you and your team were able to make it out of the lab room, you soon realize without your credentials, only you have the authority to get you and your team out alive!",
    "As you and your team approach the first checkpoint, you take a look into the keypad"};

    String[] partTwoDialogue = {"As you and your team is able to make it past the first security checkpoint, you realize that you need to fight off some robots, get read to fight!"};

    String[] partThreeDialogue = {"As you and your team manage to fight off the main horde of robots, you see the experimental military device, known as an \"Evengalion\"",
    "It was left there in the case the Robots would prove to be superior to humans",
    "As you bolt to the door, you notice that you need to hack the pin pad to gain access",
    "You know what to do."};

    String[] evangelionDialogue = {"As you and your team gain access to the Eva, you realize that only you have the right credentials to get into the Evangelion",
    "But your team can help you get the Evangelion up and running to prep your fight against the sentient beings"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_actual_story_mode);

        if (count.getFGD()){
            count.reset();
        }

        Log.d("TAG", "FGD: " + count.getFGD());

        lOne = (TextView) findViewById(R.id.labelOne);
        lTwo = (TextView) findViewById(R.id.labelTwo);
        lThree = (TextView) findViewById(R.id.labelThree);
        lFour = (TextView) findViewById(R.id.labelFour);
        //^^ TextViews to display story context

        nBtn = (Button) findViewById(R.id.nextButton);
        //^^ Next Button to move along the story

        playMusic();

        if (count.getCount() == 0){
            lOne.setText(introductionLabels[0]);
            lTwo.setText(introductionLabels[1]);
            lThree.setText(introductionLabels[2]);
            lFour.setText(introductionLabels[3]);
        }
        //^^ Beginning dialogue for first time setup

        setDialogue();
        //^^ Method that sets the dialogue so that the screen automatically changes to the correct label

        nBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialogue();
            }
        });
        //^^ Click Listener for Next Button
    }

    private void startAnimation(){
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        lOne.setAnimation(fadeIn);
        lTwo.setAnimation(fadeIn);
        lThree.setAnimation(fadeIn);
        lFour.setAnimation(fadeIn);
    }

    private void playMusic(){
        if (backgroundMusicOne == null){
            backgroundMusicOne = MediaPlayer.create(this, R.raw.feel_uneasy);
            backgroundMusicOne.start();
            backgroundMusicOne.setLooping(true);
        } else {
            backgroundMusicOne.release();
            backgroundMusicOne = null;
        }
    }

    private void openHackLevelOne(){
        Intent fgd = new Intent(this, BulkheadKeypadActivity.class);
        startActivity(fgd);

        backgroundMusicOne.stop();
    }

    private void openFirstFight(){
        Log.d("TAG", "Count Before: " + count.getCount());

        Intent intent = new Intent(this, first_fight_scene.class);
        intent.putExtra("count", count);

        startActivity(intent);

        backgroundMusicOne.stop();
    }

    private void openEvaHack(){
        Intent intent = new Intent(this, HackEvaKeyPad.class);
        intent.putExtra("count", count);

        startActivity(intent);

        backgroundMusicOne.stop();
    }

    private void openBossBattle(){
        Intent intent = new Intent(this, FinalBossBattle.class);
        intent.putExtra("count", count);

        startActivity(intent);

        backgroundMusicOne.stop();
    }

    private void setDialogue(){
        if (count.getCount() == 1){
            lOne.setText(introScreenPartOne[0]);
            lTwo.setText(introScreenPartOne[1]);
            lThree.setText(introScreenPartOne[2]);
            lFour.setText(introScreenPartOne[3]);
        } else if (count.getCount() == 2){
            lOne.setText(introScreenPartTwo[0]);
            lTwo.setText(introScreenPartTwo[1]);
            lThree.setText("");
            lFour.setText("");
        } else if (count.getCount() == 3){
            openHackLevelOne();
        } else if (count.getCount() == 4){
            lOne.setText(partTwoDialogue[0]);
            lTwo.setText("");
            lThree.setText("");
            lFour.setText("");
        } else if (count.getCount() == 5){
            openFirstFight();
        } else if (count.getCount() == 6){
            lOne.setText(partThreeDialogue[0]);
            lTwo.setText(partThreeDialogue[1]);
            lThree.setText(partThreeDialogue[2]);
            lFour.setText(partThreeDialogue[3]);
        } else if (count.getCount() == 7){
            openEvaHack();
        } else if (count.getCount() == 8){
            lOne.setText(evangelionDialogue[0]);
            lTwo.setText(evangelionDialogue[1]);
            lThree.setText("");
            lFour.setText("");
        } else if (count.getCount() == 9){
            openBossBattle();
        }

        startAnimation();

        count.increaseCount();
    }

}
