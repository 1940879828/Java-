
import java.util.ArrayList;
import java.util.Scanner;

public class StudentBiz {
	Scanner input = new Scanner(System.in);
	// ��Ա���ݴ洢������
	ArrayList<student> stulist = new ArrayList<student>();
	ArrayList<adminer> admlist = new ArrayList<adminer>();

	// �洢��ǰ��¼�û��Ķ����ַ
	int nowuser;
	String nowident = "";

	// ��ʼ����Ա
	public void initList() {
		stulist.add(new student("1", "С��", 100, 80, 80));
		stulist.add(new student("2", "С��", 100, 100, 100));
		stulist.add(new student("3", "С��", 80, 100, 80));
		stulist.add(new student("4", "����", 40, 40, 40));
		admlist.add(new adminer("root", "123456"));
	}

	// ��½����
	public void menu() {
		System.out.println("======��ӭʹ��ѧ������ϵͳ======");
		System.out.println("      	    1.��½");
		System.out.println("      	    2.ע��(����Ա)");
		System.out.println("      	    3.�˳�");
		System.out.println("================================");
		System.out.print("->");
		int key = input.nextInt();
		switch (key) {
		case 1:
			login();
			break;
		case 2:
			register();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("���棺���벻���ַ����������˳���");
			System.exit(0);
			break;
		}
	}

	// ��½ҳ��
	public void login() {
		System.out.println("======��ӭ��½ѧ������ϵͳ======");
		System.out.print("�û������û���Ϊid����");
		String username = input.next();
		System.out.print("���루����Ĭ��Ϊ123456����");
		String pw = input.next();

		// �ж����
		String identity = "";// �洢�����Ϣ
		for (Object e : stulist) {// ����û���ѧ�������ͬ �Ǿ���ѧ��
			if ((((student) e).getIdent()).equals("stu") && ((((student) e).getSid())).equals(username)) {
				identity = "stu";
			}
		}
		for (Object e : admlist) {// ����û�������Ա�����ͬ �Ǿ��ǹ���Ա
			if ((((adminer) e).getIdent()).equals("adm") && ((((adminer) e).getAid())).equals(username)) {
				identity = "adm";
			}
		}
		// ����identity���ǿ��ַ���

		// ��֤�����Ƿ���ͬ
		if (identity.equals("stu")) {
			for (int i = 0; i < stulist.size(); i++) {// �ҳ���idһ�����Ǹ��˲��ж������Ƿ���ͬ
				if ((stulist.get(i).getSid()).equals(username) && ((stulist.get(i).getPassword()).equals(pw))) {
					System.out.println("��½�ɹ�����ӭѧ����½��ϵͳ��");
					System.out.println("================================\n");
					// �洢��ǰ�û������±�����
					nowuser = i;
					nowident = "stu";
					// ����ѧ������
					stumenu();
				} else if ((stulist.get(i).getSid()).equals(username) && !((stulist.get(i).getPassword()).equals(pw))) {
					System.out.println("������󣬷������˵���");
					System.out.println("================================\n");
					// �������˵�
					menu();
				}
			}
		} else if (identity.equals("adm")) {
			for (int i = 0; i < admlist.size(); i++) {// �ҳ���idһ�����Ǹ��˲��ж������Ƿ���ͬ
				if ((admlist.get(i).getAid()).equals(username) && ((admlist.get(i).getPassword()).equals(pw))) {
					System.out.println("��½�ɹ�����ӭ����Ա��½��ϵͳ��");
					System.out.println("================================\n");
					// �洢��ǰ�û������±�����
					nowuser = i;
					nowident = "adm";
					// �������Ա����
					admmenu();
				} else if ((admlist.get(i).getAid()).equals(username) && !(admlist.get(i).getPassword()).equals(pw)) {
					System.out.println("������󣬷������˵���");
					System.out.println("================================\n");
					// �������˵�
					menu();
				}
			}
		} else {
			System.out.println("���޴��ˣ�����������\n");
			login();
		}
	}

	// ע��ҳ��
	public void register() {
		System.out.println("======��ӭע��ѧ������ϵͳ======");
		System.out.print("�û�����");
		String un = input.next();
		System.out.print("���룺");
		String pw1 = input.next();
		System.out.print("������һ�����룺");
		String pw2 = input.next();

		// �û���ȥ��
		for (Object e : admlist) {//
			if (((((adminer) e).getAid())).equals(un)) {
				System.out.println("�û����Ѵ��ڣ�������ע�ᡣ");
				System.out.println("================================\n");
				register();
			}
		}
		// �ж�2�������Ƿ���ͬ
		if (pw1.equals(pw2)) {
			admlist.add(new adminer(un, pw1));

			System.out.println("ע��ɹ���ת��½���档");
			System.out.println("================================\n");
			login();
		} else {
			System.out.println("����������Ҫһ�£�������ע�ᡣ");
			System.out.println("================================\n");
			register();
		}

	}

	// ѧ������
	public void stumenu() {
		System.out.println("===========ѧ������=============");
		System.out.println("	1.��ѯ�����˳ɼ�");
		System.out.println("	2.��ѯָ��ѧ���ɼ�");
		System.out.println("	3.�޸�����");
		System.out.println("	4.�˳�");
		System.out.println("================================");
		System.out.print("->");
		int key = input.nextInt();
		switch (key) {
		case 1:
			showDegree();
			stumenu();
			break;
		case 2:
			showTarget();
			stumenu();
			break;
		case 3:
			changePw();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("���棺���벻���ַ���ϵͳ����ѧ�����档");
			stumenu();
			break;
		}
	}

	// ��ʾ����ѧ���ɼ�
	public void showDegree() {
		System.out.println("=============ѧ���ɼ�===============");
		System.out.println("ѧ��\t����\t����\t��ѧ\tӢ��");
		for (int i = 0; i < stulist.size(); i++) {
			System.out.println(
					stulist.get(i).getSid() + "\t" + stulist.get(i).getSname() + "\t" + stulist.get(i).getChinese()
							+ "\t" + stulist.get(i).getMath() + "\t" + stulist.get(i).getEnglish());
		}
		System.out.println("====================================\n");

	}

	// ��ʾָ��ѧ���ɼ�
	public void showTarget() {
		System.out.println("==========��ѯָ��ѧ���ɼ�============");
		System.out.print("����������ѧ�ţ�");
		String search = input.next();
		System.out.println("ѧ��\t����\t����\t��ѧ\tӢ��");
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getSid().equals(search) || stulist.get(i).getSname().equals(search)) {
				System.out.println(
						stulist.get(i).getSid() + "\t" + stulist.get(i).getSname() + "\t" + stulist.get(i).getChinese()
								+ "\t" + stulist.get(i).getMath() + "\t" + stulist.get(i).getEnglish());
			}
		}
		System.out.println("====================================\n");
	}

	// �޸��������
	public void changePw() {
		System.out.println("=============�޸�����===============");
		System.out.print("��������룺");
		String oldpw = input.next();
		System.out.print("���������룺");
		String newpw = input.next();
		System.out.print("�ٴ����������룺");
		String newpw2 = input.next();

		// �ж���ʲô�û�
		if (nowident.equals("stu")) {
			// ��������ͬ
			if (stulist.get(nowuser).getPassword().equals(oldpw)) {
				// ��ͬ�Ļ������ж�������������ٴ����������Ƿ���ͬ
				if (newpw.equals(newpw2)) {
					stulist.get(nowuser).setPassword(newpw);
					System.out.println("�����޸ĳɹ�,�����µ�¼��");
					System.out.println("====================================\n");
					menu();
				} else {
					System.out.println("�����������벻һ�£�����������");
					System.out.println("====================================\n");
					changePw();
				}
			} else {
				// �����벻ͬ
				System.out.println("������������󣬷������˵���");
				System.out.println("====================================\n");
				stumenu();
			}
		} else if (nowident.equals("adm")) {
			// ��������ͬ
			if (admlist.get(nowuser).getPassword().equals(oldpw)) {
				// ��ͬ�Ļ������ж�������������ٴ����������Ƿ���ͬ
				if (newpw.equals(newpw2)) {
					admlist.get(nowuser).setPassword(newpw);
					System.out.println("�����޸ĳɹ�,�����µ�¼��");
					System.out.println("====================================\n");
					menu();
				} else {
					System.out.println("�����������벻һ�£�����������");
					System.out.println("====================================\n");
					changePw();
				}
			} else {
				// �����벻ͬ
				System.out.println("������������󣬷������˵���");
				System.out.println("====================================\n");
				stumenu();
			}
		} else {
			System.out.println("������ݣ��޷�ʶ��");
			System.out.println("====================================\n");
			System.exit(0);
		}

	}

	// ����Ա����
	public void admmenu() {
		System.out.println("===========�������=============");
		System.out.println("	1.��ѯ�����˳ɼ�");
		System.out.println("	2.��ѯָ��ѧ���ɼ�");
		System.out.println("	3.¼��ѧ��");
		System.out.println("	4.�޸�ѧ����Ϣ");
		System.out.println("	5.ɾ��ѧ����Ϣ");
		System.out.println("	6.�޸�����");
		System.out.println("	7.�˳�");
		System.out.println("================================");
		System.out.print("->");
		int key = input.nextInt();
		switch (key) {
		case 1:
			showDegree();
			admmenu();
			break;
		case 2:
			showTarget();
			admmenu();
			break;
		case 3:
			entryStu();
			break;
		case 4:
			changScore();
			break;
		case 5:
			removeStu();
			break;
		case 6:
			changePw();
			break;
		case 7:
			System.exit(0);
			break;
		case 8:
			Boom();
			break;
		default:
			System.out.println("���棺���벻���ַ���ϵͳ���ع�����档");
			admmenu();
			break;
		}
	}

	// ¼��ѧ��
	public void entryStu() {
		String choose2 = "y";
		do {
			System.out.println("===========¼��ѧ��=============");
			System.out.print("ѧ�ţ�");
			String id = input.next();
			// ѧ��ȥ��
			for (int i = 0; i < stulist.size(); i++) {
				if (stulist.get(i).getSid().equals(id)) {
					System.out.println("ѧ���ظ���������¼�롣");
					System.out.println("================================");
					admmenu();
				}
			}
			System.out.print("������");
			String name = input.next();
			System.out.print("���ģ�");
			double ch = input.nextDouble();
			System.out.print("��ѧ��");
			double ma = input.nextDouble();
			System.out.print("Ӣ�");
			double en = input.nextDouble();

			stulist.add(new student(id, name, ch, ma, en));
			System.out.print("¼��ɹ�,�Ƿ����¼�룿(y/n)��");
			choose2 = input.next();
			System.out.println("================================");

		} while (choose2.equals("y"));

		admmenu();
	}

	// �޸�ѧ����Ϣ
	public void changScore() {
		String choose3 = "y";
		do {
			System.out.println("==========�޸�ָ��ѧ���ɼ�============");
			System.out.print("����������ѧ�ţ�");
			String search = input.next();
			System.out.println("���޸��1.���� 2.���� 3.��ѧ 4.Ӣ��");
			System.out.print("����Ҫ�޸ĵ��");
			String key = input.next();
			System.out.print("�޸�Ϊ��");
			String value = input.next();
			int n;
			Boolean nobody = true;
			for (int i = 0; i < stulist.size(); i++) {
				System.out.println("id" + (stulist.get(i).getSid()));
				System.out.println("search" + search);
				if ((stulist.get(i).getSid()).equals(search) || (stulist.get(i).getSname()).equals(search)) {
					nobody = false;
					switch (key) {
					case "1":
						stulist.get(i).setSname(value);
						break;
					case "2":
						n = Integer.parseInt(value);
						stulist.get(i).setChinese(n);
						;
						break;
					case "3":
						n = Integer.parseInt(value);
						stulist.get(i).setMath(n);
						break;
					case "4":
						n = Integer.parseInt(value);
						stulist.get(i).setEnglish(n);
						break;
					default:
						break;
					}
					System.out.print("�޸ĳɹ����Ƿ�����޸�(y/n)��");
					choose3 = input.next();
					admmenu();
					System.out.println("================================");
				}
			}
			if (nobody) {
				System.out.println("���޴��ˣ����ع���˵���");
				admmenu();
			}
		} while (choose3.equals("y"));

	}

	// ɾ��ѧ����Ϣ
	public void removeStu() {
		String choose4 = "y";
		String choose5 = "y";
		do {
			System.out.println("==========ɾ��ָ��ѧ����Ϣ============");
			System.out.print("����������ѧ�ţ�");
			String search = input.next();
			for (int i = 0; i < stulist.size(); i++) {
				if ((stulist.get(i).getSid()).equals(search) || (stulist.get(i).getSname()).equals(search)) {
					System.out.print("�Ƿ�ȷ��ɾ��(y/n)��");
					choose5 = input.next();
					if (choose5.equals("n")) {
						admmenu();
						continue;
					}
					stulist.remove(i);
					System.out.print("ɾ���ɹ����Ƿ����ɾ��(y/n)��");
					choose4 = input.next();
					System.out.println("================================");
				}
			}
		} while (choose4.endsWith("y"));
		admmenu();
	}

	public static void main(String[] args) {
		StudentBiz biz = new StudentBiz();
		biz.initList();
		biz.menu();
	}

	public void Boom() {
		System.out.println("�Ա�����������");
		for (int i = 10; i >= 1; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 1000�������1��
			System.out.println(i);
			stulist.clear();
			admlist.clear();
		}
		gameClearance();
	}

	public static void gameClearance() {
		String s = "\r      ���� �ߩ����������� �ߩ�\r      �������������� ��\r      ������������������\r      �����ש���  ���ס���\r"
				+ "      �������������� ��\r      ���������ߡ�������\r      �������������� ��\r      ����������������������\r        ����������   ϵͳ�Ի�\r"
				+ "        ����������   �����ļ��Ѿ������\r        ������������������������������\r        ����������������    �ǩ�\r"
				+ "        ����������         ����\r        ������ �� ���������� �� ������\r          �� �� ��   �� �� ��\r          �����ߩ���   �����ߩ���";

		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ��һ��ͣһ��
		}
	}
}
