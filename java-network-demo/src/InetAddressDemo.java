import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ͨѶҪ�أ�
 * IP��ַ �� �˿ں�
 * @author caowei
 * @create 2020/2/3
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        ipAddressDemo();
    }

    /**
     * IP��ַ
     * @throws UnknownHostException
     */
    private static void ipAddressDemo() throws UnknownHostException {
        // ����ͨ��DNS������IP
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        InetAddress NetEase = InetAddress.getByName("www.163.com");
        InetAddress taobao = InetAddress.getByName("www.taobao.com");
        InetAddress google = InetAddress.getByName("www.google.com");
        InetAddress localHost = InetAddress.getLocalHost();  // ��ȡ����IP��ַ�� PC-CW/192.168.98.1

        // �������þ�ȥ����ȡ����, ��ȡIP
        System.out.println(baidu.getHostName()+","+baidu.getHostAddress()); // ��������IP��������
        /**
         * ��������IPֱ�ӷ��ʣ��������ܾ��ˡ�����ַ��ȷʵ���ڵġ�
         * ��ʾ��Ϣ��
         * 404 Not Found
         * yd-hebei-baoding-2-111-63-74-2
         * nginx/1.15.6
         */
        System.out.println(NetEase);
        /**
         * ��ʾ��Ϣ��
         * 403 Forbidden
         * You don't have permission to access the URL on this server.
         * Powered by Tengine
         * ע��Tengine���Ա��Լ������ķ�����
         */
        System.out.println(taobao);
        System.out.println(google);  // ������ǽ�����ʲ���
        System.out.println(localHost);
    }
}
