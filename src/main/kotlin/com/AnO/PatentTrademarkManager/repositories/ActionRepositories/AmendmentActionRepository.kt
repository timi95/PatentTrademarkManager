package com.AnO.PatentTrademarkManager.repositories.ActionRepositories

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.AmendmentAction
import org.springframework.data.jpa.repository.JpaRepository

interface AmendmentActionRepository: JpaRepository<AmendmentAction, Long> {
}