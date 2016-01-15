package org.bookdash.android.presentation.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.Html
import android.text.util.Linkify
import android.widget.Button
import android.widget.TextView
import org.bookdash.android.R
import org.bookdash.android.presentation.activity.BaseAppCompatActivity


class AboutActivity : BaseAppCompatActivity(), AboutContract.View {

    private var aboutPresenter: AboutPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        aboutPresenter = AboutPresenter(this)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setTitle(R.string.about_heading)
        }

        val textViewWhyBookDash = findViewById(R.id.text_why_bookdash) as TextView
        textViewWhyBookDash.text = Html.fromHtml(getString(R.string.why_bookdash))
        Linkify.addLinks(textViewWhyBookDash, Linkify.ALL)

        val textViewHeading = findViewById(R.id.text_view_about) as TextView
        textViewHeading.text = Html.fromHtml(getString(R.string.heading_about))
        Linkify.addLinks(textViewHeading, Linkify.ALL)

        val learnMoreBookDash = findViewById(R.id.button_learn_more) as Button
        learnMoreBookDash.setOnClickListener { aboutPresenter!!.clickLearnMore() }


        textViewHeading.findFocus()
    }

    override fun getScreenName(): String {
        return "About Screen"
    }


    override fun showLearnMorePage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
}