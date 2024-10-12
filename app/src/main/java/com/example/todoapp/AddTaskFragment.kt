package com.example.todoapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter.ViewBinder
import com.example.todoapp.databinding.FragmentAddTaskBinding
import com.example.todoapp.model.Task
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Calendar

class AddTaskFragment:BottomSheetDialogFragment() {
    lateinit var viewBinding: FragmentAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.addTaskBut.setOnClickListener {
            createTask()
        }
        viewBinding.dateContiner.setOnClickListener {
            showDatePickerDialog()
        }
    }

    val calendar = Calendar.getInstance()
    private fun showDatePickerDialog() {

        context?.let {
            val dialog = DatePickerDialog(it)
            dialog.setOnDateSetListener { datePicker, day, month, year ->
                viewBinding.date.setText(
                    "$day-$month-$year"
                )
                calendar.set(year, month, day)
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.MILLISECOND, 0)


            }




            dialog.show()
        }

    }

    private fun Valid(): Boolean {
        var isValid = true
        if (viewBinding.title.text.toString().isNullOrBlank()) {
            viewBinding.titleContainer.error = "please inter title"
            isValid = false
        } else {
            viewBinding.titleContainer.error = null
        }

        if (viewBinding.description.text.toString().isNullOrBlank()) {
            viewBinding.desContainer.error = "please enter description"
            isValid = false
        } else {
            viewBinding.desContainer.error = null
        }

        if (viewBinding.date.text.toString().isNullOrBlank()) {

            viewBinding.dateContiner.error = "please enter date"
            isValid = false
        } else {
            viewBinding.dateContiner.error = null
        }


        return isValid
    }

    private fun createTask() {
        if (!Valid()) {
            return
        }
        val task = Task(
            title = viewBinding.title.text.toString(),
            description = viewBinding.description.text.toString(),
            dateTime = calendar.timeInMillis
        )
        MyDataBase.getInstance(requireContext())
            .tasksDao().insertTask(task)
        onTaskAddedListener?.onTaskAdded()
        dismiss()


    }

    var onTaskAddedListener:OnTaskAddedListener? = null
    fun interface OnTaskAddedListener {
        fun onTaskAdded()


    }

}


