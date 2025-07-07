package org.jberet.job.model.dsl;

import org.jberet.job.model.DecisionBuilder;
import org.jberet.job.model.FlowBuilder;
import org.jberet.job.model.Job;
import org.jberet.job.model.JobBuilder;
import org.jberet.job.model.SplitBuilder;
import org.jberet.job.model.StepBuilder;

/**
 * Define job using java DSL
 *       
 * <job id="test">
 *   <step id="setp1" >
 *     <batchlet ref="simpleBatchlet"/>
 *   </step>
 * </job>

 *public static class MyApp extends JobDSL
 *{
 *                                                                  
 *  @Override
 *    public Job build(){
 *       return job("test")
 *          .add(
 *             step("setp1")
 *                .batchlet("simpleBatchlet")
 *          )
 *          .build();
 *    }
 *}
 */
public abstract class JobDSL
{

   String name;

   public JobDSL(){
      super();
   }

   public abstract Job build();

   public JobBuilder job(String id){
      name = id;
      return JobBuilder.job(id);
   }

   public FlowBuilder flow(String id){
      return FlowBuilder.flow(id);
   }

   public StepBuilder step(String id){
      return StepBuilder.step(id);
   }

   public SplitBuilder split(String id){
      return SplitBuilder.split(id);
   }

   public DecisionBuilder add (String id, final String deciderRef) {
       return DecisionBuilder.decision(id, deciderRef);
   }

   public String getName(){
      return name;
   }

}
