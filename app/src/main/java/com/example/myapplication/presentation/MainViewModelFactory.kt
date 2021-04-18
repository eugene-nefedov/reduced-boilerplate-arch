package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.cache.CachedPersonToPersonMapper
import com.example.myapplication.cache.InMemoryPersonCache
import com.example.myapplication.data.CachingNetworkPersonRepository
import com.example.myapplication.domain.GetPersonFromRepository
import com.example.myapplication.remote.PersonNetworkResponseMapper
import com.example.myapplication.remote.StubPersonNetworkApi

class MainViewModelFactory : ViewModelProvider.Factory {

    private val inMemoryPersonCache = InMemoryPersonCache()
    private val cachedPersonToPersonMapper = CachedPersonToPersonMapper()

    private val stubPersonNetworkApi = StubPersonNetworkApi()
    private val personNetworkResponseMapper = PersonNetworkResponseMapper()

    private val cachingNetworkPersonRepository = CachingNetworkPersonRepository(
        cache = inMemoryPersonCache,
        cacheMapper = cachedPersonToPersonMapper,
        networkApi = stubPersonNetworkApi,
        networkApiMapper = personNetworkResponseMapper,
    )

    private val getPersonFromRepository = GetPersonFromRepository(repository = cachingNetworkPersonRepository)

    override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM {
        return MainViewModel(
            getPerson = getPersonFromRepository,
        ) as VM
    }
}
