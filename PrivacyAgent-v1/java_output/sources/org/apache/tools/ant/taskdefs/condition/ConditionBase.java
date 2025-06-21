package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public abstract class ConditionBase extends org.apache.tools.ant.ProjectComponent {
    public java.lang.String n;
    public java.util.Vector t = new java.util.Vector();

    public ConditionBase() {
        this.n = "condition";
        this.n = "component";
    }

    public ConditionBase(java.lang.String str) {
        this.n = "condition";
        this.n = str;
    }

    public void add(org.apache.tools.ant.taskdefs.condition.Condition condition) {
        this.t.addElement(condition);
    }

    public void addAnd(org.apache.tools.ant.taskdefs.condition.And and) {
        this.t.addElement(and);
    }

    public void addAvailable(org.apache.tools.ant.taskdefs.Available available) {
        this.t.addElement(available);
    }

    public void addChecksum(org.apache.tools.ant.taskdefs.Checksum checksum) {
        this.t.addElement(checksum);
    }

    public void addContains(org.apache.tools.ant.taskdefs.condition.Contains contains) {
        this.t.addElement(contains);
    }

    public void addEquals(org.apache.tools.ant.taskdefs.condition.Equals equals) {
        this.t.addElement(equals);
    }

    public void addFilesMatch(org.apache.tools.ant.taskdefs.condition.FilesMatch filesMatch) {
        this.t.addElement(filesMatch);
    }

    public void addHttp(org.apache.tools.ant.taskdefs.condition.Http http) {
        this.t.addElement(http);
    }

    public void addIsFalse(org.apache.tools.ant.taskdefs.condition.IsFalse isFalse) {
        this.t.addElement(isFalse);
    }

    public void addIsFileSelected(org.apache.tools.ant.taskdefs.condition.IsFileSelected isFileSelected) {
        this.t.addElement(isFileSelected);
    }

    public void addIsReference(org.apache.tools.ant.taskdefs.condition.IsReference isReference) {
        this.t.addElement(isReference);
    }

    public void addIsSet(org.apache.tools.ant.taskdefs.condition.IsSet isSet) {
        this.t.addElement(isSet);
    }

    public void addIsTrue(org.apache.tools.ant.taskdefs.condition.IsTrue isTrue) {
        this.t.addElement(isTrue);
    }

    public void addNot(org.apache.tools.ant.taskdefs.condition.Not not) {
        this.t.addElement(not);
    }

    public void addOr(org.apache.tools.ant.taskdefs.condition.Or or) {
        this.t.addElement(or);
    }

    public void addOs(org.apache.tools.ant.taskdefs.condition.Os os) {
        this.t.addElement(os);
    }

    public void addSocket(org.apache.tools.ant.taskdefs.condition.Socket socket) {
        this.t.addElement(socket);
    }

    public void addUptodate(org.apache.tools.ant.taskdefs.UpToDate upToDate) {
        this.t.addElement(upToDate);
    }

    public int countConditions() {
        return this.t.size();
    }

    public final java.util.Enumeration getConditions() {
        return this.t.elements();
    }

    public java.lang.String getTaskName() {
        return this.n;
    }

    public void setTaskName(java.lang.String str) {
        this.n = str;
    }
}
