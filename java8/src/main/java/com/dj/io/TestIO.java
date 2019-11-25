package com.dj.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class TestIO {

	@Test
	public void method4() {
		try {
			FileInputStream fis = new FileInputStream("D://1.txt");
			// 获取文件读写通道
			FileChannel fc = fis.getChannel();
			// 创建字节缓冲区
			ByteBuffer bf = ByteBuffer.allocate(16);
			// 创建char缓冲区
			CharBuffer cb = CharBuffer.allocate(16);
			char[] a = null;
			// 获取字符集编码对象
			Charset charset = Charset.forName("utf-8");
			// 为charset创建新的解码构造器
			CharsetDecoder charsetDecoder = charset.newDecoder();
			// 通过通道写入缓存
			int s = fc.read(bf);

			while (s != -1) {
				// 调用flip()方法变为读模式
				bf.flip();
				// 从给定的输入缓冲区解码尽可能多的字节，将结果写入给定的输出缓冲区。
				charsetDecoder.decode(bf, cb, true);
				cb.flip();
				a = new char[cb.length()];
				while (cb.hasRemaining()) {
					cb.get(a);
					System.out.print(new String(a));

				}
				// 清空缓存区 还可以调用compact（）方法清空读取过的缓存区数据 ，clear()清空所有
				cb.clear();
				bf.clear();

			}
			fis.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void method3() throws Exception {
		FileInputStream input = new FileInputStream("D:/1.txt");
		FileChannel channel = input.getChannel();
		ByteBuffer bb = ByteBuffer.allocate(1024);
		byte[] result = new byte[1024];
		long read = channel.read(bb);
		if (read != -1) {
			int i = 0;
			bb.flip();
			while (bb.hasRemaining()) {
				byte b = bb.get();
				result[i] = b;
				i++;
			}
		}
		CharBuffer decode = Charset.forName("utf-8").decode(bb);
		System.out.println(new String(result));
	}

	@Test
	public void method2() {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("D://1.txt"));
			byte[] buf = new byte[1024];
			int bytesRead = in.read(buf);
			while (bytesRead != -1) {
				for (int i = 0; i < bytesRead; i++)
					System.out.print((char) buf[i]);
				bytesRead = in.read(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void method1() {
		RandomAccessFile aFile = null;
		try {
			aFile = new RandomAccessFile("D://1.txt", "rw");
			FileChannel fileChannel = aFile.getChannel();
			// 创建字节缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);
			// 将数据从通道读取到缓冲区中
			int bytesRead = fileChannel.read(buf);
			System.out.println(bytesRead);
			while (bytesRead != -1) {
				// 将指针归零
				buf.flip();
				// 判断是否有数据,从 position 到 limit
				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}
				buf.compact();
				bytesRead = fileChannel.read(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (aFile != null) {
					aFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
