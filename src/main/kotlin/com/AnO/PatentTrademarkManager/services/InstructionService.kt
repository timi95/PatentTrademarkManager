package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.*
import com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions.*
import com.AnO.PatentTrademarkManager.classes.Image
import com.AnO.PatentTrademarkManager.classes.Profiles.Patent
import com.AnO.PatentTrademarkManager.classes.Profiles.Trademark
import com.AnO.PatentTrademarkManager.classes.Utility.Utility.pageRequest
import com.AnO.PatentTrademarkManager.interfaces.Action
import com.AnO.PatentTrademarkManager.interfaces.Instruction
import com.AnO.PatentTrademarkManager.repositories.ActionRepositories.SearchActionRepository
import com.AnO.PatentTrademarkManager.repositories.ImageRepository
import com.AnO.PatentTrademarkManager.repositories.PatentRepository
import com.AnO.PatentTrademarkManager.repositories.TrademarkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
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

    private fun saveInstruction(instruction: Instruction): Instruction {
        lateinit var final: Instruction
        if (instruction is Patent){
            final = patentRepository.save(instruction)
        } else if (instruction is Trademark){
            final = trademarkRepository.save(instruction)
        }
        return  final
    }

    private fun retrieveInstruction(instruction_ref: UUID): Instruction {
        if(patentRepository.findById(instruction_ref).isPresent){
            try {
                return patentRepository.findById(instruction_ref).get()
            } catch (e: Exception) {throw e}
        }
        try {
            return trademarkRepository.findById(instruction_ref).get()
        } catch (e: Exception) {throw e}
    }


    //  PATENT METHODS
    fun getPatents(page: Int? = 1,
                   size: Int? = 10,
                   direction: Sort.Direction,
                   sort_property: String): Page<Patent> =
            try{patentRepository.findAll(pageRequest(page, size, direction, sort_property)) }
            catch (e:Exception){throw e}

    fun getPatent(id: UUID): Patent =
            patentRepository.findById(id).get()


    fun createPatent(patent: Patent): Patent? {
        try { return patentRepository.save(patent.copy(action_list = mutableListOf<Action>())) }
        catch (e: Exception){throw e}
    }

    fun updatePatent(id: UUID, patent: Patent): Patent? {
        val check = patentRepository.findById(id)
        if (!check.isPresent)
            throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = patent.copy(id = id)
            patentRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw e}
    }

     fun deletePatent(id: UUID):Unit?{
        try {
            return patentRepository.deleteById(id) }
        catch (e: Exception){throw e}
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
            action: P_ProcurementAction): Instruction {
        val instruction: Instruction = patentRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        val copy = action.copy(instruction_ref = instruction.id)
        println("\n " +
                "Action copy value to be saved: $copy " +
                "\n")
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

    fun applyPAmendmentAction(
            instruction_id: UUID,
            action: P_AmendmentAction): Instruction {
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
        catch (e: Exception){throw e}
    }

    fun updateTrademark(id: UUID, trademark: Trademark): Trademark? {
        val check = trademarkRepository.findById(id)
        if (!check.isPresent)
             throw(Exception("Patent of id:${id} does not exist"))
        try {
            val confirm  = trademark.copy(id = id)
            trademarkRepository.save(confirm)
            return confirm
        } catch (e: Exception){throw e}
    }

    fun deleteTrademark(id: UUID):Unit?{
        try {
            return trademarkRepository
                    .delete(trademarkRepository.findById(id).get()) }
        catch (e: Exception){throw e}
    }

    fun applyTAmendmentAction(
        instruction_id: UUID,
        action: T_AmendmentAction): Instruction {
        val instruction: Instruction = trademarkRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyTAssignmentMergerAction(
        instruction_id: UUID,
        action: T_AssignmentMergerAction): Instruction {
        val instruction: Instruction = trademarkRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyTChangeOfAdressAction(
        instruction_id: UUID,
        action: T_ChangeOfAddressAction): Instruction {
        val instruction: Instruction = trademarkRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyTProcurementOfCertificate(
        instruction_id: UUID,
        action: T_ProcurementOfCertificateAction): Instruction {
        val instruction: Instruction = trademarkRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyTReclassificationAction(
        instruction_id: UUID,
        action: T_ReclassificationAction): Instruction {
        val instruction: Instruction = trademarkRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyTRegistrationAction(
        instruction_id: UUID,
        action: T_RegistrationAction): Instruction {
        val instruction: Instruction = trademarkRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun applyTRenewalAction(
        instruction_id: UUID,
        action: T_RenewalAction): Instruction {
        val instruction: Instruction = trademarkRepository.findById(instruction_id).get()
        instruction.action_list?.add(action.copy(instruction_ref = instruction.id))
        return saveInstruction(instruction)
    }

    fun saveImage(file: MultipartFile, instruction_id: UUID): Image {
        val fileName = StringUtils
        .cleanPath(Objects.requireNonNull(file.originalFilename!!.replace("[()]|\\s+".toRegex(), "_")))
        try{
            Files.copy(file.inputStream, Paths.get(UPLOAD_DIR).resolve(fileName), StandardCopyOption.REPLACE_EXISTING)
            //flush Image Object in order to attain a valid ID
            val response = imageRepository.save(Image())
            val fileURL = "http://localhost:8080/Instruction/image/${response.id}"
            return imageRepository.save(
            response.copy(  pathString= fileURL,
                            imageName = fileName,
                            imageSize = file.size,
                            contentType = file.contentType,
                            instruction_ref = instruction_id))
            } catch (e:Error){throw (e)}
    }

    fun retrieveImageById(id: UUID): ResponseEntity<ByteArray> {
        val image = imageRepository.findById(id).get()
        // get upload directory
        val fileStorageLocation = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize()
        // get Path to download
        val filePath = fileStorageLocation.resolve(image.imageName!!).normalize()
        // Get Resource Url
        val resource: Resource = UrlResource(filePath.toUri())
        if (!resource.exists()) {
            throw FileNotFoundException("File $id Not Found")
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(Files.readAllBytes(filePath))
    }
    fun retrieveImageByName(fileName: String): ResponseEntity<ByteArray> {
        val image = imageRepository.findByImageName(fileName).get()
        // get upload directory
        val fileStorageLocation = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize()
        // get Path to download
        val filePath = fileStorageLocation.resolve(image.imageName!!).normalize()
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(Files.readAllBytes(filePath))
    }
    fun retrieveImages(): MutableList<Image> = imageRepository.findAll()
    fun retrieveInstructionImages(instruction_id: UUID): MutableList<Image>? = retrieveInstruction(instruction_id).image_list

    @Throws(MalformedURLException::class, FileNotFoundException::class)
    private fun deleteImageByName(fileName: String){
        // get upload directory
        val fileStorageLocation = Paths.get(UPLOAD_DIR)
        // get File
        val file: File = fileStorageLocation.resolve(fileName).toFile()
        try {
            // delete File
            file.deleteRecursively()
        } catch (e: Exception) {throw(e)}
    }

    @Throws(MalformedURLException::class, FileNotFoundException::class)
    fun deleteImage(id: UUID) {
        // image entity
        val image = imageRepository.findById(id).get()
        try {
            // retrieve associated instruction from instruction_ref on image entity
            val instruction = image.instruction_ref?.let { retrieveInstruction(it) }
            // remove image entity from image_list on instruction
            instruction?.image_list?.remove(image)
            // save the mutated instruction
            instruction?.let { saveInstruction(it) }
            // delete File
            image.imageName?.let { deleteImageByName(it) }
            // delete image entity
            imageRepository.deleteById(id)
        } catch (e: Exception){ throw(e) }
    }

    fun addPImage(id: UUID, multipartFile: MultipartFile): Instruction {
        val patent = patentRepository.findById(id).get()
        patent.image_list?.add(saveImage(multipartFile,id))
        return saveInstruction(patent)
    }

    fun addTImage(id: UUID, multipartFile: MultipartFile): Instruction {
        val trademark = trademarkRepository.findById(id).get()
        trademark.image_list?.add(saveImage(multipartFile,id))
        return saveInstruction(trademark)
    }

}


