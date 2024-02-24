package com.example.bitcoinresponce

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}


class MyViewModelTest {
    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun getSuccessfulResponse() {
        val repository = mock(Repository::class.java)
        val viewModel = MyViewModel(repository)
        val eventList = mutableListOf<MyViewModel.UIState>()
        viewModel.uiState.observeForever {
            eventList.add(it)
        }
        runBlocking {
            `when`(repository.getCurrencyByName("bitcoin"))

        }

        viewModel.getData()

        assertEquals(MyViewModel.UIState.Empty, eventList[0])
        assertEquals(MyViewModel.UIState.Processing, eventList[1])

    }

}
