package com.finishia.gigiku

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.finishia.gigiku.ListGigiAdapter.*
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_gigi.view.*

class ListGigiAdapter(private val listGigi:ArrayList<Gigi>): RecyclerView.Adapter<ListGigiAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback (onItemClickCallback : OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(product: Gigi) {
            with(itemView) {
                tv_item_kategori.text = product.kategori
                tv_item_detail.text = product.detail
                Glide.with(this)
                    .load(product.photo)
                    .into(img_item_photo)
            }
        }
        var tvKategori:TextView = itemView.findViewById(R.id.tv_item_kategori)
        var tvDetail:TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto:ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view:View= LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_gigi, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGigi.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listGigi[position])
        holder.itemView.setOnClickListener(){
            onItemClickCallback.onItemClicked(listGigi[holder.adapterPosition])
        }
        val gigi = listGigi[position]

        Glide.with(holder.itemView.context)
            .load(gigi.photo)
            .apply(RequestOptions().override(60,60))
            .into(holder.imgPhoto)

        holder.tvKategori.text=gigi.kategori
        holder.tvDetail.text = gigi.detail
        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listGigi[holder.adapterPosition])}

    }

    interface OnItemClickCallback {
        fun onItemClicked(data:Gigi)
    }

}