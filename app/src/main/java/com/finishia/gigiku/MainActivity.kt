package com.finishia.gigiku

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvGigies: RecyclerView
    private var list: ArrayList<Gigi> = arrayListOf()
    private var title: String = "Kesehatan Gigi & Mulut"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvGigies = findViewById(R.id.rv_gigies)
        rvGigies.setHasFixedSize(true)

        list.addAll(GigiesData.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showRecyclerList() {
        rvGigies.layoutManager = LinearLayoutManager(this)
        val listGigiAdapter = ListGigiAdapter(list)
        rvGigies.adapter = listGigiAdapter
        listGigiAdapter.setOnItemClickCallback(object : ListGigiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Gigi) {
                val detailIntent = Intent(this@MainActivity, DetailsGigi::class.java).apply {
                    putExtra(DetailsGigi.EXTRA_KATEGORI, data.kategori)
                    putExtra(DetailsGigi.EXTRA_DETAIL, data.detail)
                    putExtra(DetailsGigi.EXTRA_IMAGE, data.photo)
                }
                showSelectedGigi(data)
                startActivity(detailIntent)
            }

        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {

            R.id.action_about -> {
                val movetoAbout = Intent(this@MainActivity, About::class.java)
                startActivity(movetoAbout)

            }

        }
        setActionBarTitle(title)
    }
    private fun showSelectedGigi (gigi: Gigi){
        Toast.makeText(this, "Kamu memilih " + gigi.kategori, Toast.LENGTH_SHORT).show()
    }
}



