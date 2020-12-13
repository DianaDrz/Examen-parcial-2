package com.example.pregunta4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Rectangulo2 {

	private float vertices[] = new float [] {
		-5,-1f,5, 
		5,-1f,5, 
		5,-1f,-5,
		-5,-1f,-5,
	};
	byte maxColor = (byte)255;
	private byte colores[] = new byte[]{
		
			(byte) 183, (byte) 172, (byte) 182, maxColor, 
			(byte) 183, (byte) 172, (byte) 182, maxColor, 
			(byte) 183, (byte) 172, (byte) 182, maxColor, 
			(byte) 183, (byte) 172, (byte) 182, maxColor, 
	};
	
	FloatBuffer bufVertices;
	ByteBuffer bufColores;
	public Rectangulo2() {
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); 
		bufVertices = bufByte.asFloatBuffer(); 
		bufVertices.put(vertices);
		bufVertices.rewind(); 
		
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0);
	}
	public void dibuja(GL10 gl) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);//3 para 3d en z
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}
