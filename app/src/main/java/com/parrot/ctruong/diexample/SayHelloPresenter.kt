package com.parrot.ctruong.diexample

import android.util.Log
import javax.inject.Inject

class SayHelloPresenter @Inject constructor(val person: Person, val view: SayHelloContract.View): SayHelloContract.Presenter {

    override fun loadMessage() {
        if (person.firstName == "" || person.lastName == "")
            view.showError("No person found")
        else
            view.showMessage("${person.firstName} ${person.lastName}")
    }

    override fun saveName(firstName: String, lastName: String) {
        person.firstName = firstName
        person.lastName = lastName
        Log.i(TAG, "firstName$firstName")
    }

    companion object {
        private val TAG: String?
            get() = SayHelloPresenter::class.java.canonicalName
    }

}