import java.util.Scanner;  
  
//最短寻道时间优先  
//该算法要求访问的磁道与当前磁头所在的磁道距离最近，以使每次的寻道时间最短
public class SSTF {  
  
    private int shortIndex = 0;  //纪录最近磁道索引  
    private int visit[];    //声明访问序列  
  
    public int[] sstf(int data[],int begin) {  
        int nearest = 99999;  //纪录当前磁道与下一个要访问的磁道的最近的距离 
        visit = new int[data.length]; //为visit()分配内存  
        for(int j = 0; j < data.length; j++) {
        	//判断访问序列数据中哪一个离当前磁道最近，取最小者赋值给nearest，同时纪录该索引值
            for(int i = 0; i < data.length; i++) {  
                if(data[i] != -1) {  
                    if(Math.abs(nearest - begin) > Math.abs(data[i] - begin)) {  
                        nearest = data[i];  
                        shortIndex = i;  
                    }  
                }  
            }
            visit[j] = nearest; // 第j个访问的数据
            data[shortIndex] = -1; //除去已经访问过的数据 
            begin = nearest;  //当前磁道
            nearest = 99999;  
        }  
        return visit; //返回访问数列 
    }  
    public void print(int visit[], int begin) {  
    	System.out.print("接下来要访问的磁道:[     ");
    	for(int i = 0; i < visit.length; i++) {  
            System.out.print(visit[i]+"     ");  
        }
        System.out.println("]");
        int length = 0;  
        for(int i = 0; i < visit.length - 1; i++) {  
            length += Math.abs(visit[i] - visit[i + 1]);  
        }  
        length += Math.abs(begin - visit[0]);  
        float l = length;
        System.out.println("平均寻道长度为"+l/visit.length);  
    }  
    public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);  // 首先构造scanner对象，，并与标准输入流System.in关联
        System.out.println("请输入请求序列的个数");  //System.out.println();输出、换行
        int num = in.nextInt(); 
        //nextInt：下一个整数, next：下一个字符串, nextLine：下一行，空格也在对象里, nextDouble：下一个浮点数
        System.out.println("请输入请求序列，空格隔开");  
        int data[] = new int[num];  //数组，类的实例化，使用前要用new分配内存。 为什么简单数据类型int等不用new呢？
        for(int i = 0; i < num; i++) {  
            data[i] = in.nextInt();  
        }  //数列的赋值，通过for循环一个一个赋值
        SSTF sstfObject = new SSTF();  //当需要用到一个类(接口、抽象类除外)的时候，需要new来进行初始化，才可以调用该类的方法、属性、变量等
        System.out.println("请输入起始头位置");  //100
        int begin = in.nextInt();  
        sstfObject.print(sstfObject.sstf(data,begin),begin);  
        //如果要将数组传递到方法里，只需在方法名后的括号内写上【数组的名】即可。
        //二维数组的传递与一维数组相似，在需要的方法里声明传入的参数是一个二维数组。
    }  
//23 376 205 132 19 61 190 398 29 4 18 40
}  