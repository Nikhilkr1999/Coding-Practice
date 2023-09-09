
public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powerOf5(65));
	}

	public static boolean powerOf5(int n){ 
		if(n == 0){ 
			return false; 
		}else{ 
			int x = (int) (Math.log(n)/Math.log(4)); 
			System.out.println(Math.log(n) + " " + Math.log(5));
			if(n == Math.pow(4, x)){ 
				return true; 
			}else{ 
				return false; 
			} 
		} 
	}  
}
