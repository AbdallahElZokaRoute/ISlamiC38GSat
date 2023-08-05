package com.route.islamiappc38gsat.islamiProject.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.islamiProject.HadethDetailsActivity
import com.route.islamiappc38gsat.islamiProject.adapter.HadethAdapter
import com.route.islamiappc38gsat.islamiProject.adapter.OnHadethItemClickListener
import com.route.islamiappc38gsat.islamiProject.data.Hadeth

class HadethFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadethAdapter
    lateinit var hadethList: MutableList<Hadeth>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.hadeth_recycler_view)
        adapter = HadethAdapter(null)
        readFileContents()
        adapter.onHadethItemClickListener = object : OnHadethItemClickListener {
            override fun onHadethClick(hadeth: Hadeth) {
                val intent = Intent(requireActivity(), HadethDetailsActivity::class.java)
                intent.putExtra("hadeth_content", hadeth.hadethContent)
                startActivity(intent)
            }

        }
        recyclerView.adapter = adapter
    }

    private fun readFileContents() {
        hadethList = mutableListOf()
        val fileContent =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadeth = fileContent.trim().split("#")
        hadeth.forEachIndexed { index, hadethContent ->
            val singleHadeth = hadethContent.trim().split("\n")
            val hadethObject = Hadeth(index + 1, singleHadeth.get(0), hadethContent)
            hadethList.add(hadethObject)
        }
        adapter.updateData(hadethList)
    }

}