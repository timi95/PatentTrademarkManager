package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Patent
import com.AnO.PatentTrademarkManager.repositories.PatentRepository
import com.AnO.PatentTrademarkManager.repositories.TrademarkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InstructionService @Autowired constructor(
        val patentRepository: PatentRepository,
        val trademarkRepository:TrademarkRepository) {
    fun createPatent(patent:Patent): Patent? {
        try {
            this.patentRepository.save(patent)
        } catch (e: Exception){throw (e)}
        return null
    }
    fun updatePatent(
        id:Long,
        patent:Patent =
        this.patentRepository.
        findById(id).get()): Patent?{
        try {
            this.patentRepository.save(patent)
        } catch (e: Exception){throw (e)}
        return null
    }

    fun deletePatent(id: Long):Unit?{
        try {
            return this.patentRepository.delete(this.patentRepository.findById(id).get())
        }catch (e: Exception){throw (e)}
    }
}
