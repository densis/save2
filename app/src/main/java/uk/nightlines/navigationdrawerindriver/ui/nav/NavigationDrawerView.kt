package uk.nightlines.navigationdrawerindriver.ui.nav

import android.content.Intent
import uk.nightlines.navigationdrawerindriver.ui.driver.DriverActivity
import uk.nightlines.navigationdrawerindriver.ui.global.MvpView
import uk.nightlines.navigationdrawerindriver.ui.launch.MainActivity

interface NavigationDrawerView : MvpView {
    fun updateTextSwitchMode(text: String)

    fun startActivityDriver()

    fun startActivityClient()
}