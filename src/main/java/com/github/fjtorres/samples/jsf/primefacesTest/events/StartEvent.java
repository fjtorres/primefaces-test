package com.github.fjtorres.samples.jsf.primefacesTest.events;

import org.springframework.context.ApplicationEvent;

/**
 * Event to launch when start process.
 * 
 * @author fjtorres
 *
 */
public class StartEvent extends ApplicationEvent {

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
   public StartEvent(Object pSource) {
      super(pSource);
   }
}