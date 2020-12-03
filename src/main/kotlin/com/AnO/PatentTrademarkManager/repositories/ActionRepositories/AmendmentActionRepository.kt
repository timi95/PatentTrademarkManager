package com.AnO.PatentTrademarkManager.repositories.ActionRepositories

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.AmendmentAction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AmendmentActionRepository: JpaRepository<AmendmentAction, UUID>