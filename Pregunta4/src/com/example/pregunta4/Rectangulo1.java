package com.example.pregunta4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Rectangulo1 {
	
	private float vertices[] = new float [] {
		-3.5f,-1f,3.5f, 
		3.5f,-1f,3.5f, 
		3.5f,-1f,-3.5f, 
		-3.5f,-1f,-3.5f,
	};
	byte maxColor = (byte)255;
	private byte colores[] = new byte[]{
			
			(byte) 162, (byte) 21, (byte) 182, maxColor,
			(byte) 162, (byte) 21, (byte) 182, maxColor,
			(byte) 162, (byte) 21, (byte) 182, maxColor,
			(byte) 162, (byte) 21, (byte) 182, maxColor,
	};
	
	FloatBuffer bufVertices;
	ByteBuffer bufColores;
	public Rectangulo1() {
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
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}
