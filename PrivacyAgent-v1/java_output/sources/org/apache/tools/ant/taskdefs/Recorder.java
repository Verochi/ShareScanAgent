package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Recorder extends org.apache.tools.ant.Task implements org.apache.tools.ant.SubBuildListener {
    public static java.util.Hashtable<java.lang.String, org.apache.tools.ant.taskdefs.RecorderEntry> z = new java.util.Hashtable<>();
    public java.lang.String u = null;
    public java.lang.Boolean v = null;
    public java.lang.Boolean w = null;
    public int x = -1;
    public boolean y = false;

    public static class ActionChoices extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String[] b = {com.anythink.expressad.foundation.d.c.bT, "stop"};

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return b;
        }
    }

    public static class VerbosityLevelChoices extends org.apache.tools.ant.types.LogLevel {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        cleanup();
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    public final void cleanup() {
        for (java.util.Map.Entry entry : ((java.util.Hashtable) z.clone()).entrySet()) {
            if (((org.apache.tools.ant.taskdefs.RecorderEntry) entry.getValue()).getProject() == getProject()) {
                z.remove(entry.getKey());
            }
        }
        getProject().removeBuildListener(this);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("No filename specified");
        }
        getProject().log("setting a recorder for name " + this.u, 4);
        org.apache.tools.ant.taskdefs.RecorderEntry recorder = getRecorder(this.u, getProject());
        recorder.setMessageOutputLevel(this.x);
        recorder.setEmacsMode(this.y);
        java.lang.Boolean bool = this.w;
        if (bool != null) {
            if (bool.booleanValue()) {
                recorder.g();
                recorder.setRecordState(this.w);
            } else {
                recorder.setRecordState(this.w);
                recorder.a();
            }
        }
    }

    public org.apache.tools.ant.taskdefs.RecorderEntry getRecorder(java.lang.String str, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.RecorderEntry recorderEntry = z.get(str);
        if (recorderEntry == null) {
            recorderEntry = new org.apache.tools.ant.taskdefs.RecorderEntry(str);
            java.lang.Boolean bool = this.v;
            if (bool == null) {
                recorderEntry.e(false);
            } else {
                recorderEntry.e(bool.booleanValue());
            }
            recorderEntry.setProject(project);
            z.put(str, recorderEntry);
        }
        return recorderEntry;
    }

    @Override // org.apache.tools.ant.Task
    public void init() {
        getProject().addBuildListener(this);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    public void setAction(org.apache.tools.ant.taskdefs.Recorder.ActionChoices actionChoices) {
        if (actionChoices.getValue().equalsIgnoreCase(com.anythink.expressad.foundation.d.c.bT)) {
            this.w = java.lang.Boolean.TRUE;
        } else {
            this.w = java.lang.Boolean.FALSE;
        }
    }

    public void setAppend(boolean z2) {
        this.v = z2 ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setEmacsMode(boolean z2) {
        this.y = z2;
    }

    public void setLoglevel(org.apache.tools.ant.taskdefs.Recorder.VerbosityLevelChoices verbosityLevelChoices) {
        this.x = verbosityLevelChoices.getLevel();
    }

    public void setName(java.lang.String str) {
        this.u = str;
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        if (buildEvent.getProject() == getProject()) {
            cleanup();
        }
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }
}
