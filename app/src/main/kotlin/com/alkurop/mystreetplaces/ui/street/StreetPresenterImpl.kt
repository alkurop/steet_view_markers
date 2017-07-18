package com.alkurop.mystreetplaces.ui.street

import com.alkurop.mystreetplaces.ui.createNavigationSubject
import com.alkurop.mystreetplaces.ui.createViewSubject
import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import io.reactivex.subjects.Subject


class StreetPresenterImpl : StreetPresenter {
    override val viewBus: Subject<StreetViewModel> = createViewSubject()
    override val navBus: Subject<NavigationAction> = createNavigationSubject()

    override fun unsubscribe() {
    }
}