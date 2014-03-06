import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HolaMundo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		System.out.println("hola mundo" + s);
	}

}
