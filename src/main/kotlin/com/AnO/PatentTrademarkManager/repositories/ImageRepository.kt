package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Image
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ImageRepository : JpaRepository<Image, UUID> {
    fun findByImageName(name:String):Optional<Image>
}