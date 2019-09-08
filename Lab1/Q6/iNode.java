import java.lang.*;

public class iNode {
	int element;
	iNode next = null;
	iNode previous = null;

	public iNode (int element){
		this.element = element;
	}

	public int getElement(){
		return this.element;
	}

}
