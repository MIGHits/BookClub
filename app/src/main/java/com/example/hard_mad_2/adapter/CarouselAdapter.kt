package com.example.hard_mad_2.adapter

import android.graphics.RectF
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.util.lerp
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hard_mad_2.databinding.CarouselItemBinding
import com.example.hard_mad_2.models.CarouselItem
import com.google.android.material.shape.ShapeAppearanceModel


class CarouselAdapter(
    private val itemList: List<CarouselItem>
) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {


    class CarouselViewHolder(val binding: CarouselItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CarouselItemBinding.inflate(inflater, parent, false)
        return CarouselViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.binding.apply {
            itemContainer.shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(24f)
            val carouselMaskRect = itemContainer.maskRectF


            itemContainer.maskRectF = carouselMaskRect
            itemContainer.invalidate()

            Glide.with(itemImage.context).load(currentItem.img).into(itemImage)
            bookName.text = currentItem.name
            bookMoto.text = currentItem.slogan
            itemContainer.setOnMaskChangedListener { maskRect ->
                bookMoto.alpha = lerp(1F, 0F, maskRect.left)
                bookName.alpha = lerp(1F, 0F, maskRect.left)
            }
        }
    }
}
