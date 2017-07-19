package com.cvillaseca.spotifykt.data.store.cache

import android.content.SharedPreferences
import com.google.gson.Gson
import com.cvillaseca.spotifykt.data.entity.Token
import javax.inject.Inject


class RealmTokenCache @Inject
constructor(private val sharedPreferences: SharedPreferences) : TokenCache {

    override fun getToken(): Token? {
        val tokenGson = sharedPreferences.getString("token", null)
        val gson = Gson()
        return gson.fromJson(tokenGson, Token::class.java)
    }

    override fun saveToken(token: Token) {
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val jsonToken = gson.toJson(token)

        editor.putString("token", jsonToken)
        editor.commit()
    }
}