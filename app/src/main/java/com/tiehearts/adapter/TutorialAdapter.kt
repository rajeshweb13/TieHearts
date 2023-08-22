package com.tiehearts.adapter

import android.content.Context
import android.content.res.TypedArray
import android.graphics.LinearGradient
import android.graphics.Shader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.tiehearts.R

class TutorialAdapter(val images: TypedArray, val listHeader: Array<String>, val listDesc: Array<String>, val context:Context) : RecyclerView.Adapter<TutorialAdapter.TutorialAdapterHolder>() {

    inner class TutorialAdapterHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {
        var imageIv = itemview.findViewById<AppCompatImageView>(R.id.imageView)
        var headerTv = itemview.findViewById<AppCompatTextView>(R.id.textHeader)
        var descTv = itemview.findViewById<AppCompatTextView>(R.id.textDescript)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialAdapterHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.tuturial_item, parent, false)
        return TutorialAdapterHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeader.size
    }

    override fun onBindViewHolder(holder: TutorialAdapterHolder, position: Int) {

        var image = images.getResourceId(position,-1)
        var header = listHeader[position]
        var  desc = listDesc[position]

        val textShader: Shader = LinearGradient(
            0f, holder.headerTv.paint.measureText(holder.headerTv.text.toString()), 0f, 0f, intArrayOf(
                context.resources.getColor(R.color.blue), context.resources.getColor(R.color.pink)
            ), floatArrayOf(0f, 1f), Shader.TileMode.CLAMP
        )

        holder.imageIv.setImageResource(image)
        holder.headerTv.text = header
        holder.headerTv.paint.shader = textShader
        holder.descTv.text = desc

    }
}