package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.todoapp.databinding.SettingsFragmentBinding

class SettingsFragment:Fragment() {
    lateinit var viewBinding: SettingsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = SettingsFragmentBinding.inflate(inflater,container,false)
        return viewBinding.root

    }

}