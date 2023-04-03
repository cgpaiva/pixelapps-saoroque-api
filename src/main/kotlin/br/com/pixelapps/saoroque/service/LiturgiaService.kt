package br.com.pixelapps.saoroque.service

import br.com.pixelapps.saoroque.model.Liturgia
import br.com.pixelapps.saoroque.model.ParoquiaInfo
import br.com.pixelapps.saoroque.model.SaoRoqueHome
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class LiturgiaService() {

    ///// "21-02-2023"
    fun getHomeInformations(dataLiturgia: String): ResponseEntity<SaoRoqueHome> {
        val firestore = FirestoreClient.getFirestore()
        val query = firestore.collection("liturgiaDiaria").document(dataLiturgia).get().get()
        val queryInfo = firestore.collection("info").document("paroquia-info").get().get()

        return if (query.exists() || queryInfo.exists()) {

            val home = SaoRoqueHome(liturgia = query.toObject(Liturgia::class.java)!!, info = queryInfo.toObject(ParoquiaInfo::class.java)!!)

            ResponseEntity.ok(home)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    fun addLiturgia(liturgia: Liturgia, dataLiturgia: String) {
        val firestore = FirestoreClient.getFirestore().collection("liturgiaDiaria")
        val future: ApiFuture<WriteResult> = firestore.document("cavalo").set(liturgia)

        try {
            System.out.println("Documento adicionado com sucesso! ID do documento: " + future.get().updateTime);
        } catch (e: Exception) {
            System.out.println("Erro ao adicionar documento: " + e.localizedMessage);
        }
    }
}