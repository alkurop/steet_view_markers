package com.alkurop.mystreetplaces.di.components

import com.alkurop.mystreetplaces.di.annotations.PerActivity
import com.alkurop.mystreetplaces.di.modules.ActivityModule
import com.alkurop.mystreetplaces.ui.home.MainActivity
import com.alkurop.mystreetplaces.ui.street.StreetActivity
import dagger.Subcomponent

/** Injects activities.  */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: MainActivity)

    fun inject(activity: StreetActivity)
}

