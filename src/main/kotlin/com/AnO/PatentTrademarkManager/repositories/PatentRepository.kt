package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import org.springframework.data.jpa.repository.JpaRepository

interface PatentRepository : JpaRepository<Patent, Long> //{
//    fun findBySlug(slug: String): Patent?
//    fun findAllByOrderByAddedAtDesc(): Iterable<Patent>
//}

