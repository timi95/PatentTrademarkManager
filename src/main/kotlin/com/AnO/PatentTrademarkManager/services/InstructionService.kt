package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.SearchAction
import com.AnO.PatentTrademarkManager.classes.Patent
import com.AnO.PatentTrademarkManager.repositories.PatentRepository
import com.AnO.PatentTrademarkManager.repositories.SearchActionRepository
import com.AnO.PatentTrademarkManager.repositories.TrademarkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
@Service
class InstructionService {

    @Autowired
    lateinit var searchActionRepository: SearchActionRepository

    @Autowired
    lateinit var patentRepository: PatentRepository
    @Autowired
    lateinit var trademarkRepository:TrademarkRepository


    private fun pageRequest(page: Int?,
                    size: Int?,
                    direction: Sort.Direction,
                    sort_property:String): PageRequest =
            PageRequest.of(page!!, size!!, Sort.by(direction, sort_property))

    fun getPatents(page: Int? = 1,
                   size: Int? = 10,
                   direction: Sort.Direction,
                   sort_property:String): Page<Patent> =
            this.patentRepository.findAll(pageRequest(page, size, direction, sort_property))

    fun getPatent(id: Long): Patent =
            this.patentRepository.findById(id).get()


    fun createPatent(patent: Patent): Patent? {
        try { return this.patentRepository.save(patent) }
        catch (e: Exception){throw (e)}
    }

    fun updatePatent(id: Long, patent: Patent): Patent? {
        val check = this.patentRepository.findById(id)
        if (!check.isPresent)
            return throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = patent.copy(id = id)
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


    fun applySearchAction(
            instruction_id:Long,
            search_action: SearchAction): Patent {
        val instruction: Patent = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(search_action.copy(instruction_id = instruction.id))
        return this.patentRepository.save(instruction)
    }


}


