package com.route.islamiappc38gsat.islamiProject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.islamiProject.adapter.VersesAdapter

class SuraDetailsActivity : AppCompatActivity() {
    var suraName: String? = null
    var suraPosition: Int? = null
    lateinit var suraTitleText: TextView
    lateinit var backIcon: ImageView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        initViews()
    }

    private fun initViews() {
        suraName = intent.getStringExtra("sura_name")
        suraPosition = intent.getIntExtra("sura_position", 1)
        suraTitleText = findViewById(R.id.sura_title_text)
        backIcon = findViewById(R.id.back_icon)
        suraTitleText.text = suraName
        backIcon.setOnClickListener {
            finish()
        }
        recyclerView = findViewById(R.id.verses_recycler_view)
        adapter = VersesAdapter(null)
        readVersesFromAssets()
        recyclerView.adapter = adapter
    }

    private fun readVersesFromAssets() {
        val fileContent = assets.open("$suraPosition.txt").bufferedReader().use { it.readText() }
        val data = fileContent.trim().split("\n")
        adapter.updateData(data)
    }

}