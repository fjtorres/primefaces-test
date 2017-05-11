package com.github.fjtorres.samples.jsf.primefacesTest.events;

import org.springframework.context.ApplicationEvent;

/**
 * Event to launch when end process.
 * 
 * @author fjtorres
 *
 */
public class EndEvent extends ApplicationEvent {

   /**
    * Serial.
    */
   private static final long serialVersionUID = 1L;

   /**
    * Constructor.
    * 
    * @param pSource
    *           Source of the event.
    */
   public EndEvent(Object pSource) {
      super(pSource);
   }
}
