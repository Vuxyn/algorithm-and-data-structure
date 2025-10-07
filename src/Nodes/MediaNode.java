package Nodes;
import Data.Media;

public class MediaNode extends Node {
    public MediaNode(Media data){
        super(data);
    }

    public MediaNode(Node nestedNode){
        super(nestedNode);
    }
}
