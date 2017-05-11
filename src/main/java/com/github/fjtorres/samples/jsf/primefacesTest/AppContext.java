package com.github.fjtorres.samples.jsf.primefacesTest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("appContext")
@Scope("singleton")
public class AppContext {

   private boolean running;
   
   public void setRunning(boolean pRunning) {
      running = pRunning;
   }
   
   public boolean isRunning() {
      return running;
   }
}
