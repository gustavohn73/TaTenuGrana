package org.totschnig.myexpenses.sync

interface DatabaseProvider {
    fun initialize(config: Map<String, String>): Boolean
    fun isConnected(): Boolean
    fun getProviderName(): String
}

object DatabaseProviderFactory {
    private val providers = mutableMapOf<String, DatabaseProvider>()

    fun registerProvider(name: String, provider: DatabaseProvider) {
        providers[name] = provider
    }

    fun getProvider(name: String): DatabaseProvider? = providers[name]

    fun getAvailableProviders(): List<String> = providers.keys.toList()
}