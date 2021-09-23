package com.gr.android.ex_coroutines.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class CoroutinesRepository {

    //    vai no servidor e retorna username
//    suspend pois sera chamada futuramente de um contexto de coroutines -> quem chamar se preocupa
//    em dizer qual escopo rodara
    suspend fun fetchUserData() : String {
//    simular chamada ao servidor - assincrona
        return withContext(Dispatchers.IO) {
            delay(2000L)
            "Carlos Eduardo"
        }
    }
}