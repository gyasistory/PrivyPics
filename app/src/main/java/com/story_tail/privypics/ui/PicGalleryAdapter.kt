package com.story_tail.privypics.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.story_tail.privypics.databinding.GalleryItemLayoutBinding
import com.story_tail.privypics.model.Image

class PicGalleryAdapter : RecyclerView.Adapter<PicGalleryAdapter.PicGalleryViewHolder>() {
    private var images: List<Image?> = arrayListOf()

    fun setPics(pics: List<Image>) {
        images = pics
    }

    override fun onBindViewHolder(holder: PicGalleryViewHolder, position: Int) {
        holder.binding.image = images[position]
    }

    override fun getItemCount(): Int {
        return images.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicGalleryViewHolder {
        val binding =
            GalleryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PicGalleryViewHolder(binding)
    }

    class PicGalleryViewHolder(val binding: GalleryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}