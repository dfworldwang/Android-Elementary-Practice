import java.util.HashSet;


public class Ch17_HashSet {

	public static void main(String[] args) {
		// ���X���� HashSet �ŧi
		HashSet<String> hset = new HashSet<>();
		String name0 = "���p��", name1 = "�p�s�k";
		System.out.println("�s�W�����e�O�_�O�Ū�=" + hset.isEmpty());
		
		hset.add("���|�w");		// �s�W����
		hset.add(name0);		hset.add("������");
		// ��ܤؤo�M�O�_�O�Ū�
		System.out.println("�s�W��ؤo=" + hset.size());
		System.out.println("�O�_�O�Ū�=" + hset.isEmpty());
		// ��ܶ��X���󤺮e
		System.out.print("HashSet ���e: ");
		System.out.println(hset);
		
		// �O�_�֦����w����
		System.out.println("HashSet �O�_��[" + name0 + "]: " + 
				hset.contains(name0));
		System.out.println("HashSet �O�_��[" + name1 + "]: " +
				hset.contains(name1));
		
		hset.remove(name0);		// �R������
		System.out.print("HashSet �R��[" + name0 + "]:");
		System.out.println(hset);
		hset.clear();			// �M�����X����
	}
}