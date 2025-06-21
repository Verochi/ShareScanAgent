package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class CharSink {
    public java.io.Writer openBufferedStream() throws java.io.IOException {
        java.io.Writer openStream = openStream();
        return openStream instanceof java.io.BufferedWriter ? (java.io.BufferedWriter) openStream : new java.io.BufferedWriter(openStream);
    }

    public abstract java.io.Writer openStream() throws java.io.IOException;

    public void write(java.lang.CharSequence charSequence) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(charSequence);
        try {
            java.io.Writer writer = (java.io.Writer) com.google.common.io.Closer.create().register(openStream());
            writer.append(charSequence);
            writer.flush();
        } finally {
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public long writeFrom(java.lang.Readable readable) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(readable);
        try {
            java.io.Writer writer = (java.io.Writer) com.google.common.io.Closer.create().register(openStream());
            long copy = com.google.common.io.CharStreams.copy(readable, writer);
            writer.flush();
            return copy;
        } finally {
        }
    }

    public void writeLines(java.lang.Iterable<? extends java.lang.CharSequence> iterable) throws java.io.IOException {
        writeLines(iterable, java.lang.System.getProperty("line.separator"));
    }

    public void writeLines(java.lang.Iterable<? extends java.lang.CharSequence> iterable, java.lang.String str) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkNotNull(str);
        try {
            java.io.Writer writer = (java.io.Writer) com.google.common.io.Closer.create().register(openBufferedStream());
            java.util.Iterator<? extends java.lang.CharSequence> it = iterable.iterator();
            while (it.hasNext()) {
                writer.append(it.next()).append((java.lang.CharSequence) str);
            }
            writer.flush();
        } finally {
        }
    }
}
