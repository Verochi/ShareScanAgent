package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class WaitFor extends org.apache.tools.ant.taskdefs.condition.ConditionBase {
    public static final long DEFAULT_CHECK_MILLIS = 500;
    public static final long DEFAULT_MAX_WAIT_MILLIS = 180000;
    public static final long ONE_DAY = 86400000;
    public static final long ONE_HOUR = 3600000;
    public static final long ONE_MILLISECOND = 1;
    public static final long ONE_MINUTE = 60000;
    public static final long ONE_SECOND = 1000;
    public static final long ONE_WEEK = 604800000;
    public long u;
    public long v;
    public long w;
    public long x;
    public java.lang.String y;

    public static class Unit extends org.apache.tools.ant.types.EnumeratedAttribute {
        public java.util.Map b;
        public static final java.lang.String MILLISECOND = "millisecond";
        public static final java.lang.String SECOND = "second";
        public static final java.lang.String MINUTE = "minute";
        public static final java.lang.String HOUR = "hour";
        public static final java.lang.String DAY = "day";
        public static final java.lang.String WEEK = "week";
        public static final java.lang.String[] c = {MILLISECOND, SECOND, MINUTE, HOUR, DAY, WEEK};

        public Unit() {
            java.util.HashMap hashMap = new java.util.HashMap();
            this.b = hashMap;
            hashMap.put(MILLISECOND, new java.lang.Long(1L));
            this.b.put(SECOND, new java.lang.Long(1000L));
            this.b.put(MINUTE, new java.lang.Long(60000L));
            this.b.put(HOUR, new java.lang.Long(3600000L));
            this.b.put(DAY, new java.lang.Long(86400000L));
            this.b.put(WEEK, new java.lang.Long(604800000L));
        }

        public long getMultiplier() {
            return ((java.lang.Long) this.b.get(getValue().toLowerCase(java.util.Locale.ENGLISH))).longValue();
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return c;
        }
    }

    public WaitFor() {
        super("waitfor");
        this.u = DEFAULT_MAX_WAIT_MILLIS;
        this.v = 1L;
        this.w = 500L;
        this.x = 1L;
    }

    public WaitFor(java.lang.String str) {
        super(str);
        this.u = DEFAULT_MAX_WAIT_MILLIS;
        this.v = 1L;
        this.w = 500L;
        this.x = 1L;
    }

    public long calculateCheckEveryMillis() {
        return this.w * this.x;
    }

    public long calculateMaxWaitMillis() {
        return this.u * this.v;
    }

    public void execute() throws org.apache.tools.ant.BuildException {
        if (countConditions() > 1) {
            throw new org.apache.tools.ant.BuildException("You must not nest more than one condition into " + getTaskName());
        }
        if (countConditions() < 1) {
            throw new org.apache.tools.ant.BuildException("You must nest a condition into " + getTaskName());
        }
        org.apache.tools.ant.taskdefs.condition.Condition condition = (org.apache.tools.ant.taskdefs.condition.Condition) getConditions().nextElement();
        try {
            long calculateMaxWaitMillis = calculateMaxWaitMillis();
            long calculateCheckEveryMillis = calculateCheckEveryMillis();
            long currentTimeMillis = java.lang.System.currentTimeMillis() + calculateMaxWaitMillis;
            while (java.lang.System.currentTimeMillis() < currentTimeMillis) {
                if (condition.eval()) {
                    processSuccess();
                    return;
                }
                java.lang.Thread.sleep(calculateCheckEveryMillis);
            }
        } catch (java.lang.InterruptedException unused) {
            log("Task " + getTaskName() + " interrupted, treating as timed out.");
        }
        processTimeout();
    }

    public void processSuccess() {
        log(getTaskName() + ": condition was met", 3);
    }

    public void processTimeout() {
        log(getTaskName() + ": timeout", 3);
        if (this.y != null) {
            getProject().setNewProperty(this.y, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
    }

    public void setCheckEvery(long j) {
        this.w = j;
    }

    public void setCheckEveryUnit(org.apache.tools.ant.taskdefs.WaitFor.Unit unit) {
        this.x = unit.getMultiplier();
    }

    public void setMaxWait(long j) {
        this.u = j;
    }

    public void setMaxWaitUnit(org.apache.tools.ant.taskdefs.WaitFor.Unit unit) {
        this.v = unit.getMultiplier();
    }

    public void setTimeoutProperty(java.lang.String str) {
        this.y = str;
    }
}
