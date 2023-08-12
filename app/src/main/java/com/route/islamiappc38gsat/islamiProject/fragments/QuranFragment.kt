package com.route.islamiappc38gsat.islamiProject.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.islamiProject.SuraDetailsActivity
import com.route.islamiappc38gsat.islamiProject.adapter.OnSuraItemClickListener
import com.route.islamiappc38gsat.islamiProject.adapter.SuraNamesAdapter
import com.route.islamiappc38gsat.islamiProject.data.Constants
import com.route.islamiappc38gsat.islamiProject.data.SuraName

class QuranFragment : Fragment() {


    lateinit var quranRecyclerView: RecyclerView
    lateinit var suraNamesAdapter: SuraNamesAdapter
    lateinit var switchModeButton: Button
    lateinit var sharedPreferences: SharedPreferences
    var isDarkMode: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView = view.findViewById(R.id.sura_names_recycler_view)
        suraNamesAdapter = SuraNamesAdapter(Constants.arSuras.mapIndexed { position, name ->
            SuraName(name, position + 1)
        })
        suraNamesAdapter.onSuraItemClickListener = object : OnSuraItemClickListener {
            override fun onSuraClick(suraName: SuraName) {
                val intent = Intent(requireActivity(), SuraDetailsActivity::class.java)
                intent.putExtra("sura_name", suraName.name)
                intent.putExtra("sura_position", suraName.positionOfSura)
                startActivity(intent)
            }

        }

        // File -> Key - Value Pairs

        quranRecyclerView.adapter = suraNamesAdapter
        switchModeButton = view.findViewById(R.id.switch_mode_button)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            switchModeButton.text = "Light Mode"
        } else {
            switchModeButton.text = "Dark Mode"
        }
        switchModeButton.setOnClickListener {
            if (switchModeButton.text == "Dark Mode") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                putModeInSharedPreference(AppCompatDelegate.MODE_NIGHT_YES)
            } else if (switchModeButton.text == "Light Mode") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                putModeInSharedPreference(AppCompatDelegate.MODE_NIGHT_NO)
            }


        }
    }

    private fun putModeInSharedPreference(mode: Int) {
        sharedPreferences =
            requireContext().getSharedPreferences(
                Constants.ISLAMI_SHARED_PREFERENCE,
                Context.MODE_PRIVATE
            )
        val editor = sharedPreferences.edit()
        editor.putInt(Constants.ISLAMI_MODE_KEY, mode)
        editor.apply()
    }

}