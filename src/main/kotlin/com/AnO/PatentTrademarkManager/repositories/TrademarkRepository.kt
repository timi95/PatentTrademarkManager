package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Instructions.Trademark
import org.springframework.data.jpa.repository.JpaRepository

interface TrademarkRepository: JpaRepository<Trademark,Long> {
}