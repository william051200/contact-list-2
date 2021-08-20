package my.tarc.contactlist2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import my.tarc.contactlist2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var counter: Int = 0

    private val counterViewModal: CounterViewModal by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtCounter.text = counterViewModal._counter.toString()

        binding.btnDecrement.setOnClickListener {
            counterViewModal.decrement()
            binding.txtCounter.text = counterViewModal._counter.toString()
        }

        binding.btnIncrement.setOnClickListener {
            counterViewModal.increment()
            binding.txtCounter.text = counterViewModal._counter.toString()
        }

//        binding.txtCounter.text = counter.toString()

//        binding.btnDecrement.setOnClickListener {
//            counter -= 1
//            binding.txtCounter.text = counter.toString()
//        }
//
//        binding.btnIncrement.setOnClickListener {
//            counter += 1
//            binding.txtCounter.text = counter.toString()
//        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}