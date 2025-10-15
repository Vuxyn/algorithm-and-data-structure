package Nodes;
import Data.Media;

public class MediaNode extends Node {
    public MediaNode(Media data){
        super(data);
    }

    public Media getMedia() {
        return (Media) getData();
    }
    
    public void displayInfo() {
        Media media = getMedia();
        System.out.println("Media: " + media.toString());
    }
}
