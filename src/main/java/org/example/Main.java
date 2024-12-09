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
        json.put("type", "service_account");
        json.put("project_id", "test-only-1cba0");
        json.put("private_key_id", "50bf31e66131af180b6ecc4bbceee74f163a7837");
        json.put("private_key", "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChzFZl8uCGPIBh\n5+7BQ/3YOSGD5xMAK1XB8se9gCxZdNuxngDFg/db/5W2WLYc2NFaKW6qS0TbhmGw\nE63ypKn5E/zgJbMRm84Ttff4WMPjYS36fSdkmgtD+j4N9Zbfb/2VluuuQduFH+yV\nhuP2ADyQzxRbzlGvVUyRBRxbBL3W6uW0z9/6iWyeMKySIJFcsTZ2l5zxyt8yw/Ce\nHVV9dImtep4qn0amFXsoSXEPtgc/Tc0xW32t7FkbyLvD14P2t2mVMqwTowf/IDx6\n9mzbBgjNGwj94vKLF4L9VjhFxee/pevPgf8t0RQgKYyEQEeFJidmmkR11Y8bzE2d\nvQD/fxATAgMBAAECggEAMauALoX0JWF3bBb+dbhAuls3jb2nWJr1FbhJV0R82O2F\n8C34QKp1inmY5USwi4SIKGylu4Ol3NqRLLOt59pjD8LyE4GfSl2RUv2+5S+i2y/f\nJJG9QSYFJVYyLKjjKy6/I2gUbAdts52MTI7/dmq2LSJVNqXM78141uBBxzNacBpp\nC6Hb9vIzgVQAJKBOYLaYkSC0qOdVpbBxXt6o0GfizSkzpeZrJgqUwqtmM67AaLFL\ni6c7PcsarPOE44eaLs3XrTJhVrM9cgupXjZs//pT7isgLl9kS3y5Mz8UQcDXXmEV\nxeCIH5/fwFH17zxf2braxTGTqKNySz0MPzKNpaUEQQKBgQDdOWCdHL3HKh1vwWc+\nJrPFW+RRDGp70uD2KyVE/bo4RI/2hpidWdEoN2rZwUhEkx9UCGqe7q9RffuJ7Oum\n1L/qbbddUB6GsKW0465SpmDdhFrnrBAj8aO3ybgby6uWr6+hGynscJHaHlYGsA3j\nc7ZzQQtBF25lKmG7DNxREOzgcwKBgQC7O4JNRv9w7vxAYgRSa/d++i+0Xg3DKaeR\nXjCaPRGuK1f/Qkb039V8Nx5HGqd6BiIgsEd/mC7jGNSJ5BjzGjRjl8kY4BbIHRTh\n/GQ4aHENMpjIPkWL0uo8RSKqn0TqgHOmS11hFKmy3Cc+z+eidDgAzBb5XV74YsxQ\neQwxjT9J4QKBgEncU1aBdxddB1D9uLO2hkT5hkRNKexHnxZxl1Luh9MriQldLO00\nRLHxtroXX0KOAGK1IKwJsv05W9dUA+XCmITztsnv6xE7P0gi0FwF8sdi3lsFRqpJ\njkjZj5+wI4z/AVt/z0KC3x99C2nWM/zh8GOQruo/oXsjaFfkVla2mO/jAoGAVOyT\nF7YiWvkrVZCf4TqzkdatGKSonWMhbGBKr0sP3+4tBczsHloAnUzq4NmIKWLqy+Tp\nKUi/y6YRkVHytyGlrZ7FShEqhC4csLwoQSWuUYwnnHwSU2+hayD4rmd7fNoymrUI\nb+ZNaqFM88KdkCQi2sm3iff+Aa/eeInPLBKjKEECgYACgrLuV5/F9IfAi7YXrouV\nYeNq1OMVPqnLJWT72336n1WaKwT3N4QZd6AaQglvIF5XAumoEig+It+iFfKMQtmy\nWvhTj92NhLQprqGMFW8tWLxuS/1BoqsNIUbFXwAa/2u/e70eCipdnpjqZ6OvNO1t\n5uhtHQ8feLsolgPIMbxFaw==\n-----END PRIVATE KEY-----\n");
        json.put("client_email", "firebase-adminsdk-ykfls@test-only-1cba0.iam.gserviceaccount.com");
        json.put("client_id", "117440949407988503398");
        json.put("auth_uri", "https://accounts.google.com/o/oauth2/auth");
        json.put("token_uri", "https://oauth2.googleapis.com/token");
        json.put("auth_provider_x509_cert_url", "https://www.googleapis.com/oauth2/v1/certs");
        json.put("client_x509_cert_url", "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-ykfls%40test-only-1cba0.iam.gserviceaccount.com");
        json.put("universe_domain", "googleapis.com");

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