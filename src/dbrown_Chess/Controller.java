package dbrown_Chess;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by dbrown on 12/8/2014.
 */
public class Controller {

    public static void main(String[]args) throws IOException{

        (new BoardModel()).readCommandsFromFile(Paths.get(args[0]));



    }

}
