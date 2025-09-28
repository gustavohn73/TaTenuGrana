package org.totschnig.myexpenses.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth
import org.totschnig.myexpenses.model.Account
import org.totschnig.myexpenses.model.Transaction

class FirebaseSync private constructor() {
    
    companion object {
        @Volatile
        private var INSTANCE: FirebaseSync? = null
        
        fun getInstance(): FirebaseSync {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: FirebaseSync().also { INSTANCE = it }
            }
        }
    }
    
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var syncEnabled: Boolean = false
    
    fun enableSync(firebaseConfig: String) {
        // TODO: Configurar Firebase com config fornecida
        syncEnabled = true
    }
    
    fun syncTransaction(transaction: Transaction) {
        if (!syncEnabled) return
        
        // TODO: Lógica de sincronização
        // Se conta pessoal -> workspace pessoal
        // Se conta compartilhada -> shared_accounts
    }
    
    fun isEnabled(): Boolean = syncEnabled
}