import java.util.Scanner;  
  
//最短寻道时间优先  
//该算法要求访问的磁道与当前磁头所在的磁道距离最近，以使每次的寻道时间最短
public class SSTF {  
  
    private int shortIndex=0;      
    private int visit[];    //访问序列  
  
    public int[] sstf(int data[],int begin){  
        int nearest=99999;  //最近的值，变量  
        visit=new int[data.length];  
        for(int j=0;j<data.length;j++){  
            for(int i=0;i<data.length;i++){  
                if(data[i]!=-1){  
                    if(Math.abs(nearest-begin)>Math.abs(data[i]-begin)){  
                        nearest=data[i];  
                        shortIndex=i;  
                    }  
                }  
            }  
            visit[j]=nearest;  
            data[shortIndex]=-1;  
            begin=nearest;  
            nearest=99999;  
        }  
        return visit;  
    }  
    public void print(int visit[],int begin){  
    	System.out.print("接下来要访问的磁道:[     ");
    	for(int i=0;i<visit.length;i++){  
            System.out.print(visit[i]+"     ");  
        }
        System.out.println("]");
        int length=0;  
        for(int i=0;i<visit.length-1;i++){  
            length+=Math.abs(visit[i]-visit[i+1]);  
        }  
        length+=Math.abs(begin-visit[0]);  
        float l = length;
        System.out.println("平均寻道长度为"+l/visit.length);  
    }  
    public static void main(String[] args) {  
        Scanner in=new Scanner(System.in);  // 首先构造scanner对象，，并与标准输入流System.in关联
        System.out.println("请输入请求序列的个数");  //System.out.println();输出、换行
        int num=in.nextInt(); 
        //nextInt：下一个整数, next：下一个字符串, nextLine：下一行，空格也在对象里, nextDouble：下一个浮点数
        System.out.println("请输入请求序列，空格隔开");  
        int data[]=new int[num];  
        for(int i=0;i<num;i++){  
            data[i]=in.nextInt();  
        }  //数列的赋值，通过for循环一个一个赋值
        SSTF sstf=new SSTF();  
        System.out.println("请输入起始头位置");  //100
        int begin=in.nextInt();  
        sstf.print(sstf.sstf(data,begin),begin);  
    }  
//23 376 205 132 19 61 190 398 29 4 18 40
}  