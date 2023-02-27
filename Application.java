import java.io.File;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        MitCommandInput mitCommandInput = new MitCommandInput();
        MitCommand mitCommand = new MitCommandImpl();
        while(true){
            String input = mitCommandInput.input();

            if(input.startsWith("mit list")){
                Optional<List<File>> optionalList = mitCommand.list(input.split(" ")[2]);
                optionalList.ifPresent(MitCommand.outputList);
            }else if(input.startsWith("mit hash")){
                mitCommand.hash(input.split(" ")[2]);
            }else if(input.startsWith("mit zlib")){
                mitCommand.zlib(input.split(" ")[2]);
            }else{
                break;
            }
        }
    }
}