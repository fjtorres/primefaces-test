import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

public class Test {

   @org.junit.Test
   public void test() throws IOException {

      System.out.println(Files.list(Paths.get("target"))
            .filter(p -> !Files.isDirectory(p)
                  && FilenameUtils.getExtension(p.getFileName().toString()).equalsIgnoreCase("pdf"))
            .collect(Collectors.toList()));
   }
}
