package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.SettingsFragmentBinding
import com.example.todoapp.databinding.TasksListFragementBinding
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener

class TasksListFragemnt:Fragment() {

    lateinit var viewBinding: TasksListFragementBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = TasksListFragementBinding.inflate(inflater, container, false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews()


    }


    override fun onStart() {
        super.onStart()
        loadTasks()
    }

    fun loadTasks() {
        context?.let {
            val tasks = MyDataBase.getInstance(it)
                .tasksDao().getAllTasks()
            tasksAdpater.bindTask(tasks)

        }

    }

    val tasksAdpater = TasksAdapter(null)
    private fun initviews() {

        viewBinding.recyclerView.adapter = tasksAdpater


    }
}

