package com.route.islamiappc38gsat.islamiProject.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        quranRecyclerView.adapter = suraNamesAdapter
    }

}