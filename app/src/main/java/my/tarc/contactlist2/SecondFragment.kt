package my.tarc.contactlist2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import my.tarc.contactlist2.MainActivity.Companion.contactList
import my.tarc.contactlist2.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.btnSave.setOnClickListener {

        }

        setHasOptionsMenu(true)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            if (binding.txtName.text.isEmpty()) {
                binding.txtName.error = "Value required"
                return@setOnClickListener
            }

            if (binding.txtPhone.text.isEmpty()) {
                binding.txtPhone.error = "Value requried"
                return@setOnClickListener
            }

            contactList.add(
                Contact(
                    binding.txtName.text.toString(),
                    binding.txtPhone.text.toString()
                )
            )

            Snackbar.make(view, "Record Save", Snackbar.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}