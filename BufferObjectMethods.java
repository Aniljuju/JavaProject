import java.nio.ByteBuffer;

public class BufferObjectMethods {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(5);
        ByteBuffer buffer2 = ByteBuffer.allocate(5);

        for(byte i = 1; i<=5; i++){
            buffer1.put(i);
            buffer2.put(i);
        }

        buffer1.flip();
        buffer2.flip();

        //equals()
        System.out.println("Are bufffers equal?"+buffer1.equals(buffer2));

        //hashcode()
        System.out.println("Buffer1 hashcode:" + buffer1.hashCode());
        System.out.println("Buffer2 hashcode:" + buffer2.hashCode());

        //compareTo()
        int result = buffer1.compareTo(buffer2);
        if(result==0){
            System.out.println("Buffers are equal using compareTo()");
        }else if(result<0){
            System.out.println("Buffer1 is less than Buffer2");
        }else{
            System.out.println("Buffer1 is greater than Buffer2");
        }

        //toString()
        System.out.println("Buffer1 info:" + buffer1.toString());
        System.out.println("Buffer2 info:" + buffer2.toString());
    }
}
