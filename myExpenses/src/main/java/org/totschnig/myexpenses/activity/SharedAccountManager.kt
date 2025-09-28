package org.totschnig.myexpenses.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

class SharedAccountManager private constructor() {
    
    companion object {
        @Volatile
        private var INSTANCE: SharedAccountManager? = null
        
        fun getInstance(): SharedAccountManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: SharedAccountManager().also { INSTANCE = it }
            }
        }
    }
    
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    
    fun createSharedAccount(accountId: String, accountName: String, ownerId: String) {
        val sharedAccount = hashMapOf(
            "account_name" to accountName,
            "owner_id" to ownerId,
            "participants" to listOf(ownerId),
            "permissions" to hashMapOf(ownerId to "owner"),
            "sync_status" to "active",
            "created_at" to Timestamp.now()
        )
        
        db.collection("shared_accounts")
            .document(accountId)
            .set(sharedAccount)
    }
    
    fun addParticipant(accountId: String, userEmail: String, permission: String) {
        // TODO: Implementar lógica de adicionar participante
    }
    
    fun removeParticipant(accountId: String, userId: String) {
        // TODO: Implementar lógica de remover participante
    }
}