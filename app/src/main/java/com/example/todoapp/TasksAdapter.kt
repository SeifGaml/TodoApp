package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTaskBinding
import com.example.todoapp.model.Task

class TasksAdapter(var tasks:List<Task>?): RecyclerView.Adapter<TasksAdapter.ViewHolder>(){
    var onItemClicked:OnItemClicked? = null

    class ViewHolder(val itemBinding:ItemTaskBinding):RecyclerView.ViewHolder(itemBinding.root){
        fun bind(task: Task){
            itemBinding.title.text =task.title
            itemBinding.description.text=task.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = tasks?.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(tasks!![position])


    }

    fun bindTask(tasks: List<Task>) {
        this.tasks =tasks
        notifyDataSetChanged()

    }
}
interface OnItemClicked{
    fun onItemClick(task: Task)
}