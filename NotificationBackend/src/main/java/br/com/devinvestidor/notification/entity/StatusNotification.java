package br.com.devinvestidor.notification.entity;

public enum StatusNotification {
    OK("Sent with success"),
    ERROR("Error sending");

    private String description;

    StatusNotification(String description) {
        this.description = description;
    }

    public String getDescription() {return description; }
}
