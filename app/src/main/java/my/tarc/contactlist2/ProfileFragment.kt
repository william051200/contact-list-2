package my.tarc.contactlist2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import my.tarc.contactlist2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.img.setImageURI(it)

    }

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_profile).isVisible = false
        menu.findItem(R.id.action_settings).isVisible = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.img.setOnClickListener {
            getContent.launch("image/*")
        }

        preferences = view.context.getSharedPreferences(PROFILE_PREFERENCE, Context.MODE_PRIVATE)
        val name = preferences.getString(PROFILE_NAME, "")
        binding.txtProfileName.setText(name)

        binding.btnInsta.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ig_url)))
            if (intent.resolveActivity(context?.packageManager!!) == null) {
                startActivity(intent)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        with(preferences.edit()) {
            val name = binding.txtProfileName.text.toString()
            putString(PROFILE_NAME, name)
            apply()
        }
    }

    companion object {
        const val PROFILE_NAME = "Name"
        const val PROFILE_PREFERENCE = "preference"
    }
}