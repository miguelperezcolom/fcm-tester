package com.example.fcmtester;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import io.mateu.mdd.core.annotations.MateuUI;
import io.mateu.mdd.shared.annotations.Action;
import io.mateu.mdd.shared.annotations.Caption;
import io.mateu.util.notification.Notifier;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@MateuUI(path = "")
@Getter@Setter
@Caption("Firebase Cloud Messaging tester")
public class FCMForm {

    private String token = "fPG6m6XnW4WZw8iy-XELaW:APA91bGzehiQD9HEqnz99VjFlUaJHe9I5FEGbn-IupGNq6U4t7LeNeuRYhojfhCxiFMVbYBVwk8IpGuPTr8BQlHEpCsICES0MqpZKZUjfc7Z6R0KXsFTebHLNjFy4Ws_ozG4cgnCgqYB";

    private String VAPID = "BGVoGd9MNzhlSADscWhsh18ijPsNEZDHLwPyhh2WQfLDqa7KBfkJW1Cw3TiGaeHoZtliHgJT8N3G6cIcKdhYe30";

    @NotEmpty
    private String imageUrl = "https://mateu.io/logomateu.png";

    @NotEmpty
    private String title = "Mensaje de prueba";

    @NotEmpty
    private String body = "Este es el body";


    @Action
    public void send() throws FirebaseMessagingException {

        // This registration token comes from the client FCM SDKs.
        String registrationToken = token;

        Notification notification = Notification.builder()
                .setTitle(title)
                .setBody(body)
                .setImage(imageUrl)
                .build();

// See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("aaa", title)
                .putData("bbb", body)
                .setNotification(notification)
                .setToken(registrationToken)
                .build();

// Send a message to the device corresponding to the provided
// registration token.
        String response = FirebaseMessaging.getInstance().send(message);
// Response is a message ID string.
        Notifier.info("Successfully sent message: " + response);

    }

}
