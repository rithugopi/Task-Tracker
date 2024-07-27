package com.example.tasktracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment

class AddTaskDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_task_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinnerActivityType: Spinner = view.findViewById(R.id.spinner_activity_type)
        val editTextTaskName: EditText = view.findViewById(R.id.edittext_activity_name)
        val buttonAdd: Button = view.findViewById(R.id.button_add)

        val activityTypes = arrayOf("Work", "Personal","Fitness" ,"Studies","Hobbies","Social Life","Other")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, activityTypes)
        spinnerActivityType.adapter = adapter

        buttonAdd.setOnClickListener {
            val taskName = editTextTaskName.text.toString()
            val activityType = spinnerActivityType.selectedItem.toString()

            if (taskName.isNotEmpty()) {
                val newTask = "$activityType: $taskName"
                (activity as? MainActivity)?.supportFragmentManager?.findFragmentById(R.id.fragment_container)
                    ?.let {
                        if (it is TaskListFragment) {
                            it.addTask(newTask)
                        }
                    }
                dismiss()
            }
        }
    }
}
