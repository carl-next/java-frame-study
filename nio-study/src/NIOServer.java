import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author zhangtao
 * @Title: NIOServer
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 1/25/21 9:59 PM
 */

public class NIOServer {
    public static void main(String[] args) throws IOException {
        //创建网络服务端
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //设为非阻塞【默认均是阻塞的】
        serverSocketChannel.configureBlocking(false);
        //端口绑定
        serverSocketChannel.socket().bind(new InetSocketAddress(8090));
        System.out.println("服务端启动成功！");

        while (true){
            //获取tcp链接通道【传统socket：为阻塞 此处不是】
            SocketChannel socketChannel=serverSocketChannel.accept();
            //tcp读取/响应
            if(socketChannel!=null){
                System.out.println("收到新的链接："+socketChannel.getRemoteAddress());
                //设为非阻塞【默认均是阻塞的】
                socketChannel.configureBlocking(false);
                try{
                    ByteBuffer requestBuffer=ByteBuffer.allocate(1024);
                    while (socketChannel.isOpen()&&socketChannel.read(requestBuffer)!=-1){

                    }

                }catch (Exception e){

                }
            }
        }
    }
}
