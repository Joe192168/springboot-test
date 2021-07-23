package jvm;

//自定义ClassLoader
class FileClassLoader extends  ClassLoader{
    private String rootDir;

    public FileClassLoader() {
    }

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
       //...省略逻辑代码
       return null;
    }
	
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        //省略代码....
        return null;
    }
}

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
       
			 FileClassLoader loader1 = new FileClassLoader();

              System.out.println("自定义类加载器的父加载器: "+loader1.getClass().getClassLoader());
			  System.out.println("自定义类加载器的父加载器: "+loader1.getParent());
			  System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
			  System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
			  System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());
			
			/**
			输出结果:
             自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@18b4aac2
             系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@18b4aac2
             AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@27716f4
             ExtClassLoader的父类加载器: null
			*/
    }
}