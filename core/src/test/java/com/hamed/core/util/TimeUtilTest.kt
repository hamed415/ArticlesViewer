package com.hamed.core.util

import org.junit.Test
import org.junit.Assert.assertEquals
import java.time.LocalDateTime

class TimeUtilTest {
    @Test
    fun getFormattedDateTest(){
        assertEquals(getFormattedDate(LocalDateTime.of(2020, 3, 12, 0,0,0)), "2020-03-12")
        assertEquals(getFormattedDate(LocalDateTime.of(2020, 12, 3, 0,0,0)), "2020-12-03")
    }
}