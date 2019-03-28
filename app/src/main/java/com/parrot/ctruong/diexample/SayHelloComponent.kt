package com.parrot.ctruong.diexample

import dagger.Component

@Component(modules = [SayHelloPresenterModule::class])
interface SayHelloComponent {

    fun inject(activity: MainActivity)
}