package ru.garagetools.parapi.controllers

import ru.garagetools.parapi.model.User
import ru.garagetools.parapi.repo.UserRepository
import ru.garagetools.parapi.util.getCurrentTimeStamp
import ru.garagetools.parapi.util.getUser
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Controller
class WebController(private val repository: UserRepository) {

    @GetMapping("/")
    fun startPage(model: Model): String {
        val user: User = getUser(SecurityContextHolder.getContext().authentication.name)

        model["delete"] = ""
        model["insert"] = false
        model["user"] = repository.findTop7ByTranuserOrderByTrandatetimeDesc(user.code)
        model["userInfo"] = user
        return "startPage"
    }

    @PostMapping("/")
    fun add(model: Model, @RequestParam dated: String, @RequestParam datep: String): String {

        val user: User = getUser(SecurityContextHolder.getContext().authentication.name)
        val iam = repository.findTop1ByTranuserOrderByTrandatetimeDesc(user.code)

        if (datep.isBlank()) {
            val newIam = iam.copy(ID_TRAN = 0, trandatetime = getCurrentTimeStamp())
            repository.save(newIam)
        } else {
            val tokens = datep.split(":")
            val cal = Calendar.getInstance()
            if (!dated.isBlank()) {
                val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
                cal.time = sdf.parse(dated)// all done
            }
            cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tokens[0]))
            cal.set(Calendar.MINUTE, Integer.parseInt(tokens[1]))
            cal.set(Calendar.MILLISECOND, 0)

            val newIam = iam.copy(ID_TRAN = 0, trandatetime = cal.time)
            repository.save(newIam)
        }

        model["delete"] = ""
        model["insert"] = true
        model["user"] = repository.findTop7ByTranuserOrderByTrandatetimeDesc(user.code)
        model["userInfo"] = user
        return "startPage"
    }

    @PostMapping("/del")
    fun del(model: Model, @RequestParam delidtran: String): String {

        val user: User = getUser(SecurityContextHolder.getContext().authentication.name)

        repository.delById(delidtran.toInt())
        model["delete"] = "Событие удалено"
        model["insert"] = true
        model["user"] = repository.findTop7ByTranuserOrderByTrandatetimeDesc(user.code)
        model["userInfo"] = user
        return "startPage"
    }
}


