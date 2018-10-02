package assignement1;



public class Hand {

    public Hand(String path) {
        ReadFile file = new ReadFile(path);
        String fileContent = file.getData();
        String[] CardsNames = fileContent.split(" ");
        
    }
}