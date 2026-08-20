package ex0813.exam05;

public class Applicant<T> {	
	private T kind;
	
	public Applicant(T kind) {
		this.kind = kind;
	}

	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}
	
	
	
	
}
