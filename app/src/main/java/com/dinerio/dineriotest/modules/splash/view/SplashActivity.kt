package com.dinerio.dineriotest.modules.splash.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.dinerio.dineriotest.R
import com.dinerio.dineriotest.modules.home.view.HomeActivity
import com.dinerio.dineriotest.modules.login.view.LoginActivity
import com.dinerio.dineriotest.modules.splash.Presenter
import com.dinerio.dineriotest.modules.splash.View
import com.dinerio.dineriotest.modules.splash.presenter.SplashPresenter
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.request.ImageRequestBuilder

/**
 * Created by JC on 23/08/2017.
 */
class SplashActivity: AppCompatActivity(), View {
    @JvmField @BindView(R.id.imgv_logo)
    var imgvLogo: SimpleDraweeView? = null

    private var mPresenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ButterKnife.bind(this)

        mPresenter = SplashPresenter(this)

        val imageRequest = ImageRequestBuilder
                .newBuilderWithResourceId(R.drawable.dinerio)
                .build()
        imgvLogo?.setImageURI(imageRequest.sourceUri.toString())

        mPresenter?.initialize()
    }

    /**
     * View methods
     */
    override fun launchHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun launchLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}