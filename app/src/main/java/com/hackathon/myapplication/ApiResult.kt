package com.hackathon.myapplication

import java.util.*

data class ApiResult(
    val definitions : ArrayList<Item>,
    val word : String,
    val pronunciation:String
)
