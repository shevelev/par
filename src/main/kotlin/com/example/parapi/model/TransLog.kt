package com.example.parapi.model

import java.lang.reflect.Constructor
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "translog")
class TransLog(
        @Id @GeneratedValue var ID_TRAN: Int = 0,
        var trandatetime: Date,
        var trancode: Int,
        var isalarm: Int,
        var trandesc: String,
        var tranarea: String,
        var tranuser: String,
        var tranctrlid: Int?,
        var tranuserid: Int?,
        var tranoperid: Int?,
        var param1: Int?,
        var param2: Int?,
        var operdatetime: Date?,
        @Column(name = "Arch_ID")
        var arch_id: Int? = null) {

//    constructor(trandatetime: Date, trancode: Int, isalarm: Int, trandesc: String, tranarea: String, tranuser: String, tranctrlid: Int?, tranuserid: Int?,
//                tranoperid: Int?, param1: Int?, param2: Int?, operdatetime: Date?) :
//            this (trandatetime = trandatetime, trancode = trancode, isalarm = isalarm, trandesc = trandesc, tranarea = tranarea,
//                    tranuser = tranuser, tranctrlid = tranctrlid, tranuserid = tranuserid, tranoperid = tranoperid, param1 = param1, param2 = param2, operdatetime = operdatetime)
}
