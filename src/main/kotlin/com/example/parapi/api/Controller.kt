package com.example.parapi.api

import com.example.parapi.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/")
class ApiGetUser() {
    @Autowired
    lateinit var repa: UserRepository

    @GetMapping("/")
    fun findAll() = repa.findTop7ByTranuserOrderByTrandatetimeDesc("green_231 \$0025E3B2 g.  .")
}