package ru.garagetools.parapi.repo

import ru.garagetools.parapi.model.TransLog
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional


interface UserRepository : CrudRepository<TransLog, Long> {
    fun findTop7ByTranuserOrderByTrandatetimeDesc(tranuser: String): List<TransLog>

    fun findTop1ByTranuserOrderByTrandatetimeDesc(tranuser: String): TransLog

    @Transactional
    @Modifying
    @Query("delete from TransLog p where p.ID_TRAN = :id and p.tranuser = :name")
    fun delById(@Param("name") name: String, @Param("id") id: Int)
}
