package org.totschnig.myexpenses.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class ShareAccountActivity : Activity() {
    
    private var accountId: Long = -1
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Pegar ID da conta dos extras
        accountId = intent.getLongExtra("account_id", -1)
        
        if (accountId == -1L) {
            Toast.makeText(this, "Erro: conta não encontrada", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        
        // Por enquanto, mostrar toast
        Toast.makeText(this, "Compartilhamento da conta ID: $accountId - Em desenvolvimento", 
                       Toast.LENGTH_LONG).show()
        
        finish() // Fecha a activity por enquanto
    }
    
    private fun shareAccount(userEmail: String) {
        // TODO: Implementar lógica de compartilhamento
        // SharedAccountManager.getInstance().createSharedAccount(...)
    }
}