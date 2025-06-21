package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Timer {
    public static com.badlogic.gdx.utils.Timer.TimerThread c;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer.Task> a = new com.badlogic.gdx.utils.Array<>(false, 8);
    public static final com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> b = new com.badlogic.gdx.utils.Array<>(1);
    public static com.badlogic.gdx.utils.Timer d = new com.badlogic.gdx.utils.Timer();

    public static abstract class Task implements java.lang.Runnable {
        public long n;
        public long t;
        public int u = -1;
        public com.badlogic.gdx.Application v;

        public Task() {
            com.badlogic.gdx.Application application = com.badlogic.gdx.Gdx.app;
            this.v = application;
            if (application == null) {
                throw new java.lang.IllegalStateException("Gdx.app not available.");
            }
        }

        public synchronized void cancel() {
            this.n = 0L;
            this.u = -1;
        }

        public synchronized long getExecuteTimeMillis() {
            return this.n;
        }

        public synchronized boolean isScheduled() {
            return this.u != -1;
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public static class TimerThread implements java.lang.Runnable, com.badlogic.gdx.LifecycleListener {
        public com.badlogic.gdx.Files n;
        public long t;

        public TimerThread() {
            com.badlogic.gdx.Gdx.app.addLifecycleListener(this);
            resume();
        }

        @Override // com.badlogic.gdx.LifecycleListener
        public void dispose() {
            pause();
            com.badlogic.gdx.Gdx.app.removeLifecycleListener(this);
            com.badlogic.gdx.utils.Timer.b.clear();
            com.badlogic.gdx.utils.Timer.d = null;
        }

        @Override // com.badlogic.gdx.LifecycleListener
        public void pause() {
            this.t = java.lang.System.nanoTime() / 1000000;
            synchronized (com.badlogic.gdx.utils.Timer.b) {
                this.n = null;
                com.badlogic.gdx.utils.Timer.a();
            }
            com.badlogic.gdx.utils.Timer.c = null;
        }

        @Override // com.badlogic.gdx.LifecycleListener
        public void resume() {
            long nanoTime = (java.lang.System.nanoTime() / 1000000) - this.t;
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> array = com.badlogic.gdx.utils.Timer.b;
            synchronized (array) {
                int i = array.size;
                for (int i2 = 0; i2 < i; i2++) {
                    com.badlogic.gdx.utils.Timer.b.get(i2).delay(nanoTime);
                }
            }
            this.n = com.badlogic.gdx.Gdx.files;
            java.lang.Thread thread = new java.lang.Thread(this, "Timer");
            thread.setDaemon(true);
            thread.start();
            com.badlogic.gdx.utils.Timer.c = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> array = com.badlogic.gdx.utils.Timer.b;
                synchronized (array) {
                    if (this.n != com.badlogic.gdx.Gdx.files) {
                        return;
                    }
                    long nanoTime = java.lang.System.nanoTime() / 1000000;
                    int i = array.size;
                    long j = 5000;
                    for (int i2 = 0; i2 < i; i2++) {
                        try {
                            j = com.badlogic.gdx.utils.Timer.b.get(i2).update(nanoTime, j);
                        } catch (java.lang.Throwable th) {
                            throw new com.badlogic.gdx.utils.GdxRuntimeException("Task failed: " + com.badlogic.gdx.utils.Timer.b.get(i2).getClass().getName(), th);
                        }
                    }
                    if (this.n != com.badlogic.gdx.Gdx.files) {
                        return;
                    }
                    if (j > 0) {
                        try {
                            com.badlogic.gdx.utils.Timer.b.wait(j);
                        } catch (java.lang.InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public Timer() {
        start();
    }

    public static void a() {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> array = b;
        synchronized (array) {
            array.notifyAll();
        }
    }

    public static com.badlogic.gdx.utils.Timer instance() {
        if (d == null) {
            d = new com.badlogic.gdx.utils.Timer();
        }
        return d;
    }

    public static com.badlogic.gdx.utils.Timer.Task post(com.badlogic.gdx.utils.Timer.Task task) {
        return instance().postTask(task);
    }

    public static com.badlogic.gdx.utils.Timer.Task schedule(com.badlogic.gdx.utils.Timer.Task task, float f) {
        return instance().scheduleTask(task, f);
    }

    public static com.badlogic.gdx.utils.Timer.Task schedule(com.badlogic.gdx.utils.Timer.Task task, float f, float f2) {
        return instance().scheduleTask(task, f, f2);
    }

    public static com.badlogic.gdx.utils.Timer.Task schedule(com.badlogic.gdx.utils.Timer.Task task, float f, float f2, int i) {
        return instance().scheduleTask(task, f, f2, i);
    }

    public void clear() {
        synchronized (this) {
            int i = this.a.size;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).cancel();
            }
            this.a.clear();
        }
    }

    public void delay(long j) {
        synchronized (this) {
            int i = this.a.size;
            for (int i2 = 0; i2 < i; i2++) {
                com.badlogic.gdx.utils.Timer.Task task = this.a.get(i2);
                synchronized (task) {
                    task.n += j;
                }
            }
        }
    }

    public boolean isEmpty() {
        boolean z;
        synchronized (this) {
            z = this.a.size == 0;
        }
        return z;
    }

    public com.badlogic.gdx.utils.Timer.Task postTask(com.badlogic.gdx.utils.Timer.Task task) {
        return scheduleTask(task, 0.0f, 0.0f, 0);
    }

    public com.badlogic.gdx.utils.Timer.Task scheduleTask(com.badlogic.gdx.utils.Timer.Task task, float f) {
        return scheduleTask(task, f, 0.0f, 0);
    }

    public com.badlogic.gdx.utils.Timer.Task scheduleTask(com.badlogic.gdx.utils.Timer.Task task, float f, float f2) {
        return scheduleTask(task, f, f2, -2);
    }

    public com.badlogic.gdx.utils.Timer.Task scheduleTask(com.badlogic.gdx.utils.Timer.Task task, float f, float f2, int i) {
        synchronized (task) {
            if (task.u != -1) {
                throw new java.lang.IllegalArgumentException("The same task may not be scheduled twice.");
            }
            task.n = (java.lang.System.nanoTime() / 1000000) + ((long) (f * 1000.0f));
            task.t = (long) (f2 * 1000.0f);
            task.u = i;
        }
        synchronized (this) {
            this.a.add(task);
        }
        a();
        return task;
    }

    public void start() {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> array = b;
        synchronized (array) {
            if (array.contains(this, true)) {
                return;
            }
            array.add(this);
            if (c == null) {
                c = new com.badlogic.gdx.utils.Timer.TimerThread();
            }
            a();
        }
    }

    public void stop() {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> array = b;
        synchronized (array) {
            array.removeValue(this, true);
        }
    }

    public long update(long j, long j2) {
        synchronized (this) {
            int i = this.a.size;
            int i2 = 0;
            while (i2 < i) {
                com.badlogic.gdx.utils.Timer.Task task = this.a.get(i2);
                synchronized (task) {
                    long j3 = task.n;
                    if (j3 > j) {
                        j2 = java.lang.Math.min(j2, j3 - j);
                    } else {
                        int i3 = task.u;
                        if (i3 != -1) {
                            if (i3 == 0) {
                                task.u = -1;
                            }
                            task.v.postRunnable(task);
                        }
                        if (task.u == -1) {
                            this.a.removeIndex(i2);
                            i2--;
                            i--;
                        } else {
                            long j4 = task.t;
                            task.n = j + j4;
                            j2 = java.lang.Math.min(j2, j4);
                            int i4 = task.u;
                            if (i4 > 0) {
                                task.u = i4 - 1;
                            }
                        }
                    }
                }
                i2++;
            }
        }
        return j2;
    }
}
