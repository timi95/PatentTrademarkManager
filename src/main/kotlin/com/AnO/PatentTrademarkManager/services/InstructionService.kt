package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.*
import com.AnO.PatentTrademarkManager.classes.Image
import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import com.AnO.PatentTrademarkManager.classes.Instructions.Trademark
import com.AnO.PatentTrademarkManager.intefaces.Action
import com.AnO.PatentTrademarkManager.intefaces.Instruction
import com.AnO.PatentTrademarkManager.repositories.ActionRepositories.SearchActionRepository
import com.AnO.PatentTrademarkManager.repositories.ImageRepository
import com.AnO.PatentTrademarkManager.repositories.PatentRepository
import com.AnO.PatentTrademarkManager.repositories.TrademarkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.*

@Service
class InstructionService {
    @Value("\${file.upload-dir}")
    lateinit var UPLOAD_DIR: String
    @Value("\${file.download-url}")
    lateinit var downloadUrl: String

    @Autowired
    lateinit var searchActionRepository: SearchActionRepository

    @Autowired
    lateinit var patentRepository: PatentRepository
    @Autowired
    lateinit var trademarkRepository:TrademarkRepository

    @Autowired
    lateinit var imageRepository: ImageRepository

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
                            sort_property: String): PageRequest =
            PageRequest.of(page!!, size!!, Sort.by(direction, sort_property))

    //  PATENT METHODS
    fun getPatents(page: Int? = 1,
                   size: Int? = 10,
                   direction: Sort.Direction,
                   sort_property: String): Page<Patent> =
            this.patentRepository.findAll(pageRequest(page, size, direction, sort_property))

    fun getPatent(id: UUID): Patent =
            this.patentRepository.findById(id).get()


    fun createPatent(patent: Patent): Patent? {
        try { return this.patentRepository.save(patent.copy(action_list = mutableListOf<Action>())) }
        catch (e: Exception){throw (e)}
    }

    fun updatePatent(id: UUID, patent: Patent): Patent? {
        val check = this.patentRepository.findById(id)
        if (!check.isPresent)
            throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = patent.copy(id = id)
            this.patentRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw (e)}
    }

     fun deletePatent(id: UUID):Unit?{
        try {
            return this.patentRepository.deleteById(id) }
        catch (e: Exception){throw (e)}
    }


    fun applyPSearchAction(
            instruction_id: UUID,
            action: P_SearchAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }

    fun applyPAssignmentMergerAction(
            instruction_id: UUID,
            action: P_AssignmentMergerAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }

    fun applyPChangeOfAddressAction(
            instruction_id: UUID,
            action: P_ChangeOfAddressAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }

    fun applyPChangeOfNameAction(
            instruction_id: UUID,
            action: P_ChangeOfNameAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }

    fun applyPCTCAction(
            instruction_id: UUID,
            action: P_CTCAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }

    fun applyPProcurementOfCertificateAction(
            instruction_id: UUID,
            action: P_ProcurementOfCertificateAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }

    fun applyPRegistrationAction(
            instruction_id: UUID,
            action: P_RegistrationAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }

    fun applyPRenewalAction(
            instruction_id: UUID,
            action: P_RenewalAction): Instruction {
        val instruction: Instruction = this.patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return this.saveInstruction(instruction)
    }


    //  TRADEMARK METHODS

    fun getTrademarks(page: Int? = 1,
                      size: Int? = 10,
                      direction: Sort.Direction,
                      sort_property: String): Page<Trademark> =
            this.trademarkRepository.findAll(pageRequest(page, size, direction, sort_property))

    fun getTrademark(id: UUID): Trademark =
            this.trademarkRepository.findById(id).get()


    fun createTrademark(trademark: Trademark): Trademark? {
        try { return this.trademarkRepository.save(trademark.copy(action_list = mutableListOf<Action>())) }
        catch (e: Exception){throw (e)}
    }

    fun updateTrademark(id: UUID, trademark: Trademark): Trademark? {
        val check = this.trademarkRepository.findById(id)
        if (!check.isPresent)
             throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = trademark.copy(id = id)
            this.trademarkRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw (e)}
    }

    fun deleteTrademark(id: UUID):Unit?{
        try {
            return this.trademarkRepository
                    .delete(this.trademarkRepository.findById(id).get()) }
        catch (e: Exception){throw (e)}
    }

    @Throws(IOException::class)
    fun saveImage(file: MultipartFile): Image {
        val fileName = StringUtils
        .cleanPath(Objects.requireNonNull(file.originalFilename!!.replace("[()]|\\s+".toRegex(), "_")))

        val fileStorageLocation: Path = Paths.get(UPLOAD_DIR)

        val targetLocation = fileStorageLocation.resolve(fileName)

        Files.copy(file.inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING)

        val response = Image(null, downloadUrl + fileName, fileName, file.size, file.contentType)

        return imageRepository.save(response)
    }


    @Throws(MalformedURLException::class, FileNotFoundException::class)
    fun retrieveImage(fileName: String): File {
        // get upload directory
        val fileStorageLocation = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize()

        // get Path to download
        val filePath = fileStorageLocation.resolve(fileName).normalize()

        // Get Resource Url
        val resource: Resource = UrlResource(filePath.toUri())
        if (!resource.exists()) {
            throw FileNotFoundException("File $fileName Not Found")
        }
        return resource.file
    }

    fun updateImage(){}
    fun deleteImage(){}

}


