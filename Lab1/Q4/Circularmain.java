class Circularmain {
	public static void main(String[] args) {
	CircularDLLS<Character> list = new CircularDLLS<>();
	list.queueTail('a');
	list.printTheThing();

	list.queueTail('b');
	list.printTheThing();

	list.queueTail('p');
	list.printTheThing();

	list.queueTail('h');
	list.printTheThing();

	list.queueHead('G');
	list.printTheThing();

	list.queueTail('E');
	list.printTheThing();


	list.deQueueHead();
	list.printTheThing();


	list.deQueueTail();
	list.printTheThing();






}
}
