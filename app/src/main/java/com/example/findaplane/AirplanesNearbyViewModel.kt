package com.example.findaplane

import android.app.Application
import androidx.lifecycle.*
import com.example.findaplane.model.Repository
import com.example.findaplane.model.Response
import kotlinx.coroutines.launch

class AirplanesNearbyViewModel():ViewModel(){

    private val _all: MutableLiveData<Response> = MutableLiveData()
    val all: LiveData<Response>
        get(){
            return _all
        }


    fun postAll(lamin:Double, lomin:Double, lamax:Double, lomax:Double)
    {
        viewModelScope.launch {

            val planes= Repository.getAll(lamin, lomin, lamax, lomax)

            if(planes!=null)
                _all.value=planes!!
        }

    }


}