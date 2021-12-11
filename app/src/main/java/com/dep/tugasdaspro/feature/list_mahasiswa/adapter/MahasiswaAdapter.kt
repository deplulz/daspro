package com.dep.tugasdaspro.feature.list_mahasiswa.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dep.tugasdaspro.databinding.ItemsTeoriBinding
import com.dep.tugasdaspro.feature.config.*
import com.dep.tugasdaspro.feature.decision.Decission
import com.dep.tugasdaspro.feature.detil_list_mahasiswa.DetilListMahasiswa
import com.dep.tugasdaspro.feature.looping.Looping
import java.util.*
import kotlin.collections.ArrayList

@Suppress("DUPLICATE_LABEL_IN_WHEN")
class MahasiswaAdapter : RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MahasiswaAdapter.ViewHolder, position: Int) {
        holder.bind(mData[position],mAct)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder private constructor(private val binding: ItemsTeoriBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mData: String, mAct: Activity) {
            val intent = Intent(mAct, DetilListMahasiswa::class.java)

            binding.name.setOnClickListener {
                when (mData) {
                    PROCESS_REGISTER -> {
                        intent.putExtra("flag", PROCESS)
                    }
                    REGISTER_REJECTED -> {
                        intent.putExtra("flag", REJECTED)
                    }
                    REGISTER_APROVED -> {
                        intent.putExtra("flag", ACCEPTED)
                    }
                    else -> {
                        intent.putExtra("flag", ALL_REGISTER)
                    }
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