package com.example.hard_mad_2.components.library_screen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.RecyclerView
import com.example.hard_mad_2.adapter.CarouselAdapter
import com.example.hard_mad_2.data_stub.Data
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy

@Composable
fun LatestCarousel() {
    val context = LocalContext.current
    val carouselManager = CarouselLayoutManager()
    val snapHelper = CarouselSnapHelper()

    carouselManager.setCarouselStrategy(HeroCarouselStrategy())
    carouselManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
    AndroidView(
        modifier = Modifier
            .fillMaxHeight(0.287f)
            .fillMaxWidth(),
        factory = {
            RecyclerView(context).apply {
                adapter =
                    CarouselAdapter(Data.carouselList)
                layoutManager = carouselManager
                snapHelper.attachToRecyclerView(this)
                (layoutManager as CarouselLayoutManager).scrollToPosition(Data.carouselList.size / 2)
            }
        }
    )
}