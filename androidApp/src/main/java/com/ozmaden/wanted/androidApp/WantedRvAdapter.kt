package com.ozmaden.wanted.androidApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozmaden.wanted.kmm.shared.entity.WantedPerson

class WantedRvAdapter(var people: List<WantedPerson>) :
    RecyclerView.Adapter<WantedRvAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
            .run(::LaunchViewHolder)
    }

    override fun getItemCount(): Int = people.count()

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(people[position])
    }

    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView = itemView.findViewById<TextView>(R.id.name)
        private val aliasesTextView = itemView.findViewById<TextView>(R.id.aliases)
        private val nationalityTextView = itemView.findViewById<TextView>(R.id.nationality)
        private val raceTextView = itemView.findViewById<TextView>(R.id.race)
        private val hairTextView = itemView.findViewById<TextView>(R.id.hair)
        private val heightTextView = itemView.findViewById<TextView>(R.id.height)
        private val eyesTextView = itemView.findViewById<TextView>(R.id.eyes)
        private val complexionTextView = itemView.findViewById<TextView>(R.id.complexion)
        private val dateOfBirthTextView = itemView.findViewById<TextView>(R.id.date_of_birth)
        private val placeOfBirthTextView = itemView.findViewById<TextView>(R.id.place_of_birth)
        private val languagesTextView = itemView.findViewById<TextView>(R.id.languages)
        private val possibleCountriesTextView =
            itemView.findViewById<TextView>(R.id.possible_countries)
        private val descriptionTextView = itemView.findViewById<TextView>(R.id.description)
        private val remarksTextView = itemView.findViewById<TextView>(R.id.remarks)
        private val cautionTextView = itemView.findViewById<TextView>(R.id.caution)
        private val warningMessageTextView = itemView.findViewById<TextView>(R.id.warning_message)

        fun bindData(person: WantedPerson) {
            val ctx = itemView.context

            nameTextView.text = "Name: {person.name}"
            aliasesTextView.text = "Aliases: {person.aliases}"
            nationalityTextView.text = "Nationality: {person.nationality}"
            raceTextView.text = "Race: {person.race}"
            hairTextView.text = "hair: {person.hair}"
            heightTextView.text = "Height: {person.height}"
            eyesTextView.text = "Eyes: {person.eyes}"
            complexionTextView.text = "Complexion: {person.complexion}"
            dateOfBirthTextView.text = "Date Of Birth: {person.date_of_birth}"
            placeOfBirthTextView.text = "Place Of Birth: {person.place_of_birth}"
            languagesTextView.text = "Languages: {person.languages}"
            possibleCountriesTextView.text = "Possible Countries: {person.possible_countries}"
            descriptionTextView.text = "Description: {person.description}"
            remarksTextView.text = "Remarks: {person.remarks}"
            cautionTextView.text = "Caution: {person.caution}"
            warningMessageTextView.text = "Warning: {person.warning_message}"
        }
    }
}