package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.SearchAction
import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import com.AnO.PatentTrademarkManager.classes.Instructions.Trademark
import com.AnO.PatentTrademarkManager.intefaces.Action
import com.AnO.PatentTrademarkManager.intefaces.Instruction
import com.AnO.PatentTrademarkManager.repositories.ActionRepositories.SearchActionRepository
import com.AnO.PatentTrademarkManager.repositories.PatentRepository
import com.AnO.PatentTrademarkManager.repositories.TrademarkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class InstructionService {

    @Autowired
    lateinit var searchActionRepository: SearchActionRepository

    @Autowired
    lateinit var patentRepository: PatentRepository
    @Autowired
    lateinit var trademarkRepository:TrademarkRepository


    private fun saveInstruction(instruction: Instruction): Instruction{
        lateinit var final: Instruction
        if (instruction is Patent){
            final = this.patentRepository.save(instruction)
        } else if (instruction is Trademark){
            final = this.trademarkRepository.save(instruction)
        }
        return  final
    }

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

    fun getPatent(id: UUID): Patent =
            this.patentRepository.findById(id).get()


    fun createPatent(patent: Patent): Patent? {
        val mut_action_list = patent.action_list?.map{ it.instruction_id = patent.id } as MutableList<Action>
        val confirm = patent.copy(action_list = mut_action_list )
        try { return this.patentRepository.save(confirm) }
        catch (e: Exception){throw (e)}
    }

    fun updatePatent(id: UUID, patent: Patent): Patent? {
        val check = this.patentRepository.findById(id)
        if (!check.isPresent)
            return throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = patent.copy(id = id)
            this.patentRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw (e)}
    }

    fun deletePatent(id: UUID):Unit?{
        try {
            return this.patentRepository
                    .delete(this.patentRepository.findById(id).get()) }
        catch (e: Exception){throw (e)}
    }


    fun applySearchAction(
            instruction_id:UUID,
            search_action: SearchAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(search_action.copy(instruction_id = instruction.id))
        return this.saveInstruction(instruction)
    }


}


