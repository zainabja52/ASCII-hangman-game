# 🎉 ASCII Hangman Game Application 🎉

## Overview
This is an Android application for a Hangman game. The game allows users to guess letters to figure out a hidden word, with a maximum of six incorrect guesses allowed before the game is lost.

## Features
- **📝 User Registration**: Collects first name, last name, and student ID.
- **🕹️ Game Logic**: Implements the classic Hangman game with a predefined word ("birzeit").
- **📱 User Interface**: Displays the Hangman figure, the word with guessed letters, and the number of incorrect guesses.
- **🏆 End Game Dialog**: Informs the player if they have won or lost, with options to restart or exit the game.

### Programming Languages and Tools:

<img align="left" alt="Java" width="50px" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" />
<img align="left" alt="Android Studio" width="50px" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/androidstudio/androidstudio-original.svg" />
<img align="left" alt="XML" width="50px" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/xml/xml-original.svg" />
<br><br>

## 📹 Demo Video


https://github.com/user-attachments/assets/d62b6c58-ce11-4d71-8be2-8a61f9ab5572



## 🚀 Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/zainabja52/ASCII-hangman-game.git
    ```
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.

## 📖 Usage
1. **Main Activity**:
    - Enter your first name, last name, and student ID.
    - Click the "Login" button to start the game.
2. **Hangman Activity**:
    - Enter a letter in the input field and click "Submit" or press "Enter".
    - The game will update the display based on your guess.
    - If you guess the word correctly, you win. If you make six incorrect guesses, you lose.
    - Use the "Restart" button to play again.

## 🗂️ Code Structure
- **MainActivity.java**: Handles user registration and navigation to the Hangman game.
- **HangmanActivity.java**: Contains the game logic and UI updates.
- **activity_main.xml**: Layout for the main activity.
- **activity_hangman.xml**: Layout for the Hangman game activity.


