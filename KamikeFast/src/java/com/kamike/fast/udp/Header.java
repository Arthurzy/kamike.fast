/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamike.fast.udp;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.kamike.fast.FastConfig;
import java.net.DatagramPacket;

/**
 *
 * @author THiNk
 */
public class Header {

    private byte[] buffer;
    private long high;
    private long low;
    private long size;
    private long window;
    private int type;
    private int id;
    private int length;
    private int score;

    public void load(byte[] buffer) {
        if (buffer == null || buffer.length < FastConfig.HeaderLength) {
            return;
        }
        high = Longs.fromBytes(buffer[000], buffer[001], buffer[002], buffer[003], buffer[004], buffer[005], buffer[006], buffer[007]);
        low = Longs.fromBytes(buffer[010], buffer[011], buffer[012], buffer[013], buffer[014], buffer[015], buffer[016], buffer[017]);
        size = Longs.fromBytes(buffer[020], buffer[021], buffer[022], buffer[023], buffer[024], buffer[025], buffer[026], buffer[027]);
        window = Longs.fromBytes(buffer[030], buffer[031], buffer[032], buffer[033], buffer[034], buffer[035], buffer[036], buffer[037]);
        type = Ints.fromBytes(buffer[040], buffer[041], buffer[042], buffer[043]);
        id = Ints.fromBytes(buffer[044], buffer[045], buffer[046], buffer[047]);
        length = Ints.fromBytes(buffer[050], buffer[051], buffer[052], buffer[053]);
        score = Ints.fromBytes(buffer[054], buffer[055], buffer[056], buffer[057]);

    }

    public void load(DatagramPacket packet) {
        if (buffer == null) {
            buffer = new byte[FastConfig.HeaderLength];
        }
        System.arraycopy(packet.getData(), packet.getOffset(), buffer, 0, FastConfig.HeaderLength);
        this.load(buffer);
    }

    public byte[] data() {
        if (buffer == null) {
            buffer = new byte[FastConfig.HeaderLength];

            int count = 0;

            byte[] temp = Longs.toByteArray(high);
            for (int i = 0; i < temp.length; i++) {
                buffer[count] = temp[i];
                count++;
            }
            temp = Longs.toByteArray(low);
            for (int i = 0; i < temp.length; i++) {
                buffer[count] = temp[i];
                count++;
            }
            temp = Longs.toByteArray(getSize());
            for (int i = 0; i < temp.length; i++) {
                buffer[count] = temp[i];
                count++;
            }
            temp = Longs.toByteArray(window);
            for (int i = 0; i < temp.length; i++) {
                buffer[count] = temp[i];
                count++;
            }

            byte[] intTemp = Ints.toByteArray(type);
            intTemp = Ints.toByteArray(type);
            for (int i = 0; i < intTemp.length; i++) {
                buffer[count] = intTemp[i];
                count++;
            }
            intTemp = Ints.toByteArray(id);
            for (int i = 0; i < intTemp.length; i++) {
                buffer[count] = intTemp[i];
                count++;
            }

            intTemp = Ints.toByteArray(length);
            for (int i = 0; i < intTemp.length; i++) {
                buffer[count] = intTemp[i];
                count++;
            }
            intTemp = Ints.toByteArray(score);
            for (int i = 0; i < intTemp.length; i++) {
                buffer[count] = intTemp[i];
                count++;
            }
        }
        return buffer;
    }

    /**
     * @return the buffer
     */
    public byte[] getBuffer() {
        return buffer;
    }

    /**
     * @return the high
     */
    public long getHigh() {
        return high;
    }

    /**
     * @param high the high to set
     */
    public void setHigh(long high) {
        this.high = high;
    }

    /**
     * @return the low
     */
    public long getLow() {
        return low;
    }

    /**
     * @param low the low to set
     */
    public void setLow(long low) {
        this.low = low;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @param buffer the buffer to set
     */
    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    /**
     * @return the window
     */
    public long getWindow() {
        return window;
    }

    /**
     * @param window the window to set
     */
    public void setWindow(long window) {
        this.window = window;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }
}
