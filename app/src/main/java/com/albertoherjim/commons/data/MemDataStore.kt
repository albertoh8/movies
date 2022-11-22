package com.albertoherjim.commons.data

import com.albertoherjim.movies.domain.Film

class MemDataStore<M> {

    private val dataStore: MutableMap<String, M> = mutableMapOf()

    fun put(id: String, model: M) {
        dataStore.put(id, model)
    }

    fun get(id: String) = dataStore[id]


}