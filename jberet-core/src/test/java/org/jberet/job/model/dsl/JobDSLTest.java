package org.jberet.job.model.dsl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jberet.job.model.Job;
import org.jberet.job.model.Properties;
import org.jberet.job.model.Step;
import org.jberet.job.model.dsl.JobDSL;
import org.junit.jupiter.api.Test;

public class JobDSLTest
{

   @Test
   public void simpleTest() throws Exception{

      var app = new MyApp();
      var job = app.build();
      assertEquals("test", job.getId());
      var els = job.getJobElements();
      
      assertEquals("Step", els.get(0).getClass().getSimpleName());
      assertEquals("setp1", els.get(0).getId());
      var ref = Step.class.cast(els.get(0)).getBatchlet();
      assertEquals("simpleBatchlet", ref.getRef());
      assertEquals("{}", Properties.toJavaUtilProperties(ref.getProperties()).toString());
   }

   public static class MyApp extends JobDSL
   {

      /*
         <job id="test">
             <step id="setp1" >
                 <batchlet ref="simpleBatchlet"/>
             </step>
         </job>
       */
      @Override
      public Job build(){
         return job("test")
            .add(step("setp1")
               .batchlet("simpleBatchlet")
            ).build();
      }
   }
}
