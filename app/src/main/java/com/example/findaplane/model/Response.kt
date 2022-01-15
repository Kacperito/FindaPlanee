package com.example.findaplane.model

import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

data class Response(
    val time:Int,
    val states: List<List<Any>>

)