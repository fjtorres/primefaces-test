package com.github.fjtorres.samples.jsf.primefacesTest.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component("customEventPublisher")
public class CustomEventPublisher implements ApplicationEventPublisherAware {

   private ApplicationEventPublisher publisher;
   
   @Override
   public void setApplicationEventPublisher(ApplicationEventPublisher pApplicationEventPublisher) {
      this.publisher = pApplicationEventPublisher;
   }
   
   public void publish(ApplicationEvent event) {
      publisher.publishEvent(event);
   }
}
