package org.bookdash.android.presentation.about


interface AboutContract {
    interface View {
        fun showLearnMorePage(url :String)
    }
    interface UserActions{
        fun clickLearnMore()
    }
}