package dynamicarray;

public class Main {

	public static void main(String[] args) {
		Array arr = new Array(2);
		arr.insert(2);
		arr.insert(3);		
		arr.insert(4);
		
		Array arrOther = new Array(3);
		arrOther.insert(2);
		arrOther.insert(3);		
		arrOther.insert(7);
		arrOther.print();
		
		Array inter=new Array(1);
		inter=arr.intersect(arrOther);
		inter.print();
		//arr.print();
	}

}
