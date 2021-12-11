package com.dep.tugasdaspro.feature.teori.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dep.tugasdaspro.databinding.ItemsTeoriBinding
import com.dep.tugasdaspro.feature.decision.Decission
import com.dep.tugasdaspro.feature.looping.Looping
import java.util.*
import kotlin.collections.ArrayList

class TeoriAdapter : RecyclerView.Adapter<TeoriAdapter.ViewHolder>() {

    private val mData = ArrayList<String>()
    lateinit var mAct: Activity
    lateinit var mCtx: Context

    fun setData(mAct: Activity, items: ArrayList<String>) {
        this.mAct = mAct
        mData.clear()
        mCtx = mAct.applicationContext
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeoriAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TeoriAdapter.ViewHolder, position: Int) {
        holder.bind(mData[position],mAct)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder private constructor(private val binding: ItemsTeoriBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mData: String, mAct: Activity) {
            lateinit var intent: Intent

            binding.name.setOnClickListener {
                if (mData.lowercase(Locale.getDefault()) == "percabangan") {
                    intent = Intent(mAct, Decission::class.java)
                } else if (mData=="looping") {
                    intent = Intent(mAct, Looping::class.java)
                }
                mAct.startActivity(intent)
            }
            binding.itemTitle = mData.uppercase(Locale.getDefault())

            // make sure to include this so your view will be updated
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemsTeoriBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}