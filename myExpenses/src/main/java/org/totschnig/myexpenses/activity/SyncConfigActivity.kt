package org.totschnig.myexpenses.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import org.totschnig.myexpenses.firebase.FirebaseSync

class SyncConfigActivity : Activity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Por enquanto, mostrar toast
        Toast.makeText(this, "Tela de Configuração de Sincronização - Em desenvolvimento", 
                       Toast.LENGTH_LONG).show()
        
        finish() // Fecha a activity por enquanto
    }
    
    private fun saveConfig(config: String, enableSync: Boolean) {
        if (enableSync && config.isNotEmpty()) {
            FirebaseSync.getInstance().enableSync(config)
            Toast.makeText(this, "Sincronização ativada!", Toast.LENGTH_SHORT).show()
        }
        finish()
    }
}