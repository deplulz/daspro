package com.dep.tugasdaspro.feature.detil_list_mahasiswa.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dep.tugasdaspro.databinding.ItemsMhsBinding
import com.dep.tugasdaspro.feature.detil_list_mahasiswa.dao.DAOMahasiswa
import com.dep.tugasdaspro.feature.process_registration.ProcessRegis

@Suppress("DUPLICATE_LABEL_IN_WHEN")
class DetilMahasiswaAdapter : RecyclerView.Adapter<DetilMahasiswaAdapter.ViewHolder>() {

    private val mData = ArrayList<DAOMahasiswa>()
    lateinit var mAct: Activity
    lateinit var mCtx: Context

    fun setData(mAct: Activity, items: ArrayList<DAOMahasiswa>) {
        this.mAct = mAct
        mData.clear()
        mCtx = mAct.applicationContext
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position],mAct, position)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder private constructor(private val binding: ItemsMhsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mData: DAOMahasiswa, mAct: Activity, position: Int) {
            val intent = Intent(mAct, ProcessRegis::class.java)
            binding.name = mData.name
            binding.status = when (mData.aproved) {
                "0" -> {
                    "Butuh Di Proses"
                }
                "1" -> {
                    "Sudah di terima"
                }
                else -> {
                    "Tidak di terima"
                }
            }

            binding.colorStatus = when (mData.aproved) {
                "0" -> {
                    "#80000000"
                }
                "1" -> {
                    "#08dd18"
                }
                else -> {
                    "#cd201f"
                }
            }
            binding.parent.setOnClickListener {
                val maps = HashMap<String, String>()
                maps["dataIndex"] = "$position"
                maps["name"] = mData.name
                maps["address"] = mData.address
                maps["school"] = mData.school
                maps["gender"] = mData.gender
                maps["nilai"] = mData.point
                maps["aproved"] = mData.aproved
                intent.putExtra("data", maps)
                mAct.startActivity(intent)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemsMhsBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}