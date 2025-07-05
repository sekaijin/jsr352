package org.jberet.job.model.dsl;

import org.jberet.job.model.Job;
import org.junit.jupiter.api.Test;

public class ApplicationBuilderTest {


    @Test
    public void buildTest(){
        
    }

    public static class MyApp extends ApplicationBuilder {

        @Override
        public Job configure() {
            return job("test")
            .add(step("setp1")
                .batchlet("myBatchlet"))
            .add(step("step2")
                .reader("mockReader")
                .processor("myProcessor")
                .writer("mockWriter"))
            .add(flow("flow1")
                .add(step("step1")))
            .build();
        }        
    }
}
