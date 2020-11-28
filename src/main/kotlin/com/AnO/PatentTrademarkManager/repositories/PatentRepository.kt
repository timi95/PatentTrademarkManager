package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Patent
import com.AnO.PatentTrademarkManager.classes.Trademark
import org.springframework.data.jpa.repository.JpaRepository

interface PatentRepository : JpaRepository<Patent, Long> //{
//    fun findBySlug(slug: String): Patent?
//    fun findAllByOrderByAddedAtDesc(): Iterable<Patent>
//}

