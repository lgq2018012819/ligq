import java.util.List;

public interface StudentInterface {

	void showAll();//�������ѧ����Ϣ
	
	boolean addStudent();//����ѧ����Ϣ
	
	List<Student> findStudentByName(String name);//����������ѧ��
	/*���ܴ������������б����*/
	List<Student> deleteStudentByName(String name);//������ɾ��ѧ��
	
	Student modifyStudentByName(String name);//�������޸���Ϣ
	//���ӹ���
	Student findStudentBySid(int sid);//��ѧ�Ų���ѧ��
	
	boolean deleteStudentBySid(int sid);//��ѧ��ɾ��ѧ��
	
	boolean modifyStudentBySid(int sid);//��ѧ���޸���Ϣ
}