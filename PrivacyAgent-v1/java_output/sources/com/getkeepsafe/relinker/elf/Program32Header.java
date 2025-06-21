package com.getkeepsafe.relinker.elf;

/* loaded from: classes22.dex */
public class Program32Header extends com.getkeepsafe.relinker.elf.Elf.ProgramHeader {
    public Program32Header(com.getkeepsafe.relinker.elf.ElfParser elfParser, com.getkeepsafe.relinker.elf.Elf.Header header, long j) throws java.io.IOException {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(4);
        allocate.order(header.bigEndian ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        long j2 = header.phoff + (j * header.phentsize);
        this.type = elfParser.readWord(allocate, j2);
        this.offset = elfParser.readWord(allocate, 4 + j2);
        this.vaddr = elfParser.readWord(allocate, 8 + j2);
        this.memsz = elfParser.readWord(allocate, j2 + 20);
    }
}
