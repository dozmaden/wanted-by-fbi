package com.ozmaden.wantedbyfbi.android

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.compose.ui.platform.ComposeView
import coil.load
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

class WantedRvAdapter(var people: List<WantedPerson>) :
    RecyclerView.Adapter<WantedRvAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wanted, parent, false)
            .run(::LaunchViewHolder)
    }

    override fun getItemCount(): Int = people.count()

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(people[position])
    }

    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val thumbImageView = itemView.findViewById<ImageView>(R.id.image)
        private val nameTextView = itemView.findViewById<TextView>(R.id.name)
        private val descriptionTextView = itemView.findViewById<TextView>(R.id.description)
        private val dateOfBirthTextView = itemView.findViewById<TextView>(R.id.date_of_birth)
        private val placeOfBirthTextView = itemView.findViewById<TextView>(R.id.place_of_birth)
        private val hairTextView = itemView.findViewById<TextView>(R.id.hair)
        private val eyesTextView = itemView.findViewById<TextView>(R.id.eyes)
        private val heightTextView = itemView.findViewById<TextView>(R.id.height)
        private val weightTextView = itemView.findViewById<TextView>(R.id.weight)
        private val sexTextView = itemView.findViewById<TextView>(R.id.sex)
        private val raceTextView = itemView.findViewById<TextView>(R.id.race)
        private val nationalityTextView = itemView.findViewById<TextView>(R.id.nationality)
        private val complexionTextView = itemView.findViewById<TextView>(R.id.complexion)
        private val scarsAndMarksTextView = itemView.findViewById<TextView>(R.id.scars_and_marks)
        private val rewardTextView = itemView.findViewById<TextView>(R.id.reward)
        private val detailsTextView = itemView.findViewById<TextView>(R.id.details)
        private val remarksTextView = itemView.findViewById<TextView>(R.id.remarks)
        private val cautionTextView = itemView.findViewById<TextView>(R.id.caution)
        private val warningTextView = itemView.findViewById<TextView>(R.id.warning)

        private val textviews = listOf(
            nameTextView,
            descriptionTextView,
            dateOfBirthTextView,
            placeOfBirthTextView,
            hairTextView,
            eyesTextView,
            heightTextView,
            weightTextView,
            sexTextView,
            raceTextView,
            nationalityTextView,
            complexionTextView,
            scarsAndMarksTextView,
            rewardTextView,
            detailsTextView,
            remarksTextView,
            cautionTextView,
            warningTextView
        )

        fun bindData(person: WantedPerson) {
            val ctx = itemView.context

            val imageUrl = person.image[0].large
            thumbImageView.load(imageUrl)

            nameTextView.text = ctx.getString(R.string.name_field, person.name)
            descriptionTextView.text = ctx.getString(R.string.description_field, person.description)
            placeOfBirthTextView.text =
                ctx.getString(R.string.place_of_birth_field, person.place_of_birth)
            dateOfBirthTextView.text =
                ctx.getString(R.string.date_of_birth_field, person.date_of_birth)
            hairTextView.text = ctx.getString(R.string.hair_field, person.hair)
            eyesTextView.text = ctx.getString(R.string.eyes_field, person.eyes)
            heightTextView.text = ctx.getString(R.string.height_field, person.height)
            weightTextView.text = ctx.getString(R.string.weight_field, person.weight)
            sexTextView.text = ctx.getString(R.string.sex_field, person.sex)
            raceTextView.text = ctx.getString(R.string.race_field, person.race)
            nationalityTextView.text = ctx.getString(R.string.nationality_field, person.nationality)
            complexionTextView.text = ctx.getString(R.string.complexion_field, person.complexion)
            scarsAndMarksTextView.text =
                ctx.getString(R.string.scars_and_marks_field, person.scars_and_marks)
            rewardTextView.text = ctx.getString(R.string.reward_field, person.reward)
            detailsTextView.text = ctx.getString(
                R.string.details_field,
                person.details?.replace("<p>", "")?.replace("</p>", "")
            )
            remarksTextView.text =
                ctx.getString(R.string.remarks_field, person.remarks?.replace("<p>", "")?.replace("</p>", ""))
            cautionTextView.text = ctx.getString(R.string.caution_field, person.caution?.replace("<p>", "")?.replace("</p>", ""))
            warningTextView.text = ctx.getString(R.string.warning_field, person.warning)

            for (text in textviews) {
                hideIfNull(text)
            }
        }

        private fun hideIfNull(textview: TextView) {
            if (textview.text.contains("null") || textview.text.isEmpty()
                || textview.text == " ") {
                textview.isVisible = false
            }
        }
    }
}