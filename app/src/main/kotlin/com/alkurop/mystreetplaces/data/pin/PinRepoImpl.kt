package com.alkurop.mystreetplaces.data.pin

import com.alkurop.mystreetplaces.domain.pin.PinDto
import com.alkurop.mystreetplaces.utils.LocationUtils
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import java.util.*

class PinRepoImpl(val pinCahe: PinCahe) : PinRepo {

    val locationUpdatedBus = PublishSubject.create<Any>()

    override fun addOrUpdatePin(pin: PinDto): Single<PinDto> {
        if (pin.id == null) pin.id = UUID.randomUUID().toString()
        return pinCahe.addOrUpdatePin(pin)
                .doOnSuccess { notifyListeners() }
    }

    override fun removePin(pin: PinDto): Single<PinDto> {
        return pinCahe.removePin(pin)
                .doOnSuccess { notifyListeners() }
    }

    fun notifyListeners() {
        locationUpdatedBus.onNext(Any())
    }

    override fun observePinsByLocationAndRadius(location: LatLng, radiusMeters: Int): Observable<Array<PinDto>> {
        val minMaxPoints = LocationUtils.getSquareOfDistanceMeters(location, radiusMeters)
        return locationUpdatedBus
                .startWith(Any())
                .switchMapSingle { pinCahe.getPinsByLocationSquare(minMaxPoints) }

    }

}