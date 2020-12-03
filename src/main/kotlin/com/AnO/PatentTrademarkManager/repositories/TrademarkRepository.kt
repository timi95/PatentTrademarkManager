package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Instructions.Trademark
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrademarkRepository: JpaRepository<Trademark,Long>