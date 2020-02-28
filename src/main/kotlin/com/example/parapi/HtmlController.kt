package com.example.parapi

import com.example.parapi.model.TransLog
import com.example.parapi.model.User
import com.example.parapi.repo.UserRepository
import com.example.parapi.util.getCurrentTimeStamp
import com.example.parapi.util.getUser
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Controller
class HtmlController(private val repository: UserRepository) {

    @GetMapping("/")
    fun startPage(model: Model): String {

        val user: User = getUser(SecurityContextHolder.getContext().authentication.name)

        model["user"] = repository.findTop7ByTranuserOrderByTrandatetimeDesc(user.code)
        model["userInfo"] = user
        return "startPage"
    }

    @PostMapping("/")
    fun add(model: Model,  @RequestParam dated: String, @RequestParam datep: String) : String {
        val user: User = getUser(SecurityContextHolder.getContext().authentication.name)

        if (datep.isBlank()) {
            val iam = repository.findTop1ByTranuserOrderByTrandatetimeDesc(user.code)
//            val newIam:TransLog = iam.copy(trandatetime = Date())
//            repository.save(newIam)
        }

        model["user"] = repository.findTop7ByTranuserOrderByTrandatetimeDesc(user.code)
        model["userInfo"] = user
        return "startPage"
    }

    @PostMapping("/del")
    fun del(model: Model,  @RequestParam delidtran: String) : String {

        val user: User = getUser(SecurityContextHolder.getContext().authentication.name)

        repository.delById(delidtran.toInt())

        model["user"] = repository.findTop7ByTranuserOrderByTrandatetimeDesc(user.code)
        model["userInfo"] = user
        return "startPage"
    }
}


