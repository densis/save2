package uk.nightlines.navigationdrawerindriver.presenter.nav

import android.util.Log
import ru.terrakok.cicerone.Router
import uk.nightlines.navigationdrawerindriver.Screens
import uk.nightlines.navigationdrawerindriver.UserMode
import uk.nightlines.navigationdrawerindriver.di.UserModeStatus
import uk.nightlines.navigationdrawerindriver.flow.FlowRouter
import uk.nightlines.navigationdrawerindriver.presenter.MvpBasePresenter
import uk.nightlines.navigationdrawerindriver.ui.GlobalMenuController
import uk.nightlines.navigationdrawerindriver.ui.nav.NavigationDrawerItem
import uk.nightlines.navigationdrawerindriver.ui.nav.NavigationDrawerView
import javax.inject.Inject

class NavigationDrawerPresenter @Inject constructor(
    private val router: Router,
    private val userModeStatus: UserModeStatus
) : MvpBasePresenter<NavigationDrawerView>() {

    private var items = ArrayList<NavigationDrawerItem>()

    init {
        fillItems()
    }

    fun onItemClicked(item: NavigationDrawerItem) {
        router.newRootScreen(item.screen)
    }

    fun itemsSize(): Int = items.size

    fun getItem(position: Int): NavigationDrawerItem = items[position]

    override fun attachView(view: NavigationDrawerView) {
        super.attachView(view)

        if (userModeStatus.status == UserMode.CLIENT) {
            view.updateTextSwitchMode("switch to driver")
        } else {
            view.updateTextSwitchMode("switch to client")
        }
    }

    fun onSwitchUserModeClicked() {
        Log.d("GTA5", "onSwitchUserModeClicked = ${userModeStatus.status}")
        if (userModeStatus.status == UserMode.CLIENT) {
            view?.startActivityDriver()
            userModeStatus.status = UserMode.DRIVER
        } else {
            view?.startActivityDriver()
        }
    }

    // TODO не нужен. УДАЛИТЬ
    private fun fillItems() {
        items.add(
            NavigationDrawerItem(
                "http://avotarov.net/picture/avatarki/2/kartinki/39-3.jpg",
                "Город",
                Screens.City
            )
        )
        items.add(
            NavigationDrawerItem(
                "http://avotarov.net/picture/avatarki/8/kartinki/163-3.jpg",
                "Межгород",
                Screens.Intercity
            )
        )
    }
}