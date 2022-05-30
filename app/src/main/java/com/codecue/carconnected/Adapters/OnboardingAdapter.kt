package com.codecue.carconnected.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codecue.carconnected.R
import com.codecue.carconnected.models.onboarding_model

class OnboardingAdapter(private val onboardingitem:List<onboarding_model>):
    RecyclerView.Adapter<OnboardingAdapter.OnboardingItemViewholder>() {

    inner class OnboardingItemViewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageview = view.findViewById<ImageView>(R.id.onboardingpicture)
        private val title = view.findViewById<TextView>(R.id.onboardingTv_1)
        private val desciription = view.findViewById<TextView>(R.id.onboardingtv_2)
        fun bind(onboardingItem: onboarding_model) {

            imageview.setImageResource(onboardingItem.onboardingimage)
            desciription.text = onboardingItem.descriptoin
            title.text = onboardingItem.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewholder {
        return OnboardingItemViewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout
                    .onboarding_design_laoyout, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewholder, position: Int) {
        holder.bind(onboardingitem[position])
    }

    override fun getItemCount(): Int {
        return onboardingitem.size
    }
}

