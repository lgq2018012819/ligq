import java.util.Scanner;

public class StudentSystemApp {
	public static void main(String[] args) {
		// д����������StudentManager�������ʵ�ַ���
		StudentManager manager = new StudentManager();
		//ִ������Main������ִ��StudentManager��App����
		manager.welcome();
		Scanner scanner = new Scanner(System.in);
		while(true){
			manager.showMenu();
			int input = MyTools.getInputNumber("��ѡ�����Ĳ�����",scanner);
			switch(input){
				case 1:
					manager.addStudent();//����ѧ����Ϣ
					break;
				case 2:
					manager.findStudentByName();//������������
					break;
				case 3:
					manager.deleteStudentByName();//��������ɾ��
					break;
				case 4:
					manager.modifyStudentByName();//���������޸�
					break;
				case 5:
					manager.showAll();//�������ѧ����Ϣ
					break;
				//���ӹ���
				case 6:
					manager.findStudentBySid();//����ѧ�Ų���
					break;
				case 7:
					manager.deleteStudentBySid();//����ѧ��ɾ��
					break;
				case 8:
					manager.modifyStudentBySid();//����ѧ���޸�
					break;
				case 9:
					manager.exit();//�˳�
					return;
			}
		}
		
	}

}
