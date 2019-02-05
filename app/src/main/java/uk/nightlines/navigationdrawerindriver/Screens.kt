package uk.nightlines.navigationdrawerindriver

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import uk.nightlines.navigationdrawerindriver.ui.FragmentCity
import uk.nightlines.navigationdrawerindriver.ui.FragmentIntercity
import uk.nightlines.navigationdrawerindriver.ui.driver.DriverFlowFragmentImpl
import uk.nightlines.navigationdrawerindriver.ui.global.BaseFragment
import uk.nightlines.navigationdrawerindriver.ui.main.MainFragment

object Screens {
    object Main : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return MainFragment()
        }
    }

    object City : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FragmentCity()
        }
    }

    object Intercity : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FragmentIntercity()
        }
    }

    object Driver : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return DriverFlowFragmentImpl()
        }
    }
}