import java.util.Scanner;
//������:ʵ���������ֻ����ַ����Ĵ�ֵ

public class MyTools {
	private MyTools(){	  }
	//�õ�ָ��������������min������max������
	public static int getRandomNumber(int min, int max){
		return (int)(Math.random()*(max-min)+min);
	}
	//���û���ʾ��Ϣ��ͬʱ�����û�����һ������
	public static int getInputNumber(String msg, Scanner scanner){
		System.out.println(msg);
		return scanner.nextInt();
	}
	//���û���ʾ��Ϣ��ͬʱ�����û�����һ���ַ���
	public static String getInputString(String msg, Scanner scanner){
		System.out.println(msg);
		return scanner.next();
	}
}
