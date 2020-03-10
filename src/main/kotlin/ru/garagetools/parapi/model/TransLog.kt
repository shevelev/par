package ru.garagetools.parapi.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "translog")
data class TransLog(
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY) var ID_TRAN: Int = 0,
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
        var arch_id: Int? = null)