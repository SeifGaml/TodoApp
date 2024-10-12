package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todoapp.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
lateinit var viewBinding:ActivityHomeBinding
var TasksListFramentRef:TasksListFragemnt?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.bottomNavigationView
            .setOnItemSelectedListener {
                when(it.itemId){
                    R.id.navigation_list->{
                        TasksListFramentRef =TasksListFragemnt()
                        showFragment(TasksListFramentRef!!)

                    }
                    R.id.navigation_settings->{
                        showFragment(SettingsFragment())

                    }
                }


                return@setOnItemSelectedListener true
            }
        viewBinding.addTodoBut.setOnClickListener {
            showAddTaskBottomSheet()
        }
        viewBinding.bottomNavigationView.selectedItemId= R.id.navigation_list



    }

    private fun showAddTaskBottomSheet() {
        val addTaskSheet = AddTaskFragment()
        addTaskSheet.onTaskAddedListener =AddTaskFragment.OnTaskAddedListener {
            Snackbar.make(viewBinding.root,"task added successfully",Snackbar.LENGTH_LONG).show()
            TasksListFramentRef?.loadTasks()
        }
        addTaskSheet.show(supportFragmentManager,"")
    }

    private fun showFragment(fragemnt: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragemnt)
            .commit()


    }


}