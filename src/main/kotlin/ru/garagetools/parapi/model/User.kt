package ru.garagetools.parapi.model

data class User(var nick: String, var name: String, var code: String)
data class BodyData(var nick: String, val id: Int?, val date: String?, val time: String?)