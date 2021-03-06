public class QEntry {

	public enum Action {
		NORTH, SOUTH, EAST, WEST, PICKUP, DROPOFF
	}

	State s;
	Action a;

	private QEntry(State s, Action a) {
		this.s = s;
		this.a = a;
	}

	// R(s, a) return immediate reward, where s is some state and a is action
	public int getImmediateReward() {
		switch (a) {
		case PICKUP:
		case DROPOFF:
			return 13;
		default:
			return -1;
		}
	}

	public static QEntry MoveNorth(State s) {
		State newState = s.clone();
		return new QEntry(newState, Action.NORTH);
	}

	public static QEntry MoveSouth(State s) {
		State newState = s.clone();
		return new QEntry(newState, Action.SOUTH);
	}

	public static QEntry MoveEast(State s) {
		State newState = s.clone();
		return new QEntry(newState, Action.EAST);
	}

	public static QEntry MoveWest(State s) {
		State newState = s.clone();
		return new QEntry(newState, Action.WEST);
	}

	public static QEntry DropOff(State s) {
		State newState = s.clone();
		return new QEntry(newState, Action.DROPOFF);
	}

	public static QEntry PickUp(State s) {
		State newState = s.clone();
		return new QEntry(newState, Action.PICKUP);
	}

	public boolean movingNorth() {
		return a == Action.NORTH;
	}

	public boolean movingSouth() {
		return a == Action.SOUTH;
	}

	public boolean movingWest() {
		return a == Action.WEST;
	}

	public boolean movingEast() {
		return a == Action.EAST;
	}

	public boolean pickingUp() {
		return a == Action.PICKUP;
	}

	public boolean droppingOff() {
		return a == Action.DROPOFF;
	}

	@Override
	public boolean equals(Object o1) {
		QEntry e1 = (QEntry) o1;

		return this.toString().equals(e1.toString());
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	

	public String toString() {
		return new String(s.toString() + " " + a);
	}
}
