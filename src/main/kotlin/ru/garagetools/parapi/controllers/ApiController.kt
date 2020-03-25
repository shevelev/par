package ru.garagetools.parapi.controllers

import ru.garagetools.parapi.repo.UserRepository
import org.springframework.web.bind.annotation.*
import ru.garagetools.parapi.model.BodyData
import ru.garagetools.parapi.model.TransLog
import ru.garagetools.parapi.model.User
import ru.garagetools.parapi.util.getUser
import ru.garagetools.parapi.util.listUser
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.DeleteMapping
import ru.garagetools.parapi.util.getCurrentTimeStamp
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/api/")
class ApiController(private val repa: UserRepository) {

    @GetMapping("/users/")
    fun users(): List<User> {
        return listUser()
    }

    @PostMapping("/users/add")
    fun addDateTime(@RequestBody bd: BodyData): TransLog {
        val user: User = getUser(bd.nick)
        val iam = repa.findTop1ByTranuserOrderByTrandatetimeDesc(user.code)

        val _time = bd.time
        val _date = bd.date

        if (_time.isNullOrEmpty()) {
            val newIam = iam.copy(ID_TRAN = 0, trandatetime = getCurrentTimeStamp())
            repa.save(newIam)
        } else {
            val tokens = _time.split(":")
            val cal = Calendar.getInstance()
            if (!_date.isNullOrBlank()) {
                val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
                cal.time = sdf.parse(_date)
            }
            cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tokens.get(0)))
            cal.set(Calendar.MINUTE, Integer.parseInt(tokens.get(1)))
            cal.set(Calendar.MILLISECOND, 0)

            val newIam = iam.copy(ID_TRAN = 0, trandatetime = cal.time)
            repa.save(newIam)
        }
        return repa.findTop1ByTranuserOrderByTrandatetimeDesc(getUser(bd.nick).code)
    }

    @DeleteMapping("/users/{name}/{id}")
    fun deleteTransLog(@PathVariable name: String, @PathVariable id: Int): Int {
        repa.delById(getUser(name).code,id)
        return 1
    }

    @GetMapping("/user/{name}/7")
    fun find7(@PathVariable name: String) =
            repa.findTop7ByTranuserOrderByTrandatetimeDesc(getUser(name).code)

    @GetMapping("/user/{name}/1")
    fun find1(@PathVariable name: String) =
            repa.findTop1ByTranuserOrderByTrandatetimeDesc(getUser(name).code)
}