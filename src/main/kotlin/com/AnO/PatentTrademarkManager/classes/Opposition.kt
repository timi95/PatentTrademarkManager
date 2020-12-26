package com.AnO.PatentTrademarkManager.classes

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Opposition(@GeneratedValue @Id val id: UUID)