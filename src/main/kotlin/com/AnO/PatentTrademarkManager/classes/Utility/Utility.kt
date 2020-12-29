package com.AnO.PatentTrademarkManager.classes.Utility

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

object Utility {
     fun pageRequest(page: Int?,
                            size: Int?,
                            direction: Sort.Direction,
                            sort_property: String): PageRequest =
            PageRequest.of(page!!, size!!, Sort.by(direction, sort_property))
}