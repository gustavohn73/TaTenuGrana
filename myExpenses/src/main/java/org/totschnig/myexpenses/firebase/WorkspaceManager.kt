package org.totschnig.myexpenses.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

class WorkspaceManager private constructor() {
    
    companion object {
        @Volatile
        private var INSTANCE: WorkspaceManager? = null
        
        fun getInstance(): WorkspaceManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: WorkspaceManager().also { INSTANCE = it }
            }
        }
    }
    
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    
    fun createPersonalWorkspace(userId: String) {
        val workspace = hashMapOf(
            "personal_workspace" to hashMapOf(
                "accounts" to emptyMap<String, Any>(),
                "transactions" to emptyMap<String, Any>(),
                "categories" to emptyMap<String, Any>(),
                "payees" to emptyMap<String, Any>()
            ),
            "shared_accounts" to emptyList<String>(),
            "server_config" to null,
            "sync_enabled" to false,
            "created_at" to Timestamp.now()
        )
        
        db.collection("users")
            .document(userId)
            .set(workspace)
    }
    
    fun syncToPersonalWorkspace(userId: String, collection: String, documentId: String, data: Map<String, Any>) {
        val workspaceRef = db.collection("users").document(userId)
        val path = "personal_workspace.$collection.$documentId"
        workspaceRef.update(path, data)
    }
    
    fun enableSync(userId: String, firebaseConfig: String) {
        db.collection("users")
            .document(userId)
            .update(
                "sync_enabled", true,
                "server_config", firebaseConfig
            )
    }
}