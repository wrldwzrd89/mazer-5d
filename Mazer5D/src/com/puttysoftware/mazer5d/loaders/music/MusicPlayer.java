/* Ogg Player for Java
Licensed under Apache 2.0. See the LICENSE file for details.

All support is handled via the GitHub repository: https://github.com/wrldwzrd89/lib-java-audio-Ogg
 */
package com.puttysoftware.mazer5d.loaders.music;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

class MusicPlayer {
    private AudioInputStream stream;
    private AudioInputStream decodedStream;
    private AudioFormat format;
    private AudioFormat decodedFormat;
    private boolean stop;

    public MusicPlayer(final AudioInputStream ais) {
        this.stream = ais;
        this.stop = false;
    }

    public void playLoop() {
        while (!this.stop) {
            try {
                // Get AudioInputStream from given file.
                this.decodedStream = null;
                if (this.stream != null) {
                    this.format = this.stream.getFormat();
                    this.decodedFormat = new AudioFormat(
                            AudioFormat.Encoding.PCM_SIGNED,
                            this.format.getSampleRate(), 16,
                            this.format.getChannels(),
                            this.format.getChannels() * 2,
                            this.format.getSampleRate(), false);
                    // Get AudioInputStream that will be decoded by underlying
                    // VorbisSPI
                    this.decodedStream = AudioSystem.getAudioInputStream(
                            this.decodedFormat, this.stream);
                }
            } catch (Exception e) {
                // Do nothing
            }
            try (SourceDataLine line = MusicPlayer.getLine(this.decodedFormat)) {
                if (line != null) {
                    try {
                        byte[] data = new byte[4096];
                        // Start
                        line.start();
                        int nBytesRead = 0;
                        while (nBytesRead != -1) {
                            nBytesRead = this.decodedStream.read(data, 0,
                                    data.length);
                            if (nBytesRead != -1) {
                                line.write(data, 0, nBytesRead);
                            }
                            if (this.stop) {
                                break;
                            }
                        }
                        // Stop
                        line.drain();
                        line.stop();
                    } catch (IOException io) {
                        // Do nothing
                    } finally {
                        // Stop
                        line.drain();
                        line.stop();
                    }
                }
            } catch (LineUnavailableException lue) {
                // Do nothing
            }
        }
    }

    private static SourceDataLine getLine(AudioFormat audioFormat)
            throws LineUnavailableException {
        SourceDataLine res = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                audioFormat);
        Line line = AudioSystem.getLine(info);
        res = (SourceDataLine) line;
        res.open(audioFormat);
        return res;
    }

    public void stopLoop() {
        this.stop = true;
    }
}
