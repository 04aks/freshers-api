package aks.freshers.service.firebase;

import java.io.FileInputStream;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import aks.freshers.service.utils.Strings;

public class FirebaseInit {
    private static FirebaseDatabase fb;

    public FirebaseInit(){
        initialize();
    }

    private void initialize(){
        try{
            FileInputStream fis = new FileInputStream(Strings.DB_PATH);

            FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(fis))
            .setDatabaseUrl(Strings.DB_URL)
            .build();

            FirebaseApp.initializeApp(options);
            fb = FirebaseDatabase.getInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static FirebaseDatabase getInstance(){
        return fb;
    }
}
