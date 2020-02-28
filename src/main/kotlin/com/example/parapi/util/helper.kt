package com.example.parapi.util

import com.example.parapi.model.User
import java.text.SimpleDateFormat
import java.util.*

fun getCurrentTimeStamp(): String {
    val sdfDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val now = Date()
    return sdfDate.format(now)
}

fun getUser(name: String?): User {
    val newUser: User
    newUser = when (name) {
        "s" -> User(nick = name, name = "Шевелев Сергей", code = "green_231 $0025E3B2 g.  .")
        "d" -> User(nick = name, name = "Осипов Денис", code = "Осипов $002BF590 Д.  .")
        "v" -> User(nick = name, name = "Андриянов Виталий", code = "green_204 $0026826E 2. 2.")
        "e" -> User(nick = name, name = "Тимофеева Екатерина", code = "green_174 $002C0C7E g.  .")
        "gv" -> User(nick = name, name = "Горбунов Владимир", code = "green_242 $00913AC5 g.  .")
        "un" -> User(nick = name, name = "Урих Никита", code = "green_235 $0025C574 g.  .")
        "sg" -> User(nick = name, name = "Голиков Сергей", code = "Ключ : $002C7661")
        "ad" -> User(nick = name, name = "Андриянов Денис", code = "green_395 $00916119 g.  .")
        "ra" -> User(nick = name, name = "Роговиков Антон", code = "green_357 $00265691 g.  .")
        "kp" -> User(nick = name, name = "Киреев Петр", code = "Андреев $002BF594 И. М.")
        "kr" -> User(nick = name, name = "Кукуев Руслан", code = "green_431 $0055639B g.  .")
        "ku" -> User(nick = name, name = "Костюченко Юлия", code = "green_471 $0052751F g.  .")
        else -> User(nick = "test", name = "test", code = "test")
    }

    return newUser
}