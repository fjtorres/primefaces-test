package com.github.fjtorres.samples.jsf.primefacesTest.mappers;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class KeyValueResultHandler<K, V> implements ResultHandler<Map<String, Object>> {
   
   private final Map<K, V> results = new HashMap<>();
   
   @Override
   @SuppressWarnings("unchecked")
   public void handleResult(ResultContext<? extends Map<String, Object>> pResultContext) {

      Map<String, Object> map = pResultContext.getResultObject();
      
      results.put((K)map.get("key"), (V)map.get("value"));
   }
   
   public Map<K, V> getResults() {
      return results;
   }

}
