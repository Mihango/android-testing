package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(manifest= Config.NONE)
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @Test
    fun addNewTask_setsNewTaskEvent() {
        // Given a fresh TaskViewModel
        val taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
        // When adding a new task
        taskViewModel.addNewTask()
        // Then the new task event is triggered
    }
}