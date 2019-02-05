package uk.nightlines.navigationdrawerindriver.di.main

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.NavigatorHolder

interface MainApi {
    fun main(): Fragment
    .
    fun database(): NavigatorHolder
}