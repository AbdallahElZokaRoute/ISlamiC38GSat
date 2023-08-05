package com.route.islamiappc38gsat.islamiProject

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.islamiProject.adapter.VersesAdapter

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var backIcon: ImageView
    var hadethContent: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        initViews()
    }

    private fun initViews() {
//        suraName = intent.getStringExtra("sura_name")
//        suraPosition = intent.getIntExtra("sura_position", 1)
//        suraTitleText = findViewById(R.id.sura_title_text)
        hadethContent = intent.getStringExtra("hadeth_content")
        backIcon = findViewById(R.id.back_icon)
//        suraTitleText.text = suraName
        backIcon.setOnClickListener {
            finish()
        }
        recyclerView = findViewById(R.id.hadeth_recycler_view)
        adapter = VersesAdapter(null)
        adapter.updateData(hadethContent?.split("\n"))
        recyclerView.adapter = adapter
    }

}