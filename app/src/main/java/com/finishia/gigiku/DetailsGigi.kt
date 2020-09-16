package com.finishia.gigiku

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.details_gigi.*
import kotlinx.android.synthetic.main.details_gigi.view.*
import kotlinx.android.synthetic.main.details_gigi.view.img_item_photo
import kotlinx.android.synthetic.main.item_row_gigi.*
import kotlinx.android.synthetic.main.item_row_gigi.img_item_photo
import kotlinx.android.synthetic.main.item_row_gigi.view.*

class DetailsGigi: AppCompatActivity () {
    private var title: String = "Halaman Detail"

    companion object{
        const val EXTRA_KATEGORI="extra_kategori"
        const val EXTRA_DETAIL="extra_detail"
        const val EXTRA_IMAGE="extra_img_item_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_gigi)
        setActionBarTitle(title)

        supportActionBar!!.title = "Halaman Detail"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val tvKategori:TextView = findViewById(R.id.tv_item_kategori)
        val tvDetail:TextView = findViewById(R.id.tv_item_detail)
        val imgPhoto:ImageView = findViewById(R.id.img_item_photo)

        val tKategori = intent.getStringExtra(EXTRA_KATEGORI)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tPhoto = intent.getIntExtra(EXTRA_IMAGE, 0)

        tvKategori.text = tKategori

        Glide.with(this)
            .load(tPhoto)
            .apply(RequestOptions())
            .into(imgPhoto)

        tvDetail.text = tDetail


    }

    private fun setActionBarTitle (title: String){
        supportActionBar?.title = title

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }




    private fun setMode(selectedMode: Int){
        when (selectedMode){
            R.id.action_share->{

            }
            R.id.action_favorit->{

            }
        }
    }


}