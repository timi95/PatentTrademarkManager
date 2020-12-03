package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatentRepository : JpaRepository<Patent, Long>

