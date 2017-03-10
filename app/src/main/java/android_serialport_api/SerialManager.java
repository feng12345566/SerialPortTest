package android_serialport_api;

import android.util.Log;


import com.su.sdk.ObdUtil;
import com.su.sdk.OnReceiveListener;
import com.su.sdk.OnSentListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;

/**
 * Created by Admin on 2016/8/6.
 */
public class SerialManager {
    private static final String TAG = "SerialManager";
    private static SerialManager instance;
    private boolean isRunning = false;
    private InputStream mInputStream;
    protected OutputStream mOutputStream;
    private ReadThread mReadThread;
    protected SerialPort mSerialPort;
    private OnReceiveListener receiveListener = null;
    private OnSentListener sentListener = null;

    public SerialManager() {
        start();
    }


    private void SerialReadStart() {
        this.mReadThread = new ReadThread();
        this.mReadThread.start();
    }

    public static SerialManager getInstance() {
        if (instance == null) ;
        try {
            if (instance == null)
                instance = new SerialManager();
            return instance;
        } finally {
        }
    }

    private void notifyBytesReceive(byte[] paramArrayOfByte) {
        if (this.receiveListener != null)
            this.receiveListener.onBytesReceive(paramArrayOfByte);
    }

    public SerialPort getSerialPort()
            throws SecurityException, IOException, InvalidParameterException {
        if (this.mSerialPort == null) {
            this.mSerialPort = new SerialPort(new File("/dev/ttyMT2"), 9600, 0);
            this.mOutputStream = this.mSerialPort.getOutputStream();
            this.mInputStream = this.mSerialPort.getInputStream();
        }
        return this.mSerialPort;
    }

    public void registerReceiveListener(OnReceiveListener paramOnReceiveListener) {
        this.receiveListener = paramOnReceiveListener;
    }

    public void registerSentListener(OnSentListener paramOnSentListener) {
        this.sentListener = paramOnSentListener;
    }

    public void sendBytes(byte[] paramArrayOfByte) {
        Log.e("sendBytes",ObdUtil.bytesToHexString(paramArrayOfByte));
        if (this.mOutputStream == null)
            return;
        try {
            try {
                this.mOutputStream.write(paramArrayOfByte);
                return;
            } finally {
            }
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
    }

    public void start() {
        if (!this.isRunning)
            this.isRunning = true;
        try {
            getSerialPort();
            SerialReadStart();
            Log.e("SerialManager", "start");
            return;
        } catch (InvalidParameterException localInvalidParameterException) {
            while (true)
                localInvalidParameterException.printStackTrace();
        } catch (SecurityException localSecurityException) {
            while (true)
                localSecurityException.printStackTrace();
        } catch (IOException localIOException) {
            while (true)
                localIOException.printStackTrace();
        }
    }

    public void stop() {
        Log.v("SerialManager", "stop");
        this.isRunning = false;
        if (this.mReadThread != null)
            this.mReadThread.interrupt();
        if (this.mSerialPort != null) {
            this.mSerialPort.close();
            this.mSerialPort = null;
        }
        instance = null;
    }



    private class ReadThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                int size;
                try {
                    if (mInputStream == null)
                        return;
                    byte[] buffer = new byte[512];
                    size = mInputStream.read(buffer);
                    if (size > 0) {
                        if (null != receiveListener) {
                            byte[] data=new byte[size];
                            for(int j=0;j<size;j++){
                                data[j]=buffer[j];
                            }
                            receiveListener.onBytesReceive(data);
                        }
                    }
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }


}
