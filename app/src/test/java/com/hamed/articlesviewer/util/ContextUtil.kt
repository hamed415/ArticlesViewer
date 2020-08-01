package com.hamed.articlesviewer.util

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.nhaarman.mockitokotlin2.*


fun mockContext(block: Context.() -> Unit): Context {
    val c = mock<Context>()

    // if application context is required return itself
    doReturn(c)
        .`when`(c)
        .applicationContext
    c.apply { block }
    return c
}

fun Context.mockString(id: Int, value: String): Context {
    doReturn(value)
        .whenever(this)
        .getString(id)

    return this
}

fun Context.mockResource(): Context {
    val resources = mock<Resources> { }
    doReturn(resources)
        .whenever(this)
        .resources

    return this
}

fun Context.sharedPreferences(vararg values: Pair<String, kotlin.Any>) {
    val preferences = mock<SharedPreferences>()
    doReturn(preferences)
        .whenever(this)
        .getSharedPreferences(any(), any())

    values.forEach {
        when (it.second) {
            is Boolean -> {
                doReturn(it.second)
                    .whenever(preferences)
                    .getBoolean(eq(it.first), any())
            }
            is String -> {
                doReturn(it.second)
                    .`when`(preferences)
                    .getString(eq(it.first), any())
            }
            is Int -> {
                doReturn(it.second)
                    .`when`(preferences)
                    .getInt(eq(it.first), any())
            }
            is Long -> {
                doReturn(it.second)
                    .`when`(preferences)
                    .getLong(eq(it.first), any())
            }
            is Float -> {
                doReturn(it.second)
                    .`when`(preferences)
                    .getFloat(eq(it.first), any())
            }
        }
    }
}

