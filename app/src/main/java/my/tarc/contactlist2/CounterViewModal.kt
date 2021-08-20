package my.tarc.contactlist2

import android.util.Log
import androidx.lifecycle.ViewModel

class CounterViewModal : ViewModel() {
    var _counter: Int = 0

    init {
        _counter
        Log.d("ViewModel", "initialize")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ViewModel", "Cleared")
    }

    fun increment() {
        _counter++
    }

    fun decrement() {
        _counter--
    }
}