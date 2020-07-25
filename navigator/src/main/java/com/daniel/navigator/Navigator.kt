package com.daniel.navigator

import android.content.Intent

interface Navigation {
    fun getIntent(): Intent?
}

object MoviesListNavigator : Navigation {
    private const val MOVIES_LIST = "com.daniel.movieslist.MoviesListActivity"
    override fun getIntent(): Intent? = MOVIES_LIST.loadIntentOrNull()
}

private const val PACKAGE_NAME = "com.daniel.moviesapp"

private fun intentTo(className: String): Intent =
    Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, className)

fun String.loadIntentOrNull(): Intent? =
    try {
        Class.forName(this).run { intentTo(this@loadIntentOrNull) }
    } catch (e: ClassNotFoundException) {
        null
    }
