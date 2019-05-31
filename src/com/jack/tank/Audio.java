
package com.jack.tank;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

public class Audio {


	public void run() {
		try {
			byte[] b = new byte[1024];
			int len = 0;
			sourceDataLine.open(audioFormat, 1024);
			sourceDataLine.start();
			while ((len = audioInputStream.read(b)) > 0) {
				sourceDataLine.write(b, 0, len);
			}
			audioInputStream.reset();
			sourceDataLine.drain();
			sourceDataLine.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AudioFormat audioFormat = null;
	private SourceDataLine sourceDataLine = null;
	private DataLine.Info dataLine_info = null;

	private AudioInputStream audioInputStream = null;

	public Audio(String fileName) {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(Audio.class.getClassLoader().getResource(fileName));
			audioFormat = audioInputStream.getFormat();
			dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			audioInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
