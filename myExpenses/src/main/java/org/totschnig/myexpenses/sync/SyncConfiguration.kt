package org.totschnig.myexpenses.sync

import android.content.Context
import android.content.SharedPreferences

class SyncConfiguration(private val context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("sync_config", Context.MODE_PRIVATE)

    fun setDatabaseProvider(providerName: String, config: Map<String, String>) {
        prefs.edit().apply {
            putString("provider_name", providerName)
            config.forEach { (key, value) ->
                putString("config_$key", value)
            }
            apply()
        }
    }

    fun getCurrentProvider(): DatabaseProvider? {
        val providerName = prefs.getString("provider_name", null) ?: return null
        val provider = DatabaseProviderFactory.getProvider(providerName) ?: return null

        val config = mutableMapOf<String, String>()
        prefs.all.forEach { (key, value) ->
            if (key.startsWith("config_") && value is String) {
                config[key.removePrefix("config_")] = value
            }
        }

        return if (provider.initialize(config)) provider else null
    }

    fun clearConfiguration() {
        prefs.edit().clear().apply()
    }
}