package org.apache.tools.ant.taskdefs.email;

/* loaded from: classes25.dex */
public abstract class Mailer {
    protected org.apache.tools.ant.taskdefs.email.EmailAddress from;
    protected org.apache.tools.ant.taskdefs.email.Message message;
    protected org.apache.tools.ant.Task task;
    protected java.lang.String host = null;
    protected int port = -1;
    protected java.lang.String user = null;
    protected java.lang.String password = null;
    protected boolean SSL = false;
    protected java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> replyToList = null;
    protected java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> toList = null;
    protected java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> ccList = null;
    protected java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> bccList = null;
    protected java.util.Vector<java.io.File> files = null;
    protected java.lang.String subject = null;
    protected boolean includeFileNames = false;
    protected java.util.Vector<org.apache.tools.ant.taskdefs.email.Header> headers = null;
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;

    public final java.lang.String getDate() {
        return org.apache.tools.ant.util.DateUtils.getDateForHeader();
    }

    public boolean isPortExplicitlySpecified() {
        return this.c;
    }

    public boolean isStartTLSEnabled() {
        return this.b;
    }

    public abstract void send() throws org.apache.tools.ant.BuildException;

    public void setBccList(java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> vector) {
        this.bccList = vector;
    }

    public void setCcList(java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> vector) {
        this.ccList = vector;
    }

    public void setEnableStartTLS(boolean z) {
        this.b = z;
    }

    public void setFiles(java.util.Vector<java.io.File> vector) {
        this.files = vector;
    }

    public void setFrom(org.apache.tools.ant.taskdefs.email.EmailAddress emailAddress) {
        this.from = emailAddress;
    }

    public void setHeaders(java.util.Vector<org.apache.tools.ant.taskdefs.email.Header> vector) {
        this.headers = vector;
    }

    public void setHost(java.lang.String str) {
        this.host = str;
    }

    public void setIgnoreInvalidRecipients(boolean z) {
        this.a = z;
    }

    public void setIncludeFileNames(boolean z) {
        this.includeFileNames = z;
    }

    public void setMessage(org.apache.tools.ant.taskdefs.email.Message message) {
        this.message = message;
    }

    public void setPassword(java.lang.String str) {
        this.password = str;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPortExplicitlySpecified(boolean z) {
        this.c = z;
    }

    public void setReplyToList(java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> vector) {
        this.replyToList = vector;
    }

    public void setSSL(boolean z) {
        this.SSL = z;
    }

    public void setSubject(java.lang.String str) {
        this.subject = str;
    }

    public void setTask(org.apache.tools.ant.Task task) {
        this.task = task;
    }

    public void setToList(java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> vector) {
        this.toList = vector;
    }

    public void setUser(java.lang.String str) {
        this.user = str;
    }

    public boolean shouldIgnoreInvalidRecipients() {
        return this.a;
    }
}
