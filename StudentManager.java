import java.util.List;
import java.util.*;
//接口的实现类
public class StudentManager implements StudentInterface{
	//App方法，负责程序的整个控制流程（首先输出选择菜单，等待用户输入选项；然后根据选项执行相应操作）
	public void welcome(){
		System.out.println("********************欢迎使用************************");//进入
		System.out.println("系统初始化成功……");
	}
	public void exit(){
		System.out.println("********************谢谢使用************************");//退出
	}
	public void showMenu(){
		//显示系统菜单
		System.out.println("\n请选择操作：");
		System.out.println("********************");
		System.out.println("*  1-->插入学生信息  *");
		System.out.println("*  2-->根据姓名查找  *");
		System.out.println("*  3-->根据姓名删除  *");
		System.out.println("*  4-->根据姓名修改  *");
		System.out.println("*  5-->输出学生信息  *");
		//附加功能已经实现
		System.out.println("******附加功能*******");
		System.out.println("*  6-->根据学号查找  *");
		System.out.println("*  7-->根据学号删除  *");
		System.out.println("*  8-->根据学号修改  *");
		System.out.println("*  9-->退出                *");
		System.out.println("********************");
	}
	
	//使用HashMap保存所有的学生信息，容器中的Entry的key是学号。value就是学号对应的学生对象
	private Map<Integer,Student> students = new HashMap<Integer,Student>();//
	
	//用Scanner输入数据
	private Scanner scanner = new Scanner(System.in);
	
	//1.添加学生信息（成功）
	@Override
	public boolean addStudent() {
		// 插入学生的信息
		int sid = MyTools.getInputNumber("请输入学生的学号：", scanner);
		String name = MyTools.getInputString("请输入学生的姓名：", scanner);
		int age = MyTools.getInputNumber("请输入学生的年龄：", scanner);
		Sex sex = MyTools.getInputString("请输入学生的性别：", scanner).equals("男")?Sex.男:Sex.女;
		//创建学生对象
		Student s = new Student(sid,name,age,sex);
		students.put(sid,s);
		System.out.println("添加学生信息成功！");
		return true;
	}
	//2.根据姓名查找学生（成功）
	@Override
	public List<Student> findStudentByName(String name) {
		//返回得到学生的列表
		List<Student> list = new ArrayList<Student>();
		// 遍历所有的学生，然后和name逐个进行比较
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
		// 实现输入业务方法
		String name = MyTools.getInputString("请输入要查找的学生的姓名：", scanner);
		List<Student> stus = findStudentByName(name);
		if(stus == null){
			System.out.println("该姓名的学生不存在！");
		}else{
			//打印所有的学生的信息
			System.out.println("查找到的学生的信息如下：");
			for(int i = 0;i<stus.size();i++){
				System.out.println(stus.get(i));
			}
		}
	}
	//3.根据姓名删除学生信息
	@Override
	public List<Student> deleteStudentByName(String name) {
		// 获取姓名删除
		//Student student = students.remove(name);
		List<Student> list = new ArrayList<Student>();
		// 遍历所有的学生，然后和name逐个进行比较
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
		// 实现输入业务方法
		String name = MyTools.getInputString("请输入要删除的学生的姓名：", scanner);
		//boolean bool = deleteStudentByName(name);
		List<Student> stus = deleteStudentByName(name);
		if(stus == null){
			System.out.println("该姓名的学生不存在！");
		}else{
			for(int i = 0;i<stus.size();i++){
			if (name.equals()){
                 stus.remove(i);
                 System.out.println("删除成功！");
             }
			System.out.println("删除学生成功！");
		}
		/*if(true){
			System.out.println("删除学生成功！");
		}else{
			System.out.println("该学生不存在。");
		}*/
		
	}
	//4.根据姓名修改学生信息
	
	
	@Override
	public Student modifyStudentByName(String name) {
		
		Student student2 = students.get(name);
		if(student2 !=null){
			//如果不存在则输入要修改的信息
			int sid = MyTools.getInputNumber("请输入新的学生的学号：", scanner);
			name = MyTools.getInputString("请输入新的学生的姓名：", scanner);
			int age = MyTools.getInputNumber("请输入新的学生的年龄：", scanner);
			Sex sex = MyTools.getInputString("请输入新的学生的性别：", scanner).equals("男")?Sex.男:Sex.女;
			//输入并获取保存
			student2.setSid(sid);
			student2.setName(name);
			student2.setAge(age);
			student2.setSex(sex);
		}
		return student2;
	}
	public void modifyStudentByName() {
		// 重载实现输入业务方法
		String name = MyTools.getInputString("请输入要修改的学生的姓名：", scanner);
		Student stu = modifyStudentByName(name);
		if(name.equals(stu)){
			System.out.println("修改学生信息成功！");
		}else{
			System.out.println("学生不存在。");
		}
	}
		
	//5.遍历输出所有学生信息（成功）
	@Override
	public void showAll() {
		// 获取学生的学号
		Set<Integer> sids = students.keySet();
		Iterator<Integer> iterator = sids.iterator();
		while(iterator.hasNext()){
			Integer sid = iterator.next();
			Student student = students.get(sid);
			System.out.println(student);
		}
	}
	
	//附加功能已成功实现
	//6.根据学号查找学生（成功）
	@Override
	public Student findStudentBySid(int sid) {
		// 根据学号查找，对比存在与否
		Student student = students.get(sid);
		if(student != null){
			System.out.println(student);
		}else{
			System.out.println("该学生不存在！");
		}
		return student;
	}
	public Student findStudentBySid() {
		//实现输入
		int sid = MyTools.getInputNumber("请输入要查找的学生的学号：", scanner);
		return findStudentBySid(sid);
	}
	//7.根据学号删除学生信息（成功）
	@Override
	public boolean deleteStudentBySid(int sid) {
		// 获取学号删除
		Student student = students.remove(sid);
		return student == null?false:true;
	}
	public void deleteStudentBySid() {
		// 实现输入业务方法
		int sid = MyTools.getInputNumber("请输入要删除的学生的学号：", scanner);
		boolean bool = deleteStudentBySid(sid);
		if(bool){
			System.out.println("删除学生成功！");
		}else{
			System.out.println("该学生不存在。");
		}
	}
	//8.根据学号修改学生信息（成功）
	@Override
	public boolean modifyStudentBySid(int sid) {
		// 
		Student student = students.get(sid);
		if(student !=null){
			//如果不存在则输入要修改的信息
			sid = MyTools.getInputNumber("请输入新的学生的学号：", scanner);
			String name = MyTools.getInputString("请输入新的学生的姓名：", scanner);
			int age = MyTools.getInputNumber("请输入新的学生的年龄：", scanner);
			Sex sex = MyTools.getInputString("请输入新的学生的性别：", scanner).equals("男")?Sex.男:Sex.女;
			//输入并获取保存
			student.setSid(sid);
			student.setName(name);
			student.setAge(age);
			student.setSex(sex);
		}
		return student == null ?false:true;
	}
	public void modifyStudentBySid() {
		// 重载实现输入业务方法
		int sid = MyTools.getInputNumber("请输入要修改的学生的学号：", scanner);
		boolean bool = modifyStudentBySid(sid);
		if(bool){
			System.out.println("修改学生信息成功！");
		}else{
			System.out.println("学生不存在。");
		}
	}
	
}


