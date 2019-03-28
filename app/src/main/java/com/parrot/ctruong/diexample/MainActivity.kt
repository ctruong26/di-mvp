package com.parrot.ctruong.diexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), SayHelloContract.View {

    @Inject
    lateinit var presenter: SayHelloPresenter

    override fun showMessage(message: String) {
        message_hello.text = message
    }

    override fun showError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerSayHelloComponent.builder().sayHelloPresenterModule(SayHelloPresenterModule(this, Person())).build()
            .inject(this)
        showMessage.apply {
            setOnClickListener {
                presenter.loadMessage()
            }
        }
        update.setOnClickListener {
            presenter.saveName(firstName.text.toString(), lastName.text.toString())
        }
    }
}
