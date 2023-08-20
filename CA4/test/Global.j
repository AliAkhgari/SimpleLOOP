.class public Global
.super java/lang/Object
.field static z Ljava/lang/Integer;
.field static y Ljava/lang/Integer;
.method public <init>()V
		.limit stack 128
		.limit locals 128
		aload_0
		invokespecial java/lang/Object/<init>()V
		aload_0
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		putfield Global/Identifier_z Ljava/lang/Integer;
		aload_0
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		putfield Global/Identifier_y Ljava/lang/Integer;
		return
		.end method
