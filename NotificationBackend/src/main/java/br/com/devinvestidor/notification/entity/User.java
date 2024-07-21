package br.com.devinvestidor.notification.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "app_user_category",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categoryList;

    @ElementCollection(targetClass = Channel.class)
    @Enumerated(EnumType.STRING)
    private List<Channel> channelList;

    public User(){}

    public User(Long id, String name, String email, String phoneNumber, List<Category> categoryList, List<Channel> channelList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.categoryList = categoryList;
        this.channelList = channelList;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public List<Category> getCategoryList() {return categoryList;}

    public void setCategoryList(List<Category> categoryList) {this.categoryList = categoryList; }

    public List<Channel> getNotificationChannelList() {return channelList;}

    public void setNotificationChannelList(List<Channel> channelList) {this.channelList = channelList;}

    public boolean hasPhoneNumber() {
        return getPhoneNumber() != null;
    }

    public boolean hasNotPhoneNumber() {
        return !hasPhoneNumber();
    }

    public boolean hasEmail() {
        return getEmail() != null;
    }

    public boolean hasNotEmail() {
        return !hasNotEmail();
    }
}