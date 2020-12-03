package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PatentRepository : JpaRepository<Patent, UUID>

