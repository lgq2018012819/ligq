import java.util.List;
import java.util.*;
//�ӿڵ�ʵ����
public class StudentManager implements StudentInterface{
	//App�������������������������̣��������ѡ��˵����ȴ��û�����ѡ�Ȼ�����ѡ��ִ����Ӧ������
	public void welcome(){
		System.out.println("********************��ӭʹ��************************");//����
		System.out.println("ϵͳ��ʼ���ɹ�����");
	}
	public void exit(){
		System.out.println("********************ллʹ��************************");//�˳�
	}
	public void showMenu(){
		//��ʾϵͳ�˵�
		System.out.println("\n��ѡ�������");
		System.out.println("********************");
		System.out.println("*  1-->����ѧ����Ϣ  *");
		System.out.println("*  2-->������������  *");
		System.out.println("*  3-->��������ɾ��  *");
		System.out.println("*  4-->���������޸�  *");
		System.out.println("*  5-->���ѧ����Ϣ  *");
		//���ӹ����Ѿ�ʵ��
		System.out.println("******���ӹ���*******");
		System.out.println("*  6-->����ѧ�Ų���  *");
		System.out.println("*  7-->����ѧ��ɾ��  *");
		System.out.println("*  8-->����ѧ���޸�  *");
		System.out.println("*  9-->�˳�                *");
		System.out.println("********************");
	}
	
	//ʹ��HashMap�������е�ѧ����Ϣ�������е�Entry��key��ѧ�š�value����ѧ�Ŷ�Ӧ��ѧ������
	private Map<Integer,Student> students = new HashMap<Integer,Student>();//
	
	//��Scanner��������
	private Scanner scanner = new Scanner(System.in);
	
	//1.���ѧ����Ϣ���ɹ���
	@Override
	public boolean addStudent() {
		// ����ѧ������Ϣ
		int sid = MyTools.getInputNumber("������ѧ����ѧ�ţ�", scanner);
		String name = MyTools.getInputString("������ѧ����������", scanner);
		int age = MyTools.getInputNumber("������ѧ�������䣺", scanner);
		Sex sex = MyTools.getInputString("������ѧ�����Ա�", scanner).equals("��")?Sex.��:Sex.Ů;
		//����ѧ������
		Student s = new Student(sid,name,age,sex);
		students.put(sid,s);
		System.out.println("���ѧ����Ϣ�ɹ���");
		return true;
	}
	//2.������������ѧ�����ɹ���
	@Override
	public List<Student> findStudentByName(String name) {
		//���صõ�ѧ�����б�
		List<Student> list = new ArrayList<Student>();
		// �������е�ѧ����Ȼ���name������бȽ�
		Collection<Student> stus = students.values();
		Iterator<Student> iterator = stus.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			if(student.getName().equals(name)){
				list.add(student);
			}
		}
		return list.size() == 0?null:list;
	}
	public void findStudentByName() {
		// ʵ������ҵ�񷽷�
		String name = MyTools.getInputString("������Ҫ���ҵ�ѧ����������", scanner);
		List<Student> stus = findStudentByName(name);
		if(stus == null){
			System.out.println("��������ѧ�������ڣ�");
		}else{
			//��ӡ���е�ѧ������Ϣ
			System.out.println("���ҵ���ѧ������Ϣ���£�");
			for(int i = 0;i<stus.size();i++){
				System.out.println(stus.get(i));
			}
		}
	}
	//3.��������ɾ��ѧ����Ϣ
	@Override
	public List<Student> deleteStudentByName(String name) {
		// ��ȡ����ɾ��
		//Student student = students.remove(name);
		List<Student> list = new ArrayList<Student>();
		// �������е�ѧ����Ȼ���name������бȽ�
		Collection<Student> stus = students.values();
		Iterator<Student> iterator = stus.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			if(student.getName().equals(name)){
				list.add(student);
			}
		}
		return list.size() == 0?null:list;

		//return student == null?false:true;
	}
	public void deleteStudentByName() {
		// ʵ������ҵ�񷽷�
		String name = MyTools.getInputString("������Ҫɾ����ѧ����������", scanner);
		//boolean bool = deleteStudentByName(name);
		List<Student> stus = deleteStudentByName(name);
		if(stus == null){
			System.out.println("��������ѧ�������ڣ�");
		}else{
			for(int i = 0;i<stus.size();i++){
			if (name.equals()){
                 stus.remove(i);
                 System.out.println("ɾ���ɹ���");
             }
			System.out.println("ɾ��ѧ���ɹ���");
		}
		/*if(true){
			System.out.println("ɾ��ѧ���ɹ���");
		}else{
			System.out.println("��ѧ�������ڡ�");
		}*/
		
	}
	//4.���������޸�ѧ����Ϣ
	
	
	@Override
	public Student modifyStudentByName(String name) {
		
		Student student2 = students.get(name);
		if(student2 !=null){
			//���������������Ҫ�޸ĵ���Ϣ
			int sid = MyTools.getInputNumber("�������µ�ѧ����ѧ�ţ�", scanner);
			name = MyTools.getInputString("�������µ�ѧ����������", scanner);
			int age = MyTools.getInputNumber("�������µ�ѧ�������䣺", scanner);
			Sex sex = MyTools.getInputString("�������µ�ѧ�����Ա�", scanner).equals("��")?Sex.��:Sex.Ů;
			//���벢��ȡ����
			student2.setSid(sid);
			student2.setName(name);
			student2.setAge(age);
			student2.setSex(sex);
		}
		return student2;
	}
	public void modifyStudentByName() {
		// ����ʵ������ҵ�񷽷�
		String name = MyTools.getInputString("������Ҫ�޸ĵ�ѧ����������", scanner);
		Student stu = modifyStudentByName(name);
		if(name.equals(stu)){
			System.out.println("�޸�ѧ����Ϣ�ɹ���");
		}else{
			System.out.println("ѧ�������ڡ�");
		}
	}
		
	//5.�����������ѧ����Ϣ���ɹ���
	@Override
	public void showAll() {
		// ��ȡѧ����ѧ��
		Set<Integer> sids = students.keySet();
		Iterator<Integer> iterator = sids.iterator();
		while(iterator.hasNext()){
			Integer sid = iterator.next();
			Student student = students.get(sid);
			System.out.println(student);
		}
	}
	
	//���ӹ����ѳɹ�ʵ��
	//6.����ѧ�Ų���ѧ�����ɹ���
	@Override
	public Student findStudentBySid(int sid) {
		// ����ѧ�Ų��ң��Աȴ������
		Student student = students.get(sid);
		if(student != null){
			System.out.println(student);
		}else{
			System.out.println("��ѧ�������ڣ�");
		}
		return student;
	}
	public Student findStudentBySid() {
		//ʵ������
		int sid = MyTools.getInputNumber("������Ҫ���ҵ�ѧ����ѧ�ţ�", scanner);
		return findStudentBySid(sid);
	}
	//7.����ѧ��ɾ��ѧ����Ϣ���ɹ���
	@Override
	public boolean deleteStudentBySid(int sid) {
		// ��ȡѧ��ɾ��
		Student student = students.remove(sid);
		return student == null?false:true;
	}
	public void deleteStudentBySid() {
		// ʵ������ҵ�񷽷�
		int sid = MyTools.getInputNumber("������Ҫɾ����ѧ����ѧ�ţ�", scanner);
		boolean bool = deleteStudentBySid(sid);
		if(bool){
			System.out.println("ɾ��ѧ���ɹ���");
		}else{
			System.out.println("��ѧ�������ڡ�");
		}
	}
	//8.����ѧ���޸�ѧ����Ϣ���ɹ���
	@Override
	public boolean modifyStudentBySid(int sid) {
		// 
		Student student = students.get(sid);
		if(student !=null){
			//���������������Ҫ�޸ĵ���Ϣ
			sid = MyTools.getInputNumber("�������µ�ѧ����ѧ�ţ�", scanner);
			String name = MyTools.getInputString("�������µ�ѧ����������", scanner);
			int age = MyTools.getInputNumber("�������µ�ѧ�������䣺", scanner);
			Sex sex = MyTools.getInputString("�������µ�ѧ�����Ա�", scanner).equals("��")?Sex.��:Sex.Ů;
			//���벢��ȡ����
			student.setSid(sid);
			student.setName(name);
			student.setAge(age);
			student.setSex(sex);
		}
		return student == null ?false:true;
	}
	public void modifyStudentBySid() {
		// ����ʵ������ҵ�񷽷�
		int sid = MyTools.getInputNumber("������Ҫ�޸ĵ�ѧ����ѧ�ţ�", scanner);
		boolean bool = modifyStudentBySid(sid);
		if(bool){
			System.out.println("�޸�ѧ����Ϣ�ɹ���");
		}else{
			System.out.println("ѧ�������ڡ�");
		}
	}
	
}


