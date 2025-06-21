package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Parallel extends org.apache.tools.ant.Task implements org.apache.tools.ant.TaskContainer {
    public boolean A;
    public boolean B;
    public org.apache.tools.ant.taskdefs.Parallel.TaskList C;
    public java.lang.StringBuffer D;
    public java.lang.Throwable F;
    public org.apache.tools.ant.Location G;
    public java.lang.Integer H;
    public long y;
    public volatile boolean z;
    public java.util.Vector u = new java.util.Vector();
    public final java.lang.Object v = new java.lang.Object();
    public int w = 0;
    public int x = 0;
    public int E = 0;

    /* renamed from: org.apache.tools.ant.taskdefs.Parallel$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public synchronized void run() {
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis() + org.apache.tools.ant.taskdefs.Parallel.this.y;
                for (long currentTimeMillis2 = java.lang.System.currentTimeMillis(); currentTimeMillis2 < currentTimeMillis; currentTimeMillis2 = java.lang.System.currentTimeMillis()) {
                    wait(currentTimeMillis - currentTimeMillis2);
                }
                synchronized (org.apache.tools.ant.taskdefs.Parallel.this.v) {
                    org.apache.tools.ant.taskdefs.Parallel.this.z = false;
                    org.apache.tools.ant.taskdefs.Parallel.this.A = true;
                    org.apache.tools.ant.taskdefs.Parallel.this.v.notifyAll();
                }
            } catch (java.lang.InterruptedException unused) {
            }
        }
    }

    public static class TaskList implements org.apache.tools.ant.TaskContainer {
        public java.util.List n = new java.util.ArrayList();

        @Override // org.apache.tools.ant.TaskContainer
        public void addTask(org.apache.tools.ant.Task task) {
            this.n.add(task);
        }
    }

    public class TaskRunnable implements java.lang.Runnable {
        public java.lang.Throwable n;
        public org.apache.tools.ant.Task t;
        public boolean u;
        public volatile java.lang.Thread v;

        public TaskRunnable(org.apache.tools.ant.Task task) {
            this.t = task;
        }

        public java.lang.Throwable a() {
            return this.n;
        }

        public void b() {
            this.v.interrupt();
        }

        public boolean c() {
            return this.u;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.apache.tools.ant.property.LocalProperties.get(org.apache.tools.ant.taskdefs.Parallel.this.getProject()).copy();
                this.v = java.lang.Thread.currentThread();
                this.t.perform();
                synchronized (org.apache.tools.ant.taskdefs.Parallel.this.v) {
                    this.u = true;
                    org.apache.tools.ant.taskdefs.Parallel.this.v.notifyAll();
                }
            } catch (java.lang.Throwable th) {
                try {
                    this.n = th;
                    if (org.apache.tools.ant.taskdefs.Parallel.this.B) {
                        org.apache.tools.ant.taskdefs.Parallel.this.z = false;
                    }
                    synchronized (org.apache.tools.ant.taskdefs.Parallel.this.v) {
                        this.u = true;
                        org.apache.tools.ant.taskdefs.Parallel.this.v.notifyAll();
                    }
                } catch (java.lang.Throwable th2) {
                    synchronized (org.apache.tools.ant.taskdefs.Parallel.this.v) {
                        this.u = true;
                        org.apache.tools.ant.taskdefs.Parallel.this.v.notifyAll();
                        throw th2;
                    }
                }
            }
        }
    }

    public void addDaemons(org.apache.tools.ant.taskdefs.Parallel.TaskList taskList) {
        if (this.C != null) {
            throw new org.apache.tools.ant.BuildException("Only one daemon group is supported");
        }
        this.C = taskList;
    }

    @Override // org.apache.tools.ant.TaskContainer
    public void addTask(org.apache.tools.ant.Task task) {
        this.u.addElement(task);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        k();
        if (this.w == 0) {
            this.w = this.u.size();
        }
        j();
    }

    public final void h(org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[] taskRunnableArr) {
        int i = 0;
        do {
            boolean z = false;
            for (org.apache.tools.ant.taskdefs.Parallel.TaskRunnable taskRunnable : taskRunnableArr) {
                if (taskRunnable != null && !taskRunnable.c()) {
                    taskRunnable.b();
                    java.lang.Thread.yield();
                    z = true;
                }
            }
            if (z) {
                i++;
                java.lang.Thread.yield();
            }
            if (!z) {
                return;
            }
        } while (i < 100);
    }

    public final void i(org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[] taskRunnableArr) {
        if (taskRunnableArr == null) {
            return;
        }
        for (org.apache.tools.ant.taskdefs.Parallel.TaskRunnable taskRunnable : taskRunnableArr) {
            java.lang.Throwable a = taskRunnable.a();
            if (a != null) {
                this.E++;
                if (this.F == null) {
                    this.F = a;
                }
                if ((a instanceof org.apache.tools.ant.BuildException) && this.G == org.apache.tools.ant.Location.UNKNOWN_LOCATION) {
                    this.G = ((org.apache.tools.ant.BuildException) a).getLocation();
                }
                if ((a instanceof org.apache.tools.ant.ExitStatusException) && this.H == null) {
                    org.apache.tools.ant.ExitStatusException exitStatusException = (org.apache.tools.ant.ExitStatusException) a;
                    this.H = java.lang.Integer.valueOf(exitStatusException.getStatus());
                    this.G = exitStatusException.getLocation();
                }
                this.D.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
                this.D.append(a.getMessage());
            }
        }
    }

    public final void j() throws org.apache.tools.ant.BuildException {
        boolean z;
        int i;
        int size = this.u.size();
        org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[] taskRunnableArr = new org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[size];
        this.z = true;
        this.A = false;
        java.util.Enumeration elements = this.u.elements();
        int i2 = 0;
        while (elements.hasMoreElements()) {
            taskRunnableArr[i2] = new org.apache.tools.ant.taskdefs.Parallel.TaskRunnable((org.apache.tools.ant.Task) elements.nextElement());
            i2++;
        }
        int i3 = this.w;
        if (size < i3) {
            i3 = size;
        }
        org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[] taskRunnableArr2 = new org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[i3];
        java.lang.ThreadGroup threadGroup = new java.lang.ThreadGroup("parallel");
        org.apache.tools.ant.taskdefs.Parallel.TaskList taskList = this.C;
        org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[] taskRunnableArr3 = (taskList == null || taskList.n.size() == 0) ? null : new org.apache.tools.ant.taskdefs.Parallel.TaskRunnable[this.C.n.size()];
        synchronized (this.v) {
        }
        synchronized (this.v) {
            if (taskRunnableArr3 != null) {
                for (int i4 = 0; i4 < taskRunnableArr3.length; i4++) {
                    try {
                        taskRunnableArr3[i4] = new org.apache.tools.ant.taskdefs.Parallel.TaskRunnable((org.apache.tools.ant.Task) this.C.n.get(i4));
                        java.lang.Thread thread = new java.lang.Thread(threadGroup, taskRunnableArr3[i4]);
                        thread.setDaemon(true);
                        thread.start();
                    } catch (java.lang.Throwable th) {
                        throw th;
                    }
                }
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < i3) {
                taskRunnableArr2[i5] = taskRunnableArr[i6];
                new java.lang.Thread(threadGroup, taskRunnableArr2[i5]).start();
                i5++;
                i6++;
            }
            if (this.y != 0) {
                new org.apache.tools.ant.taskdefs.Parallel.AnonymousClass1().start();
            }
            while (i6 < size) {
                try {
                    if (!this.z) {
                        break;
                    }
                    while (i < i3) {
                        org.apache.tools.ant.taskdefs.Parallel.TaskRunnable taskRunnable = taskRunnableArr2[i];
                        i = (taskRunnable == null || taskRunnable.c()) ? 0 : i + 1;
                        taskRunnableArr2[i] = taskRunnableArr[i6];
                        new java.lang.Thread(threadGroup, taskRunnableArr2[i]).start();
                        i6++;
                        break;
                    }
                    this.v.wait();
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                }
            }
            while (this.z) {
                int i7 = 0;
                while (true) {
                    if (i7 >= i3) {
                        this.z = false;
                        break;
                    }
                    org.apache.tools.ant.taskdefs.Parallel.TaskRunnable taskRunnable2 = taskRunnableArr2[i7];
                    if (taskRunnable2 != null && !taskRunnable2.c()) {
                        this.v.wait();
                        break;
                    }
                    i7++;
                }
            }
            z = false;
            if (!this.A && !this.B) {
                h(taskRunnableArr2);
            }
        }
        if (z) {
            throw new org.apache.tools.ant.BuildException("Parallel execution interrupted.");
        }
        if (this.A) {
            throw new org.apache.tools.ant.BuildException("Parallel execution timed out");
        }
        this.D = new java.lang.StringBuffer();
        this.E = 0;
        this.F = null;
        this.H = null;
        this.G = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
        i(taskRunnableArr3);
        i(taskRunnableArr);
        int i8 = this.E;
        if (i8 == 1) {
            java.lang.Throwable th2 = this.F;
            if (!(th2 instanceof org.apache.tools.ant.BuildException)) {
                throw new org.apache.tools.ant.BuildException(this.F);
            }
            throw ((org.apache.tools.ant.BuildException) th2);
        }
        if (i8 > 1) {
            if (this.H != null) {
                throw new org.apache.tools.ant.ExitStatusException(this.D.toString(), this.H.intValue(), this.G);
            }
            throw new org.apache.tools.ant.BuildException(this.D.toString(), this.G);
        }
    }

    public final void k() {
        if (this.x != 0) {
            this.w = java.lang.Runtime.getRuntime().availableProcessors() * this.x;
        }
    }

    public void setFailOnAny(boolean z) {
        this.B = z;
    }

    public void setPollInterval(int i) {
    }

    public void setThreadCount(int i) {
        this.w = i;
    }

    public void setThreadsPerProcessor(int i) {
        this.x = i;
    }

    public void setTimeout(long j) {
        this.y = j;
    }
}
