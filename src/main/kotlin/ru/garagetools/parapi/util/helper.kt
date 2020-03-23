package ru.garagetools.parapi.util

import ru.garagetools.parapi.model.User
import java.util.*

fun getCurrentTimeStamp(): Date {
    val cal = Calendar.getInstance()
    cal.set(Calendar.MILLISECOND, 0)
    return cal.time
}

fun listUser(): List<User> {
    val res: List<User> = listOf(
            User(nick = "s", name = "Шевелев Сергей", code = "green_231 $0025E3B2 g.  ."),
            User(nick = "d", name = "Осипов Денис", code = "green_777 $006BA878 g.  ."),
            User(nick = "v", name = "Андриянов Виталий", code = "green_204 $0026826E 2. 2."),
            User(nick = "e", name = "Тимофеева Екатерина", code = "green_174 $002C0C7E g.  ."),
            User(nick = "gv", name = "Горбунов Владимир", code = "green_242 $00913AC5 g.  ."),
            User(nick = "un", name = "Урих Никита", code = "green_235 $0025C574 g.  ."),
            User(nick = "sg", name = "Голиков Сергей", code = "Ключ : $002C7661"),
            User(nick = "ad", name = "Андриянов Денис", code = "green_395 $00916119 g.  ."),
            User(nick = "ra", name = "Роговиков Антон", code = "green_357 $00265691 g.  ."),
            User(nick = "kp", name = "Киреев Петр", code = "Андреев $002BF594 И. М."),
            User(nick = "kr", name = "Кукуев Руслан", code = "green_431 $0055639B g.  ."),
            User(nick = "ku", name = "Костюченко Юлия", code = "green_471 $0052751F g.  .")
    )
    return res
}

fun getUser(name: String?): User {
    return listUser().first { it.nick == name }
}