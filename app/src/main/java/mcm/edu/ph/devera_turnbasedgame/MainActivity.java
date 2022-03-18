package mcm.edu.ph.devera_turnbasedgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView RobotNameTag, AlienNameTag, dmgpersecondrobot, dmgpersecondalien, combattext;
    ProgressBar RobotHealthBar, AlienHealthBar;
    ImageButton SkillOne, SkillTwo, SkillThree;
    Button NextTurn;

    String RobotStats ="Protag";
    int protaghp = 1210;
    int protaghppercent;
    int protagmindamage = 15;
    int protagmaxdamage = 20;
    int turnNumber = 1;


    String AlienStats ="Antag";
    int antaghp = 4000;
    int alienhppercent;
    int antagmindamage = 10;
    int antagmaxdamage = 15;
    Boolean disablestatus = false;
    int buttoncounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RobotNameTag = findViewById(R.id.RobotNameTag);
        AlienNameTag = findViewById(R.id.AlienNameTag);
        dmgpersecondrobot= findViewById(R.id.dmgpersecondrobot);
        dmgpersecondalien = findViewById(R.id.dmgpersecondalien);
        combattext = findViewById(R.id.combattext);

        RobotHealthBar = findViewById(R.id.RobotHealthBar);
        AlienHealthBar = findViewById(R.id.AlienHealthBar);

        SkillOne = findViewById(R.id.SkillOne);
        SkillTwo = findViewById(R.id.SkillTwo);
        SkillThree = findViewById(R.id.SkillThree);

        NextTurn = findViewById(R.id.NextTurn);

        dmgpersecondrobot.setText(RobotStats);
        SkillOne.setOnClickListener(this);
        SkillTwo.setOnClickListener(this);
        SkillThree.setOnClickListener(this);
        NextTurn.setOnClickListener(this);

        dmgpersecondrobot.setText(String.valueOf(protagmindamage)+" - "+ String.valueOf(protagmaxdamage));
        dmgpersecondalien.setText(String.valueOf(antagmindamage)+" - "+ String.valueOf(antagmaxdamage));

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        Random randomizer = new Random();
        int robotdps = randomizer.nextInt(protagmaxdamage - protagmindamage) + protagmaxdamage;
        int aliendps = randomizer.nextInt(antagmaxdamage - antagmindamage) + antagmaxdamage;
        int critChance = randomizer.nextInt(50);
        if (critChance <= 20){

        }
        int evade = randomizer.nextInt(22);
        if (evade < 5){

        }

        if (turnNumber % 2 == 1) {
            SkillOne.setEnabled(false);
        } else if (turnNumber % 2 != 1) {
            SkillOne.setEnabled(true);

        }
        if (buttoncounter > 0) {
            SkillOne.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            SkillOne.setEnabled(true);
        }
        if (turnNumber % 2 == 1) {
            SkillTwo.setEnabled(false);
        } else if (turnNumber % 2 != 1) {
            SkillTwo.setEnabled(true);
        }
        if (buttoncounter > 0) {
            SkillTwo.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            SkillTwo.setEnabled(true);
        }
        if (turnNumber % 2 == 1) {
            SkillThree.setEnabled(false);
        } else if (turnNumber % 2 != 1) {
            SkillThree.setEnabled(true);
        }
        if (buttoncounter > 0) {
            SkillThree.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            SkillThree.setEnabled(true);
        }

        //robot hp//
        if ((int) protaghppercent > 80 && (int) protaghppercent <= 115) {
            RobotHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.lime)));
        } else if ((int) protaghppercent >= 60 && (int) protaghppercent <= 72) {
            RobotHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.lime)));
        } else if ((int) protaghppercent >= 32 && (int) protaghppercent <= 40) {
            RobotHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
        } else if ((int) protaghppercent >= 15 && (int) protaghppercent <= 20) {
            RobotHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
        } else {
            RobotHealthBar.setProgressTintList(ColorStateList.valueOf((getResources().getColor(R.color.red))));
        }

        //alien hp//
        if ((int) alienhppercent > 80 && (int) alienhppercent <= 100) {
            AlienHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.lime)));
        } else if ((int) alienhppercent >= 50 && (int) alienhppercent <= 75) {
            AlienHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.lime)));
        } else if ((int) alienhppercent >= 25 && (int) alienhppercent <= 50) {
            AlienHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
        } else if ((int) alienhppercent >= 10 && (int) alienhppercent <= 25) {
            AlienHealthBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
        } else {
            AlienHealthBar.setProgressTintList(ColorStateList.valueOf((getResources().getColor(R.color.red))));
        }

        switch (view.getId()) {

            case R.id.SkillOne:
                antaghp = antaghp - 260;
                alienhppercent = antaghp * 100 / 4000;
                AlienHealthBar.setProgress((int) alienhppercent, true);
                turnNumber++;
                dmgpersecondalien.setText(String.valueOf(antaghp));
                NextTurn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                combattext.setText(" Robot " + String.valueOf( RobotStats ) + " chooses to do BOMBS AWAY! It dealt " + String.valueOf(180) + " The Alien has been blown away, literally.");
                disablestatus = false;

                if (antaghp < 0) {
                    combattext.setText("The Robot Overlord has reigned again!");
                    protaghp = 1210;
                    antaghp = 4000;
                    turnNumber = 1;
                    NextTurn.setText("Reset Game");
                }

                buttoncounter = 1;
                break;

            case R.id.SkillTwo:
                antaghp = antaghp - 260;
                alienhppercent = antaghp * 100 / 4000;
                AlienHealthBar.setProgress((int) alienhppercent, true);
                turnNumber++;
                dmgpersecondalien.setText(String.valueOf(antaghp));
                NextTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");

                combattext.setText(" Robot " + String.valueOf( RobotStats ) + " chooses to do LASERS PEW! It dealt " + String.valueOf(200) + " The Alien has been pewed to infinity.");
                disablestatus = false;

                if (antaghp < 0) {
                    combattext.setText("The Robot Overlord has reigned again!");
                    protaghp = 1210;
                    antaghp = 4000;
                    turnNumber = 1;
                    NextTurn.setText("Reset Game");
                }

                buttoncounter = 1;
                break;

            case R.id.SkillThree:
                antaghp = antaghp - 260;
                alienhppercent = antaghp * 100 / 4000;
                AlienHealthBar.setProgress((int) alienhppercent, true);
                turnNumber++;
                dmgpersecondalien.setText(String.valueOf(antaghp));
                NextTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");

                combattext.setText(" Robot " + String.valueOf(RobotStats) + " chooses, EPIC PUNCH FIST! It dealt " + String.valueOf(150) + " The Alien has been punched and you know... fisted... ");
                disablestatus = false;

                if (antaghp < 0) {
                    combattext.setText("The Robot Overlord has reigned again!");
                    protaghp = 1210;
                    antaghp = 4000;
                    turnNumber = 1;
                    NextTurn.setText("Reset Game");

                }

                buttoncounter = 1;
                break;

            case R.id.NextTurn:
                if (turnNumber % 2 == 1) {
                    antaghp = antaghp - robotdps;
                    turnNumber++;
                    dmgpersecondalien.setText(String.valueOf(antaghp));
                    NextTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");

                    if (antaghp < 0) {
                        combattext.setText("The Robot Overlord has reigned again!");
                        protaghp = 1210;
                        antaghp = 4000;
                        turnNumber = 1;
                        NextTurn.setText("Reset Game");

                    }

                    else if (turnNumber % 2 != 1) {
                        if (disablestatus == false) {
                            disablestatus = false;
                        }

                    }

                    else {
                        protaghp = protaghp - aliendps;
                        protaghppercent = protaghp * 100/1210;
                        RobotHealthBar.setProgress((int) protaghppercent, true);
                        turnNumber++;
                        dmgpersecondrobot.setText(String.valueOf(protaghp));
                        NextTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");

                        combattext.setText(" Alien attacks! The Robot got hit, Beep Boop BEEP! ");

                        if (protaghp < 0) {

                            combattext.setText("The Robot Overlord has lost :( ");
                            protaghp = 1210;
                            antaghp = 4000;
                            turnNumber = 1;
                            NextTurn.setText("Reset Game");
                            {

                            }
                            buttoncounter--;
                        }
                        break;
                    }

                }


        }
    }
}