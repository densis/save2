package uk.nightlines.navigationdrawerindriver.ui.nav

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_drawer.*
import uk.nightlines.navigationdrawerindriver.R
import uk.nightlines.navigationdrawerindriver.di.AppComponent
import uk.nightlines.navigationdrawerindriver.di.navigation.api.NavigationDrawerFragment
import uk.nightlines.navigationdrawerindriver.presenter.nav.NavigationDrawerPresenter
import uk.nightlines.navigationdrawerindriver.ui.driver.DriverActivity
import uk.nightlines.navigationdrawerindriver.ui.global.BaseFragment
import uk.nightlines.navigationdrawerindriver.ui.launch.MainActivity
import javax.inject.Inject

class NavigationDrawerFragmentImpl @Inject constructor() : BaseFragment(), NavigationDrawerView,
    NavigationDrawerFragment {
    @Inject
    lateinit var presenter: NavigationDrawerPresenter

    override val layoutRes: Int = R.layout.fragment_drawer

    private val adapter: NavigationDrawerAdapter by lazy {
        NavigationDrawerAdapter(
            { presenter.getItem(it) },
            { presenter.itemsSize() },
            { presenter.onItemClicked(it) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponent.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        sectors.layoutManager = LinearLayoutManager(context)
        sectors.adapter = adapter

        switchUserMode.setOnClickListener {
            presenter.onSwitchUserModeClicked()
        }
    }

    override fun updateTextSwitchMode(text: String) {
        switchUserMode.text = text
    }

    override fun startActivityDriver() {
        activity?.startActivity(Intent(activity, DriverActivity::class.java))
    }

    override fun startActivityClient() {
        activity?.startActivity(Intent(activity, MainActivity::class.java))
    }
}