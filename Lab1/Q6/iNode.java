/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input:Tests already implemented.
*Output: Printed current queue.
*
*Goal: Ordered Queue
*/


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
