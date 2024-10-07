package com.example.Zainab_Jaradat_1201766;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HangmanActivity extends AppCompatActivity {

    private String wordToGuess = "birzeit";
    private StringBuilder currentGuess;
    private int incorrectGuesses = 0;

    private TextView hangmanFigure;
    private TextView wordDisplay;
    private TextView progressDisplay;
    private EditText guessInput;
    private Button submitGuessButton;
    private Button restartButton;
    private String firstName;
    private String secondName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        getSupportActionBar().setTitle("Zainab Application 1201766");


        Intent intent = getIntent();
        firstName = intent.getStringExtra("FIRST_NAME");
        secondName = intent.getStringExtra("SECOND_NAME");
        String idNum = intent.getStringExtra("ID_NUM");

        TextView playerInfo = findViewById(R.id.playerInfo);
        playerInfo.setText(String.format("%s %s %s", firstName, secondName, idNum));

        hangmanFigure = findViewById(R.id.hangmanFigure);
        wordDisplay = findViewById(R.id.hangmanWord);
        progressDisplay = findViewById(R.id.progressTextView);
        guessInput = findViewById(R.id.guessEditText);
        submitGuessButton = findViewById(R.id.submitGuessButton);
        restartButton = findViewById(R.id.restartButton);

        currentGuess = new StringBuilder("-------");
        wordDisplay.setText(currentGuess.toString());

        submitGuessButton.setOnClickListener(v -> submitGuess());

        guessInput.setOnEditorActionListener((v, actionId, event) -> { // Set up the listener for the "Enter" on the guess input field
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                submitGuess();
                return true;
            }
            return false;
        });
        restartButton.setOnClickListener(v -> restartGame());
    }

    private void submitGuess() {
        String guess = guessInput.getText().toString().trim().toLowerCase();
        if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
            checkGuess(guess.charAt(0));
        } else if (!guess.isEmpty()) {
            Toast.makeText(HangmanActivity.this, "Please enter a single letter", Toast.LENGTH_SHORT).show();
        }
        guessInput.setText("");
    }

    private void checkGuess(char guess) {
        if (!Character.isLetter(guess)) {
            Toast.makeText(HangmanActivity.this, "Please enter a valid letter (a-z)", Toast.LENGTH_SHORT).show();
            return;
        }
        if (currentGuess.toString().contains(String.valueOf(guess))) { // if the letter already guessed
            Toast.makeText(HangmanActivity.this, "You already guessed this letter!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean correct = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentGuess.setCharAt(i, guess);
                correct = true;
            }
        }

        if (correct) {
            wordDisplay.setText(currentGuess.toString());
            if (currentGuess.toString().equals(wordToGuess)) {
                showEndGameDialog(true);
            }
        } else {
            incorrectGuesses++;
            updateHangmanFigure();
            progressDisplay.setText(String.format("Incorrect Guesses: %d/6", incorrectGuesses));
            if (incorrectGuesses == 6) {
                showEndGameDialog(false);
            }
        }
    }

    private void updateHangmanFigure() { // this function to insert parts of the figure when the player submits a wrong letter
        switch (incorrectGuesses) {
            case 1:
                hangmanFigure.setText("O");
                break;
            case 2:
                hangmanFigure.setText("O\n|");
                break;
            case 3:
                hangmanFigure.setText("O\n|\\");
                break;
            case 4:
                hangmanFigure.setText("O\n/|\\");
                break;
            case 5:
                hangmanFigure.setText("O\n/|\\\n/");
                break;
            case 6:
                hangmanFigure.setText("O\n/|\\\n/ \\");
                break;
        }
    }

    private void showEndGameDialog(boolean won) { // here I Inform the players when they win or lose the game
        String message;
        if (won) {
            message = String.format("Congratulations, %s %s! You won the game!", firstName, secondName);
        } else {
            message = String.format("Sorry, %s %s! You lost. The word was '%s'.", firstName, secondName, wordToGuess);
        }

        new AlertDialog.Builder(this).setTitle(won ? "You Won!" : "Game Over").setMessage(message).setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                restartGame();
            }
        }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    private void restartGame() { // here I allow the player to restart the game after winning or losing
        currentGuess = new StringBuilder("-------");
        incorrectGuesses = 0;
        hangmanFigure.setText("");
        wordDisplay.setText(currentGuess.toString());
        progressDisplay.setText("Incorrect Guesses: 0/6");
        guessInput.setText("");
    }
}
