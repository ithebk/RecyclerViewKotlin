package com.ithebk.recyclerviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerViewCustomAdapter(private val dataSets: Array<String>, private val callBack: ClickCallback) :
    RecyclerView.Adapter<RecyclerViewCustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewCustomAdapter.CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view, parent, false)
        )
    }

    //Return view holder size
    override fun getItemCount() = dataSets.size;

    override fun onBindViewHolder(viewHolder: RecyclerViewCustomAdapter.CustomViewHolder, position: Int) {
        viewHolder.itemView.textView.text = dataSets[position];
        viewHolder.itemView.setOnClickListener {
            callBack.onClick(position, dataSets[position])
        }
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}