package com.example.viemodel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.viemodel.databinding.FragmentWordGuesserBinding

class WordGuesser : Fragment() {

    companion object {
        fun newInstance() = WordGuesser()
    }

    private  val viewModel: WordGuesserViewModel by viewModels()

    private lateinit var binding: FragmentWordGuesserBinding;




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWordGuesserBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(WordGuesserViewModel::class.java)
        viewModel.initializeWord()
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showWordButton.setOnClickListener { onSubmit() }
       onInit()

    }

    fun onSubmit(){
        val userInputAnswer = binding.fragTextInp.text.toString().lowercase();
       val isAnswerRight:Boolean =  viewModel.isWordCorrect(userInputAnswer)
        if(isAnswerRight){
            binding.showWordNameFragment.setText(viewModel._currentScrambledWord)
            binding.showScore.setText(viewModel._score.toString())
            binding.fragTextInp.setText("");
        }else{
            Toast.makeText(context,"Sorry wrong answer",Toast.LENGTH_LONG).show()
        }
    }

    fun onInit(){
        binding.showWordNameFragment.setText(viewModel._currentScrambledWord)
        binding.showScore.setText(viewModel._score.toString())
    }

}