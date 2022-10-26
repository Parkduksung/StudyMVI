package com.example.core_datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class TestDataStoreImpl @Inject constructor(@ApplicationContext private val context: Context) :
    TestDataStore {

    private val Context.dataStore by preferencesDataStore(name = "textStore")

    private val testStringKey = stringPreferencesKey("textKey")

    override val text: Flow<String> =
        context.dataStore.data.catch { exception ->
            when (exception) {
                is IOException -> {
                    emit(emptyPreferences())
                }

                else -> throw exception
            }
        }.map { preferences ->
            preferences[testStringKey].orEmpty()
        }

    override suspend fun updateTestString(text: String){
        context.dataStore.edit {  preferences ->
            preferences[testStringKey] = text
        }
    }
}