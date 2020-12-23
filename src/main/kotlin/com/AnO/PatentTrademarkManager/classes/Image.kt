package com.AnO.PatentTrademarkManager.classes

import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Image(
        @GeneratedValue @Id val id:UUID?=null,
        val pathString:String?=null,
        val imageName: String?=null,
        val imageSize: Long?=null,
        val contentType: String?=null,
        val instruction_ref: UUID?=null)