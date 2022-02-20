import java.util.ArrayList;
import java.util.List;

public class LinuxFind {
    //1.find all file > 5mb
    //2.find all xml
    class File{
        String name;
        String type;
        int size;
        boolean isDirectory;
        File[] children;
    }
    interface Filter{
        boolean match(File file);
    }
    class TypeFilter implements  Filter{
        String type;
        public TypeFilter(String type){
            this.type = type;
        }
        public boolean match(File file){
            return file.type.equals(type);
        }
    }
    class SizeFilter implements Filter{
        int size;
        public SizeFilter(int size){
            this.size = size;
        }
        public boolean match(File file){
            return file.size == size;
        }
    }
    class NotADirectoryException extends Exception{
            public NotADirectoryException(){
                super("not a dir");
            }
    }
    class FindCommand{
        public List<File> findwithFilter(File dir, List<Filter> filters) throws NotADirectoryException {
            if(!dir.isDirectory){
                throw new NotADirectoryException();
            }
            List<File> fileList = new ArrayList<>();
            findByFilter(dir,filters,fileList);
            return fileList;
        }
        private void findByFilter(File dir,List<Filter> f,List<File> fileList){
            if(dir.children == null) return;
            for(File file:fileList){
                if(file.isDirectory){
                    findByFilter(file,f,fileList);
                }else{
                    boolean matchedFile = true;
                    for(Filter filter:f){
                        if(!filter.match(file)){
                            matchedFile = false;
                            break;
                        }
                    }
                    if(matchedFile) fileList.add(file);
                }
            }
            return;
        }
    }
}
