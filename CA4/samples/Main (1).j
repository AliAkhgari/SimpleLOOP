.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 128
.limit locals 128
		new Main
		invokespecial Main/<init>()V
		return
.end method
.method public <init>()V
.limit stack 128
.limit locals 128
		aload 0
		invokespecial java/lang/Object/<init>()V
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		astore 1
		ldc 0
		istore 2
	Label_0:
		iload 2
		new Array
		dup
		ldc 1
		ldc 4
		invokespecial Array/<init>(II)V
		getfield Array/elements Ljava/util/ArrayList;
		invokevirtual java/util/ArrayList/size()I
		if_icmpge Label_1
		new Array
		dup
		ldc 1
		ldc 4
		invokespecial Array/<init>(II)V
		iload 2
		invokevirtual Array/getElement(I)Ljava/lang/Object;
		checkcast java/lang/Integer
		astore 1
		iinc 2 1
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 1
		invokevirtual java/lang/Integer/intValue()I
		invokevirtual java/io/PrintStream/println(I)V
		goto Label_0
	Label_1:
		return
.end method
		 
