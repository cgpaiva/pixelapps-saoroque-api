package br.com.pixelapps.saoroque

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader
import java.io.FileInputStream

@Configuration
class FirebaseConfiguration {

    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    @Bean
    fun firebase() : FirebaseApp {
        val serviceAccount = resourceLoader.getResource("classpath:static/pixel_config.json")
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount.inputStream))
            .setProjectId("pixel-apps-paroquia-sao-roque")
            .build()

       return FirebaseApp.initializeApp(options)
    }
}