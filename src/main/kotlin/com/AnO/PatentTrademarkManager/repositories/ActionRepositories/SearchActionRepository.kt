package com.AnO.PatentTrademarkManager.repositories.ActionRepositories

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.SearchAction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SearchActionRepository: JpaRepository<SearchAction, UUID>