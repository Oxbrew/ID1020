class Circularmain {
	public static void main(String[] args) {
	CircularDLLS<Character> list = new CircularDLLS<>();
	list.queueHead('a');
	list.printTheThing();

	list.queueHead('b');
	list.printTheThing();

	list.queueHead('p');
	list.printTheThing();

	list.queueHead('h');
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
