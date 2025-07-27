package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  Observer -> Notifies Multiple Objects of an Object State Changes.
                     --> Think it of as New Agency , Having Many Subscribers ( Mobile & Email Subscribers ) Updating them about Latest News.
*/

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String args[]){
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Observer");
        NewAgency newAgency = new NewAgency("Aaj-Tak");
        NewUpdate emailSubscriber = new EmailSubscriber("vk2830678@gmail.com");
        NewUpdate emailSubscriber2 = new EmailSubscriber("vinod3535chandani@gmail.com");
        NewUpdate smsSubscriber = new SMSSubscriber("9694998126");
        NewUpdate smsSubscriber2 = new SMSSubscriber("9079292343");
        newAgency.add(emailSubscriber);
        newAgency.add(emailSubscriber2);
        newAgency.add(smsSubscriber);
        newAgency.add(smsSubscriber2);
        newAgency.setNews("High-Taxation Rates Introdues by Nirmala Sitharaman in India");
        newAgency.update(newAgency.getNews());
        System.out.println();
        newAgency.setNews("Time to teach lesson to Delhi parties, says KTR");
        newAgency.update(newAgency.getNews());

    }
}

// Behavioural Design Patterns -> Observer
interface NewUpdate {
    public void update(String news);
}

class EmailSubscriber implements NewUpdate {
    private String email;

    public EmailSubscriber(String email){
        this.email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("Latest New updated to EmailSubscriber with Email : "+this.email);
    }
}

class SMSSubscriber implements NewUpdate {

    private String mobile;

    public SMSSubscriber(String mobile){
        this.mobile = mobile;
    }

    @Override
    public void update(String news) {
        System.out.println("Latest New updated to SMSSubscriber with Mobile Number : "+this.mobile);
    }
}

class NewAgency implements NewUpdate{
    private String news;
    private String agencyName;
    private List<NewUpdate> subscriberList = new ArrayList<>();

    public NewAgency(String agencyName){
        this.agencyName = agencyName;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public List<NewUpdate> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<NewUpdate> subscriberList) {
        this.subscriberList = subscriberList;
    }

    @Override
    public void update(String news) {
        System.out.println("New Agency : "+this.getAgencyName());
        System.out.println("Latest news : "+this.getNews());
        for(NewUpdate newUpdate : subscriberList){
            newUpdate.update(news);
        }
    }

    public void add(NewUpdate newUpdate) {
        subscriberList.add(newUpdate);
    }

}

