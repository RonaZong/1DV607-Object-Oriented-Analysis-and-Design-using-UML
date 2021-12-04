

public class Program {

	public static void main(String[] args) {
		model.Member m = new model.Member();
		view.Console v = new view.Console();
		controller.User c = new controller.User();
		
		c.register(m, v);
	}

}
