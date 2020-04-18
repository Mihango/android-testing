package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsKtTest {
    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        val statsResult = getActiveAndCompletedStats(emptyList())
        assertThat(statsResult.activeTasksPercent, `is`(0f))
        assertThat(statsResult.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        val statsResult = getActiveAndCompletedStats(getCompletedTasks())
        assertThat(statsResult.activeTasksPercent, `is`(0f))
        assertThat(statsResult.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        val statsResult = getActiveAndCompletedStats(null)
        assertThat(statsResult.activeTasksPercent, `is`(0f))
        assertThat(statsResult.completedTasksPercent, `is`(0f))

    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHudredZero() {
        val statsResult = getActiveAndCompletedStats(getActiveTasks())
        assertThat(statsResult.activeTasksPercent, `is`(100f))
        assertThat(statsResult.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnFortySixty() {
        val statsResult = getActiveAndCompletedStats(getActiveAndCompleted())
        assertThat(statsResult.activeTasksPercent, `is`(40f))
        assertThat(statsResult.completedTasksPercent, `is`(60f))
    }


    private fun getCompletedTasks() = listOf(Task(isCompleted = true))

    private fun getActiveTasks() = listOf(Task())

    private fun getActiveAndCompleted() = listOf(
            Task(isCompleted = true), Task(isCompleted = true), Task(isCompleted = true),
            Task(), Task()
    )
}