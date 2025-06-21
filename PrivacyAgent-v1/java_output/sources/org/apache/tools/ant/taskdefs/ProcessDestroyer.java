package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
class ProcessDestroyer implements java.lang.Runnable {
    public java.lang.reflect.Method t;
    public java.lang.reflect.Method u;
    public java.util.HashSet n = new java.util.HashSet();
    public org.apache.tools.ant.taskdefs.ProcessDestroyer.ProcessDestroyerImpl v = null;
    public boolean w = false;
    public boolean x = false;

    public class ProcessDestroyerImpl extends java.lang.Thread {
        public boolean n;

        public ProcessDestroyerImpl() {
            super("ProcessDestroyer Shutdown Hook");
            this.n = true;
        }

        public void a(boolean z) {
            this.n = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.n) {
                org.apache.tools.ant.taskdefs.ProcessDestroyer.this.run();
            }
        }
    }

    public ProcessDestroyer() {
        try {
            java.lang.Class[] clsArr = {java.lang.Thread.class};
            this.t = java.lang.Runtime.class.getMethod("addShutdownHook", clsArr);
            this.u = java.lang.Runtime.class.getMethod("removeShutdownHook", clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(java.lang.Process process) {
        boolean add;
        synchronized (this.n) {
            if (this.n.size() == 0) {
                b();
            }
            add = this.n.add(process);
        }
        return add;
    }

    public final void b() {
        if (this.t == null || this.x) {
            return;
        }
        org.apache.tools.ant.taskdefs.ProcessDestroyer.ProcessDestroyerImpl processDestroyerImpl = new org.apache.tools.ant.taskdefs.ProcessDestroyer.ProcessDestroyerImpl();
        this.v = processDestroyerImpl;
        try {
            this.t.invoke(java.lang.Runtime.getRuntime(), processDestroyerImpl);
            this.w = true;
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e2) {
            java.lang.Throwable targetException = e2.getTargetException();
            if (targetException == null || targetException.getClass() != java.lang.IllegalStateException.class) {
                e2.printStackTrace();
            } else {
                this.x = true;
            }
        }
    }

    public boolean c(java.lang.Process process) {
        boolean remove;
        synchronized (this.n) {
            remove = this.n.remove(process);
            if (remove && this.n.size() == 0) {
                d();
            }
        }
        return remove;
    }

    public final void d() {
        java.lang.reflect.Method method = this.u;
        if (method == null || !this.w || this.x) {
            return;
        }
        try {
            if (!((java.lang.Boolean) method.invoke(java.lang.Runtime.getRuntime(), this.v)).booleanValue()) {
                java.lang.System.err.println("Could not remove shutdown hook");
            }
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e2) {
            java.lang.Throwable targetException = e2.getTargetException();
            if (targetException == null || targetException.getClass() != java.lang.IllegalStateException.class) {
                e2.printStackTrace();
            } else {
                this.x = true;
            }
        }
        this.v.a(false);
        if (!this.v.getThreadGroup().isDestroyed()) {
            this.v.start();
        }
        try {
            this.v.join(com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        } catch (java.lang.InterruptedException unused) {
        }
        this.v = null;
        this.w = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.n) {
            this.x = true;
            java.util.Iterator it = this.n.iterator();
            while (it.hasNext()) {
                ((java.lang.Process) it.next()).destroy();
            }
        }
    }
}
