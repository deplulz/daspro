package com.dep.tugasdaspro.feature.config

val JOB_RECEIVER = "updateData"

val PROCESS = "proses"
val ACCEPTED = "accpeted"
val REJECTED = "rejected"

val ALL_REGISTER = "Semua Pendaftaran"
val PROCESS_REGISTER = "Proses Pendaftaran"
val REGISTER_REJECTED = "Pendaftaran di tolak"
val REGISTER_APROVED = "Pendaftaran di Terima"

val mData: ArrayList<String> = ArrayList()

fun setData() {
    mData.add(PROCESS_REGISTER)
    mData.add(REGISTER_REJECTED)
    mData.add(REGISTER_APROVED)
    mData.add(ALL_REGISTER)
}