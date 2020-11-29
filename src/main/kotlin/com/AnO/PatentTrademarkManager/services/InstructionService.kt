package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Patent
import com.AnO.PatentTrademarkManager.repositories.PatentRepository
import com.AnO.PatentTrademarkManager.repositories.TrademarkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InstructionService {
    @Autowired
    lateinit var patentRepository: PatentRepository
    @Autowired
    lateinit var trademarkRepository:TrademarkRepository

    fun getPatents():List<Patent>?{
        return this.patentRepository.findAll()
    }
    fun getPatent(id:Long): Patent {
        return this.patentRepository.findById(id).get()
    }

    fun createPatent(patent:Patent): Patent? {
        try { return this.patentRepository.save(patent) }
        catch (e: Exception){throw (e)}
    }

    fun updatePatent(id:Long, patent:Patent): Patent? {
        val check = this.patentRepository.findById(id)
        if (!check.isPresent)
            return throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = patent.copy(id=id)
            this.patentRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw (e)}
    }

    fun deletePatent(id: Long):Unit?{
        try {
            return this.patentRepository
                    .delete(this.patentRepository.findById(id).get()) }
        catch (e: Exception){throw (e)}
    }


}
