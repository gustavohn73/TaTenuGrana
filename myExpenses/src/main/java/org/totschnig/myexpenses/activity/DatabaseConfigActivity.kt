package org.totschnig.myexpenses.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.totschnig.myexpenses.sync.DatabaseProviderFactory
import org.totschnig.myexpenses.sync.SyncConfiguration

class DatabaseConfigActivity : AppCompatActivity() {
    private lateinit var syncConfig: SyncConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        syncConfig = SyncConfiguration(this)

        // UI para configurar provedores de banco
        setupProviderSelection()
    }

    private fun setupProviderSelection() {
        val availableProviders = DatabaseProviderFactory.getAvailableProviders()
        // Criar interface para seleção e configuração
    }

    private fun configureFirebase() {
        // Campos: API Key, Project ID, App ID
        val config = mapOf(
            "apiKey" to "sua-api-key",
            "projectId" to "seu-project-id",
            "appId" to "seu-app-id"
        )
        syncConfig.setDatabaseProvider("Firebase", config)
    }
}