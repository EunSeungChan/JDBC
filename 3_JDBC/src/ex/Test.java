package ex;
/**
 * 김영선
 */
import java.util.List;


public class Test {

	public static void main(String[] args) {

		DeptManager mn = new DeptManager();
		List<DeptVO> list = mn.getDepts();
		
		System.out.println("dept List");
		
		list.forEach(i->System.out.println(i));
		
	}

}
