package uk.nightlines.navigationdrawerindriver.ui.driver

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import uk.nightlines.navigationdrawerindriver.R
import uk.nightlines.navigationdrawerindriver.Screens
import uk.nightlines.navigationdrawerindriver.di.AppComponent
import uk.nightlines.navigationdrawerindriver.di.navigation.api.NavigationDrawerFragment
import uk.nightlines.navigationdrawerindriver.setLaunchScreen
import uk.nightlines.navigationdrawerindriver.ui.global.BaseFragment
import javax.inject.Inject

class DriverActivity : AppCompatActivity() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigationDrawerFragment: NavigationDrawerFragment

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.mainContainer) as BaseFragment

    private val drawerFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.drawerLayout) as BaseFragment

    private val navigator: Navigator =
        object : SupportAppNavigator(this, supportFragmentManager, R.id.mainContainer) {
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                //fix incorrect order lifecycle callback of MainFlowFragment
                fragmentTransaction.setReorderingAllowed(true)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponent.get().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_container)

        if (supportFragmentManager.fragments.isEmpty()) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.navDrawerContainer, navigationDrawerFragment as BaseFragment)
                .commitNow()
            navigator.setLaunchScreen(Screens.City)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}