package com.AnO.PatentTrademarkManager.classes

import java.io.File
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Image(
        @GeneratedValue @Id val id:UUID?=null,
        val pathString:String?=null,
        val imageName: String?=null,
        val imageFile: File?=null)