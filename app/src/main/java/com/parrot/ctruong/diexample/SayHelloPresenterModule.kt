package com.parrot.ctruong.diexample

import dagger.Module
import dagger.Provides

@Module
class SayHelloPresenterModule(val view: SayHelloContract.View, val person: Person) {

    @Provides fun provideSayHelloContractView(): SayHelloContract.View = view
    @Provides fun providePerson(): Person = person
}