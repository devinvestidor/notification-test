package br.com.devinvestidor.notification.entity;

public enum Channel {
    SMS("Sms"),
    EMAIL("Finance"),
    PUSH_NOTIFICATION("Push Notification");
    private String description;

    Channel(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }
}
