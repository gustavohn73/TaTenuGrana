package org.totschnig.myexpenses.firebase

import org.totschnig.myexpenses.sync.DatabaseProvider

class FirebaseProvider : DatabaseProvider {
    private var isInitialized = false

    override fun initialize(config: Map<String, String>): Boolean {
        // Validação básica - Firebase será inicializado quando usuário configurar
        isInitialized = config.containsKey("apiKey") &&
                config.containsKey("projectId") &&
                config.containsKey("appId")
        return isInitialized
    }

    override fun isConnected(): Boolean = isInitialized

    override fun getProviderName(): String = "Firebase"
}