package br.com.devinvestidor.notification.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateSent;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @Enumerated(EnumType.STRING)
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Enumerated(EnumType.STRING)
    private StatusNotification statusNotification;


    public Log(){}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Date getDateSent() {return dateSent;}

    public void setDateSent(Date dateSent) {this.dateSent = dateSent;}

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}

    public Channel getChannel() {return channel;}

    public void setChannel(Channel channel) {this.channel = channel;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public StatusNotification getStatusNotification(){return statusNotification;}

    public void setStatusNotification(StatusNotification statusNotification) {this.statusNotification = statusNotification;}
}
