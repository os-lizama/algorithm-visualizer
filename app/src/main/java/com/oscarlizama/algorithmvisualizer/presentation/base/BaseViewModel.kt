package com.oscarlizama.algorithmvisualizer.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscarlizama.algorithmvisualizer.presentation.util.NavEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    var baseEvent = MutableSharedFlow<Any>()

    fun emitBaseEvent(data: Any) {
        viewModelScope.launch {
            baseEvent.emit(data)
        }
    }

    /**
     * Use this val to store one time events defined in NavigationEvent Class
     **/
    private val navigationEvent = MutableSharedFlow<NavEvent>()

    private fun sendNavigationEvent(event: NavEvent) {
        viewModelScope.launch {
            navigationEvent.emit(event)
        }
    }

    /**
     * Use this function to navigate to specified screen
     **/
    fun navigateTo(route: String) = sendNavigationEvent(NavEvent.Navigate(route = route))

    fun navigateBack(popTo: String) =
        sendNavigationEvent(NavEvent.PopBackStack(popTo = popTo))

    fun popAndNavigateTo(route: String, popTo: String) =
        sendNavigationEvent(NavEvent.PopAndNavigateTo(route = route, popTo = popTo))

    fun executeNavigation(
        onNavigate: (NavEvent.Navigate) -> Unit = {},
        onPopBackStack: (NavEvent.PopBackStack) -> Unit = {},
        onPopAndNavigateTo: (NavEvent.PopAndNavigateTo) -> Unit = {}
    ) {
        viewModelScope.launch {
            navigationEvent.collectLatest { event ->
                when (event) {
                    is NavEvent.PopBackStack -> onPopBackStack(event)
                    is NavEvent.Navigate -> onNavigate(event)
                    is NavEvent.PopAndNavigateTo -> onPopAndNavigateTo(event)
                }
            }
        }
    }

}