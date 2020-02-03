import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 通讯要素：
 * IP地址 和 端口号
 * @author caowei
 * @create 2020/2/3
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        ipAddressDemo();
    }

    /**
     * IP地址
     * @throws UnknownHostException
     */
    private static void ipAddressDemo() throws UnknownHostException {
        // 域名通过DNS解析出IP
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        InetAddress NetEase = InetAddress.getByName("www.163.com");
        InetAddress taobao = InetAddress.getByName("www.taobao.com");
        InetAddress google = InetAddress.getByName("www.google.com");
        InetAddress localHost = InetAddress.getLocalHost();  // 获取本机IP地址。 PC-CW/192.168.98.1

        // 两个常用就去：获取域名, 获取IP
        System.out.println(baidu.getHostName()+","+baidu.getHostAddress()); // 解析出的IP正常访问
        /**
         * 解析出的IP直接访问，服务器拒绝了。但地址是确实存在的。
         * 提示信息：
         * 404 Not Found
         * yd-hebei-baoding-2-111-63-74-2
         * nginx/1.15.6
         */
        System.out.println(NetEase);
        /**
         * 提示信息：
         * 403 Forbidden
         * You don't have permission to access the URL on this server.
         * Powered by Tengine
         * 注：Tengine是淘宝自己开发的服务器
         */
        System.out.println(taobao);
        System.out.println(google);  // 不允许翻墙，访问不了
        System.out.println(localHost);
    }
}
