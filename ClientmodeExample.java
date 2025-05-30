import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ClientmodeExample {
    public static void main(String[] args)throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        SSLSocket socket = (SSLSocket) factory.createSocket("example.com",443);

        socket.setUseClientMode(true);
        socket.startHandshake();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

        writer.write("GET / HTTP/1.1\r\n");
        writer.write("Host: example.com\r\n");
        writer.write("\r\n");
        writer.flush();

        BufferedReader reader = new BufferedReader(
                   new InputStreamReader(socket.getInputStream()));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
        writer.close();
        socket.close();
    }
}
