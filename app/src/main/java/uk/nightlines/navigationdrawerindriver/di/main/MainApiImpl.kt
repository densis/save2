package uk.nightlines.navigationdrawerindriver.di.main

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.NavigatorHolder
import uk.nightlines.navigationdrawerindriver.ui.main.MainFragment
import javax.inject.Inject

class MainApiImpl : MainApi {

    @Inject
    lateinit var nav: NavigatorHolder

    init {
        Component.inject()
    }

    override fun main(): Fragment = MainFragment()

    override fun database(): NavigatorHolder = nav
}