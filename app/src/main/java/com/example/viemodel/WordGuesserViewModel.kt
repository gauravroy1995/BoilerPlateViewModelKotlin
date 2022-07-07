package com.example.viemodel

import androidx.lifecycle.ViewModel

class WordGuesserViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val wordsList: List<String> =
        listOf("gaurav", "pranay", "sushreeta", "chinmay", "varun", "vishali");

    private var currentWord = "";
    private var currentScrambledWord = "";
    private var userGuessedWords: MutableList<String> = mutableListOf();
    private var score: Int = 0;

    val _currentScrambledWord: String
        get() = currentScrambledWord

    val _currentWord: String
        get() = currentWord

    val _score: Int
        get() = score

    init {
        initializeWord()
    }


    fun initializeWord() {
        val hasUserAlreadyGuessed = userGuessedWords.size > 0;
    if(!hasUserAlreadyGuessed){
        val randomWord = wordsList.random();
        val tempWord = randomWord.toCharArray();
        tempWord.shuffle()
        currentScrambledWord = String(tempWord);
        userGuessedWords.add(randomWord);
        currentWord = randomWord;
    }
    }

    fun isWordCorrect(playerWord:String): Boolean {
        if(playerWord == currentWord ){
            ++score;
            getNextWord()
            return true
        } else{
            return false
        }
    }

    private fun getNextWord(){
        if(userGuessedWords.size != wordsList.size){
            val randomWord = wordsList.random();
            if(userGuessedWords.contains(randomWord)){
                return getNextWord()
            }
            val tempWord = randomWord.toCharArray();
            tempWord.shuffle()
            currentScrambledWord = String(tempWord);
            userGuessedWords.add(randomWord);
            currentWord = randomWord;
        } else{

        }

    }





    fun showWords() {
        val randomWord = wordsList.random();
        val tempWord = randomWord.toCharArray();
        tempWord.shuffle()
        currentScrambledWord = String(tempWord);
    }
}