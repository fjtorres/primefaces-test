package com.github.fjtorres.samples.jsf.primefacesTest.events.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.github.fjtorres.samples.jsf.primefacesTest.AppContext;
import com.github.fjtorres.samples.jsf.primefacesTest.events.EndEvent;
import com.github.fjtorres.samples.jsf.primefacesTest.events.StartEvent;

@Component
public class CustomEventListener implements ApplicationListener<ApplicationEvent> {

   private final AppContext appContext;
   
   @Autowired
   public CustomEventListener(AppContext pAppContext) {
      this.appContext = pAppContext;
   }
   
   @Override
   public void onApplicationEvent(ApplicationEvent pEvent) {
   
       if (pEvent instanceof StartEvent) {
          appContext.setRunning(true);
       } else if (pEvent instanceof EndEvent) {
          appContext.setRunning(false);
       }
      
   }
}
