package org.jberet.job.model.dsl;

import org.jberet.job.model.FlowBuilder;
import org.jberet.job.model.Job;
import org.jberet.job.model.JobBuilder;
import org.jberet.job.model.SplitBuilder;
import org.jberet.job.model.StepBuilder;

public abstract class ApplicationBuilder {

    public ApplicationBuilder() {
        super();
    }

    public abstract Job configure();


    public JobBuilder job(String id) {
        return JobBuilder.job(id);
    }

    public FlowBuilder flow(String id) {
        return FlowBuilder.flow(id);
    }

    public StepBuilder step(String id) {
        return StepBuilder.step(id);
    }

    public SplitBuilder split(String id) {
        return SplitBuilder.split(id);
    }


}
