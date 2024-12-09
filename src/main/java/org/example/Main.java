package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }

    static FirebaseApp initializeFirebaseApp(GoogleCredentials credentials) throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
               // .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            System.out.println("Firebase application initialized");
            return FirebaseApp.initializeApp(options);
        }

        // return FirebaseApp.getApps().getFirst();
        return null;
    }

    public static GoogleCredentials getGoogleCredentials() throws JSONException, IOException {
        JSONObject json = new JSONObject();
        json.put("type", "");
        json.put("project_id", "");
        json.put("private_key_id", "");
        json.put("private_key", "");
        json.put("client_email", "");
        json.put("client_id", "");
        json.put("auth_uri", "");
        json.put("token_uri", "");
        json.put("auth_provider_x509_cert_url", "");
        json.put("client_x509_cert_url", "");
        json.put("universe_domain", "");

        String str = json.toString();
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return GoogleCredentials.fromStream(is);
    }

    public static void main(String[] args) {
        try {
            FirebaseApp app = initializeFirebaseApp(getGoogleCredentials());
            FirebaseMessaging fcm = firebaseMessaging(app);

            // This registration token comes from the client FCM SDKs.
            String registrationToken = "dnfRyZC0oiOoAS0xyMxnLF:APA91bGs6W5vDhaMZqQX3n1GZFwPGUEJiUi0sVC5hffXMItw8958ldrsHE7IMyrLVNuP6v2eDLNn1gFBKolyOPgNRQ79msH55Vu_Us42Eavl2vTVVBQBNyA";

            // See documentation on defining a message payload.
            Message message = Message.builder()
                    .putData("score", "850")
                    .putData("time", "2:45")
                    .setToken(registrationToken)
                    .build();

            // Send a message to the device corresponding to the provided
            // registration token.
            String response = fcm.send(message);
            // Response is a message ID string.
            System.out.println("Successfully sent message: " + response);


        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }


    }
}