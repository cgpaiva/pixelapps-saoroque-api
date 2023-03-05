package br.com.pixelapps.saoroque.service

import br.com.pixelapps.saoroque.model.Liturgia
import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service

@Service
class LiturgiaService() {

    fun getLiturgia(): Liturgia {
        val firestore = FirestoreClient.getFirestore()
        val query = firestore.collection("liturgiaDiaria").document("21-02-2023").get().get()
        return query.toObject(Liturgia::class.java)!!
    }
}