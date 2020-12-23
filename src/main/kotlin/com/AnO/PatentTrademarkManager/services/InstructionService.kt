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
            final = patentRepository.save(instruction)
        } else if (instruction is Trademark){
            final = trademarkRepository.save(instruction)
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
            patentRepository.findAll(pageRequest(page, size, direction, sort_property))

    fun getPatent(id: UUID): Patent =
            patentRepository.findById(id).get()


    fun createPatent(patent: Patent): Patent? {
        try { return patentRepository.save(patent.copy(action_list = mutableListOf<Action>())) }
        catch (e: Exception){throw (e)}
    }

    fun updatePatent(id: UUID, patent: Patent): Patent? {
        val check = patentRepository.findById(id)
        if (!check.isPresent)
            throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = patent.copy(id = id)
            patentRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw (e)}
    }

     fun deletePatent(id: UUID):Unit?{
        try {
            return patentRepository.deleteById(id) }
        catch (e: Exception){throw (e)}
    }


    fun applyPSearchAction(
            instruction_id: UUID,
            action: P_SearchAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyPAssignmentMergerAction(
            instruction_id: UUID,
            action: P_AssignmentMergerAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyPChangeOfAddressAction(
            instruction_id: UUID,
            action: P_ChangeOfAddressAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyPChangeOfNameAction(
            instruction_id: UUID,
            action: P_ChangeOfNameAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyPCTCAction(
            instruction_id: UUID,
            action: P_CTCAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyPProcurementOfCertificateAction(
            instruction_id: UUID,
            action: P_ProcurementOfCertificateAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyPRegistrationAction(
            instruction_id: UUID,
            action: P_RegistrationAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyPRenewalAction(
            instruction_id: UUID,
            action: P_RenewalAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }


    //  TRADEMARK METHODS

    fun getTrademarks(page: Int? = 1,
                      size: Int? = 10,
                      direction: Sort.Direction,
                      sort_property: String): Page<Trademark> =
            trademarkRepository.findAll(pageRequest(page, size, direction, sort_property))

    fun getTrademark(id: UUID): Trademark =
            trademarkRepository.findById(id).get()


    fun createTrademark(trademark: Trademark): Trademark? {
        try { return trademarkRepository.save(trademark.copy(action_list = mutableListOf<Action>())) }
        catch (e: Exception){throw (e)}
    }

    fun updateTrademark(id: UUID, trademark: Trademark): Trademark? {
        val check = trademarkRepository.findById(id)
        if (!check.isPresent)
             throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = trademark.copy(id = id)
            trademarkRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw (e)}
    }

    fun deleteTrademark(id: UUID):Unit?{
        try {
            return trademarkRepository
                    .delete(trademarkRepository.findById(id).get()) }
        catch (e: Exception){throw (e)}
    }

    @Throws(IOException::class)
    fun saveImage(file: MultipartFile, instruction_id: UUID): Image {
        val fileName = StringUtils
        .cleanPath(Objects.requireNonNull(file.originalFilename!!.replace("[()]|\\s+".toRegex(), "_")))

        val fileStorageLocation: Path = Paths.get(UPLOAD_DIR)

        val targetLocation = fileStorageLocation.resolve(fileName)

        Files.copy(file.inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING)

        val response = Image(null, downloadUrl + fileName, fileName, file.size, file.contentType, instruction_id)

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

    @Throws(MalformedURLException::class, FileNotFoundException::class)
    fun deleteImage(id: UUID){
        val image = imageRepository.findById(id).get()
        try {
            imageRepository.deleteById(id)
        } catch (e: Exception){ throw(e) }
        // if image successfully deleted delete file from server
        if (!imageRepository.findById(id).isPresent) {
            // get upload directory
            val fileStorageLocation = Paths.get(UPLOAD_DIR)
            // get File
            val file: File = fileStorageLocation.resolve(image.imageName).toFile()
            if (file.delete()) {
               return imageRepository.delete(image)
            }
        }
    }
    fun updateImage(){}

    fun applyPImage(id: UUID, multipartFile: MultipartFile): Instruction {
        val patent = patentRepository.findById(id).get()
        patent.image_list?.add(saveImage(multipartFile,id))
        return saveInstruction(patent)
    }

    fun applyTImage(id: UUID, multipartFile: MultipartFile): Instruction {
        val trademark = trademarkRepository.findById(id).get()
        trademark.image_list?.add(saveImage(multipartFile,id))
        return saveInstruction(trademark)
    }

}


