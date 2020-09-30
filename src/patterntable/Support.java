package patterntable;

public abstract class Support {
	private Support next;

	public Support() {

	}

	public Support setNext(Support next) {
		this.next = next;
		return next;
	}

	public final String[][] support(String pattern) {
		if(resolve(pattern)) {
			return done();
		}
		else if(next != null) {
			return next.support(pattern);
		}
		else {
			fail();
		}
		return null;
	}

	protected abstract boolean resolve(String pattern);
	protected abstract String[][] done();
	protected void fail() {
		System.out.println("パターンとして用意していないやつ");
	}
}
