class Orderedmain {
	public static void main(String[] args) {
	OrderedQueue list = new OrderedQueue();
	list.Queue(1);
	list.printTheThing();

	list.Queue(7);
	list.printTheThing();

	list.Queue(3);
	list.printTheThing();

	list.Queue(-2);
	list.printTheThing();

	list.Queue(6);
	list.printTheThing();

	list.Queue(5);
	list.printTheThing();

	list.deQueue();
	list.printTheThing();


	list.deQueue();
	list.printTheThing();

	}
}
