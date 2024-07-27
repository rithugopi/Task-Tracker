package com.example.tasktracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class TaskListFragment : Fragment() {

    private val tasks = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listViewTasks: ListView = view.findViewById(R.id.listView_tasks)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, tasks)
        listViewTasks.adapter = adapter
        listViewTasks.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    }

    fun addTask(task: String) {
        tasks.add(task)
        (view?.findViewById<ListView>(R.id.listView_tasks)?.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }
}
