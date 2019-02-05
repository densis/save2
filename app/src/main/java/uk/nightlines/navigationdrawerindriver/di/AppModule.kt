package uk.nightlines.navigationdrawerindriver.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import uk.nightlines.navigationdrawerindriver.UserMode
import uk.nightlines.navigationdrawerindriver.di.navigation.api.NavigationDrawerFragment
import uk.nightlines.navigationdrawerindriver.presenter.nav.NavigationDrawerPresenter
import uk.nightlines.navigationdrawerindriver.ui.nav.NavigationDrawerFragmentImpl
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    private val cicerone = Cicerone.create()

    @Provides
    @Singleton
    fun context(): Context = context

    @Provides
    @Singleton
    fun userModeStatus(): UserModeStatus = UserModeStatus(UserMode.CLIENT)

    @Provides
    fun router(): Router = cicerone.router

    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    fun navigationDrawerFragment(): NavigationDrawerFragment = NavigationDrawerFragmentImpl()

    @Provides
    fun navigationDrawerPresenter(router: Router, userModeStatus: UserModeStatus): NavigationDrawerPresenter =
        NavigationDrawerPresenter(router, userModeStatus)
}