package com.example.spring5.webflux;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.start();
    }

    public void start() {
        BufferedReader inputReader = null;
        // 从socket读取
        BufferedWriter writer = null;
        Socket socket = null;
        DataInputStream in = null;
        // Alt + Shift + z    try...catch等快捷键
        // 从Console读取内容
        try {
            socket = new Socket("127.0.0.1", 8080);
            // 用于读取服务器返回的数据
            in = new DataInputStream(socket.getInputStream());
            // 从socket进行写入
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            String inputContent;
            while (!(inputContent = inputReader.readLine()).equals("bye")) {
                writer.write(inputContent + "\n");
                writer.flush();
//				System.out.println(inputContent);
                // 服务器返回的数据
                byte[] bytes = new byte[100];
                in.read(bytes);
                System.out.println("服务端发话了:"+new String(bytes,"UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                writer.close();
                inputReader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
