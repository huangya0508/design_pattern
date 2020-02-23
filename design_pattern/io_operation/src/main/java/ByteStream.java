import java.io.*;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 */
public class ByteStream {

    // 使用文件字节流 一次拷贝一个字节
    private static void copyFile1(String src, String dest) throws IOException {
        //1. 创建流
        InputStream in = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);

        //2. 读写数据
        int size = 0;
        while ((size = in.read()) != -1) {
            os.write(size);
        }

        //3. 关闭流
        in.close();
        os.close();
    }



    // 使用文件字节流 一次拷贝一个字节数组
    public static void copyFile2(String src,String dest) throws IOException{
        //1. 创建流
        InputStream in = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);

        //读写流
        byte[] bytes = new byte[1024];
        int size = 0;
        while ((size = in.read(bytes)) != -1){
            os.write(bytes,0,size);
        }

        //关闭流
        in.close();
        os.close();
    }

    // 向文件中写入 java基本数据类型
    public static void  write(String dest) throws IOException{
        DataOutputStream os = new DataOutputStream(new FileOutputStream(dest));
        os.writeInt(1);
        os.writeChar('h');
        os.close();
    }

    // 从文件中读取 java基本数据类型，要和写入的顺序保持一致
    private static void read(String src) throws IOException {
        //1. 创建数据流对象
        DataInputStream in = new DataInputStream(new FileInputStream(src));
        //2. 读取数据
        int a = in.readInt();
        char b = in.readChar();
        System.out.println(a);
        System.out.println(b);
        //3. 关闭流
        in.close();
    }
}
