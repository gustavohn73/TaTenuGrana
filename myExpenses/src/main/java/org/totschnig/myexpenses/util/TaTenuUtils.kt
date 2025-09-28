package org.totschnig.myexpenses.util

import org.json.JSONObject
import org.json.JSONException

object TaTenuUtils {
    
    const val APP_NAME = "Ta Tenu Grana"
    const val ORIGINAL_APP = "MyExpenses"
    const val ORIGINAL_AUTHOR = "Michael Totschnig"
    const val ORIGINAL_REPO = "https://github.com/mtotschnig/MyExpenses"
    
    /**
     * Valida se a string é uma configuração Firebase válida
     */
    fun isValidFirebaseConfig(config: String?): Boolean {
        if (config.isNullOrBlank()) return false
        
        return try {
            val json = JSONObject(config)
            json.has("apiKey") && 
            json.has("authDomain") && 
            json.has("projectId")
        } catch (e: JSONException) {
            false
        }
    }
    
    /**
     * Retorna string de créditos formatada
     */
    fun getCreditsText(): String {
        return "$APP_NAME é baseado no $ORIGINAL_APP " +
               "desenvolvido por $ORIGINAL_AUTHOR\n\n" +
               "Projeto original: $ORIGINAL_REPO\n" +
               "Licença: GPL v3+"
    }
    
    /**
     * Gera ID único para conta compartilhada
     */
    fun generateSharedAccountId(localAccountId: Long, userId: String): String {
        return "shared_${userId}_${localAccountId}_${System.currentTimeMillis()}"
    }
    
    /**
     * Verifica se a conta é compartilhada baseado no ID
     */
    fun isSharedAccount(accountId: String?): Boolean {
        return accountId?.startsWith("shared_") == true
    }
}