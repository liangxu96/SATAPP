package com.example.sat_app;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class PracticeMode extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TextView textViewPassage;
    private TextView lineNumber;
    private TextView textViewQuestion;
    private TextView textViewQuestionNumber;
    private ImageView image;
    private ProgressBar progressBar;
    private RadioGroup rbGroup;
    private RadioButton optionA;
    private RadioButton optionB;
    private RadioButton optionC;
    private RadioButton optionD;
    private Button buttonNext;
    private Button buttonBack;
    private DrawerLayout drawer;
    private ImageButton openMenu;
    private ScrollView mainPassageView;

    private NavigationView navView;
    private Menu menu;

    private TextView finishScore;


    private List<readingPassage> passagesList;
    private List<readingPassage> usingPassages;
    private List<readingQuestion> questionsList;
    private List<readingQuestion> usingQuestions;



    private readingPassage currentPassage;
    private int currentPassageIndex; //Current Index of the passage
    private readingQuestion currentQuestion;
    private int currentQuestionIndex;
    private boolean viewExpandedPassage;

    private int numberOfPassages;
    private String mode;
    private List<String> customPassage;
    private int progress;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_mode);

        //Declaring Variables
        usingPassages = new ArrayList<>();
        usingQuestions = new ArrayList<>();
        progress = 0;
        viewExpandedPassage = true;

        //User Imported Settings Acknowledged here
        numberOfPassages = 2;
        mode = "DG"; //R = reading, G = Grammar, DG = Developer Grammar, DR = Developer Reading

        customPassage = new ArrayList<>();
        customPassage.add("P1GP2");
        customPassage.add("P1GP1");


        //ID's for all off the XML
        textViewPassage = findViewById(R.id.PMG_EnglishPassage);
        lineNumber = findViewById(R.id.PMG_LineNumbers);
        textViewQuestion = findViewById(R.id.PMG_Question);
        textViewQuestionNumber = findViewById(R.id.PMG_QuestionCount);
        image = findViewById(R.id.PMG_Image);
        progressBar = findViewById(R.id.PMG_progressBar);
        rbGroup = findViewById(R.id.PMG_RadioGroup);
        optionA = findViewById(R.id.PMG_OptionA);
        optionB = findViewById(R.id.PMG_OptionB);
        optionC = findViewById(R.id.PMG_OptionC);
        optionD = findViewById(R.id.PMG_OptionD);
        buttonNext = findViewById(R.id.PMG_ViewNext);
        buttonBack = findViewById(R.id.PMG_ViewBack);
        drawer = findViewById(R.id.drawer_layout);
        openMenu = findViewById(R.id.PMG_Menu);
        mainPassageView = findViewById(R.id.PMG_ScrollViewPassage);

        navView = findViewById(R.id.PMG_nav_view);
        menu = navView.getMenu();





        //Imports all of the Passages and shuffles then
        readingPassageDBHelper passageHelper = new readingPassageDBHelper(this);
        passagesList = passageHelper.getAllPassages();
        Collections.shuffle(passagesList);

        //Imports all of the questions
        readingQuestionDBHelper questionHelper = new readingQuestionDBHelper(this);
        questionsList = questionHelper.getAllQuestions();


        //Generates all the passages that will be used
        generateUsingPassages();
        currentPassageIndex = 0;
        currentPassage = usingPassages.get(0);

        //Generates all the questions that will be used
        generateUsingQuestions();
        currentQuestionIndex = 0;
        currentQuestion = usingQuestions.get(0);

        //Generates ProgressBar
        progressBar.setMax(usingQuestions.size());

        //Generates Side Menu
        makeMenuQuestions();
        navView.setNavigationItemSelectedListener(this);



        //button interactions
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                saveCheckedOption();
                currentQuestionIndex++;
                if (currentQuestionIndex == usingQuestions.size()) {
                    finished();
                    return;
                }
                currentQuestion = usingQuestions.get(currentQuestionIndex);
                menu.getItem(currentQuestionIndex).setChecked(true);
                buildPracticeMode();
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                saveCheckedOption();
                currentQuestionIndex--;
                currentQuestion = usingQuestions.get(currentQuestionIndex);
                menu.getItem(currentQuestionIndex).setChecked(true);
                buildPracticeMode();
            }
        });

        openMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        optionA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (currentQuestion.getOptionSelected() == 0 && optionA.isChecked()) {
                    updateProgress();
                    currentQuestion.setOptionSelected(1);
                }
            }
        });

        optionB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (currentQuestion.getOptionSelected() == 0 && optionB.isChecked()) {
                    updateProgress();
                    currentQuestion.setOptionSelected(2);
                }
            }
        });

        optionC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (currentQuestion.getOptionSelected() == 0 && optionC.isChecked()) {
                    updateProgress();
                    currentQuestion.setOptionSelected(3);
                }
            }
        });

        optionD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (currentQuestion.getOptionSelected() == 0 && optionD.isChecked()) {
                    updateProgress();
                    currentQuestion.setOptionSelected(4);
                }
            }
        });


        buildPracticeMode();
    }

    @SuppressLint("ResourceType")
    private void updateProgress() {
        //CharSequence currentTitle = menu.getItem(currentQuestionIndex).getTitle();
        progress++;
        progressBar.setProgress(progress);
        textViewQuestionNumber.setText(progress + "/" + usingQuestions.size());


        menu.getItem(currentQuestionIndex).setIcon(getResources().getDrawable(R.drawable.ic_baseline_check_circle_outline_24));

        //menu.getItem(currentQuestionIndex).setTitle(currentTitle + " " + "Complete");
    }


    private void makeMenuQuestions() {

        String curQuestionID;
        String curPassageID;
        String questionName;
        int passageCounter = 0;

        Drawable icon = getResources().getDrawable(R.drawable.questionnotcomplete);

        for(int i = 0; i < usingQuestions.size(); i++) {
            curQuestionID = usingQuestions.get(i).getId();
            curPassageID = usingPassages.get(passageCounter).getId();
            if (!curPassageID.equals(curQuestionID)) {
                passageCounter++;
            }

            if (i < 9) {
                questionName = "Question " + (i + 1) + "      Passage " + (passageCounter + 1);
            } else {
                questionName = "Question " + (i + 1) + "    Passage " + (passageCounter + 1);
            }

            menu.add(R.id.MENU_Question, i, Menu.NONE, questionName);
            menu.getItem(i).setIcon(icon);
        }

        menu.getItem(0).setChecked(true);

        menu.setGroupCheckable(R.id.MENU_Question, true, true);
        menu.setGroupVisible(R.id.MENU_Question, true);

    }

    private void generateUsingQuestions() {
        for (readingPassage curPassage : usingPassages) {
            String findId = curPassage.getId();
            for (readingQuestion curQuestion : questionsList) {
                if (curQuestion.getId().equals(findId)) {
                    usingQuestions.add(curQuestion);
                }
            }
        }
    }

    private void generateUsingPassages() {
        int counter = 0;

        for (readingPassage curPassage : passagesList) {

            if (mode.equals("G")) {
                if (curPassage.getSynopsis() == null) {
                    usingPassages.add(curPassage);
                    counter++;
                }
            } else if (mode.equals("R")) {
                if (curPassage.getSynopsis() != null) {
                    usingPassages.add(curPassage);
                    counter++;
                }
            } else if (mode.equals("DG") || mode.equals("DR")) {
                if (customPassage.contains(curPassage.getId())) {
                    usingPassages.add(curPassage);
                }
            }

            if (counter == numberOfPassages) {
                break;
            }
        }

    }


    //Takes the current passage and Generates the text.
    private void generatePassage() {
        if (mode.equals("G") || mode.equals("DG")) {

            String passage = currentPassage.getPassage();

            int firstQuestionIndex = 0;

            for (int  i = 0; i < usingQuestions.size(); i++) {
                if (currentPassage.getId().equals(usingQuestions.get(i).getId())) {
                    firstQuestionIndex = i;
                    break;
                }
            }


            String[] passageArray = passage.split(" ", 0);


            for (int i = 0; i < passageArray.length; i++) {
                if (passageArray[i].contains("}")) {
                    int lastBracket = passageArray[i].lastIndexOf("}");
                    String keepString = passageArray[i].substring(lastBracket);
                    String newNumber = "}" + (firstQuestionIndex + 1);
                    passageArray[i] = newNumber + keepString;
                    firstQuestionIndex++;
                }

            }

            passage = "";
            for (String curString: passageArray) {
                passage += curString + " ";
            }


            int passageSize = passage.length();

            SpannableString str = new SpannableString(passage);

            int startingMarker = -1;
            int endingMarker = -1;

            for (int i = 0; i < passageSize; i++) {
                char currentCharacter = passage.charAt(i);
                if (currentCharacter == ('}')) {
                    if (startingMarker == -1) {
                        startingMarker = i;
                    } else if (startingMarker > -1) {
                        endingMarker = i;
                        str.setSpan(new BackgroundColorSpan(Color.GRAY), startingMarker, endingMarker + 1, 0);
                        str.setSpan(new ForegroundColorSpan(Color.WHITE), startingMarker, endingMarker + 1, 0);
                        str.setSpan(new ForegroundColorSpan(Color.GRAY), startingMarker, startingMarker + 1, 0);
                        str.setSpan(new ForegroundColorSpan(Color.GRAY), endingMarker, endingMarker + 1, 0);

                        startingMarker = -1;
                        endingMarker = -1;
                    }

                } else if (currentCharacter == '_') {
                    if (startingMarker == -1) {
                        startingMarker = i;
                    } else if (startingMarker > -1) {
                        endingMarker = i;
                        str.setSpan(new UnderlineSpan(), startingMarker, endingMarker, 0);
                        str.setSpan(new ForegroundColorSpan(Color.WHITE), startingMarker, startingMarker + 1, 0);
                        str.setSpan(new ForegroundColorSpan(Color.WHITE), endingMarker, endingMarker + 1, 0);

                        startingMarker = -1;
                        endingMarker = -1;
                    }
                } else if (currentCharacter == '|') {
                    if (startingMarker == -1) {
                        startingMarker = i;
                    } else if (startingMarker > -1) {
                        endingMarker = i;
                        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), startingMarker, endingMarker, 0);
                        str.setSpan(new ForegroundColorSpan(Color.WHITE), startingMarker, startingMarker + 1, 0);
                        str.setSpan(new ForegroundColorSpan(Color.WHITE), endingMarker, endingMarker + 1, 0);


                        startingMarker = -1;
                        endingMarker = -1;
                    }
                }
            }

            textViewPassage.setText(str);
            return;

        }
        String displayText = "";

        if (currentPassage.getSecondPassage() != null) {
            displayText += currentPassage.getSynopsis();
            displayText += "\n\n";
            displayText += "PASSAGE 1 \n";
            displayText += currentPassage.getPassage();
            displayText += "\n\nPASSAGE 2\n";
            displayText += currentPassage.getSecondPassage();
        } else {
            displayText = currentPassage.getSynopsis() + "\n\n" + currentPassage.getPassage();
        }
        textViewPassage.setText(displayText);
    }

    private void generateImage() {
        if (currentPassage.getImage() == null) {
            image.setImageDrawable(null);
        } else {
            int resID = getResId(currentPassage.getImage(), R.drawable.class);
            Drawable picture = getDrawable(resID);
            image.setImageDrawable(picture);
        }
    }

    //Helper Method for generateImage()
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    //Views the current passage and Generates the Line Numbers
    private void generateLineNumbers() {
        if (currentPassage.getSecondPassage() == null) {
            int synopsisPadding = currentPassage.getSynopsisPadding();
            int numOfLines = currentPassage.getLines();
            int currentLine = 5;
            String textString = "";

            for (int i = 0; i <= synopsisPadding; i++) {
                textString += "\n";
            }

            while(numOfLines > 0) {
                textString += currentLine;
                textString += "\n\n\n\n\n";
                currentLine += 5;
                numOfLines -= 5;
            }
            lineNumber.setText(textString);
        } else {
            int synopsisPadding = currentPassage.getSynopsisPadding();
            int totalLines = currentPassage.getLines();
            int firstPassageLines = currentPassage.getTwoPassageLine();
            String textString = "";
            int currentLine = 5;
            for (int i = 0; i <= synopsisPadding; i++) {
                textString += "\n";
            }
            while (firstPassageLines > 0) {
                textString += currentLine;
                textString += "\n\n\n\n\n";
                currentLine += 5;
                firstPassageLines -= 5;
                totalLines -= 5;
            }
            textString += "\n\n";
            while (totalLines > 0) {
                textString += currentLine;
                textString += "\n\n\n\n\n";
                currentLine += 5;
                totalLines -= 5;
            }
            lineNumber.setText(textString);
        }

    }

    @SuppressLint("SetTextI18n")
    private void generateQuestion() {
        int optionSelected;

        textViewQuestionNumber.setText(progress + "/" + usingQuestions.size());

        textViewQuestion.setText(currentQuestion.getQuestion());
        optionA.setText("A) " + currentQuestion.getOption1());
        optionB.setText("B) " + currentQuestion.getOption2());
        optionC.setText("C) " + currentQuestion.getOption3());
        optionD.setText("D) " + currentQuestion.getOption4());

        optionSelected = currentQuestion.getOptionSelected();
        if (optionSelected == 0) {
            rbGroup.clearCheck();
        } else if (optionSelected == 1) {
            optionA.setChecked(true);
        } else if (optionSelected == 2) {
            optionB.setChecked(true);
        } else if (optionSelected == 3) {
            optionC.setChecked(true);
        } else if (optionSelected == 4) {
            optionD.setChecked(true);
        }

    }

    private void buildPracticeMode() {
        checkQuestionMatchPassage();
        generatePassage();
        generateLineNumbers();
        generateQuestion();
        checksButtonBounds();
        generateImage();
        defaultPassageView();
    }

    private void saveCheckedOption() {
        if (optionA.isChecked()) {
            currentQuestion.setOptionSelected(1);
        } else if (optionB.isChecked()) {
            currentQuestion.setOptionSelected(2);
        } else if (optionC.isChecked()) {
            currentQuestion.setOptionSelected(3);
        } else if (optionD.isChecked()) {
            currentQuestion.setOptionSelected(4);
        }
    }

    //Checks to see if we are on first question (disable back)
    private void checksButtonBounds() {
        if (currentQuestionIndex == 0) {
            buttonBack.setVisibility(View.GONE);
        } else {
            buttonBack.setVisibility(View.VISIBLE);
        }
        if (currentQuestionIndex == usingQuestions.size() - 1) {
            buttonNext.setText("Finish");
        } else {
            buttonNext.setText("Next");
        }
    }


    //Checks to see if the currentQuestion Matches the current Question
    private void checkQuestionMatchPassage() {
        String questionId = currentQuestion.getId();
        String passageId = currentPassage.getId();

        if (questionId.equals(passageId)) {
            return;
        } else {
            for (int i = 0; i < usingPassages.size(); i++) {
                if (usingPassages.get(i).getId().equals(questionId)) {
                    currentPassage = usingPassages.get(i);
                    currentPassageIndex = i;
                    break;
                }
            }
        }
    }

    private void checkFinished() {
        if (progress == usingQuestions.size()) {
            finished();
        }
    }

    private void finished() {
        setContentView(R.layout.activity_practice_mode_finish);
        finishScore = findViewById(R.id.PM_Score);
        gradePractice();
    }

    private void gradePractice() {
        int score = 0;
        for (readingQuestion curQuestion : usingQuestions) {
            if (curQuestion.getCorrectAnswer() == curQuestion.getOptionSelected()) {
                score++;
            }
        }
        finishScore.setText(score + "/" + usingQuestions.size());
    }

    private void defaultPassageView() {
        if (viewExpandedPassage) {
            viewExpandedPassage = false;
            findViewById(R.id.PMG_Question_ScrollView).setVisibility(View.VISIBLE);
            findViewById(R.id.PMG_Question).setVisibility(View.VISIBLE);
            findViewById(R.id.PMG_ViewNext).setVisibility(View.VISIBLE);
            findViewById(R.id.PMG_ViewBack).setVisibility(View.VISIBLE);

            ConstraintLayout parent = findViewById(R.id.PM_Parent);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(parent);

            constraintSet.constrainHeight(mainPassageView.getId(), 800);

            constraintSet.applyTo(parent);

            menu.getItem(menu.size() - 3).setTitle("Expand Passage");


        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();

        if (itemID == R.id.MENU_toggleExpandPassage) {

            if(!viewExpandedPassage) {
                viewExpandedPassage = true;
                findViewById(R.id.PMG_Question_ScrollView).setVisibility(View.GONE);
                findViewById(R.id.PMG_Question).setVisibility(View.GONE);
                findViewById(R.id.PMG_ViewNext).setVisibility(View.GONE);
                findViewById(R.id.PMG_ViewBack).setVisibility(View.GONE);

                ConstraintLayout parent = findViewById(R.id.PM_Parent);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(parent);

                constraintSet.constrainHeight(mainPassageView.getId(), ConstraintSet.MATCH_CONSTRAINT);

                constraintSet.applyTo(parent);

                menu.getItem(menu.size() - 3).setTitle("Minimize Passage"); //f

            } else {
                defaultPassageView();
            }


        } else if (itemID == R.id.nav_finish) {
            finished();

        } else if (itemID == R.id.nav_pause) {

        } else {
            currentQuestionIndex = itemID;
            currentQuestion = usingQuestions.get(itemID);
            generateQuestion();
            buildPracticeMode();

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}