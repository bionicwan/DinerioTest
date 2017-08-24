package com.dinerio.dineriotest.modules.home.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.dinerio.dineriotest.R
import com.dinerio.dineriotest.modules.home.Presenter
import com.dinerio.dineriotest.modules.home.View
import com.dinerio.dineriotest.modules.home.presenter.HomePresenter

/**
 * Created by JC on 23/08/2017.
 */
class HomeActivity: AppCompatActivity(), View {

    @JvmField @BindView(R.id.txtv_email)
    var txtvEmail: TextView? = null

    var mPresenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)

        mPresenter = HomePresenter(this)
        mPresenter?.initialize()
    }

    /**
     * View methods
     */
    override fun displayEmail(email: String) {
        txtvEmail?.text = email
    }
}