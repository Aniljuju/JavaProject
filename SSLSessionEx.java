import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLSessionEx {
    public static void main(String[] args) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            SSLSocket socket = (SSLSocket) factory.createSocket("example.com",443);

            socket.startHandshake();
            
            SSLSession session = socket.getSession();

            System.out.println("Session ID:" + bytesToHex(session.getId()));
            System.out.println("Protocol:" + session.getProtocol());
            System.out.println("Cipher Suite:" + session.getCipherSuite());
            System.out.println("Peer Host:" + session.getPeerHost());
            System.out.println("Session Creation Time:" + session.getCreationTime());

            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    private static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(String.format("%02X",b));
        }
        return sb.toString();

    }
}
