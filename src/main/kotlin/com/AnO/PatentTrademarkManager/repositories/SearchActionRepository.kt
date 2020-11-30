package com.AnO.PatentTrademarkManager.repositories

import com.AnO.PatentTrademarkManager.classes.Actions.SearchAction
import org.springframework.data.jpa.repository.JpaRepository

interface SearchActionRepository: JpaRepository<SearchAction,Long> {
}