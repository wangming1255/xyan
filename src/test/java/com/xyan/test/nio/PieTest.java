package com.xyan.test.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PieTest {
	
	public static void main(String[] args) throws IOException {
		//创建管道
		//通过Pipe.open()方法打开管道。例如：
		Pipe pipe = Pipe.open();
		//向管道写数据
		//要向管道写数据，需要访问sink通道。像这样：
		Pipe.SinkChannel sinkChannel = pipe.sink();
		//通过调用SinkChannel的write()方法，将数据写入SinkChannel,像这样：
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());

		buf.flip();

		while(buf.hasRemaining()) {
		    sinkChannel.write(buf);
		}

		/*//从管道读取数据
		//从读取管道的数据，需要访问source通道，像这样：
		Pipe.SourceChannel sourceChannel = pipe.source();
		//调用source通道的read()方法来读取数据，像这样：
		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = sourceChannel.read(buf);*/
	}
}
