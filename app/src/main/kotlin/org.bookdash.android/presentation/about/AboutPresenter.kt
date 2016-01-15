package org.bookdash.android.presentation.about


/**
 * @author rebeccafranks
 * *
 * @since 15/11/07.
 */
class AboutPresenter(private val aboutView: AboutContract.View) : AboutContract.UserActions {


    override fun clickLearnMore() {
        aboutView.showLearnMorePage(BOOKDASH_SITE_URL)

    }

    val BOOKDASH_SITE_URL = "http://bookdash.org"

}
