package org.apache.tools.ant.taskdefs.optional.testing;

/* loaded from: classes25.dex */
public class Funtest extends org.apache.tools.ant.Task {
    public static final java.lang.String APPLICATION_EXCEPTION = "Application Exception";
    public static final java.lang.String APPLICATION_FORCIBLY_SHUT_DOWN = "Application forcibly shut down";
    public static final java.lang.String SHUTDOWN_INTERRUPTED = "Shutdown interrupted";
    public static final java.lang.String SKIPPING_TESTS = "Condition failed -skipping tests";
    public static final java.lang.String TEARDOWN_EXCEPTION = "Teardown Exception";
    public static final java.lang.String WARN_OVERRIDING = "Overriding previous definition of ";
    public org.apache.tools.ant.taskdefs.Sequential A;
    public org.apache.tools.ant.taskdefs.Sequential B;
    public long C;
    public java.lang.String G;
    public org.apache.tools.ant.BuildException J;
    public org.apache.tools.ant.BuildException K;
    public org.apache.tools.ant.BuildException L;
    public org.apache.tools.ant.BuildException M;
    public org.apache.tools.ant.taskdefs.optional.testing.Funtest.NestedCondition u;
    public org.apache.tools.ant.taskdefs.Parallel v;
    public org.apache.tools.ant.taskdefs.Sequential w;
    public org.apache.tools.ant.taskdefs.Sequential x;
    public org.apache.tools.ant.taskdefs.optional.testing.BlockFor y;
    public org.apache.tools.ant.taskdefs.Sequential z;
    public long D = 1;
    public long E = 10000;
    public long F = 1;
    public java.lang.String H = "Tests failed";
    public boolean I = true;

    public static class NestedCondition extends org.apache.tools.ant.taskdefs.condition.ConditionBase implements org.apache.tools.ant.taskdefs.condition.Condition {
        public NestedCondition() {
        }

        public /* synthetic */ NestedCondition(org.apache.tools.ant.taskdefs.optional.testing.Funtest.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.apache.tools.ant.taskdefs.condition.Condition
        public boolean eval() {
            if (countConditions() == 1) {
                return ((org.apache.tools.ant.taskdefs.condition.Condition) getConditions().nextElement()).eval();
            }
            throw new org.apache.tools.ant.BuildException("A single nested condition is required.");
        }
    }

    public void addApplication(org.apache.tools.ant.taskdefs.Sequential sequential) {
        d("application", this.x);
        this.x = sequential;
    }

    public void addBlock(org.apache.tools.ant.taskdefs.optional.testing.BlockFor blockFor) {
        d("block", this.y);
        this.y = blockFor;
    }

    public void addReporting(org.apache.tools.ant.taskdefs.Sequential sequential) {
        d("reporting", this.A);
        this.A = sequential;
    }

    public void addSetup(org.apache.tools.ant.taskdefs.Sequential sequential) {
        d("setup", this.w);
        this.w = sequential;
    }

    public void addTeardown(org.apache.tools.ant.taskdefs.Sequential sequential) {
        d("teardown", this.B);
        this.B = sequential;
    }

    public void addTests(org.apache.tools.ant.taskdefs.Sequential sequential) {
        d("tests", this.z);
        this.z = sequential;
    }

    public final void c(org.apache.tools.ant.Task task) {
        task.bindToOwner(this);
        task.init();
    }

    public org.apache.tools.ant.taskdefs.condition.ConditionBase createCondition() {
        d("condition", this.u);
        org.apache.tools.ant.taskdefs.optional.testing.Funtest.NestedCondition nestedCondition = new org.apache.tools.ant.taskdefs.optional.testing.Funtest.NestedCondition(null);
        this.u = nestedCondition;
        return nestedCondition;
    }

    public final void d(java.lang.String str, java.lang.Object obj) {
        if (obj != null) {
            log("Overriding previous definition of <" + str + kotlin.text.Typography.greater, 2);
        }
    }

    public final org.apache.tools.ant.taskdefs.Parallel e(long j) {
        org.apache.tools.ant.taskdefs.Parallel parallel = new org.apache.tools.ant.taskdefs.Parallel();
        c(parallel);
        parallel.setFailOnAny(true);
        parallel.setTimeout(j);
        return parallel;
    }

    /* JADX WARN: Finally extract failed */
    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        long j;
        g(this.w, "setup");
        g(this.x, "application");
        g(this.z, "tests");
        g(this.A, "reporting");
        g(this.B, "teardown");
        org.apache.tools.ant.taskdefs.optional.testing.Funtest.NestedCondition nestedCondition = this.u;
        if (nestedCondition != null && !nestedCondition.eval()) {
            log(SKIPPING_TESTS);
            return;
        }
        long j2 = this.C * this.D;
        org.apache.tools.ant.taskdefs.Parallel e = e(j2);
        org.apache.tools.ant.util.WorkerAnt workerAnt = new org.apache.tools.ant.util.WorkerAnt(e, null);
        org.apache.tools.ant.Task task = this.x;
        if (task != null) {
            e.addTask(task);
        }
        org.apache.tools.ant.taskdefs.Sequential sequential = new org.apache.tools.ant.taskdefs.Sequential();
        c(sequential);
        org.apache.tools.ant.taskdefs.optional.testing.BlockFor blockFor = this.y;
        if (blockFor != null) {
            org.apache.tools.ant.Task taskAdapter = new org.apache.tools.ant.TaskAdapter(blockFor);
            taskAdapter.bindToOwner(this);
            g(taskAdapter, "block");
            sequential.addTask(taskAdapter);
            j = this.y.calculateMaxWaitMillis();
        } else {
            j = 0;
        }
        org.apache.tools.ant.taskdefs.Sequential sequential2 = this.z;
        if (sequential2 != null) {
            sequential.addTask(sequential2);
            j += j2;
        }
        org.apache.tools.ant.taskdefs.Sequential sequential3 = this.A;
        if (sequential3 != null) {
            sequential.addTask(sequential3);
            j += j2;
        }
        this.v = f(j, sequential);
        try {
            try {
                try {
                    org.apache.tools.ant.Task task2 = this.w;
                    if (task2 != null) {
                        f(j2, task2).execute();
                    }
                    workerAnt.start();
                    this.v.execute();
                    org.apache.tools.ant.Task task3 = this.B;
                    if (task3 != null) {
                        f(j2, task3).execute();
                    }
                } catch (org.apache.tools.ant.BuildException e2) {
                    this.J = e2;
                    org.apache.tools.ant.Task task4 = this.B;
                    if (task4 != null) {
                        f(j2, task4).execute();
                    }
                }
            } catch (org.apache.tools.ant.BuildException e3) {
                this.K = e3;
            }
            try {
                long j3 = this.E * this.F;
                workerAnt.waitUntilFinished(j3);
                if (workerAnt.isAlive()) {
                    log(APPLICATION_FORCIBLY_SHUT_DOWN, 1);
                    workerAnt.interrupt();
                    workerAnt.waitUntilFinished(j3);
                }
            } catch (java.lang.InterruptedException e4) {
                log(SHUTDOWN_INTERRUPTED, e4, 3);
            }
            this.L = workerAnt.getBuildException();
            processExceptions();
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.Task task5 = this.B;
            if (task5 != null) {
                try {
                    f(j2, task5).execute();
                } catch (org.apache.tools.ant.BuildException e5) {
                    this.K = e5;
                }
            }
            throw th;
        }
    }

    public final org.apache.tools.ant.taskdefs.Parallel f(long j, org.apache.tools.ant.Task task) {
        org.apache.tools.ant.taskdefs.Parallel e = e(j);
        e.addTask(task);
        return e;
    }

    public final void g(org.apache.tools.ant.Task task, java.lang.String str) {
        if (task == null || task.getProject() != null) {
            return;
        }
        throw new org.apache.tools.ant.BuildException(str + " task is not bound to the project" + task);
    }

    public org.apache.tools.ant.BuildException getApplicationException() {
        return this.L;
    }

    public org.apache.tools.ant.BuildException getTaskException() {
        return this.M;
    }

    public org.apache.tools.ant.BuildException getTeardownException() {
        return this.K;
    }

    public org.apache.tools.ant.BuildException getTestException() {
        return this.J;
    }

    public void ignoringThrowable(java.lang.String str, java.lang.Throwable th) {
        log(str + ": " + th.toString(), th, 1);
    }

    public void processExceptions() {
        org.apache.tools.ant.BuildException buildException = this.J;
        this.M = buildException;
        org.apache.tools.ant.BuildException buildException2 = this.L;
        if (buildException2 != null) {
            if (buildException == null || (buildException instanceof org.apache.tools.ant.taskdefs.optional.testing.BuildTimeoutException)) {
                this.M = buildException2;
            } else {
                ignoringThrowable(APPLICATION_EXCEPTION, buildException2);
            }
        }
        org.apache.tools.ant.BuildException buildException3 = this.K;
        if (buildException3 != null) {
            if (this.M == null && this.I) {
                this.M = buildException3;
            } else {
                ignoringThrowable(TEARDOWN_EXCEPTION, buildException3);
            }
        }
        if (this.G != null && getProject().getProperty(this.G) != null) {
            log(this.H);
            if (this.M == null) {
                this.M = new org.apache.tools.ant.BuildException(this.H);
            }
        }
        org.apache.tools.ant.BuildException buildException4 = this.M;
        if (buildException4 != null) {
            throw buildException4;
        }
    }

    public void setFailOnTeardownErrors(boolean z) {
        this.I = z;
    }

    public void setFailureMessage(java.lang.String str) {
        this.H = str;
    }

    public void setFailureProperty(java.lang.String str) {
        this.G = str;
    }

    public void setShutdownTime(long j) {
        this.E = j;
    }

    public void setShutdownUnit(org.apache.tools.ant.taskdefs.WaitFor.Unit unit) {
        this.F = unit.getMultiplier();
    }

    public void setTimeout(long j) {
        this.C = j;
    }

    public void setTimeoutUnit(org.apache.tools.ant.taskdefs.WaitFor.Unit unit) {
        this.D = unit.getMultiplier();
    }
}
