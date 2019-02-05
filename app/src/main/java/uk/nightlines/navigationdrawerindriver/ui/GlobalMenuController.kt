package uk.nightlines.navigationdrawerindriver.ui

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable

class GlobalMenuController {
    private val stateRelay = PublishRelay.create<Boolean>()

    val state: Observable<Boolean> = stateRelay
    fun open() = stateRelay.accept(true)
    fun close() = stateRelay.accept(false)
}