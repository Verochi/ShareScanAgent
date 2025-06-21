package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class RenameExtensions extends org.apache.tools.ant.taskdefs.MatchingTask {
    public java.lang.String u = "";
    public java.lang.String v = "";
    public boolean w = false;
    public java.io.File x;
    public org.apache.tools.ant.types.Mapper.MapperType y;

    public RenameExtensions() {
        org.apache.tools.ant.types.Mapper.MapperType mapperType = new org.apache.tools.ant.types.Mapper.MapperType();
        this.y = mapperType;
        mapperType.setValue("glob");
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null || this.v == null || this.x == null) {
            throw new org.apache.tools.ant.BuildException("srcDir, fromExtension and toExtension attributes must be set!");
        }
        log("DEPRECATED - The renameext task is deprecated.  Use move instead.", 1);
        log("Replace this with:", 2);
        log("<move todir=\"" + this.x + "\" overwrite=\"" + this.w + "\">", 2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("  <fileset dir=\"");
        sb.append(this.x);
        sb.append("\" />");
        log(sb.toString(), 2);
        log("  <mapper type=\"glob\"", 2);
        log("          from=\"*" + this.u + "\"", 2);
        log("          to=\"*" + this.v + "\" />", 2);
        log("</move>", 2);
        log("using the same patterns on <fileset> as you've used here", 2);
        org.apache.tools.ant.taskdefs.Move move = new org.apache.tools.ant.taskdefs.Move();
        move.bindToOwner(this);
        move.setOwningTarget(getOwningTarget());
        move.setTaskName(getTaskName());
        move.setLocation(getLocation());
        move.setTodir(this.x);
        move.setOverwrite(this.w);
        this.fileset.setDir(this.x);
        move.addFileset(this.fileset);
        org.apache.tools.ant.types.Mapper createMapper = move.createMapper();
        createMapper.setType(this.y);
        createMapper.setFrom("*" + this.u);
        createMapper.setTo("*" + this.v);
        move.execute();
    }

    public void setFromExtension(java.lang.String str) {
        this.u = str;
    }

    public void setReplace(boolean z) {
        this.w = z;
    }

    public void setSrcDir(java.io.File file) {
        this.x = file;
    }

    public void setToExtension(java.lang.String str) {
        this.v = str;
    }
}
